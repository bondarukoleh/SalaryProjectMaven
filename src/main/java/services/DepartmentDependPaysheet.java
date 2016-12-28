package services;

import essences.Company;
import essences.Department;
import essences.Manager;
import essences.Worker;
import org.joda.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class DepartmentDependPaysheet implements Paysheet {

     public Map<Worker, Float> calculateSalary(Company company){
        Map<Worker, Float> workersSalaryMap = new LinkedHashMap<Worker, Float>();
        LocalDate today = new LocalDate();
        float remainsOnBonuses = company.getSalaryFond() - CompanyService.getPureSalary(company);
        float toEachDepartment = remainsOnBonuses / company.getDepartmentsCount();

        for (Department department : company.getDepartments()){
            float toEachWorkerInDepartment = toEachDepartment / department.getAllWorkersCount();

            for (Worker worker : department.getWorkersList()){
                float toEachWorker = worker.getSalary() + toEachWorkerInDepartment;
                if(worker.getBirthDay().getMonthOfYear() == today.getMonthOfYear()){
                    toEachWorker += 50;
                    System.out.println("Today is BirthDay of "+ worker.getName() +
                            " from " + worker.getDepartmentName() +
                            ". Lets congratulate him! He gets +50 bucks.");
                }
                workersSalaryMap.put(worker, toEachWorker);
            }

            for (Manager manager : department.getManagersList()){
                float toEachWorker = manager.getSalary() + toEachWorkerInDepartment;
                if (manager.getBirthDay().getMonthOfYear() == today.getMonthOfYear()){
                    toEachWorker += 50;
                    System.out.println("Today is BirthDay of "+ manager.getName() +
                            " from " + manager.getDepartmentName() +
                            ". Lets congratulate him! He gets +50 bucks.");
                }
                if (manager.getWorkersList().isEmpty()){
                    System.out.println(manager.getName() +" from "
                            + manager.getDepartmentName()  + " has no workers.");
                }
                else{
                    toEachWorker += manager.getWorkersCount() * 50;
                }
                workersSalaryMap.put(manager, toEachWorker);
            }
        }
        return workersSalaryMap;
    }
}
