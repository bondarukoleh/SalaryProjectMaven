import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private float departmentFond;
    private List<Worker> workers;
    private List<Manager> managers;

    public Department(String name){
        this.name = name;
        workers = new ArrayList<Worker>();
        managers = new ArrayList<Manager>();
    }

    public String getName(){
        return name;
    }

    public float getDepartmentFond(){
        return departmentFond;
    }

    public void setDepartmentFond(float departmentFond){
         this.departmentFond = departmentFond;
    }

    public void addWorker(Worker worker){
        workers.add(worker);
    }

    public void addManager(Manager manager){
        managers.add(manager);
    }

    public void removeWorker(Worker worker){
        workers.remove(worker);
    }

    public void removeManager(Manager manager){
        workers.remove(manager);
    }

    public int getWorkersCount(){
        return (workers.size());
    }

    public List<Worker> getWorkersList() {
        return new ArrayList<Worker>(workers);
    }

    public List<Manager> getManagersList(){
        return new ArrayList<Manager>(managers);
    }

    public void setWorkersToManagers(){
        for (Manager manager : managers){
            for (Worker worker : workers){
                manager.addWorker(worker);
            }
        }
    }

    public void printManagers(){
        for (Manager m : managers)
        System.out.println(m.getName());
    }
}
