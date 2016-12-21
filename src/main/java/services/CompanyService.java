package services;

import essences.Company;
import essences.Department;
import essences.Manager;
import essences.Worker;
import org.joda.time.LocalDate;

import java.util.List;

public class CompanyService {

    public static float getPureSalary(Company company){
        List<Department> departments = company.getDepartments();
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

    public static int getTotalWorkersCount(Company company){
        List<Department> departments = company.getDepartments();
        int totalCount = 0;
        for(Department department : departments){
            totalCount += department.getAllWorkersCount();
        }
        return totalCount;
    }

}
