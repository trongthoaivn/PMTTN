package CONTROLLER;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class ct_Login {
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

    @FXML
    void btn_login_click(ActionEvent event)  {
        if(txt_US.getText().equals("admin") && txt_PW.getText().equals("123")){
            lb_error.setVisible(false);
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/frm_Main.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Main");
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }catch (Exception e){

            }

        }else {
            lb_error.setVisible(true);
        }
    }
    @FXML
    void close(MouseEvent event) {
        Platform.exit();
    }

}
