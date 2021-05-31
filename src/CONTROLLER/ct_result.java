package CONTROLLER;

import DAO.ketquaDao;
import MODEL.AdminEntity;
import MODEL.HocsinhEntity;
import MODEL.KetquaEntity;
import MODEL.KythiEntity;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;

public class ct_result implements Initializable {

    @FXML
    private ComboBox<?> cbo_Lop;

    @FXML
    private TextField txt_MaHS;

    @FXML
    private TextField txt_maKT;

    @FXML
    private TableView<KetquaEntity> tbv_KQ;

    @FXML
    private TextArea txt_Kythi;

    @FXML
    private TextField txt_tenHS;

    @FXML
    private TextField txt_ngaythi;

    @FXML
    private TextField txt_diem;

    @FXML
    private TextField txt_xeploai;

    ketquaDao dao = new ketquaDao();

    public void setTbv_KQ(){
        List<KetquaEntity> list = dao.getAll();
        tbv_KQ.setItems(FXCollections.observableArrayList(list));
        TableColumn col1 =   tbv_KQ.getColumns().get(0);
        col1.setCellValueFactory(new PropertyValueFactory<KetquaEntity,String>("maKq"));
        TableColumn col2 =   tbv_KQ.getColumns().get(1);
        col2.setCellValueFactory(new PropertyValueFactory<KetquaEntity, Timestamp>("ngaythi"));
        TableColumn col3 =   tbv_KQ.getColumns().get(2);
        col3.setCellValueFactory(new PropertyValueFactory<KetquaEntity,Double>("diem"));
        TableColumn col4 =   tbv_KQ.getColumns().get(3);
        col4.setCellValueFactory(new PropertyValueFactory<KetquaEntity,String>("xeploai"));
        TableColumn col5 =   tbv_KQ.getColumns().get(4);
        col5.setCellValueFactory(new PropertyValueFactory<KetquaEntity, KythiEntity>("kythiByMaKt"));
        TableColumn col6 =   tbv_KQ.getColumns().get(5);
        col6.setCellValueFactory(new PropertyValueFactory<KetquaEntity, HocsinhEntity>("hocsinhByMaHs"));

    }


    public void selectKQ(MouseEvent event) {
        KetquaEntity kq = tbv_KQ.getSelectionModel().getSelectedItem();
        txt_Kythi.setText(kq.getKythiByMaKt().getTenKt());
        txt_tenHS.setText(kq.getHocsinhByMaHs().getTenHs());
        txt_diem.setText(String.valueOf(kq.getDiem()));
        txt_ngaythi.setText(String.valueOf(kq.getNgaythi()));
        if (kq.getXeploai())
            txt_xeploai.setText("Đạt");
        else
            txt_xeploai.setText("Chưa đạt");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(()->{
           setTbv_KQ();
        }).start();
    }


}
