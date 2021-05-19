package CONTROLLER;

import DAO.giaovienDao;
import DAO.taikhoanDao;
import MODEL.GiaovienEntity;
import MODEL.QuyenEntity;
import MODEL.TaikhoanEntity;
import REF.ComboItem;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class ct_addeditTeacher implements Initializable {
    
    
    @FXML
    public Button btn_insertimg;
    public Rectangle img;
    public TextField txt_maT;
    public TextField txt_tenT;
    public TextField txt_us;
    public TextField txt_pw;
    public ComboBox<ComboItem> cbo_rule;
    public Button btn_save;
    public Button btn_cancel;
    public RadioButton rdb_active;
    public ToggleGroup radiobutton;
    public RadioButton rdb_disable;
    @FXML
    private DatePicker dp_Ngaysinh;

    DAO.taikhoanDao taikhoanDao = new taikhoanDao();
    DAO.giaovienDao giaovienDao = new giaovienDao();
    Boolean status ;
    File source, dest;
    String   url="";
    int flag =0;
    DateTimeFormatter formatER= DateTimeFormatter.ofPattern("dd/MM/yyyy");

    void setInformation_Teacher(GiaovienEntity teacher) throws ParseException {
        txt_maT.setText(teacher.getMaGv());
        txt_tenT.setText(teacher.getTenGv());
        dp_Ngaysinh.setValue(LocalDate.parse(convertTimeStamptoDate(teacher.getNgaysinh()),formatER));
        url=teacher.getImgGv();
        txt_us.setText(teacher.getTaikhoanByUsername().getUsername());
        txt_pw.setText(teacher.getTaikhoanByUsername().getPasswords());
        if(teacher.getTaikhoanByUsername().getTrangthai()==true){
            rdb_active.setSelected(true);
        }else{
            rdb_disable.setSelected(true);
        }
        cbo_rule.getSelectionModel().select(0);


        if (teacher.getImgGv().equals("")==false)
            setImg(new Image(teacher.getImgGv()));
        flag =1;
    }

    public void Openfile(ActionEvent actionEvent) throws IOException {
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

    public void CheckEmpty(MouseEvent mouseEvent) {
    }

    public void save_Teacher(ActionEvent actionEvent) throws IOException {
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

            File fileAd= new File("src/DataSet/"+txt_maT.getText()+".jpg");
            if (fileAd.exists() )
            {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(fileAd.getName()+ "this file is existing !" +
                        "\n"+" Replace this file ?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get() == ButtonType.OK){
                    copyFileUsingStream(source,dest);
                    url = "DataSet/"+txt_maT.getText()+".jpg";
                }


            }

            GiaovienEntity giaovienEntity = new GiaovienEntity(
                    txt_maT.getText(),
                    txt_tenT.getText(),
                    convertStringToTimestamp(formatER.format(dp_Ngaysinh.getValue())),
                    url,
                    taikhoanEntity
            );
            try{
                if (flag == 0){
                    if(taikhoanDao.addData(taikhoanEntity)==1 && giaovienDao.addData(giaovienEntity)==1 ) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Add new Teacher complete!");
                        alert.show();
                    }
                }

                else{
                    if(taikhoanDao.updateData(taikhoanEntity)==1 && giaovienDao.updateData(giaovienEntity)==1 ) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Update Teacher complete!");
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

    public void cancel(ActionEvent actionEvent) {

        System.out.println("Cancel");
        System.out.println(flag);
    }

    public static String convertTimeStamptoDate(Timestamp timestamp) throws ParseException {
        Timestamp ts = new Timestamp(timestamp.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = format.parse(ts.toString());
        format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
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

    public void setImg(Image link){
        if (link.equals("")==false) {
            img.setFill(new ImagePattern(link));

        }
    }
    public Boolean check_Empty(){
        if(txt_maT.getText().equals("")==false
                && txt_tenT.getText().equals("")==false
                && dp_Ngaysinh.getValue()!=null
                && txt_pw.getText().equals("")==false
                && txt_us.getText().equals("")==false)
            return true;
        else
            return false;
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
    public void check_Teacher(){
        String str =giaovienDao.getGv_id_last();
        int id =Integer.parseInt(str.substring(str.indexOf("GV")+2))+1;
        txt_maT.setText("GV"+id);
        txt_us.setText("giaovien"+id);
    }

    public void addComboboxItem(){
        cbo_rule.setItems(FXCollections.observableArrayList(
                new ComboItem("Admin",1),
                new ComboItem("Teacher",2),
                new ComboItem("Student",3)
        ));
        cbo_rule.getSelectionModel().select(1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addComboboxItem();
        rdb_active.setSelected(true);
        check_Teacher();
    }
}
