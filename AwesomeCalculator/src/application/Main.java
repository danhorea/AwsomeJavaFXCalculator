package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;


public class Main extends Application {
	double xOffset;
	double yOffset;
	@Override
	public void start(final Stage primaryStage) {
		try {
			primaryStage.initStyle(StageStyle.TRANSPARENT);//For transparency
			Font.loadFont(Main.class.getResource("/resources/digital-7.ttf").toExternalForm(), 60);
			Parent root = FXMLLoader.load(getClass().getResource("zzz.fxml"));
			Scene scene = new Scene(root,400,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			scene.setFill(null);//for transparency
			
			//drag
			scene.setOnMousePressed(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                xOffset =  event.getSceneX();
	                yOffset =  event.getSceneY();
	            }
	        });
	        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                primaryStage.setX(event.getScreenX() - xOffset);
	                primaryStage.setY(event.getScreenY() - yOffset);
	            }
	        });
			//end drag
	        			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

