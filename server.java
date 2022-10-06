package CAP_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Yousef Ismail
 * @class server
 * 
 * @version 1.0
 * 
 * NOTE: The header package CAP_server is the default header, removing such gives errors and disables my code.
 */

public class server {

    public static void main(String[] args) {
        System.out.println("Server: Starting...");

        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Waiting for connection...");
            Socket clientSocket = server.accept();
            System.out.println("Connected to client...");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                System.out.println("Server Capitlizing: " + inputLine + " -> " + inputLine.toUpperCase());
                out.println(inputLine.toUpperCase());
            }

        } catch (IOException e) {
            System.err.println("Server: Error Occured");
            e.printStackTrace();

        }
    }
}
