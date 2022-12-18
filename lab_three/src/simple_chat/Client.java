package simple_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Input: ");
            String message = scanner.nextLine();
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

            System.out.println("Server: " + dataInputStream.readUTF());

        }


    }
}
