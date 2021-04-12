package CONTROLLER;

import DAO.adminDao;
import DAO.taikhoanDao;
import MODEL.AdminEntity;
import MODEL.TaikhoanEntity;
import REF.CustomImage;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.hibernate.tuple.PropertyFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ct_Admin implements Initializable {

    @FXML
    private TableView<AdminEntity>tbv_Admin;
    ObservableList<AdminEntity> adminEntities ;
    ObservableList<TaikhoanEntity> taikhoanEntities;


    public  void test(){
        adminDao dao =new adminDao();

        System.out.println(dao.getAdmin());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        adminDao dao = new adminDao();
        taikhoanDao dao1 = new taikhoanDao();
        adminEntities= dao.getAll();
        taikhoanEntities=dao1.getAll();

        tbv_Admin.setItems(adminEntities);

        TableColumn col1 =   tbv_Admin.getColumns().get(0);
        col1.setCellValueFactory(new PropertyValueFactory("maAd"));
        TableColumn col2 =   tbv_Admin.getColumns().get(1);
        col2.setCellValueFactory(new PropertyValueFactory("tenAd"));
        TableColumn col3 =  tbv_Admin.getColumns().get(2);
        col3.setCellValueFactory(new PropertyValueFactory("ngaysinh"));
        TableColumn col4 =  tbv_Admin.getColumns().get(3);
        col4.setCellValueFactory(new PropertyValueFactory<CustomImage, ImageView>("imgAd"));
        TableColumn col5 =   tbv_Admin.getColumns().get(4);
        col5.setCellValueFactory(new PropertyValueFactory("username"));
        TableColumn col6 =   tbv_Admin.getColumns().get(5);
        col6.setCellValueFactory(new PropertyValueFactory("username"));

//         test();

    }
}
