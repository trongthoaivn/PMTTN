package CONTROLLER;

import DAO.cauhoiDao;
import DAO.madeDao;
import MODEL.BodeEntity;
import MODEL.CauhoiEntity;
import MODEL.MadeEntity;
import MODEL.MadeJson;
import REF.Excel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ct_genarateExcode implements Initializable {

    @FXML
    private TableView<CauhoiEntity> tbv_Question;

    @FXML
    private TextArea txt_Exam_info;

    @FXML
    private VBox V_box;

    @FXML
    private VBox V_Box_Excode;

    @FXML
    private javafx.scene.layout.Pane Pane;

    @FXML
    private TableView<MadeEntity> tbv_Exam_code;

    @FXML
    private TextField txt_maDe;

    @FXML
    private TextField txt_tenMade;

    @FXML
    private TableView<CauhoiEntity> tbv_jsonView;

    @FXML
    private ListView<List<CauhoiEntity>> lsv_Questions;

    cauhoiDao dao = new cauhoiDao();
    madeDao madeDao = new madeDao();
    int flag = 0;
    int flag1 = 0;
    CauhoiEntity recent = null;
    BodeEntity bodeEntity = null;
    MadeEntity madeEntity = null;
    ObservableList<CauhoiEntity> cauhoiEntities ;
    List<CauhoiEntity> cauhoi =new ArrayList<>();
    ObservableList<MadeEntity> madeEntities;
    List<List<CauhoiEntity>> LvQuestions = new ArrayList<>();
    List<CauhoiEntity> recentCH=null;

    @FXML
    void New_Excode(ActionEvent event) {
        if(flag==0){
            V_Box_Excode.getChildren().add(0,Pane);
            flag=1;
        }
        else{
            V_Box_Excode.getChildren().remove(0);
            flag =0;
        }

    }


    @FXML
    void Delete(ActionEvent event) {
        if(madeEntity!=null&&flag1==0){
            if (madeDao.delData(madeEntity)==1){
                System.out.println("delete +1");
                File excel = new File(madeEntity.getMaCHde());
                excel.delete();
                flag=0;
            }
        }
        if(recent!=null&&flag1==1){
            cauhoi.remove(cauhoi.indexOf(recent));
            tbv_jsonView.setItems(FXCollections.observableArrayList(cauhoi));
            TableColumn col1 =   tbv_jsonView.getColumns().get(0);
            col1.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("maCh"));
            TableColumn col2 =   tbv_jsonView.getColumns().get(1);
            col2.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("ndCh"));
            flag1=0;
        }
        if(LvQuestions.indexOf(recentCH)!=-1&&flag1==2){
            LvQuestions.remove(LvQuestions.indexOf(recentCH));
            lsv_Questions.setItems(FXCollections.observableArrayList(LvQuestions));
            flag1=0;
        }
        this.Refresh(event);
    }

    @FXML
    void Save(ActionEvent event) throws IOException {
        if(txt_maDe.getText().equals("")==false&&txt_tenMade.getText().equals("")==false){
            MadeEntity made = new MadeEntity(
                    txt_maDe.getText(),
                    txt_tenMade.getText(),
                    "src/XLS/"+txt_maDe.getText()+".xls",
                    bodeEntity
            );
            Workbook workbook = new HSSFWorkbook();
            workbook.createSheet();
            FileOutputStream outputStream = new FileOutputStream(made.getMaCHde());
            workbook.write(outputStream);
            if(recentCH!=null){
                try {
                    Excel excel = new Excel();
                    excel.writeExcel(recentCH,made,made.getMaCHde());
                    recentCH=null;
                }catch (Exception e){
                    recentCH=null;
                }

            }
            if(madeDao.InsertorUpdate(made)==1){
                System.out.println("made +1");
                txt_maDe.clear();
                txt_tenMade.clear();
            }
        }
        if(madeEntity!=null&&recentCH!=null){
            if(recentCH!=null){
                try {
                    Excel excel = new Excel();
                    excel.writeExcel(recentCH,madeEntity,madeEntity.getMaCHde());
                    recentCH=null;
                    madeEntity= null;
                }catch (Exception e){
                    recentCH=null;
                    madeEntity=null;
                }

            }
        }

        this.Refresh(event);

    }

    @FXML
    void Save_Questions(ActionEvent event) {
        LvQuestions.add(new ArrayList<>(cauhoi));
        System.out.println(lsv_Questions.getItems().size());
        lsv_Questions.setItems(FXCollections.observableArrayList(LvQuestions));
        cauhoi.clear();
        tbv_jsonView.getItems().clear();
    }

    @FXML
    void Refresh(ActionEvent event) {
        loadExamcode();
    }

    @FXML
    void select_Examcode(MouseEvent event) {
        tbv_jsonView.getItems().clear();
        try {
            madeEntity= tbv_Exam_code.getSelectionModel().getSelectedItem();
            flag1=0;
            File file = new File(tbv_Exam_code.getSelectionModel().getSelectedItem().getMaCHde());
            if(file.exists()){
                Excel excel = new Excel();
                try {
                    List<CauhoiEntity> list = excel.readExcel(tbv_Exam_code.getSelectionModel().getSelectedItem().getMaCHde());
                    tbv_jsonView.setItems(FXCollections.observableArrayList(list));
                    TableColumn col1 =   tbv_jsonView.getColumns().get(0);
                    col1.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("maCh"));
                    TableColumn col2 =   tbv_jsonView.getColumns().get(1);
                    col2.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("ndCh"));
                }catch (Exception e){
                    tbv_jsonView.getItems().clear();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void Select_ExQuestion(MouseEvent event) {
        recent=tbv_jsonView.getSelectionModel().getSelectedItem();
        flag1=1;
    }

    @FXML
    void Select_Questions(MouseEvent event) {
        tbv_jsonView.setItems(FXCollections.observableArrayList(lsv_Questions.getSelectionModel().getSelectedItem()));
        TableColumn col1 =   tbv_jsonView.getColumns().get(0);
        col1.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("maCh"));
        TableColumn col2 =   tbv_jsonView.getColumns().get(1);
        col2.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("ndCh"));
        recentCH=lsv_Questions.getSelectionModel().getSelectedItem();
        flag1=2;
    }

    @FXML
    void select_Question(MouseEvent event) {
        recent= tbv_Question.getSelectionModel().getSelectedItem();
        if (tbv_jsonView.getItems().indexOf(recent)==-1){
            tbv_jsonView.getItems().clear();
            cauhoi.add(recent);
            tbv_jsonView.setItems(FXCollections.observableArrayList(cauhoi));
            TableColumn col1 =   tbv_jsonView.getColumns().get(0);
            col1.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("maCh"));
            TableColumn col2 =   tbv_jsonView.getColumns().get(1);
            col2.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("ndCh"));
        }

    }
    @FXML
    void exit(ActionEvent event) {

    }

    void loadExamcode(){
        madeEntities = FXCollections.observableArrayList(madeDao.getMadebyCode(bodeEntity));
        if(madeEntities!=null){
            tbv_Exam_code.setItems(madeEntities);
            TableColumn col1 =   tbv_Exam_code.getColumns().get(0);
            col1.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("maDe"));
            TableColumn col2 =   tbv_Exam_code.getColumns().get(1);
            col2.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("tenMade"));
            TableColumn col3 =   tbv_Exam_code.getColumns().get(2);
            col3.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("maCHde"));
        }

    }

    void loadQuestion(BodeEntity bode){
        bodeEntity =bode;
        cauhoiEntities = dao.getQuestionbyCode(bode);
        txt_Exam_info.setText(bode.getMaBode() +" "+bode.getTenBode());
        if(cauhoiEntities!=null)
        {
            tbv_Question.setItems(cauhoiEntities);
            TableColumn col1 =   tbv_Question.getColumns().get(0);
            col1.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("maCh"));
            TableColumn col2 =   tbv_Question.getColumns().get(1);
            col2.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("ndCh"));
            TableColumn col3 =   tbv_Question.getColumns().get(2);
            col3.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("imgCh"));
            TableColumn col4 =   tbv_Question.getColumns().get(3);
            col4.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("audCh"));
            TableColumn col5 =   tbv_Question.getColumns().get(4);
            col5.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("tl1"));
            TableColumn col6 =   tbv_Question.getColumns().get(5);
            col6.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("tl2"));
            TableColumn col7 =   tbv_Question.getColumns().get(6);
            col7.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("tl3"));
            TableColumn col8 =   tbv_Question.getColumns().get(7);
            col8.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("tl4"));
            TableColumn col9 =   tbv_Question.getColumns().get(8);
            col9.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("da"));
            TableColumn col10 =   tbv_Question.getColumns().get(9);
            col10.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,Integer>("dokho"));
        }
        loadExamcode();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        V_Box_Excode.getChildren().remove(0);
    }
}
