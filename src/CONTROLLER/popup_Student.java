package CONTROLLER;


import MODEL.HocsinhEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Date;

public class popup_Student {

    @FXML
    private ImageView img_S;

    @FXML
    private Label txt_maS;

    @FXML
    private Label txt_tenS;

    @FXML
    private Label txt_ngaysinh;

    @FXML
    private Label txt_us;

    @FXML
    private Label txt_pw;

    @FXML
    private Label txt_grade;

    @FXML
    private Label txt_class;

    HocsinhEntity recent ;
    public void setImg(String url){
        if (url.equals("")==false){
            Image image = new Image(url);
            img_S.setImage(image);
        }
    }

    public  void detailinfo_Student(HocsinhEntity hocsinhEntity){
        if (recent != hocsinhEntity){
            txt_maS.setText(hocsinhEntity.getMaHs());
            txt_tenS.setText(hocsinhEntity.getTenHs());
            Date date = new Date(hocsinhEntity.getNgaysinh().getTime());
            txt_ngaysinh.setText(date.toString());
            txt_us.setText(hocsinhEntity.getTaikhoanByUsername().getUsername());
            txt_pw.setText(hocsinhEntity.getTaikhoanByUsername().getPasswords());
            System.out.println(hocsinhEntity.getImgHs());
            if(hocsinhEntity.getImgHs().equals("")==false)
                setImg(hocsinhEntity.getImgHs());
        }
        recent = hocsinhEntity;
    }


}