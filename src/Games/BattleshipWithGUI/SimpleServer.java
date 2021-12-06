package Games.BattleshipWithGUI;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 1234;
        try {
            ServerSocket ss = new ServerSocket(port);
            Socket s1 = ss.accept(); //client1
            Socket s2 = ss.accept(); //client2
            ObjectInputStream ois1 = new ObjectInputStream(s1.getInputStream()); //read a general object sent from client1
            ObjectInputStream ois2 = new ObjectInputStream(s2.getInputStream()); //read a general object sent from client2
            //create the ArrayList of String arrays from client1
            ArrayList<String[]> al1 = (ArrayList<String[]>) ois1.readObject();
            for (String[] S : al1) {
                System.out.println(Arrays.toString(S));
            }
            System.out.println("\n"); // separation
            //create the ArrayList of String arrays from client2
            ArrayList<String[]> al2 = (ArrayList<String[]>) ois2.readObject();
            for (String[] S : al2) {
                System.out.println(Arrays.toString(S));
            }
            //close everything
            s1.close();
            s2.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
