package CONTROLLER;

import DAO.monhocDao;
import MODEL.MonhocEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ct_Subject implements Initializable {

    @FXML
    private TableView<MonhocEntity> tbv_Subject;

    @FXML
    private Button btn_Add;

    @FXML
    private Button btn_Cancel;

    @FXML
    private Button btn_Save;

    @FXML
    private Button btn_Delete;

    @FXML
    private Button btn_Update;

    @FXML
    private Button btn_Refesh;

    @FXML
    private Pane pane_info;

    @FXML
    private TextField txt_SubjectID;

    @FXML
    private TextField txt_Subjectname;

    monhocDao dao = new monhocDao();

    int flag =0;


    private void getSubjecttotable(){
        tbv_Subject.getItems().clear();

        tbv_Subject.setItems(dao.getAll());
        TableColumn col1 =  tbv_Subject.getColumns().get(0);
        col1.setCellValueFactory(new PropertyValueFactory<MonhocEntity,String>("maMh"));
        TableColumn col2 =  tbv_Subject.getColumns().get(1);
        col2.setCellValueFactory(new PropertyValueFactory<MonhocEntity,String>("tenMh"));
    }

    @FXML
    void Add(ActionEvent event) {
        if(pane_info.isVisible()) pane_info.setVisible(false);
        else {
            pane_info.setVisible(true);
            txt_Subjectname.clear();
            txt_SubjectID.clear();
            flag = 0;
        }
    }

    @FXML
    void Cancel(ActionEvent event) {
        btn_Add.fire();
    }

    @FXML
    void Delete(ActionEvent event) {
        MonhocEntity monhocselected =tbv_Subject.getSelectionModel().getSelectedItem();
        if (monhocselected!=null){
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete Subject");
                alert.setHeaderText("Are you sure you want delete "+ monhocselected.getTenMh());
                Optional<ButtonType> option = alert.showAndWait();
                if(option.get()==ButtonType.OK) {
                    System.out.println("delete : "+dao.delData(monhocselected));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        btn_Refesh.fire();
    }

    @FXML
    void Refresh(ActionEvent event) {
        getSubjecttotable();
    }

    @FXML
    void Save(ActionEvent event) {
        if(txt_SubjectID.getText().equals("")!=true && txt_Subjectname.getText().equals("")!=true){
            MonhocEntity monhocEntity = new MonhocEntity(txt_SubjectID.getText(),txt_Subjectname.getText());
            try {
                if(flag == 0)
                    System.out.println("add subject :"+dao.addData(monhocEntity));
                else
                    System.out.println("update subject : " + dao.updateData(monhocEntity));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        btn_Refesh.fire();
    }

    @FXML
    void Update(ActionEvent event) {
        MonhocEntity monhocselected =tbv_Subject.getSelectionModel().getSelectedItem();
        if(pane_info.isVisible()) pane_info.setVisible(false);
        else {
            if (monhocselected != null){
                pane_info.setVisible(true);
                flag = 1;
                txt_SubjectID.setText(monhocselected.getMaMh());
                txt_Subjectname.setText(monhocselected.getTenMh());
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getSubjecttotable();
        pane_info.setVisible(false);
    }
}