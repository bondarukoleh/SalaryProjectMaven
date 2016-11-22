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

    public String getDepartmentName(){
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
        return departments;
    }

    public int getDepartmentsCount(){
        return departments.size();
    }

    public int getTotalWorkersCount(){
        int totalCount = 0;
        for(Department department : departments){
            totalCount += department.getWorkersCount();
        }
        return totalCount;
    }

    public float getPureSalary(){
        float pureSalary = 0;
        for(Department department : departments){
            for (Worker worker : department.getWorkersList()){
                pureSalary += worker.getSalary();
            }
        }
        return pureSalary;
    }
}
