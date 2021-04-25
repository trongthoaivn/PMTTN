package CONTROLLER;

import DAO.adminDao;
import DAO.taikhoanDao;
import MODEL.AdminEntity;
import MODEL.TaikhoanEntity;
import REF.CustomImage;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
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

    AdminEntity SelectedAd = new AdminEntity();
    TaikhoanEntity SelectedAdacc = new TaikhoanEntity();


    public void EditAdmin() throws IOException, ParseException {
        if(SelectedAd.getTenAd()!=null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/fadd_edit_Admin.fxml"));
            Parent root = loader.load();
            ct_addeditAdmin ct =loader.getController();
            ct.setInformation_Admin(SelectedAd);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UTILITY);
            if(stage.isShowing()==false){
                stage.show();
            }
        }

    }

    public void DeleteAdmin(){
        adminDao adminDao = new adminDao();
        taikhoanDao taikhoanDao = new taikhoanDao();
        System.out.println(SelectedAd.getTenAd());
        if(SelectedAd.getTenAd()!=null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Admin");
            alert.setHeaderText("Are you sure you want delete "+ SelectedAd.getTenAd());
            Optional<ButtonType> option = alert.showAndWait();
            if(option.get()==ButtonType.OK) {
                SelectedAdacc = taikhoanDao.getUser_Pass(SelectedAd.getTaikhoanByUsername().getUsername());
                System.out.println(SelectedAdacc.getUsername());
                File image = new File("src/"+SelectedAd.getImgAd());
                if (image.exists()&& image.delete()){
                    System.out.println("image delete :"+image.getName());
                }else {
                    System.out.println("image delete fail" +image.getPath());
                }
                System.out.println("admin delete: "+adminDao.delData(SelectedAd));
                System.out.println("account delete:"+taikhoanDao.delData(SelectedAdacc));
            }else if(option.get()==ButtonType.CANCEL){
                alert.close();
            }else
                alert.close();
        }



    }


    @FXML
    void SelectAdmin(MouseEvent event) throws IOException {
        AdminEntity adminEntity = tbv_Admin.getSelectionModel().getSelectedItem();
        if(adminEntity!=null){
            SelectedAd = adminEntity;
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
        tbv_Admin.getItems().clear();
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
