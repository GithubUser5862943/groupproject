package application;
	
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/*
Names: Paul Carrizales, Angel Galicia
UTSA IDs: pja691, 
Class Description: This class contains the startup code for the application
*/
public class Main extends Application {
	
	/* This method loads the view for the Main/home page of the application */
	@Override
	public void start(Stage primaryStage) {
		try {
			URL urlmain = new File("src/application/view/Main.fxml").toURI().toURL();
			BorderPane root = (BorderPane)FXMLLoader.load(urlmain);
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Calendar");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*This method launches the program */
	public static void main(String[] args) {
		launch(args);
	}
}
