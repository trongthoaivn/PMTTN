package CONTROLLER;

import DAO.hocsinhDao;
import DAO.taikhoanDao;
import MODEL.HocsinhEntity;
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

public class ct_Student implements Initializable {

    @FXML
    private TableView<HocsinhEntity> tbv_Student;

    @FXML
    private TableColumn<?, ?> image;

    @FXML
    private TableColumn<HocsinhEntity, String> username;

    @FXML
    private TableColumn<HocsinhEntity, String> passwords;

    HocsinhEntity SelectedS = new HocsinhEntity();
    TaikhoanEntity SelectedAdacc = new TaikhoanEntity();
    Thread thread = new Thread();
    ObservableList<HocsinhEntity> hocsinhEntities;

    public void EditStudent() throws IOException, ParseException {
        if(SelectedS.getTenHs()!=null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/fadd_edit_Student.fxml"));
            Parent root = loader.load();
            ct_addeditStudent ct =loader.getController();
            ct.setInformation_Student(SelectedS);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UTILITY);
            if(stage.isShowing()==false){
                stage.show();
            }
        }

    }

    public void DeleteStudent(){
        hocsinhDao hocsinhDao = new hocsinhDao();
        taikhoanDao taikhoanDao = new taikhoanDao();
        System.out.println(SelectedS.getTenHs());
        if(SelectedS.getTenHs()!=null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Admin");
            alert.setHeaderText("Are you sure you want delete "+ SelectedS.getTenHs());
            Optional<ButtonType> option = alert.showAndWait();
            if(option.get()==ButtonType.OK) {
                SelectedAdacc = taikhoanDao.getUser_Pass(SelectedS.getTaikhoanByUsername().getUsername());
                System.out.println(SelectedAdacc.getUsername());
                File image = new File("src/"+SelectedS.getImgHs());
                if (image.exists()&& image.delete()){
                    System.out.println("image delete :"+image.getName());
                }else {
                    System.out.println("image delete fail" +image.getPath());
                }
                System.out.println("admin delete: "+hocsinhDao.delData(SelectedS));
                System.out.println("account delete:"+taikhoanDao.delData(SelectedAdacc));
            }else if(option.get()==ButtonType.CANCEL){
                alert.close();
            }else
                alert.close();
        }



    }

    public void getStudenttoTable(){
        tbv_Student.getItems().clear();
        hocsinhDao dao = new hocsinhDao();
        hocsinhEntities= dao.getAll();

        tbv_Student.setItems(hocsinhEntities);

        TableColumn col1 =   tbv_Student.getColumns().get(0);
        col1.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("maHs"));
        TableColumn col2 =   tbv_Student.getColumns().get(1);
        col2.setCellValueFactory(new PropertyValueFactory<HocsinhEntity,String>("tenHs"));
        TableColumn col3 =  tbv_Student.getColumns().get(2);
        col3.setCellValueFactory(new PropertyValueFactory<HocsinhEntity, Timestamp>("ngaysinh"));
        TableColumn col4 =  tbv_Student.getColumns().get(3);
        col4.setCellValueFactory(new PropertyValueFactory<CustomImage, ImageView>("imgHs"));
        username.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getTaikhoanByUsername().getUsername()));
        passwords.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getTaikhoanByUsername().getPasswords()));
        thread.interrupt();
    }
    public void SelectStudent(MouseEvent event) throws IOException {
        HocsinhEntity hocsinhEntity = tbv_Student.getSelectionModel().getSelectedItem();
        if(hocsinhEntity!=null){
            SelectedS = hocsinhEntity;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../VIEW/Form/popup_Student.fxml"));
            Parent root = loader.load();
            popup_Student main = loader.getController();
            main.detailinfo_Student(hocsinhEntity);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        thread = new Thread(this::getStudenttoTable);
        thread.start();
    }


}
