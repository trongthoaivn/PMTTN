package CONTROLLER;

import DAO.giaovienDao;
import DAO.taikhoanDao;
import MODEL.AdminEntity;
import MODEL.GiaovienEntity;
import MODEL.TaikhoanEntity;
import REF.CustomImage;
import javafx.animation.PauseTransition;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ct_Teacher implements Initializable {
    @FXML
    private TableView<GiaovienEntity> tbv_Teacher;

    @FXML
    private TableColumn<?, ?> image;

    @FXML
    private TableColumn<GiaovienEntity, String> username;

    @FXML
    private TableColumn<GiaovienEntity, String> passwords;

    ObservableList<GiaovienEntity> giaovienEntities;
    GiaovienEntity SelectedGv = new GiaovienEntity();
    TaikhoanEntity SelectedAdacc = new TaikhoanEntity();
    Thread thread = new Thread();

    public void EditTeacher() throws IOException, ParseException {
        if(SelectedGv.getTenGv()!=null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/fadd_edit_Teacher.fxml"));
            Parent root = loader.load();
            ct_addeditTeacher ct =loader.getController();
            ct.setInformation_Teacher(SelectedGv);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UTILITY);
            if(stage.isShowing()==false){
                stage.show();
            }
        }

    }

    public void DeleteTeacher(){
        giaovienDao giaovienDao = new giaovienDao();
        taikhoanDao taikhoanDao = new taikhoanDao();
        System.out.println(SelectedGv.getTenGv());
        if(SelectedGv.getTenGv()!=null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Teacher");
            alert.setHeaderText("Are you sure you want delete "+ SelectedGv.getTenGv());
            Optional<ButtonType> option = alert.showAndWait();
            if(option.get()==ButtonType.OK) {
                SelectedAdacc = taikhoanDao.getUser_Pass(SelectedGv.getTaikhoanByUsername().getUsername());
                System.out.println(SelectedAdacc.getUsername());
                File image = new File("src/"+SelectedGv.getImgGv());
                if (image.exists()&& image.delete()){
                    System.out.println("image delete :"+image.getName());
                }else {
                    System.out.println("image delete fail" +image.getPath());
                }
                System.out.println("teacher delete: "+giaovienDao.delData(SelectedGv));
                System.out.println("account delete:"+taikhoanDao.delData(SelectedAdacc));
            }else if(option.get()==ButtonType.CANCEL){
                alert.close();
            }else
                alert.close();
        }
    }

    @FXML
    void SelectTeacher(MouseEvent event) throws IOException {
        GiaovienEntity giaovienEntity = tbv_Teacher.getSelectionModel().getSelectedItem();
        if(giaovienEntity!=null){
            SelectedGv = giaovienEntity;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/popup_Teacher.fxml"));
            Parent root = loader.load();
            popup_Teacher main = loader.getController();
            main.detailinfo_Teacher(giaovienEntity);
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
    public void getTeachertoTable(){
        tbv_Teacher.getItems().clear();
        giaovienDao dao = new giaovienDao();
        giaovienEntities = dao.getAll();

        tbv_Teacher.setItems(giaovienEntities);

        TableColumn col1 =  tbv_Teacher.getColumns().get(0);
        col1.setCellValueFactory(new PropertyValueFactory<AdminEntity,String>("maGv"));
        TableColumn col2 =  tbv_Teacher.getColumns().get(1);
        col2.setCellValueFactory(new PropertyValueFactory<AdminEntity,String>("tenGv"));
        TableColumn col3 =  tbv_Teacher.getColumns().get(2);
        col3.setCellValueFactory(new PropertyValueFactory<AdminEntity, Timestamp>("ngaysinh"));
        TableColumn col4 =  tbv_Teacher.getColumns().get(3);
        col4.setCellValueFactory(new PropertyValueFactory<CustomImage, ImageView>("imgGv"));
        username.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getTaikhoanByUsername().getUsername()));
        passwords.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getTaikhoanByUsername().getPasswords()));
        thread.interrupt();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        thread = new Thread(this::getTeachertoTable);
        thread.start();
    }
}
