package CONTROLLER;

import DAO.bodeDao;
import DAO.cauhoiDao;
import DAO.monhocDao;
import MODEL.BodeEntity;
import MODEL.MonhocEntity;
import REF.ComboboxString;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ct_Exam implements Initializable {

    @FXML
    private ComboBox<ComboboxString> cbo_Subject;

    @FXML
    private Button btn_Subject;

    @FXML
    private Button btn_edit_question;

    @FXML
    private ListView<String> lsv_Exam;

    BodeEntity recent = new BodeEntity();
    bodeDao dao = new bodeDao();
    cauhoiDao cauhoiDao = new cauhoiDao();
    ObservableList<BodeEntity> list = dao.getAll();


    @FXML
    void edit_question(ActionEvent event) throws IOException {

        if(recent.getMaBode()!=null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW/Form/fadd_edit_Question.fxml"));
            Parent root = loader.load();
            ct_addeditQuestion addeditQuestion = loader.getController();
            addeditQuestion.loadQuestion(recent);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UTILITY);
            if(stage.isShowing()==false){
                stage.show();
            }
        }


    }

    @FXML
    void selectExam(MouseEvent event) {
        recent = list.get(lsv_Exam.getSelectionModel().getSelectedIndex());
    }

    private  void loadSubjecttocombobox(){
        monhocDao dao = new monhocDao();
        ObservableList<MonhocEntity>list = dao.getAll();
        List<ComboboxString> listItem = new ArrayList<>();
        list.forEach(e->{
            listItem.add(new ComboboxString(e.getTenMh(),e.getMaMh()));

        });
        cbo_Subject.setItems(FXCollections.observableArrayList(listItem));
        cbo_Subject.getSelectionModel().selectFirst();
    }
    private void loadListTesttoListview(){

        List<String> listitem = new ArrayList<>();
        list.forEach(e ->{
            listitem.add(e.getMaBode()+"\n"+e.getTenBode());
        });
        lsv_Exam.setItems(FXCollections.observableArrayList(listitem));
    }

    @FXML
    void open_frm_Subject(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/frm_Subject.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UTILITY);
        if(stage.isShowing()==false){
            stage.show();
        }
    }

    @FXML
    void open_frm_Examcode(ActionEvent event) throws IOException {

        if (recent.getMaBode()!=null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/frm_generateExcode.fxml"));
            Parent root = loader.load();
            ct_genarateExcode ct_genarateExcode = loader.getController();
//            ct_genarateExcode.loadExamcode(recent);
            ct_genarateExcode.loadQuestion(recent);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UTILITY);
            if(stage.isShowing()==false){
                stage.show();
            }
        }

    }

    public void EditExam() throws IOException {
        System.out.println(recent.getMaBode());
        if (recent.getMaBode()!=null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/fadd_edit_Exam.fxml"));
            Parent root = loader.load();
            ct_addeditExam ct_addeditExam = loader.getController();
            ct_addeditExam.setinfoListTest(recent);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UTILITY);
            if(stage.isShowing()==false){
                stage.show();
            }
        }
        loadListTesttoListview();

    }
    public void DeleteExam() {
        if(recent.getMaBode()!= null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Test");
            alert.setHeaderText("Are you sure you want delete "+ recent.getMaBode());
            Optional<ButtonType> option = alert.showAndWait();
            if(option.get()==ButtonType.OK && cauhoiDao.DeleteQuestiobymaDe(recent)==1 && dao.delData(recent)==1 ) {
                System.out.println("delete ListTest : 1");
            }else if (option.get() ==ButtonType.CANCEL){
                alert.close();
            }else alert.close();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadSubjecttocombobox();
        loadListTesttoListview();
    }



}
