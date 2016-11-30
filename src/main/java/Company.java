import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private float salaryFond;
    private List<Department> departments;

    public Company(String name){
        this.name = name;
        departments = new ArrayList<Department>();
    }

    public String getCompanyName(){
        return name;
    }

    public float getSalaryFond(){
        return salaryFond;
    }

    public void setSalaryFond(float fond){
        salaryFond = fond;
    }

    public void addDepartment(Department department){
        departments.add(department);
    }

    public void removeDepartment(Department department){
        departments.remove(department);
    }

    public List<Department> getDepartments(){
        return new ArrayList<Department>(departments);
    }

    public int getDepartmentsCount(){
        return departments.size();
    }

    public int getTotalWorkersCount(){
        int totalCount = 0;
        for(Department department : departments){
            totalCount += department.getWorkersCount();
            totalCount += department.getManagersCount();
        }
        return totalCount;
    }

    public float getPureSalary(){
        LocalDate today = new LocalDate();
        float pureSalary = 0;
        for(Department department : departments){
            for (Worker worker : department.getWorkersList()){
                pureSalary += worker.getSalary();
                if(worker.getBirthDay().getMonthOfYear() == today.getMonthOfYear()) {
                    pureSalary += 50;
                }
            }
            for (Manager manager : department.getManagersList()){
                pureSalary += manager.getSalary();
                if (manager.getBirthDay().getMonthOfYear() == today.getMonthOfYear()){
                    pureSalary += 50;
                }
                if (manager.getWorkersCount() > 0){
                    pureSalary += manager.getWorkersCount() * 50;
                }
            }
        }
        return pureSalary;
    }
}
