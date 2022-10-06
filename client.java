package CAP_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Yousef Ismail
 * @class client
 * 
 * @version 1.0
 * 
 * NOTE: The header package CAP_client is the default header, removing such gives errors and disables my code.
 */

public class client {

    public static void main(String[] args) {
        System.out.println("Client: Starting...");

        try {
            System.out.println("Waiting for connection....");
            InetAddress localAddress = InetAddress.getLocalHost();
            try {
                Socket clientSocket = new Socket(localAddress, 6000);

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("Connected to server...");
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.print("Enter text: ");
                    String inputLine = scanner.nextLine();
                    if ("quit".equalsIgnoreCase(inputLine)) {
                        System.out.println("QUITTING THE APPLICATION!");
                        break;
                    }
                    out.println(inputLine);
                    String response = br.readLine();
                    System.out.print("Server response: " + response + "\n");
                }
            } catch (IOException e) {
                System.err.println("Client: Error Occured...");
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.err.println("Client: Error Occured...");
            e.printStackTrace();
        }
    }
}
