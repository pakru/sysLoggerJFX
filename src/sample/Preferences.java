package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Preferences {
    @FXML private ComboBox<String> ipListenChoice;

    public void showDialog() {
        Stage dialog = new Stage();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("preferences.fxml"));
            dialog.setScene(new Scene(root));
        } catch (Exception e) {}

        dialog.initOwner(Main.getMainStage());
        dialog.initModality(Modality.APPLICATION_MODAL);

        //dialog.showAndWait();
        dialog.show();

        try {
            //getAllIpIfaces();
            ipListenChoice.setItems(FXCollections.observableArrayList(getAllIpIfaces()));
        } catch (Exception e) {}


    }

    private ArrayList<String> getAllIpIfaces() throws SocketException{
        ArrayList<String> resultListOfAddresses = new ArrayList<>();

        Enumeration<NetworkInterface> nics = NetworkInterface.getNetworkInterfaces();

        for (NetworkInterface nic : Collections.list(nics)) {

            Enumeration<InetAddress> ifaceIpAddresses = nic.getInetAddresses();
            for (InetAddress inetAddress : Collections.list(ifaceIpAddresses)){
                if (inetAddress.toString().contains("."))  // check if not ipv6
                {
                    System.out.println("NetCard: " + nic.getName() );
                    System.out.println("Address: " + inetAddress.toString().substring(1));
                    System.out.println("--------------------------");
                    resultListOfAddresses.add(inetAddress.toString().substring(1));
                }
            }

        }
        return resultListOfAddresses;
    }
}
