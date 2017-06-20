package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        //StackPane root = new StackPane();
        mainStage = primaryStage;
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
        //Controller.sysLogServerThread.stop();
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.exit(0);
        /*
        if (Controller.sysLogServerThread != null) {
            Controller.sysLogServerThread.stop();  // TODO exit when in thread
        } */


    }

    public static void main(String[] args) {
        launch(args);
    }
}
