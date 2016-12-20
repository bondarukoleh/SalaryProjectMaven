import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Department {
    private String name;
    private float departmentFond;
    private List<Worker> workers;
    private List<Manager> managers;
    private int id;

    public Department(String name, int id){
        this.name = name;
        this.id = id;
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

    public int getWorkersCount(){
        return (workers.size());
    }

    public int getManagersCount(){
        return (managers.size());
    }

    public int getAllWorkersCount(){
        return (workers.size() + managers.size());
    }

    public List<Worker> getWorkersList() {
        return new ArrayList<Worker>(workers);
    }

    public List<Manager> getManagersList(){
        return new ArrayList<Manager>(managers);
    }

    public int getId() {
        return id;
    }

    public synchronized void downgradeManager(Manager manager){
        if (managers.size() >= 1){
            Random random = new Random();
            Manager assignManager;
            while (manager.equals(assignManager = managers.get(random.nextInt(managers.size())))){
                assignManager.addWorkers(manager.getWorkersList());
                Worker worker = new Worker(("Used to be " + manager.getName()),
                        name,
                        manager.getBirthDay(),
                        manager.getSalary(),
                        manager.getEmploymentDate(),
                        manager.getId());
                assignManager.addWorker(worker);
                System.out.println("You've got new worker " + worker.getName());
                managers.remove(manager);
            }
        }
        else {
            System.out.println("Sorry, it is last manager in this department. Hire another one.");
        }
    }

    public synchronized void upgradeWorker(Worker worker){
        managers.add(new Manager("Used to be "+worker.getName(),
                name,
                worker.getBirthDay(),
                worker.getSalary(),
                worker.getEmploymentDate(),
                worker.getId()));
        System.out.println("You've got new worker " + managers.get(worker.getId()).getName());
        workers.remove(worker);
    }


    public void printManagers(){
        for (Manager m : managers)
        System.out.println(m.getName()+ " with id "+ m.getId() + " from "+m.getDepartmentName());
    }
}
