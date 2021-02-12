package ui;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
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
	private CheckBox btnSoftware = new CheckBox("Sotfware Engineering");	

	@FXML
	private CheckBox btnTelematic = new CheckBox("Telematic Engineering");

	@FXML
	private CheckBox btnIndustrial = new CheckBox("Industrial Engineering");

	@FXML
	private DatePicker btnBirthday;

	@FXML
	private RadioButton btnMale;

	@FXML
	private RadioButton btnFemale;

	@FXML
	private RadioButton btnOther;

	@FXML
	private ComboBox<String> btnFavBrowser;	
	   
	@FXML
	private Label user;

	@FXML
	private ImageView profilePhoto;

	
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
	public void browsePhoto(ActionEvent event) throws IOException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
		File file = fileChooser.showOpenDialog(primaryStage);
		if (file != null) {
			txtPhoto.setText(file.getAbsolutePath());
		}
	}
	
	 
	 @FXML
	 public void verifyInformation(ActionEvent event) throws IOException {
		 if((!btnFemale.isSelected()&&!btnMale.isSelected()&&!btnOther.isSelected()) || 
				 ((!btnSoftware.isSelected())&&(!btnTelematic.isSelected())&&(!btnIndustrial.isSelected())||
				 txtUserName.getText().trim().equals("") || txtPassword.getText().trim().equals("") || 
				 txtPhoto.getText().trim().equals("") || btnBirthday.getValue()==null || btnFavBrowser.getValue()==null))
		 {
				validationAlert("You must fill each field in the form", "error.png", "Validation Error", "OK");
			} else if(classroom.verifyUsername(txtUserName.getText())){
				validationAlert("The username entered already exists", "error.png", "Validation Error", "OK");
			} else {
				createAccount();
			}

	    }
	 @FXML
	 public void verifyCredentials(ActionEvent event) throws IOException {
		 if(classroom.verifyCredentials(txtUserName.getText().trim(), txtPassword.getText().trim())) {
				loadList();
		 }else if (txtUserName.getText().trim().equals("") || txtPassword.getText().trim().equals("")) {
				validationAlert("You must fill each field in the form", "error.png", "Validation Error", "OK");
			}
		 else{
				validationAlert("The credentials entered are not valid", "error.png", "Validation Error", "OK");
			}
		 
	 }
	 

	@FXML
	 public void logOut(ActionEvent event) throws IOException {
		txtUserName.setText("");
		txtPassword.setText("");
		logIn();
		 
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
		 btnFavBrowser.getItems().addAll(
		            "Firefox",
		            "Chrome",
		            "Edge",
		            "Safari",
		            "Opera",
		            "Thor"
		        );
		 
		
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
		 profilePhoto.setImage(new Image(classroom.getActiveUser().getPhoto()));
		 user.setText(classroom.getActiveUser().getUsername());
		 
	 }
	 private void createAccount() throws IOException {
		 String gender = "";
		 if(btnFemale.isSelected()) {
			 gender = "Female";
		 } else if(btnMale.isSelected()) {
			 gender = "Male";
		 } else if(btnOther.isSelected()) {
			 gender = "Other";
		 }
		 
		 String career = "";
		 if(btnSoftware.isSelected()) {
			 career+=btnSoftware.getText()+"\n";
		 }
		 if(btnTelematic.isSelected()) {
			 career+=btnTelematic.getText()+"\n";
		 }
		 if(btnSoftware.isSelected()) {
			 career+=btnIndustrial.getText()+"\n";
		 }
		 classroom.createAccount(txtUserName.getText().trim(), txtPassword.getText().trim(), txtPhoto.getText(), gender, 
					career, btnBirthday.getValue(), btnFavBrowser.getValue().toString());
			
		 validationAlert("The account has been created", "validation.png", "Confirmation", "OK");
		 
		 logIn();
			
			
			
	}
	private void validationAlert(String msg, String icon, String tittle, String button) {
		ButtonType ok = new ButtonType(button);
		Alert user = new Alert(AlertType.NONE);
		user.getButtonTypes().addAll(ok);
		user.setTitle(tittle);
		user.setContentText(msg);
		Stage stage = (Stage)user.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(getClass().getResourceAsStream(icon)));
		user.showAndWait();
	} 
	public void setStage(Stage stage) {
		primaryStage = stage;
	}
	
	 

	 
	
	 


}
