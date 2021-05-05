package CONTROLLER;

import DAO.cauhoiDao;
import MODEL.AdminEntity;
import MODEL.BodeEntity;
import MODEL.CauhoiEntity;
import REF.ComboItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class ct_addeditQuestion implements Initializable {

    @FXML
    private Button btn_clear;

    @FXML
    private TextArea txt_Question;

    @FXML
    private VBox vbox_answer;

    @FXML
    private HBox hbox_A;

    @FXML
    private ToggleGroup choice;

    @FXML
    private HBox hbox_B;

    @FXML
    private HBox hbox_C;

    @FXML
    private HBox hbox_D;

    @FXML
    private ComboBox<ComboItem> cbo_diff;

    @FXML
    private ListView<CauhoiEntity> lsv_Recent;

    @FXML
    private TableView<CauhoiEntity> tbv_Question;

    @FXML
    private TextArea txt_info;


    List<HBox> list = new ArrayList<HBox>() ;
    List<String> rdb = new ArrayList<String>();
    ObservableList<CauhoiEntity> cauhoiEntities ;
    List<CauhoiEntity>listview  = new ArrayList<CauhoiEntity>();
    cauhoiDao dao = new cauhoiDao();
    CauhoiEntity recent = null;
    BodeEntity bodeEntity = null;
    String code;
    int i;
    int index = 0;
    int flag = 0;

    @FXML
    void Save_recent(ActionEvent event) {
        CauhoiEntity cauhoi = new CauhoiEntity();
        if (flag== 0){
            cauhoi =getValuetoCH(i);
            i++;
        }
        if(flag == 1 || flag ==3){
          cauhoi = getValuetoCH(recent.getMaCh());
          flag =0;
          listview.remove(recent);
        }
        listview.add(cauhoi);
        lsv_Recent.setItems(FXCollections.observableArrayList(listview));
    }
    private CauhoiEntity getValuetoCH(int Id){
        List<String> str = new ArrayList<String>();
        final String[] DA = new String[1];
        list.forEach(e -> {
            TextArea textArea =(TextArea) e.getChildren().get(1);
            RadioButton radioButton = (RadioButton) e.getChildren().get(0);
            if(textArea.getText().equals("")==false)
                str.add(textArea.getText());
            else str.add("");
            if (radioButton.isSelected())
                DA[0] = rdb.get(list.indexOf(e));
        });
        CauhoiEntity cauhoi = new CauhoiEntity(
                Id,
                true,
                txt_Question.getText(),
                "",
                "",
                str.get(0),
                str.get(1),
                str.get(2),
                str.get(3),
                DA[0],
                cbo_diff.getValue().getValue(),
                new BodeEntity(code)

        );
        return cauhoi;
    }

    @FXML
    void cancel(ActionEvent event) {
        Stage  stage = (Stage) btn_clear.getScene().getWindow();
        stage.close();
    }

    @FXML
    void save_all(ActionEvent event) throws InterruptedException {
        Thread  thread = new Thread(this::save_all);
        thread.start();
        thread.join();
        this.loadQuestion(bodeEntity);
        thread.interrupt();
        listview.clear();
        lsv_Recent.setItems(FXCollections.observableArrayList(listview));
    }
    private void save_all(){
        cauhoiDao dao = new cauhoiDao();
        System.out.println("insert or update : "+dao.InsertorUpdate(listview));
    }

    @FXML
    void delete_question(ActionEvent event) {
        cauhoiDao dao = new cauhoiDao();
        if(flag ==3)
            System.out.println("delete question: " + dao.delData(recent));
            this.loadQuestion(bodeEntity);
    }

    @FXML
    void delete_listview(ActionEvent event) {
        listview.remove(recent);
        lsv_Recent.setItems(FXCollections.observableArrayList(listview));
    }

    @FXML
    void listview_select(MouseEvent event) {
        btn_clear.fire();
        vbox_answer.getChildren().clear();
        recent =lsv_Recent.getSelectionModel().getSelectedItem();
        //System.out.println(recent.toDetail());
        this.info_Question();
        flag = 1;
    }

    @FXML
    void clear(ActionEvent event) {
        index=0;
        txt_Question.clear();
        vbox_answer.getChildren().clear();
        list.forEach(e ->{
            TextArea textArea=(TextArea) e.getChildren().get(1);
            RadioButton radioButton =(RadioButton) e.getChildren().get(0);
            textArea.clear();
            radioButton.setSelected(false);
        });
        flag = 0;
    }

    @FXML
    void new_answers(ActionEvent event) {
        if (index<4){
            vbox_answer.getChildren().add(index,list.get(index));
            index ++;
        }
    }

    @FXML
    void delete_answers(ActionEvent event) {
        if (index>0){
            vbox_answer.getChildren().remove(index-1);
            index--;
        }
    }

    public void info_Question(){
        final int[] count = {0};
        if (recent!=null){
            int i = rdb.indexOf(recent.getDa());
            txt_Question.setText(recent.getNdCh());
            List<String> listAnswer=  new ArrayList<String>();
            listAnswer.add(recent.getTl1());
            listAnswer.add(recent.getTl2());
            listAnswer.add(recent.getTl3());
            listAnswer.add(recent.getTl4());
            listAnswer.forEach(A -> {
                if (A.equals("")==false) {
                    vbox_answer.getChildren().add(list.get(listAnswer.indexOf(A)));
                    HBox hBox = (HBox) vbox_answer.getChildren().get(listAnswer.indexOf(A));
                    TextArea Answer = (TextArea) hBox.getChildren().get(1);
                    Answer.setText(A);
                    count[0]++;
                    if(listAnswer.indexOf(A) ==i){
                        RadioButton rdbutton  = (RadioButton) hBox.getChildren().get(0);
                        rdbutton.setSelected(true);
                    }
                }
            });
            index = count[0];
        }
    }

    @FXML
    void select_Question(MouseEvent event) {
        vbox_answer.getChildren().clear();
        recent =tbv_Question.getSelectionModel().getSelectedItem();
        this.info_Question();
       // System.out.println(recent.toDetail());
        flag = 3;
    }

    void loadQuestion(BodeEntity bode){
        bodeEntity =bode;
        cauhoiEntities = dao.getQuestionbyCode(bode);
        txt_info.setText(bode.getMaBode() +" "+bode.getTenBode());
        if(cauhoiEntities!=null)
        {
            code =bode.getMaBode();
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
       i= tbv_Question.getItems().size() + 1;
    }

    private void setValuecbo(){
        cbo_diff.setItems(FXCollections.observableArrayList(
                new ComboItem("Biết",1),
                new ComboItem("Hiểu",2),
                new ComboItem("Vận dụng thấp",3),
                new ComboItem("Vận dụng cao",4)
        ));
        cbo_diff.getSelectionModel().selectFirst();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.add(hbox_A);
        list.add(hbox_B);
        list.add(hbox_C);
        list.add(hbox_D);
        rdb.add("A");
        rdb.add("B");
        rdb.add("C");
        rdb.add("D");
        setValuecbo();
//        loadQuestion( new BodeEntity("BIO2020"));
    }
}
