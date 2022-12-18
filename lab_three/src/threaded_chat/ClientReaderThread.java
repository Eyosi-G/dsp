package threaded_chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReaderThread extends Thread{
    private final DataInputStream dataInputStream;

    public ClientReaderThread(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    @Override
    public void run() {
        super.run();
        try {
            String message = dataInputStream.readUTF();
            while (message != "STOP"){
                System.out.println("Server: " + message);
                message = dataInputStream.readUTF();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
