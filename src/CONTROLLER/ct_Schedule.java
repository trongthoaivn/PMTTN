package CONTROLLER;
import DAO.*;
import MODEL.*;
import REF.ComboboxString;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ct_Schedule implements Initializable {
    @FXML
    private TableView<KythiEntity> tbv_KT;

    @FXML
    private DatePicker dp_date;

    @FXML
    private TableView<GiaovienEntity> tbv_Teacher;

    @FXML
    private TableView<HocsinhEntity> tbv_Student;

    @FXML
    private ComboBox<ComboboxString> cbo_class;

    @FXML
    private TableView<GiaovienEntity> tbv_teacher_temp;

    @FXML
    private TableView<HocsinhEntity> tbv_student_temp;

    @FXML
    private Pane pane;

    @FXML
    private TextField txt_maKT;

    @FXML
    private TextArea txt_tenKT;

    @FXML
    private DatePicker dp_ngaythi;

    @FXML
    private TextField txt_Tglambai;

    @FXML
    private TextField txt_batdau;

    @FXML
    private TextField txt_ketthuc;

    @FXML
    private TextField txt_SL;

    @FXML
    private ComboBox<ComboboxString> cbo_Monhoc;

    @FXML
    private ComboBox<ComboboxString> cbo_HK;

    List<KythiEntity> kythi= new ArrayList<>();
    List<HocsinhEntity> hocsinh= new ArrayList<>();
    List<GiaovienEntity> giaovien= new ArrayList<>();
    List<HocsinhEntity> hsTemp = new ArrayList<>();
    List<GiaovienEntity> gvTemp = new ArrayList<>();
    Thread threadKt = new Thread();
    Thread threadHs = new Thread();
    Thread threadGV = new Thread();
    Thread threadClass = new Thread();
    Thread threadSubject = new Thread();
    int chooseGVorHS = 0;
    HocsinhEntity recent_hocsinh = null;
    GiaovienEntity recent_giaovien = null;
    KythiEntity recent_kythi = null;
    DateTimeFormatter formatER= DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @FXML
    void Add_KT(ActionEvent event) {
        setclear();
        if (pane.isVisible()) pane.setVisible(false);
        else pane.setVisible(true);
    }

    public void setclear(){
        txt_maKT.clear();
        txt_tenKT.clear();
        txt_SL.clear();
        txt_ketthuc.clear();
        txt_batdau.clear();
        txt_Tglambai.clear();
        cbo_Monhoc.getSelectionModel().clearSelection();
        dp_date.setValue(java.time.LocalDate.now());
    }

    @FXML
    void Select_KT(MouseEvent event) {
        pane.setVisible(true);
        recent_kythi = tbv_KT.getSelectionModel().getSelectedItem();
        try{
            if (!recent_kythi.getMaKt().equals("")) {
                txt_maKT.setText(recent_kythi.getMaKt());
                txt_tenKT.setText(recent_kythi.getTenKt());
                txt_Tglambai.setText(String.valueOf(recent_kythi.getTgLambai()));
                txt_batdau.setText(String.valueOf(recent_kythi.getTgBatdau()).substring(0,4));
                txt_ketthuc.setText(String.valueOf(recent_kythi.getTgKetthuc()).substring(0,4));
                txt_SL.setText(String.valueOf(recent_kythi.getSlCh()));
                dp_ngaythi.setValue(recent_kythi.getNgaythi().toLocalDateTime().toLocalDate());
                for (ComboboxString a : cbo_Monhoc.getItems()) {
                    if (a.getValue().equals(recent_kythi.getMonhocByMaMh().getMaMh())) {
                        cbo_Monhoc.getSelectionModel().select(a);
                    }
                }
                thisinhDao dao = new thisinhDao();
                hocsinh.clear();
                tbv_student_temp.getItems().clear();
                hocsinh = dao.getThisinhbyKT(recent_kythi);
                if (!hocsinh.isEmpty()){
                    tbv_student_temp.setItems(FXCollections.observableArrayList(hocsinh));
                    TableColumn col1 =   tbv_student_temp.getColumns().get(0);
                    col1.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("maHs"));
                    TableColumn col2 =   tbv_student_temp.getColumns().get(1);
                    col2.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("tenHs"));
                }

            }
        }catch (Exception e){}

    }

    @FXML
    void delete_KT(ActionEvent event) {
        try{
            kythiDao dao= new kythiDao();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want delete "+ recent_kythi.getTenKt());
            Optional<ButtonType> option = alert.showAndWait();
            if(option.get()==ButtonType.OK) {
                System.out.println(dao.delData(recent_kythi));
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        this.refresh(event);
        setclear();
    }

    @FXML
    void refresh(ActionEvent event) {
        kythiDao dao = new kythiDao();
        kythi = dao.getAll();
        tbv_KT.setItems(FXCollections.observableArrayList(kythi));

    }

    @FXML
    void remove(ActionEvent event) {

    }

    @FXML
    void remove_all(ActionEvent event) {

    }

    @FXML
    void save_DS(ActionEvent event) {

    }

    @FXML
    void save_KT(ActionEvent event) {
        kythiDao  dao = new kythiDao();
        try {
            if(getkythi()!=null && dao.addData(getkythi())==1){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Save complete !");
                alert.showAndWait();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        this.refresh(event);

    }

    public static Timestamp convertStringToTimestamp(String str_date) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = (Date) formatter.parse(str_date);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }
    public boolean check_empty(){
        return !txt_maKT.getText().equals("")&&!txt_tenKT.getText().equals("")
                &&!txt_SL.getText().equals("")&&!txt_Tglambai.getText().equals("")
                &&!txt_batdau.getText().equals("")&&!txt_ketthuc.getText().equals("")
                &&cbo_Monhoc.getSelectionModel().getSelectedItem()!=null;
    }
    public KythiEntity getkythi(){
        if (check_empty())
        return new KythiEntity(
                txt_maKT.getText(),
                txt_tenKT.getText(),
                convertStringToTimestamp(formatER.format(dp_ngaythi.getValue())),
                Integer.valueOf(txt_Tglambai.getText()),
                Time.valueOf(txt_batdau.getText()+":00"),
                Time.valueOf(txt_batdau.getText()+":00"),
                Integer.valueOf(txt_SL.getText()),
                new MonhocEntity(cbo_Monhoc.getValue().getValue(),cbo_Monhoc.getValue().getKey())
        );
        else return null;
    }

    @FXML
    void select(ActionEvent event) {
        if (chooseGVorHS==1&&!recent_hocsinh.getMaHs().equals("")&&hsTemp.indexOf(recent_hocsinh)==-1){
            hsTemp.add(recent_hocsinh);
            tbv_student_temp.setItems(FXCollections.observableArrayList(hsTemp));
            TableColumn col1 =   tbv_student_temp.getColumns().get(0);
            col1.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("maHs"));
            TableColumn col2 =   tbv_student_temp.getColumns().get(1);
            col2.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("tenHs"));
        }
        if (chooseGVorHS==2&& !recent_giaovien.getMaGv().equals("")&&gvTemp.indexOf(recent_giaovien)==-1){
            gvTemp.add(recent_giaovien);
            tbv_teacher_temp.setItems(FXCollections.observableArrayList(gvTemp));
            TableColumn col1 =   tbv_teacher_temp.getColumns().get(0);
            col1.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("maGv"));
            TableColumn col2 =   tbv_teacher_temp.getColumns().get(1);
            col2.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("tenGv"));
        }
    }

    @FXML
    void select_Student(MouseEvent event) throws IOException {
        chooseGVorHS = 1;
        recent_hocsinh = tbv_Student.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/popup_Student.fxml"));
        Parent root = loader.load();
        popup_Student main = loader.getController();
        main.detailinfo_Student(recent_hocsinh);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UTILITY);
        stage.setX(event.getScreenX());
        stage.setY(event.getScreenY());
        stage.show();
        PauseTransition wait = new PauseTransition(Duration.seconds(3));
        wait.setOnFinished((e) -> {
            stage.close();
        });
        wait.play();
    }

    @FXML
    void select_Teacher(MouseEvent event) throws IOException {
        chooseGVorHS = 2;
        recent_giaovien=tbv_Teacher.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/popup_Teacher.fxml"));
        Parent root = loader.load();
        popup_Teacher main = loader.getController();
        main.detailinfo_Teacher(recent_giaovien);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UTILITY);
        stage.setX(event.getScreenX());
        stage.setY(event.getScreenY());
        stage.show();
        PauseTransition wait = new PauseTransition(Duration.seconds(3));
        wait.setOnFinished((e) -> {
            stage.close();
        });
        wait.play();
    }

    @FXML
    void select_all(ActionEvent event) {

    }

    @FXML
    void sort_class(ActionEvent event) {
        List<HocsinhEntity> list = new ArrayList<>();
        for(HocsinhEntity ahs : hocsinh){
            if (ahs.getLopByMaLop().getMaLop().equals(cbo_class.getValue().getValue())){
                list.add(ahs);
            }
        }
        tbv_Student.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    void sort_date(ActionEvent event) {

    }

    @FXML
    void setMaKT(ActionEvent event) {
        LocalDateTime dateTime =  java.time.LocalDateTime.now();
        int year =dateTime.getYear();
        int day = dateTime.getDayOfMonth();
        int second =dateTime.getSecond();
        txt_maKT.setText(year+""+cbo_HK.getValue().getValue()+""+day+""+second);
    }
    public void Loadcbo(){
        List<ComboboxString>list = new ArrayList<>();
        list.add(new ComboboxString("Học kỳ 1","1A"));
        list.add(new ComboboxString("Học kỳ 2","2A"));
        list.add(new ComboboxString("1 tiết","1T"));
        list.add(new ComboboxString("30 phút","2T"));
        cbo_HK.setItems(FXCollections.observableArrayList(list));
//        cbo_.getSelectionModel().selectFirst();
    }
    public void LoadSubject(){
        monhocDao dao = new monhocDao();
        ObservableList<MonhocEntity> list = dao.getAll();
        List<ComboboxString> listItem = new ArrayList<>();
        list.forEach(e->{
            listItem.add(new ComboboxString(e.getTenMh(),e.getMaMh()));

        });
        cbo_Monhoc.setItems(FXCollections.observableArrayList(listItem));
        threadSubject.interrupt();
    }
    public void LoadTeacher(){
        giaovienDao dao = new giaovienDao();
        giaovien = dao.getAll();
        tbv_Teacher.setItems(FXCollections.observableArrayList(giaovien));
        if(!giaovien.get(0).getMaGv().equals("")){
            TableColumn col1 =   tbv_Teacher.getColumns().get(0);
            col1.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("maGv"));
            TableColumn col2 =   tbv_Teacher.getColumns().get(1);
            col2.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("tenGv"));
        }
        threadGV.interrupt();
    }
    public void LoadStudent(){
        hocsinhDao  dao = new hocsinhDao();
        hocsinh = dao.getAll();
        tbv_Student.setItems(FXCollections.observableArrayList(hocsinh));
        if(!hocsinh.get(0).getMaHs().equals("")){
            TableColumn col1 =   tbv_Student.getColumns().get(0);
            col1.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("maHs"));
            TableColumn col2 =   tbv_Student.getColumns().get(1);
            col2.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("tenHs"));
        }
        threadHs.interrupt();
    }
    public void getClasstocbo(){
        lopDao dao = new lopDao();
        List<LopEntity> list=dao.getAll();
        List<ComboboxString> list1 =new ArrayList<>();
        for (LopEntity alop :list){
            list1.add(new ComboboxString(alop.getTenLop(),alop.getMaLop()));
        }
        cbo_class.setItems(FXCollections.observableArrayList(list1));
        threadClass.interrupt();
    }

    public void LoadKT(){
        kythiDao dao = new kythiDao();
        kythi = dao.getAll();
        tbv_KT.setItems(FXCollections.observableArrayList(kythi));
        if(!kythi.get(0).getMaKt().equals("")){
            TableColumn col1 =   tbv_KT.getColumns().get(0);
            col1.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("maKt"));
            TableColumn col2 =   tbv_KT.getColumns().get(1);
            col2.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("tenKt"));
        }
        threadKt.interrupt();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        threadKt = new Thread(this::LoadKT);
        threadKt.start();
        threadHs = new Thread(this::LoadStudent);
        threadHs.start();
        threadGV = new Thread(this::LoadTeacher);
        threadGV.start();
        threadClass = new Thread(this::getClasstocbo);
        threadClass.start();
        threadSubject = new Thread(this::LoadSubject);
        threadSubject.start();
        Loadcbo();
    }
}
