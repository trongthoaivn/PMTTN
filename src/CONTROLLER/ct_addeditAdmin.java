package CONTROLLER;

import DAO.adminDao;
import DAO.taikhoanDao;
import MODEL.AdminEntity;
import MODEL.QuyenEntity;
import MODEL.TaikhoanEntity;
import REF.ComboItem;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;


import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ct_addeditAdmin implements Initializable {

    @FXML
    private ComboBox<ComboItem> cbo_rule;

    @FXML
    private Button btn_insertimg;

    @FXML
    private Rectangle img;

    @FXML
    private TextField txt_maAd;

    @FXML
    private TextField txt_tenAd;

    @FXML
    private TextField txt_ngaysinh;

    @FXML
    private TextField txt_us;

    @FXML
    private TextField txt_pw;

    @FXML
    private RadioButton rdb_active;

    @FXML
    private RadioButton rdb_disable;


    @FXML
    private Button btn_save;

    @FXML
    private Button btn_cancel;

    String   url;
    Boolean status ;
    taikhoanDao taikhoanDao = new taikhoanDao();
    adminDao adminDao = new adminDao();


    public Boolean check_Admin(){
        return true;
    }
    public Boolean check_Empty(){
        if(txt_maAd.getText()=="") System.out.println("Code is empty");
        if(txt_tenAd.getText()=="") System.out.println("Name is empty");
        return true;
    }

    @FXML
    void CheckEmpty(MouseEvent event) {
        if(txt_maAd.getText().equals("")) System.out.println("Code is empty");
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



    @FXML
    void cancel(ActionEvent event) {
        System.out.println("Cancel");
    }

    @FXML
    void save_Ad(ActionEvent event) throws ParseException {
        QuyenEntity quyenEntity = new QuyenEntity(
                cbo_rule.getValue().getValue(),
                cbo_rule.getValue().getKey());



        if(rdb_active.isSelected()) status= Boolean.TRUE;
        else status=Boolean.FALSE;
        TaikhoanEntity taikhoanEntity = new TaikhoanEntity(
                txt_us.getText(),
                txt_pw.getText(),
                status,
                quyenEntity);


        System.out.println( "taikhoan "+ taikhoanDao.addData(taikhoanEntity));


        AdminEntity adminEntity = new AdminEntity(
                txt_maAd.getText(),
                txt_tenAd.getText(),
                convertStringToTimestamp(txt_ngaysinh.getText()),
                url,
                taikhoanEntity
        );
        System.out.println("admin " +  adminDao.addData(adminEntity));

    }

    public void addComboboxItem(){
        cbo_rule.setItems(FXCollections.observableArrayList(
                new ComboItem("Admin",1),
                new ComboItem("Teacher",2),
                new ComboItem("Student",3)
        ));
    }

    @FXML
    void Openfile(ActionEvent event) {
        final FileChooser fileChooser= new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Image file","*.jpg","*.png");
        fileChooser.getExtensionFilters().add(filter);
        File file =fileChooser.showOpenDialog(null);
        if(file!=null){
            System.out.println(file.getName());
            String directory = "VIEW/Image/"+file.getName();
            File fileAd= new File(directory);
            if (fileAd.isFile())
            {
                System.out.println(fileAd.getPath());
            }else {
                System.out.println(fileAd.getPath());
                System.out.println("none");
            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addComboboxItem();
    }
}
