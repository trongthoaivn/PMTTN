package CONTROLLER;

import DAO.bodeDao;
import DAO.kythiDao;
import DAO.monhocDao;
import MODEL.BodeEntity;
import MODEL.KythiEntity;
import MODEL.MonhocEntity;
import REF.ComboboxString;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    public ComboBox<ComboboxString> cbo_Schedule;

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
            KythiEntity kythiEntity = new KythiEntity(cbo_Schedule.getValue().getValue());

            BodeEntity bodeEntity = new BodeEntity(
                    txt_ListTestID.getText(),
                    txt_ListTestname.getText(),
                    monhocEntity,
                    kythiEntity
            );
            try{
                if (flag ==0 && bodeDao.addData(bodeEntity)==1)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Add new Test complete!");
                    alert.show();
                    System.out.println("add ListTest : 1" );
                }
                if (flag ==1 && bodeDao.addData(bodeEntity)==1){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Update Test complete!");
                    alert.show();
                    System.out.println("update ListTest : 1" );
                }


            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.show();
            }

        }
        System.out.println(cbo_Subject.getValue().getValue());
        System.out.println(cbo_Schedule.getValue().getValue());
    }



    private  void loadSubjecttocombobox(){
        monhocDao dao = new monhocDao();
        ObservableList<MonhocEntity> list = dao.getAll();
        List<ComboboxString> listItem = new ArrayList<>();
        list.forEach(e->{
            listItem.add(new ComboboxString(e.getTenMh(),e.getMaMh()));

        });
        cbo_Subject.setItems(FXCollections.observableArrayList(listItem));
    }

    void  setinfoListTest(BodeEntity bodeEntity){
        try {
            txt_ListTestID.setText(bodeEntity.getMaBode());
            txt_ListTestname.setText(bodeEntity.getTenBode());
            System.out.println(bodeEntity.getMaBode());
            cbo_Subject.getItems().forEach( e ->{
                if (e.getValue().equals(bodeEntity.getMonhocByMaMh().getMaMh())){
                    cbo_Subject.getSelectionModel().select(e);
                    new Thread(()->{
                        kythiDao dao = new kythiDao();
                        List<KythiEntity> list= dao.getKythibyMH(cbo_Subject.getValue().getValue());
                        List<ComboboxString> cb_schedule = new ArrayList<>();
                        for (KythiEntity a : list){
                            cb_schedule.add(new ComboboxString(a.getTenKt(),a.getMaKt()));
                        }
                        cbo_Schedule.setItems(FXCollections.observableArrayList(cb_schedule));
                    }).start();
                }
            });
            flag=1;
            txt_ListTestID.setEditable(false);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void select_Subject(ActionEvent actionEvent) {
        new Thread(()->{
            kythiDao dao = new kythiDao();
            List<KythiEntity> list= dao.getKythibyMH(cbo_Subject.getValue().getValue());
            List<ComboboxString> cb_schedule = new ArrayList<>();
            for (KythiEntity a : list){
                cb_schedule.add(new ComboboxString(a.getTenKt(),a.getMaKt()));
            }
            cbo_Schedule.setItems(FXCollections.observableArrayList(cb_schedule));
        }).start();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadSubjecttocombobox();

    }


}
