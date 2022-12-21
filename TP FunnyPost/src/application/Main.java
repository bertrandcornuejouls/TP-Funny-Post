package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.*;

import Modele.derby;


public class Main extends Application {
	

	@Override
	public void start(Stage primaryStage) {
		try {
			derby d = new derby();
			derby.ConnectBDD();
			
			
			
			Parent rootFXML = FXMLLoader.load(getClass().getResource("vueBDD.fxml"));
			Scene sceneFXML = new Scene(rootFXML,500,500);
			primaryStage.setTitle("Vue BDD");
			primaryStage.setScene(sceneFXML);
			primaryStage.show();
			




		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}