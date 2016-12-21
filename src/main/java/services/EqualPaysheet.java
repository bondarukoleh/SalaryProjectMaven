package services;

import essences.Company;
import essences.Department;
import essences.Manager;
import essences.Worker;
import org.joda.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class EqualPaysheet implements Paysheet {

    public Map<Worker, Float> calculateSalary(Company company){
        Map<Worker, Float> workersSalaryMap = new LinkedHashMap<Worker, Float>();
        LocalDate today = new LocalDate();
        float remainsOnBonuses = company.getSalaryFond() - CompanyService.getPureSalary(company);
        float eachWorkerBonus = remainsOnBonuses / CompanyService.getTotalWorkersCount(company);

        for (Department department : company.getDepartments()){

            for (Worker worker: department.getWorkersList()){
                float salaryAndBonusMoney = worker.getSalary() + eachWorkerBonus;
                if(worker.getBirthDay().getMonthOfYear() == today.getMonthOfYear()){
                    salaryAndBonusMoney += 50;
                    System.out.println("Today is BirthDay of "+ worker.getName() +
                            " from " + worker.getDepartmentName() +
                            ". Lets congratulate him! He gets +50 bucks.");
                }
                workersSalaryMap.put(worker, salaryAndBonusMoney);
            }

            for (Manager manager : department.getManagersList()){
                float salaryAndBonusMoney = manager.getSalary() + eachWorkerBonus;
                if (manager.getBirthDay().getMonthOfYear() == today.getMonthOfYear()){
                    salaryAndBonusMoney += 50;
                    System.out.println("Today is BirthDay of "+ manager.getName() +
                            " from " + manager.getDepartmentName() +
                            ". Lets congratulate him! He gets +50 bucks.");
                }
                if (manager.getWorkersList().isEmpty()){
                    System.out.println(manager.getName()
                            + " from " + manager.getDepartmentName() + " has no workers.");
                }
                else{
                    salaryAndBonusMoney += manager.getWorkersCount() * 500;
                }
                workersSalaryMap.put(manager, salaryAndBonusMoney);
            }
        }
        return workersSalaryMap;
    }

    public void printWorkersSalary(Map<Worker, Float> workersSalaryMap){
        for (Map.Entry<Worker, Float> workerAndSalaryEntry : workersSalaryMap.entrySet()){
            String formattedSalary = String.format("%.2f", workerAndSalaryEntry.getValue());
            System.out.println(workerAndSalaryEntry.getKey().getName()+" from "+
                    workerAndSalaryEntry.getKey().getDepartmentName()+" gets "+formattedSalary);
        }
    }
}
