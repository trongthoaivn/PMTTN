package CONTROLLER;


import MODEL.TaikhoanEntity;
import TCP.Register;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

public class ct_Network  implements Initializable  {

    @FXML
    public TextArea txt_Log;

    public Button Disconnect;

    @FXML
    private TextField txt_Port;

    @FXML
    private Button btn_listen;

    public static TextArea txt_status = new TextArea();

    public  ServerSocket serverSocket = null;
    TCP.Server server = new TCP.Server();
    Thread thread;

    public void StartServer(){
        server.start();
        txt_Port.setText(server.returnstr());
    }

    @FXML
    void Listen(ActionEvent event) throws IOException {
       thread = new Thread(()->server.start());
       thread.start();
        btn_listen.setDisable(true);
        Disconnect.setDisable(false);
    }
    @FXML
    void closeSV(ActionEvent event) {
        server.close();
        thread.interrupt();
        btn_listen.setDisable(false);
        Disconnect.setDisable(true);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txt_status.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!oldValue.equals(newValue))
                txt_Log.setText(txt_status.getText());
            }
        });
    }
}
