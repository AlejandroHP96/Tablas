package dad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FicherosApp extends Application{
    
    private FicherosController ficherosController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ficherosController = new FicherosController();

        Scene scene = new Scene(ficherosController.getView());

        primaryStage.setTitle("Ficheros");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
