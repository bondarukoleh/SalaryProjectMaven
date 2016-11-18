import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleh.bondaruk on 11/18/2016.
 */
public class Department {
    private String name;
    private List<Worker> workers;

    public Department(String name){
        this.name = name;
        workers = new ArrayList<Worker>();
    }

    public String getDepartmentName(){
        return name;
    }

    public void addWorker(Worker worker){
        workers.add(worker);
    }

    public void removeWorker(Worker worker){
        workers.remove(worker);
    }

    public int getWorkersCount(){
        return workers.size();
    }

    public List<Worker> getWorkersList() {
        return new ArrayList<Worker>(workers);
    }
}
