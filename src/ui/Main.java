package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Classroom;


public class Main extends Application{
	
	private ClassroomGUI classroomgui;
	private Classroom classroom;
	
	public Main() {
		classroom = new Classroom();
		classroomgui = new ClassroomGUI(classroom);
		
	}
	
	public static void main(String[]args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(classroomgui);
		Parent root = fxmlLoader.load();
		classroomgui.setStage(primaryStage);
		Scene scene = new Scene(root);		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Classroom");
		classroomgui.logIn();
		
	}

}
