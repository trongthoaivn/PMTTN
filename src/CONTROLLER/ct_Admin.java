package CONTROLLER;

import DAO.adminDao;
import MODEL.AdminEntity;
import MODEL.TaikhoanEntity;
import REF.CustomImage;
import javafx.animation.PauseTransition;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ct_Admin implements Initializable {


    @FXML
    private TableView<AdminEntity> tbv_Admin;

    @FXML
    private TableColumn<?, ?> image;

    @FXML
    private TableColumn<AdminEntity, String> username;

    @FXML
    private TableColumn<AdminEntity, String> passwords;

    @FXML
    void SelectAdmin(MouseEvent event) throws IOException {
        AdminEntity adminEntity = tbv_Admin.getSelectionModel().getSelectedItem();
        if(adminEntity!=null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/popup_Admin.fxml"));
            Parent root = loader.load();
            popup_Admin main = loader.getController();
            main.detailinfo_Admin(adminEntity);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UTILITY);
            stage.setX(event.getScreenX());
            stage.setY(event.getScreenY());
            stage.show();
            PauseTransition wait = new PauseTransition(Duration.seconds(3));
            wait.setOnFinished((e) -> {
                stage.close();
            });
            wait.play();
        }


    }


    ObservableList<AdminEntity> adminEntities ;

    public void getAdmintoTable(){
        adminDao dao = new adminDao();
        adminEntities= dao.getAll();

        tbv_Admin.setItems(adminEntities);

        TableColumn col1 =   tbv_Admin.getColumns().get(0);
        col1.setCellValueFactory(new PropertyValueFactory<AdminEntity,String>("maAd"));
        TableColumn col2 =   tbv_Admin.getColumns().get(1);
        col2.setCellValueFactory(new PropertyValueFactory<AdminEntity,String>("tenAd"));
        TableColumn col3 =  tbv_Admin.getColumns().get(2);
        col3.setCellValueFactory(new PropertyValueFactory<AdminEntity, Timestamp>("ngaysinh"));
        TableColumn col4 =  tbv_Admin.getColumns().get(3);
        col4.setCellValueFactory(new PropertyValueFactory<CustomImage, ImageView>("imgAd"));
        username.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getTaikhoanByUsername().getUsername()));
        passwords.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getTaikhoanByUsername().getPasswords()));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getAdmintoTable();
    }
}
