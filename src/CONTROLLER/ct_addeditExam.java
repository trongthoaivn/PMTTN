package CONTROLLER;

import DAO.bodeDao;
import DAO.monhocDao;
import MODEL.BodeEntity;
import MODEL.MonhocEntity;
import REF.ComboboxString;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ct_addeditExam implements Initializable {

    @FXML
    private TextField txt_ListTestID;

    @FXML
    private TextField txt_ListTestname;

    @FXML
    private Button btn_Save_list;

    @FXML
    private ComboBox<ComboboxString> cbo_Subject;
    bodeDao bodeDao = new bodeDao();
    int flag = 0;

    @FXML
    void Save_ListTest(ActionEvent event) {

        if(txt_ListTestID.getText()!=null&&txt_ListTestname.getText()!=null){
            MonhocEntity monhocEntity = new MonhocEntity(
              cbo_Subject.getValue().getValue(),
              cbo_Subject.getValue().getKey()
            );
            BodeEntity bodeEntity = new BodeEntity(
                    txt_ListTestID.getText(),
                    txt_ListTestname.getText(),
                    monhocEntity
            );
            try{
                if (flag ==0 && bodeDao.addData(bodeEntity)==1)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Add new Test complete!");
                    alert.show();
                    System.out.println("add ListTest : 1" );
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        System.out.println(cbo_Subject.getValue().getValue());

    }

    private  void loadSubjecttocombobox(){
        monhocDao dao = new monhocDao();
        ObservableList<MonhocEntity> list = dao.getAll();
        List<ComboboxString> listItem = new ArrayList<>();
        list.forEach(e->{
            listItem.add(new ComboboxString(e.getTenMh(),e.getMaMh()));

        });
        cbo_Subject.setItems(FXCollections.observableArrayList(listItem));
        cbo_Subject.getSelectionModel().selectFirst();
    }

    void  setinfoListTest(BodeEntity bodeEntity){
        try {
            txt_ListTestID.setText(bodeEntity.getMaBode());
            txt_ListTestname.setText(bodeEntity.getTenBode());
            cbo_Subject.getSelectionModel();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadSubjecttocombobox();
    }
}
