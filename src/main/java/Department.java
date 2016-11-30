import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Department {
    private Random random;
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
        random = new Random();
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

    public int getManagersCount(){
        return (managers.size());
    }

    public List<Worker> getWorkersList() {
        return new ArrayList<Worker>(workers);
    }

    public List<Manager> getManagersList(){
        return new ArrayList<Manager>(managers);
    }

    // TODO: 11/30/2016 synchronized

    public void downgradeManager(Manager manager){
        if (managers.size() > 1){
            Manager assignManager;
            while (manager.equals(assignManager = managers.get(random.nextInt(managers.size())))){
                assignManager.getWorkersList().addAll(manager.getWorkersList());
                assignManager.getWorkersList().add(new Worker(("Used to be "+manager.getName()),
                                name,
                                manager.getBirthDay().getYear(),
                                manager.getBirthDay().getMonthOfYear(),
                                manager.getBirthDay().getDayOfMonth(),
                                manager.getSalary(),
                                manager.getEmploymentDate().getYear(),
                                manager.getEmploymentDate().getMonthOfYear(),
                                manager.getEmploymentDate().getDayOfMonth(),
                                manager.getId()));
                System.out.println("You've got new worker " + assignManager.getWorkersList().get(manager.getId()).getName());
                managers.remove(manager);
            }
        }
        else {
            System.out.println("Sorry, it is last manager in this department. Hire another one.");
        }
    }


    public void printManagers(){
        for (Manager m : managers)
        System.out.println(m.getName()+ " with id "+ m.getId() + " from "+m.getDepartmentName());
    }
}
