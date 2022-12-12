import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        PingServiceImpl pingService = new PingServiceImpl();
        PingService stub = (PingService) UnicastRemoteObject.exportObject(pingService, 0);
        registry.rebind("PingPongService", stub);

    }
}
