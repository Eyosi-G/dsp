import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1099);
        TaskService taskService = (TaskService) registry.lookup("TaskService");
        taskService.addTask(new Task(1, "Buy Milk", false));
        taskService.addTask(new Task(2, "Get Some Coffee", false));
        taskService.getTasks().stream().forEach(task -> {
            System.out.println("Id: "+ task.getId());
            System.out.println("Name: "+ task.getName());
            System.out.println("Completed: "+ task.isCompleted());
            System.out.println("........");
        });
        taskService.markCompleted(1);
        taskService.getTasks().stream().forEach(task -> {
            System.out.println("Id: "+ task.getId());
            System.out.println("Name: "+ task.getName());
            System.out.println("Completed: "+ task.isCompleted());
            System.out.println("........");
        });
    }
}
