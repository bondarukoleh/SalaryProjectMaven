import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private double salaryFond;
    private List<Department> departments;

    public Company(String name){
        this.name = name;
        departments = new ArrayList<Department>();
    }

    public String getDepartmentName(){
        return name;
    }

    public double getSalaryFond(){
        return salaryFond;
    }

    public void setSalaryFond(double fond){
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

    public double getPureSalary(){
        double pureSalary=0.0;
        for(Department department : departments){
            for (Worker worker : department.getWorkersList()){
                pureSalary += worker.getSalary();
            }
        }
        return pureSalary;
    }
}
