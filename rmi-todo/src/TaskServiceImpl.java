import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private List<Task> tasks = new ArrayList<>();
    @Override
    public List<Task> getTasks() throws RemoteException {
        return tasks;
    }

    @Override
    public void markCompleted(int id) throws RemoteException {
        tasks.stream().forEach(task -> {
            if(task.getId() == id){
                task.setCompleted(true);
            }
        });
    }

    @Override
    public void addTask(Task task) throws RemoteException {
        tasks.add(task);
    }
}
