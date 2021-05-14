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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private TableView<MadeEntity> tbv_Exam_code;

    @FXML
    private TextField txt_maDe;

    @FXML
    private TextField txt_tenMade;

    @FXML
    private TableView<CauhoiEntity> tbv_jsonView;

    cauhoiDao dao = new cauhoiDao();
    madeDao madeDao = new madeDao();

    CauhoiEntity recent = null;
    BodeEntity bodeEntity = null;
    ObservableList<CauhoiEntity> cauhoiEntities ;
    ObservableList<MadeEntity> madeEntities;

    @FXML
    void select_Examcode(MouseEvent event) {
        try {
            File file = new File(tbv_Exam_code.getSelectionModel().getSelectedItem().getMaCHde());
            if(file.exists()){

                Excel excel = new Excel();
                List<CauhoiEntity> list = excel.readExcel(tbv_Exam_code.getSelectionModel().getSelectedItem().getMaCHde());
                tbv_jsonView.setItems(FXCollections.observableArrayList(list));
                TableColumn col1 =   tbv_jsonView.getColumns().get(0);
                col1.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("maCh"));
                TableColumn col2 =   tbv_jsonView.getColumns().get(1);
                col2.setCellValueFactory(new PropertyValueFactory<CauhoiEntity,String>("ndCh"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void select_Question(MouseEvent event) {

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

    }
}
