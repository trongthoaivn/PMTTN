package CONTROLLER;

import MODEL.TaikhoanEntity;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.nio.file.OpenOption;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class ct_Main implements Initializable,Runnable {

    @FXML
    private BorderPane pane_Main;

    @FXML
    private BorderPane pane_Center;

    @FXML
    private Text txt_Date;

    @FXML
    private Button btn_notify;

    @FXML
    private Pane pane;

    @FXML
    private Pane pane_notify;

    @FXML
    private Circle img_student;

    @FXML
    private Text txt_login_name;

    @FXML
    private Text txt_rule;

    @FXML
    private Button btn_exit;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_admin;

    @FXML
    private Button btn_teacher;

    @FXML
    private Button btn_student;

    @FXML
    private Button btn_test;

    @FXML
    private Button btn_schedule;

    @FXML
    private Button btn_history;

    @FXML
    private Button btn_statistic;

    @FXML
    private Button btn_network;

    @FXML
    private BorderPane border_Menu;

    @FXML
    private Button btn_menu;

    @FXML
    private Pane pane_Menu;

    @FXML
    private Button btn_Add;

    @FXML
    private Button btn_edit;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_refresh;


    @FXML
    void exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Are you sure you want to logout ?");
        Optional<ButtonType> option = alert.showAndWait();
        if(option.get()==ButtonType.OK)
            Platform.exit();

    }


    @FXML
    void load_frm_history(ActionEvent event) {

    }

    @FXML
    void load_frm_network(ActionEvent event) {

    }

    @FXML
    void load_frm_schedule(ActionEvent event) {

    }

    @FXML
    void load_frm_statistic(ActionEvent event) {

    }

    @FXML
    void load_frm_student(ActionEvent event) {

    }

    @FXML
    void load_frm_teacher(ActionEvent event) {

    }

    @FXML
    void load_frm_test(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

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

    @FXML
    void load_frm_admin(ActionEvent event) throws IOException {
        Pane  frm_admin = FXMLLoader.load(getClass().getResource("/VIEW//Form/frm_Admin.fxml"));
        pane_Center.setCenter(frm_admin);
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
