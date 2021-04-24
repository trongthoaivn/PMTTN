package TEST;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.stream.IntStream;
public class button extends Application{
    private static int nClicks = 0;

    @Override
    public void start(Stage stage) throws IOException {
        // setup button and action handler.
        Button button = new Button("Click Me!");
        button.setOnAction(event -> {
            nClicks++;
            System.out.println("Clicked " + nClicks + " times.");
        });
        button.setPadding(new Insets(10));
        button.setPrefWidth(100);

        // show the button.
        stage.setScene(new Scene(button));
        stage.show();

        // fire the button a few times in succession.
        IntStream.range(0, 4).forEach(
                i -> button.fire()
        );
    }
    public static void main(String[] args) {
        launch(args);
    }
}
