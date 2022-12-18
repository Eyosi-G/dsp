package simple_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket connected = serverSocket.accept();

        DataInputStream dataInputStream = new DataInputStream(connected.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(connected.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Client: " + dataInputStream.readUTF());
            System.out.print("Input: ");
            String message = scanner.nextLine();
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        }
    }
}
