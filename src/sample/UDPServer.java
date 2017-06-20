package sample;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Павел on 15.06.2017.
 */
interface recievedLogListener {
    void onRecievedSyslogMessage(String syslogMessage);
}

public class UDPServer implements Runnable {
    private DatagramSocket socket;
    private int listenPort = 4445;
    private boolean running;
    private byte[] buf = new byte[1024];
    private recievedLogListener logListener;

    public void addSyslogMessageListener(recievedLogListener listener) {
        logListener = listener;
    }

    @Override
    public void run()  {
        System.out.println("Start running");

        try {
            System.out.println("Start socket");
            socket = new DatagramSocket(listenPort);
        } catch (Exception e) {
            System.out.println("Error!!! Exception: " + e.toString());
        }

        while (true) {
            DatagramPacket packet = new DatagramPacket(buf,buf.length);
            try {
                System.out.println("Trying to recieve packet");
                socket.receive(packet);
                System.out.println("Recieved packet");
            } catch (Exception e) {
                System.out.println("Error!!! Exception: " + e.toString());
                break;
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            String recieved = new String(packet.getData(),0,packet.getLength());
            logListener.onRecievedSyslogMessage(address.toString() + ":" + Integer.toString(port) + " > " + recieved);

            //InetAddress address = socket.g


        } // while
    }


}
