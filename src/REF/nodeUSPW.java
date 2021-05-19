package REF;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class nodeUSPW extends Application{
        public static void main(String[] args) {
            Application.launch(args);
        }


        public void start(Stage stage) {
            InputDialog inputDialog = new InputDialog();
            Matrix matrix = inputDialog.Display();
            System.out.println("Socau :"+ matrix.getSocau());
            System.out.println("hieu :" +(matrix.getSocau()* matrix.getHieu())/100);
            System.out.println("biet :" +(matrix.getSocau()* matrix.getBiet())/100);
            System.out.println("vdthap :" +(matrix.getSocau()* matrix.getVdthap())/100);
            System.out.println("vdcao :" +(matrix.getSocau()* matrix.getVdcao())/100);
        }


}
