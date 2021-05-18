package CONTROLLER;

import DAO.giaovienDao;
import DAO.hocsinhDao;
import DAO.lopDao;
import DAO.taikhoanDao;
import MODEL.*;
import REF.ComboItem;
import REF.ComboboxString;
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
import java.util.*;

public class ct_addeditStudent implements Initializable {

    @FXML
    private Button btn_insertimg;

    @FXML
    private Rectangle img;

    @FXML
    private TextField txt_maS;

    @FXML
    private TextField txt_tenS;

    @FXML
    private DatePicker dp_Ngaysinh;

    @FXML
    private TextField txt_us;

    @FXML
    private TextField txt_pw;

    @FXML
    private ComboBox<ComboItem> cbo_rule;

    @FXML
    private ComboBox<ComboboxString> cbo_Class;

    @FXML
    private Button btn_save;

    @FXML
    private Button btn_cancel;

    @FXML
    private RadioButton rdb_active;

    @FXML
    private ToggleGroup radiobutton;

    @FXML
    private RadioButton rdb_disable;

    DAO.taikhoanDao taikhoanDao = new taikhoanDao();
    hocsinhDao hocsinhDao = new hocsinhDao();
    Boolean status ;
    File source, dest;
    String   url="";
    DateTimeFormatter formatER= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    int flag =0;

    void CheckStudent() {
        String str =hocsinhDao.geHS_id_last();
        int id =Integer.parseInt(str.substring(str.indexOf("HS")+2))+1;
        txt_maS.setText("HS"+id);
        txt_us.setText("hocsinh"+id);
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
    void setInformation_Student(HocsinhEntity hocsinh) throws ParseException {
        txt_maS.setText(hocsinh.getMaHs());
        txt_tenS.setText(hocsinh.getTenHs());
        dp_Ngaysinh.setValue(LocalDate.parse(convertTimeStamptoDate(hocsinh.getNgaysinh()),formatER));
        url = hocsinh.getImgHs();
        txt_us.setText(hocsinh.getTaikhoanByUsername().getUsername());
        txt_pw.setText(hocsinh.getTaikhoanByUsername().getPasswords());
        cbo_Class.getSelectionModel().select(new ComboboxString(hocsinh.getLopByMaLop().getTenLop(),hocsinh.getLopByMaLop().getMaLop()));
        if(hocsinh.getTaikhoanByUsername().getTrangthai()==true){
            rdb_active.setSelected(true);
        }else{
            rdb_disable.setSelected(true);
        }
        cbo_rule.getSelectionModel().select(0);


        if (hocsinh.getImgHs().equals("")==false)
            setImg(new Image(hocsinh.getImgHs()));
        flag =1;
    }

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void save_Student(ActionEvent event) throws IOException {
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

            File fileAd= new File("src/DataSet/"+txt_maS.getText()+".jpg");
            if (fileAd.exists() )
            {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(fileAd.getName()+ "this file is existing !" +
                        "\n"+" Replace this file ?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get() == ButtonType.OK){
                    copyFileUsingStream(source,dest);
                    url = "DataSet/"+txt_maS.getText()+".jpg";
                }


            }

           HocsinhEntity hocsinhEntity = new HocsinhEntity(
                    txt_maS.getText(),
                    txt_tenS.getText(),
                    convertStringToTimestamp(formatER.format(dp_Ngaysinh.getValue())),
                    url,
                    new LopEntity(cbo_Class.getSelectionModel().getSelectedItem().getValue()),
                    taikhoanEntity
            );
            try{
                if (flag == 0){
                    if(taikhoanDao.addData(taikhoanEntity)==1 && hocsinhDao.addData(hocsinhEntity)==1 ) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Add new Teacher complete!");
                        alert.show();
                    }
                }

                else{
                    if(taikhoanDao.updateData(taikhoanEntity)==1 && hocsinhDao.updateData(hocsinhEntity)==1 ) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Update Teacher complete!");
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
        if(txt_maS.getText().equals("")==false
                && txt_tenS.getText().equals("")==false
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

    public  void addComboboxClass(){
        lopDao dao = new lopDao();
        List<LopEntity> list=dao.getAll();
        List<ComboboxString> list1 =new ArrayList<>();
        for (LopEntity alop :list){
            list1.add(new ComboboxString(alop.getTenLop(),alop.getMaLop()));
        }
        cbo_Class.setItems(FXCollections.observableArrayList(list1));
        cbo_Class.getSelectionModel().selectFirst();
    }

    public void addComboboxItem(){
        cbo_rule.setItems(FXCollections.observableArrayList(
                new ComboItem("Admin",1),
                new ComboItem("Teacher",2),
                new ComboItem("Student",3)
        ));
        cbo_rule.getSelectionModel().select(2);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addComboboxItem();
        rdb_active.setSelected(true);
        addComboboxClass();
        CheckStudent();
    }
}