package CONTROLLER;

import MODEL.TaikhoanEntity;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ct_Main implements Initializable,Runnable {

    @FXML
    private Button btn_notify;

    @FXML
    private BorderPane pane_Main;

    @FXML
    private Pane pane_notify;

    @FXML
    private Button btn_menu;

    @FXML
    private Text txt_Date;

    @FXML
    private Circle img_student;

    @FXML
    private Pane pane_Menu;

    @FXML
    private BorderPane border_Menu;

    public void Login_info(TaikhoanEntity taikhoan ){
        System.out.println(taikhoan.getMaQuyen());
    }
    public void setCurrentDate(){
        while (true) {
            long millis = System.currentTimeMillis();
            Date date = new java.util.Date(millis);
            txt_Date.setText(date.toString());
        }
    }

    @FXML
    void btn_notofi_click(ActionEvent event) {
        if(pane_Main.getRight()!=null){
            pane_Main.setRight(null);
        }else {
            pane_Main.setRight(pane_notify);
        }
    }

    @FXML
    void btn_menu_click(ActionEvent event) {
        if(border_Menu.getLeft()!=null){
            border_Menu.setLeft(null);
        }else {
            border_Menu.setLeft(pane_Menu);
        }

    }



    public void setImg_student(){
        Image image = new Image("VIEW/Image/trong.jpg");
        img_student.setFill(new ImagePattern(image));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImg_student();
        Thread thread = new Thread(this::setCurrentDate);
        thread.start();
        border_Menu.setLeft(null);
        pane_Main.setRight(null);
    }

    @Override
    public void run() {

    }
}
