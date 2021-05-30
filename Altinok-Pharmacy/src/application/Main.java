package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("admin.fxml"));
			Scene scene = new Scene(root,400,400);
			
			primaryStage.getIcons().add(new Image("file:img/icon.png"));
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			Scene scene2 = new Scene(new Group(), 1200, 1000);
			scene2.getStylesheets().add("/CSS/stylesheet.css");
			
			Scene scene3 = new Scene(new Group(), 1200, 1000);
			scene3.getStylesheets().add("/CSS/eczane.css");
			
			


			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
