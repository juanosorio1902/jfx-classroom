package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Classroom;

public class ClassroomGUI {
	
	private Stage primaryStage;
	
	@FXML
    private BorderPane mainPane;
	
	@FXML
	private TextField logUser;

	@FXML
	private TextField logPassword;
	 
	@FXML
	private TextField txtUserName;

	@FXML
	private TextField txtPassword;

	@FXML
	private TextField txtPhoto;

	@FXML
	private CheckBox btnSoftware;

	@FXML
	private CheckBox btnTelematic;

	@FXML
	private CheckBox btnIndustrial;

	@FXML
	private DatePicker btnBirthday;

	@FXML
	private RadioButton btnMale;

	@FXML
	private RadioButton btnFemale;

	@FXML
	private RadioButton btnOther;

	@FXML
	private ComboBox<?> btnFavBrowser;
	
	@FXML
    public void selectMale(ActionEvent event) {
		btnFemale.setSelected(false);
		btnOther.setSelected(false);
    }
	
	@FXML
    public void selectFemale(ActionEvent event) {
		btnMale.setSelected(false);
		btnOther.setSelected(false);
    }
	
	@FXML
    public void selectOther(ActionEvent event) {
		btnFemale.setSelected(false);
		btnMale.setSelected(false);
    }

	@FXML
	public void browsePhoto(ActionEvent event) {

		}

	 @FXML
	 public  void createAccount(ActionEvent event) {
		 
		 

	    }
	 @FXML
	 public void logIn(ActionEvent event) throws IOException {
		 loadList();
	 }
	 @FXML
	 public void logOut(ActionEvent event) throws IOException {
		 loadLogOut();
		 
	 }
	 @FXML
	 public void loadLogIn(ActionEvent event) throws IOException {
		 logIn();

	 }

	

	@FXML
	 public void singUp(ActionEvent event) throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		 fxmlLoader.setController(this);
		 Parent root = fxmlLoader.load();
		 mainPane.getChildren().clear();
		 mainPane.setCenter(root);
		 primaryStage.close();
		 primaryStage.show();

	 }
	 	
	 private Classroom classroom;
	 
	 public ClassroomGUI(Classroom cm) {
		 classroom = cm;		 
		 
	 }
	 public void logIn() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		 fxmlLoader.setController(this);
		 Parent root = fxmlLoader.load();
		 mainPane.getChildren().clear();
		 mainPane.setCenter(root);
		 primaryStage.close();
		 primaryStage.show();

	 }
	 public void loadList() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("contact-list.fxml"));
		 fxmlLoader.setController(this);
		 Parent root = fxmlLoader.load();
		 mainPane.getChildren().clear();
		 mainPane.setCenter(root);
		 primaryStage.close();
		 primaryStage.show();
		 
	 }
	 private void loadLogOut() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		 fxmlLoader.setController(this);
		 Parent root = fxmlLoader.load();
		 mainPane.getChildren().clear();
		 mainPane.setCenter(root);
		 primaryStage.close();
		 primaryStage.show();
			
			
		}
	 public void setStage(Stage stage) {
		 primaryStage = stage;
	 }
	 

	 
	
	 


}
