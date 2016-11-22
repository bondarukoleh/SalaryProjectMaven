import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paysheet {

    Company company;
    Map<Worker, Float> workersSalaryMap;
    float moneyWithoutSalaryAndBonus;
    LocalDate today;

    public Paysheet(Company company){
        this.company = company;
        workersSalaryMap = new HashMap<Worker, Float>();
        today = new LocalDate();
    }

    public Map<Worker, Float> setUpWorkersAndSalaryMap(){
        Map<Worker, Float> workersAndSalaryList = new HashMap<Worker, Float>();
        List<Worker> allWorkers;
        for (Department department : company.getDepartments()){
            allWorkers = department.getWorkersList();
            for (Worker worker: allWorkers){
                workersAndSalaryList.put(worker, worker.getSalary());
            }
        }
        return workersAndSalaryList;
    }

    public void calcEqualBonusForEachWorker(Map<Worker, Float> workersAndSalaryList){
        float remainsOnBonuses = company.getSalaryFond() - company.getPureSalary();
        moneyWithoutSalaryAndBonus = remainsOnBonuses / company.getTotalWorkersCount();
        float workersBonusMoney = remainsOnBonuses - moneyWithoutSalaryAndBonus;
        float eachWorkerBonus = workersBonusMoney / company.getTotalWorkersCount();

        for (Map.Entry<Worker, Float> workerSalaryEntry : workersAndSalaryList.entrySet()){
            float salaryAndBonusMoney = workerSalaryEntry.getValue() + eachWorkerBonus;
            if(workerSalaryEntry.getKey().getBirthDay().getMonthOfYear() == today.getMonthOfYear()){
                salaryAndBonusMoney += 50;
                System.out.println("Today is DirthDay of "+ workerSalaryEntry.getKey().getName() +
                        ". Lets congratulate him! He gets +50 bucks.");
            }
            workerSalaryEntry.setValue(salaryAndBonusMoney);
        }
    }

    public void calcSalaryDependOnBranches(Map<Worker, Float> workersAndSalaryMap){
        float remainsOnBonuses = company.getSalaryFond() - company.getPureSalary();
        float toEachDepartment = remainsOnBonuses / company.getDepartmentsCount();

        for (Department department : company.getDepartments()){
            float toEachWorkerInDepartment = toEachDepartment / department.getWorkersList().size();
            for (Worker worker : department.getWorkersList()){
                float toEachWorker = worker.getSalary() + toEachWorkerInDepartment;
                workersSalaryMap.put(worker, toEachWorker);
            }
        }
    }

    public void printWorkersSalary(Map<Worker, Float> workersSalaryMap){
        for (Map.Entry<Worker, Float> workerAndSalaryEntry : workersSalaryMap.entrySet()){
            String formattedSalary = String.format("%.2f", workerAndSalaryEntry.getValue());
            System.out.println(workerAndSalaryEntry.getKey().getName()+" from "+
                    workerAndSalaryEntry.getKey().getDepartmentName()+" gets "+formattedSalary);
        }
    }
}
