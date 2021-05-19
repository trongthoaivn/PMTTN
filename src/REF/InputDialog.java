package REF;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;

public class InputDialog {
        static int hieu, biet, vdthap, vdcao, socau;
        List<Integer> list = Arrays.asList(0,10,20,30,40,50,60,70,80,90,100);
        List<Integer> cau= Arrays.asList(10,20,30,50);
        public Matrix Display(){
            Stage stage= new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Spinner<Integer> txt_hieu = new Spinner<>(FXCollections.observableArrayList(list));
            Spinner<Integer> txt_biet = new Spinner<>(FXCollections.observableArrayList(list));
            Spinner<Integer> txt_vdthap = new Spinner<>(FXCollections.observableArrayList(list));
            Spinner<Integer> txt_vdcao = new Spinner<>(FXCollections.observableArrayList(list));
            Spinner<Integer> txt_socau = new Spinner<>(FXCollections.observableArrayList(cau));
            Button button = new Button("Submit");
            button.setOnAction(event -> {
                hieu =txt_hieu.getValue();
                biet =txt_biet.getValue();
                vdthap=txt_vdthap.getValue();
                vdcao=txt_vdcao.getValue();
                socau=txt_socau.getValue();
                if((hieu+biet+vdthap+vdcao)==100)
                stage.close();
                else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Cảnh báo!");
                    alert.setHeaderText(null);
                    alert.setContentText("Tỉ lệ không đúng");
                    alert.showAndWait();
                }

            });

            Label label = new Label("Số câu : ");
            Label label1 = new Label("Hiểu (%) : ");
            Label label2 = new Label(("Biết (%) : "));
            Label label3 = new Label("Vận dung thấp (%) : ");
            Label label4 = new Label("Vận dụng cao (%) : ");
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(10,10,10,10));
            gridPane.setVgap(5);
            gridPane.setHgap(5);
            gridPane.add(label,0,1);
            gridPane.add(txt_socau,1,1);
            gridPane.add(label1,0,2);
            gridPane.add(txt_hieu,1,2);
            gridPane.add(label2,0,3);
            gridPane.add(txt_biet,1,3);
            gridPane.add(label3,0,4);
            gridPane.add(txt_vdthap,1,4);
            gridPane.add(label4,0,5);
            gridPane.add(txt_vdcao,1,5);
            gridPane.add(button,1,6);
            Scene scene = new Scene(gridPane,350,235);
            stage.setScene(scene);
            stage.showAndWait();
            return new Matrix(hieu,biet,vdthap,vdcao,socau);
        }

}
