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
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;


import java.io.*;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class ct_addeditAdmin implements Initializable{

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
    private TextField txt_us;

    @FXML
    private TextField txt_pw;

    @FXML
    private RadioButton rdb_active;

    @FXML
    private RadioButton rdb_disable;

    @FXML
    private DatePicker dp_Ngaysinh;

    @FXML
    private Button btn_save;

    @FXML
    private Button btn_cancel;

    String   url="";
    Boolean status ;
    taikhoanDao taikhoanDao = new taikhoanDao();
    adminDao adminDao = new adminDao();
    File source, dest;
    int flag =0;
    DateTimeFormatter formatER= DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void check_Admin(){
        LocalDateTime dateTime =  java.time.LocalDateTime.now();
        int year=  dateTime.getYear();
        int day = dateTime.getDayOfMonth();
        int h =dateTime.getHour();
        int m = dateTime.getMinute();
        int s = dateTime.getSecond();
        txt_maAd.setText("AD"+""+year+""+day+""+h+""+m+""+s);
        txt_us.setText("AD"+""+year+""+day+""+h+""+m+""+s);
    }
    public Boolean check_Empty(){
        if(txt_maAd.getText().equals("")==false
                && txt_tenAd.getText().equals("")==false
                && dp_Ngaysinh.getValue()!=null
                && txt_pw.getText().equals("")==false
                && txt_us.getText().equals("")==false)
            return true;
        else
            return false;
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
    public static String convertTimeStamptoDate(Timestamp timestamp) throws ParseException {
        Timestamp ts = new Timestamp(timestamp.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = format.parse(ts.toString());
        format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }


    @FXML
    void cancel(ActionEvent event) {

        System.out.println("Cancel");
        System.out.println(flag);
    }

    @FXML
    void save_Ad(ActionEvent event) throws ParseException, IOException {
        System.out.println(check_Empty().toString());
        if (check_Empty()==true){
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

            File fileAd= new File("src/DataSet/"+txt_maAd.getText()+".jpg");
            if (fileAd.exists() )
            {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(fileAd.getName()+ "this file is existing !" +
                        "\n"+" Replace this file ?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get() == ButtonType.OK){
                    copyFileUsingStream(source,dest);
                    url = "DataSet/"+txt_maAd.getText()+".jpg";
                }


            }

            AdminEntity adminEntity = new AdminEntity(
                    txt_maAd.getText(),
                    txt_tenAd.getText(),
                    convertStringToTimestamp(formatER.format(dp_Ngaysinh.getValue())),
                    url,
                    taikhoanEntity
            );
            try{
                if (flag == 0){
                    if(taikhoanDao.addData(taikhoanEntity)==1 && adminDao.addData(adminEntity)==1 ) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Add new Admin complete!");
                        alert.show();
                    }
                }

                else{
                        if(taikhoanDao.updateData(taikhoanEntity)==1 && adminDao.updateData(adminEntity)==1 ) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setContentText("Update Admin complete!");
                            alert.show();
                        }
                    }

            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(e.toString());
                alert.show();
            }
        }
    }


    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public void setImg(Image link){
        if (link.equals("")==false) {
            img.setFill(new ImagePattern(link));

        }
    }

    public void addComboboxItem(){
        cbo_rule.setItems(FXCollections.observableArrayList(
                new ComboItem("Admin",1),
                new ComboItem("Teacher",2),
                new ComboItem("Student",3)
        ));
        cbo_rule.getSelectionModel().selectFirst();
    }

    @FXML
    void Openfile(ActionEvent event) throws IOException {
        final FileChooser fileChooser= new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Image file","*.jpg","*.png");
        fileChooser.getExtensionFilters().add(filter);
        File file =fileChooser.showOpenDialog(null);
        if(file!=null){
            source =file;
            dest = new File("src/DataSet/"+file.getName());
            copyFileUsingStream(source,dest);
            url="DataSet/"+file.getName();
            System.out.println(file.getPath().replace(file.getPath().substring(0,2),"file:"));
            setImg(new Image(file.getPath().replace(file.getPath().substring(0,2),"file:")));
        }
    }

    void setInformation_Admin(AdminEntity admin) throws ParseException {
        txt_maAd.setText(admin.getMaAd());
        txt_tenAd.setText(admin.getTenAd());
        dp_Ngaysinh.setValue(LocalDate.parse(convertTimeStamptoDate(admin.getNgaysinh()),formatER));
        url=admin.getImgAd();
        txt_us.setText(admin.getTaikhoanByUsername().getUsername());
        txt_pw.setText(admin.getTaikhoanByUsername().getPasswords());
        if(admin.getTaikhoanByUsername().getTrangthai()==true){
            rdb_active.setSelected(true);
        }else{
            rdb_disable.setSelected(true);
        }
        cbo_rule.getSelectionModel().select(0);


        if (admin.getImgAd().equals("")==false)
            setImg(new Image(admin.getImgAd()));
        flag =1;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addComboboxItem();
        rdb_active.setSelected(true);
        check_Admin();
//        setImg(new Image("file:/Users/trong/Pictures/Saved Pictures/1.jpg"));
    }
}
