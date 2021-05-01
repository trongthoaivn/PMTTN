package CONTROLLER;

import MODEL.GiaovienEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Date;

public class popup_Teacher {
    @FXML
    public Label txt_maT;
    public Label txt_tenT;
    public Label txt_ngaysinh;
    public Label txt_us;
    public Label txt_pw;
    public ImageView img_T;

    GiaovienEntity recent;

    public void setImg(String url){
        if (url.equals("")==false){
            Image image = new Image(url);
            img_T.setImage(image);
        }
    }

    public  void detailinfo_Teacher(GiaovienEntity giaovien){
        if (recent != giaovien){
            txt_maT.setText(giaovien.getMaGv());
            txt_tenT.setText(giaovien.getTenGv());
            Date date = new Date(giaovien.getNgaysinh().getTime());
            txt_ngaysinh.setText(date.toString());
            txt_us.setText(giaovien.getTaikhoanByUsername().getUsername());
            txt_pw.setText(giaovien.getTaikhoanByUsername().getPasswords());
            if(giaovien.getImgGv().equals("")==false)
                setImg(giaovien.getImgGv());
        }
        recent = giaovien;
    }
}
