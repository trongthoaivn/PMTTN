package CONTROLLER;
import DAO.taikhoanDao;
import MODEL.TaikhoanEntity;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class ct_Login implements Initializable {
    @FXML
    private RadioButton rdb_Teacher;

    @FXML
    private ToggleGroup login;

    @FXML
    private RadioButton rdb_Student;

    @FXML
    private TextField txt_US;

    @FXML
    private PasswordField txt_PW;

    @FXML
    private Button btn_login;

    @FXML
    private Text lb_error;

    @FXML
    private ImageView btn_close;


    Thread thread ;
    taikhoanDao taikhoanDao= new taikhoanDao();
    List<TaikhoanEntity> list = new ArrayList<>();

    void getList(){
        list = taikhoanDao.getlist();
        thread.interrupt();
    }

    @FXML
    void btn_login_click(ActionEvent event)  {

        for (TaikhoanEntity taikhoan :list){
            if(taikhoan !=  null && taikhoan.getUsername().equals(txt_US.getText())&&taikhoan.getPasswords().equals(txt_PW.getText())&&rdb_Teacher.isSelected()){
                lb_error.setVisible(false);
                if(taikhoan.getQuyenByMaQuyen().getMaQuyen() == 1){
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/frm_Main.fxml"));
                        Parent root = loader.load();
                        ct_Main main = loader.getController();
                        main.Login_info(taikhoan);
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.initStyle(StageStyle.UTILITY);
                        stage.show();
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                    }catch (Exception e){

                    }
                }

            }else {
                lb_error.setVisible(true);
            }
        }

    }
    @FXML
    void close(MouseEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        thread= new Thread(this::getList);
        thread.start();
        rdb_Teacher.setSelected(true);
    }
}
