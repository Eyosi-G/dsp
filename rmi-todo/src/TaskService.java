import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TaskService extends Remote {
    List<Task> getTasks() throws RemoteException;

    void markCompleted(int id) throws RemoteException;

    void addTask(Task task) throws RemoteException;
}
