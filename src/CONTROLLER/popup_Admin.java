package CONTROLLER;

import MODEL.AdminEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class popup_Admin implements Initializable {

    @FXML
    private ImageView img_Ad;

    @FXML
    private Label txt_maAd;

    @FXML
    private Label txt_tenAd;

    @FXML
    private Label txt_ngaysinh;

    @FXML
    private Label txt_us;

    @FXML
    private Label txt_pw;
    AdminEntity recent ;

    public void setImg(String url){
        if (url.equals("")==false){
            Image image = new Image(url);
            img_Ad.setImage(image);
        }
    }

    public  void detailinfo_Admin(AdminEntity adminEntity){
        if (recent != adminEntity){
            txt_maAd.setText(adminEntity.getMaAd());
            txt_tenAd.setText(adminEntity.getTenAd());
            Date date = new Date(adminEntity.getNgaysinh().getTime());
            txt_ngaysinh.setText(date.toString());
            txt_us.setText(adminEntity.getTaikhoanByUsername().getUsername());
            txt_pw.setText(adminEntity.getTaikhoanByUsername().getPasswords());
            setImg(adminEntity.getImgAd());
        }
        recent = adminEntity;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
