import java.util.ArrayList;
import java.util.List;

public class Department {
    private static String name;
    private double departmentFond;
    private List<Worker> workers;

    public Department(String name){
        this.name = name;
        workers = new ArrayList<Worker>();
    }

    public static String getDepartmentName(){
        return name;
    }

    public double getDepartmentFond(){
        return departmentFond;
    }

    public void setDepartmentFond(double departmentFond){
         this.departmentFond = departmentFond;
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
