import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleh.bondaruk on 11/18/2016.
 */
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

    private int getTotalWorkersCount(){
        int totalCount =0;
        for(Department d : departments){
            totalCount += d.getWorkersCount();
        }
        return totalCount;
    }

    public void calcSalary(){
        int totalWorkersCount = getTotalWorkersCount();
        double remains = getSalaryFond()%(totalWorkersCount);
        double pureWorkerSalary = getSalaryFond() - remains;
        double toEachWorker = pureWorkerSalary/totalWorkersCount;

        for (Department d: departments){
            for (Worker w : d.getWorkersList()){
                w.setSalary(toEachWorker);
            }
        }
    }
    public void enterFond() throws IOException {
        System.out.println("Please enter Salary fond for your department:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userEnter = reader.readLine();
        double fond = Double.parseDouble(userEnter);
        setSalaryFond(fond);
    }

    public void printWorkersSalary(){
        for (Department d: departments){
            for (Worker w : d.getWorkersList()){
                System.out.println(w.getName()+" gets "+w.getSalary());
            }
        }
    }
}
