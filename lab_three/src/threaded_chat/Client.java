package threaded_chat;

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
        ClientReaderThread readerThread = new ClientReaderThread(dataInputStream);
        readerThread.start();
        while (true){
            String message = scanner.nextLine();
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

        }


    }
}
