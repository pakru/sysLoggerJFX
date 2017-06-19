package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class Controller implements recievedLogListener {
    public static UDPServer sysLogServer;
    public static Thread sysLogServerThread;
    @FXML private TextArea loggerTextArea;
    @FXML private ListView listOfConnections;


    @Override
    public void onRecievedSyslogMessage(String syslogMessage) {
        loggerTextArea.appendText(syslogMessage + "\n");

    }

    @FXML protected void startSyslogServer() {
        //System.out.println("Stuff!");
        onRecievedSyslogMessage("Stuff!!!");

        if (sysLogServer == null) {
            sysLogServer = new UDPServer();
            sysLogServer.addSyslogMessageListener(this);
            sysLogServerThread = new Thread(sysLogServer);
            sysLogServerThread.start();
        } else {
            System.out.println("Already started");
        }


    }

}
