package Games.BattleshipWithGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",1234)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner sc = new Scanner(System.in);
            String line = null;

            while (!"exit".equalsIgnoreCase(line)) {
                line = sc.nextLine();

                out.println(line);
                out.flush();

                System.out.println("Server replied " + in.readLine());
            }
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
