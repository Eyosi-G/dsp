import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        TaskServiceImpl taskService = new TaskServiceImpl();
        TaskService stub = (TaskService) UnicastRemoteObject.exportObject(taskService, 0);
        registry.rebind("TaskService", stub);
    }
}
