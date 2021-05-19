package CONTROLLER;

import DAO.adminDao;
import MODEL.AdminEntity;
import MODEL.TaikhoanEntity;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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
    private Button btn_search;


    AdminEntity admin = new AdminEntity();
    Pane  frm_admin = null;
    Pane  frm_teacher = null;
    Pane  frm_student = null;
    Pane  frm_Exam = null;
    Thread thread;
    private ct_Admin ControllerAdmin;
    private ct_Teacher ControllerTeacher;
    private ct_Student ControllerStudent;
    private ct_Exam ControllerExam;


    @FXML
    void exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout ?");
        Optional<ButtonType> option = alert.showAndWait();
        if(option.get()==ButtonType.OK) {
            Platform.exit();
            thread.interrupt();
        }else if(option.get()==ButtonType.CANCEL){
            alert.close();
        }else
            alert.close();


    }

    @FXML
    void searchRow(ActionEvent event) {
        if(pane_Center.getCenter() ==frm_admin){
            System.out.println("search admin");
        }
    }

    @FXML
    void editRow(ActionEvent event) throws IOException, ParseException {
        if(pane_Center.getCenter() ==frm_admin){
            ControllerAdmin.EditAdmin();
        }
        if(pane_Center.getCenter() ==frm_teacher){
            ControllerTeacher.EditTeacher();
        }
        if(pane_Center.getCenter() ==frm_student){
            ControllerStudent.EditStudent();
        }
        if(pane_Center.getCenter() ==frm_Exam){
            ControllerExam.EditExam();
        }

    }

    @FXML
    void deleteRow(ActionEvent event) throws IOException {
        if(pane_Center.getCenter() ==frm_admin){
            ControllerAdmin.DeleteAdmin();
            btn_refresh.fire();
            btn_refresh.fire();
        }
        if(pane_Center.getCenter() ==frm_teacher){
            ControllerTeacher.DeleteTeacher();
            btn_refresh.fire();
            btn_refresh.fire();
        }
        if(pane_Center.getCenter() ==frm_student){
            ControllerStudent.DeleteStudent();
            btn_refresh.fire();
            btn_refresh.fire();
        }
        if(pane_Center.getCenter() ==frm_Exam){
            ControllerExam.DeleteExam();
            btn_refresh.fire();
            btn_refresh.fire();
        }
    }

    @FXML
    void newRow(ActionEvent event) throws IOException {
        if(pane_Center.getCenter() ==frm_admin){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/fadd_edit_Admin.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UTILITY);
            if(stage.isShowing()==false){
                stage.show();
            }
        }
        if(pane_Center.getCenter() ==frm_teacher){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/fadd_edit_Teacher.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UTILITY);
            if(stage.isShowing()==false){
                stage.show();
            }
        }
        if(pane_Center.getCenter() ==frm_student){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/fadd_edit_Student.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UTILITY);
            if(stage.isShowing()==false){
                stage.show();
            }
        }
        if(pane_Center.getCenter() ==frm_Exam){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/fadd_edit_Exam.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UTILITY);
            if(stage.isShowing()==false){
                stage.show();
            }
        }

    }

    @FXML
    void refresh(ActionEvent event) throws IOException {
        if(pane_Center.getCenter() ==frm_admin){
            try {
                btn_admin.fire();
                btn_admin.fire();

            }catch (Exception e){
                System.out.println(e);
            }
        }
        if(pane_Center.getCenter() ==frm_teacher){
            try {
                btn_teacher.fire();
                btn_teacher.fire();

            }catch (Exception e){
                System.out.println(e);
            }
        }
        if(pane_Center.getCenter() ==frm_student){
            try {
                btn_student.fire();
                btn_student.fire();

            }catch (Exception e){
                System.out.println(e);
            }
        }
        if(pane_Center.getCenter() ==frm_Exam){
            try {
                btn_test.fire();
                btn_test.fire();

            }catch (Exception e){
                System.out.println(e);
            }
        }

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
    void load_frm_student(ActionEvent event) throws IOException {

        if (pane_Center.getCenter()!= frm_student || pane_Center.getCenter()==null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW//Form/frm_Student.fxml"));

            frm_student = (Pane) loader.load();

            ControllerStudent =loader.getController();
            pane_Center.setCenter(frm_student);
        }else{
            pane_Center.setCenter(pane);
        }

    }

    @FXML
    void load_frm_teacher(ActionEvent event) throws IOException {
        if (pane_Center.getCenter()!= frm_teacher || pane_Center.getCenter()==null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW//Form/frm_Teacher.fxml"));
            frm_teacher = (Pane) loader.load();

            ControllerTeacher =loader.getController();
            pane_Center.setCenter(frm_teacher);
        }else{
            pane_Center.setCenter(pane);
        }

    }

    @FXML
    void load_frm_test(ActionEvent event) throws IOException {
        if (pane_Center.getCenter()!= frm_Exam || pane_Center.getCenter()==null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW//Form/frm_Exam.fxml"));
            frm_Exam = (Pane) loader.load();
            ControllerExam =loader.getController();
            pane_Center.setCenter(frm_Exam);
        }else{
            pane_Center.setCenter(pane);
        }
    }

    @FXML
    void logout(ActionEvent event) {
        System.out.println();
    }



    public void Login_info(TaikhoanEntity taikhoan ){
        if (taikhoan.getQuyenByMaQuyen().getMaQuyen()==1){
//            System.out.println(taikhoan.getAdminsByUsername().getTenAd());
            adminDao adminDao= new adminDao();
            admin = adminDao.infoAdmin(taikhoan.getUsername());
            txt_login_name.setText(admin.getTenAd());
            txt_rule.setText("Administrator");
            setImg_student(admin.getImgAd());

        }

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
        if (pane_Center.getCenter()!= frm_admin || pane_Center.getCenter()==null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW//Form/frm_Admin.fxml"));
            frm_admin = (Pane) loader.load();

            ControllerAdmin =loader.getController();
            pane_Center.setCenter(frm_admin);
        }else{
            pane_Center.setCenter(pane);
        }

    }

    public void setImg_student(String url){
        if (url.equals("")==false) {
            Image image = new Image(url);
            img_student.setFill(new ImagePattern(image));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        thread = new Thread(this::setCurrentDate);
        thread.start();
//        border_Menu.setLeft(null);
//        pane_Main.setRight(null);
//        adminDao adminDao= new adminDao();
//        admin = adminDao.infoAdmin("admin1");
//        System.out.println(admin.getTenAd());

    }

    @Override
    public void run() {

    }
}
