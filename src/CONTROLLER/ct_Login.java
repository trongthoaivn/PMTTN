package CONTROLLER;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;



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
    void btn_login_click(ActionEvent event) {
        if(txt_US.getText().equals("admin") && txt_PW.getText().equals("123")){
            System.out.println("complete");
        }else {
            lb_error.setVisible(true);
        }
    }
    @FXML
    void close(MouseEvent event) {
        Platform.exit();
    }

}
