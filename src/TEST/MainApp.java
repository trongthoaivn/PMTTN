package TEST;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TextField textField = new TextField();
        textField.setPromptText("Drag text here");
        textField.addEventHandler(
                DragEvent.DRAG_OVER,
                event -> {
                    if (event.getDragboard().hasString()) {
                        event.acceptTransferModes(TransferMode.COPY);
                    }
                    event.consume();
                });
        textField.addEventHandler(
                DragEvent.DRAG_DROPPED,
                event -> {
                    Dragboard dragboard = event.getDragboard();
                    if (event.getTransferMode() == TransferMode.COPY &&
                            dragboard.hasString()) {
                        textField.setText(dragboard.getString());
                        event.setDropCompleted(true);
                    }
                    event.consume();
                });
        StackPane stackPane = new StackPane(textField);
        stackPane.setPadding(new Insets(5));
        stage.setScene(new Scene(stackPane, 300, 150));
        stage.setTitle("Drag and Drop");
        stage.show();
    }

    public static void main(String[] args) {
        MainApp.launch(args);
    }

}
