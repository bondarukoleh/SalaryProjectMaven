import java.util.ArrayList;
import java.util.List;

public class Manager extends Worker {
    private List<Worker> workersList;

    public Manager(String name, String departmentName, int year, int monthOfYear, int dayOfMonth, float salary,
                   int empYear, int empMonthOfYear, int empDayOfMonth, int id){
        super(name, departmentName, year, monthOfYear, dayOfMonth, salary, empYear, empMonthOfYear, empDayOfMonth, id);
        workersList = new ArrayList<Worker>();
    }

    public List<Worker> getWorkersList(){
        return new ArrayList<Worker>(workersList);
    }

    public void addWorker(Worker worker){
        workersList.add(worker);
    }

    public void removeWorker(Worker worker){
        workersList.remove(worker);
    }

    public int getWorkersCount(){
        return workersList.size();
    }

    public void printManagerWorkers(){
        System.out.println("Manager " + getName()+" from "+getDepartmentName()+" has:");
        for(Worker w : workersList){
            System.out.println(w.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        return workersList.equals(manager.workersList) && super.equals(o);



    }

    @Override
    public int hashCode() {
        return workersList.hashCode();
    }
}
