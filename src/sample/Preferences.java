package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Павел on 21.06.2017.
 */
public class Preferences {

    public void showDialog() {
        Stage dialog = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("preferences.fxml"));
            dialog.setScene(new Scene(root));
        } catch (Exception e) {}

        dialog.initOwner(Main.getMainStage());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();

    }
}
