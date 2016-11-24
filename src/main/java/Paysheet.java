import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: 11/24/2016  убрать из локальных полей всё передавать в методы что может сделать их статическими

public class Paysheet {

    Company company;
    Map<Worker, Float> workersSalaryMap;
    LocalDate today;//кинуть в методы начисления

    public Paysheet(Company company){
        this.company = company;
        workersSalaryMap = new HashMap<Worker, Float>();
        today = new LocalDate();
    }

//    public Map<Worker, Float> setUpWorkersAndSalaryMap(){
//        Map<Worker, Float> workersAndSalaryList = new HashMap<Worker, Float>();
//        List<Worker> allWorkers;
//        for (Department department : company.getDepartments()){
//            allWorkers = department.getWorkersList();
//            for (Worker worker: allWorkers){
//                workersAndSalaryList.put(worker, worker.getSalary());
//            }
//        }
//        return workersAndSalaryList;
//    }
// TODO: 11/24/2016 calc methods gets company as parameters and return map

    public void calcEqualBonusForEachWorker(){
        float remainsOnBonuses = company.getSalaryFond() - company.getPureSalary();
        float eachWorkerBonus = remainsOnBonuses / company.getTotalWorkersCount();

            List<Worker> allWorkers;
            for (Department department : company.getDepartments()){
                for (Worker worker: department.getWorkersList()){
                    float salaryAndBonusMoney = worker.getSalary() + eachWorkerBonus;
                    if(worker.getBirthDay().getMonthOfYear() == today.getMonthOfYear()){
                        salaryAndBonusMoney += 50;
                        System.out.println("Today is DirthDay of "+ worker.getName() +
                                ". Lets congratulate him! He gets +50 bucks.");
                    }
                    workersSalaryMap.put(worker, salaryAndBonusMoney);
                }
            }
    }

    public void calcSalaryDependOnBranches(){
        float remainsOnBonuses = company.getSalaryFond() - company.getPureSalary();
        float toEachDepartment = remainsOnBonuses / company.getDepartmentsCount();

        for (Department department : company.getDepartments()){
            float toEachWorkerInDepartment = toEachDepartment / department.getWorkersCount();
            for (Worker worker : department.getWorkersList()){
                float toEachWorker = worker.getSalary() + toEachWorkerInDepartment;
                if(worker.getBirthDay().getMonthOfYear() == today.getMonthOfYear()){
                    toEachWorker += 50;
                    System.out.println("Today is DirthDay of "+ worker.getName() +
                            ". Lets congratulate him! He gets +50 bucks.");
                }
                workersSalaryMap.put(worker, toEachWorker);

            }
        }
    }

    public void printWorkersSalary(){
        for (Map.Entry<Worker, Float> workerAndSalaryEntry : workersSalaryMap.entrySet()){
            String formattedSalary = String.format("%.2f", workerAndSalaryEntry.getValue());
            System.out.println(workerAndSalaryEntry.getKey().getName()+" from "+
                    workerAndSalaryEntry.getKey().getDepartmentName()+" gets "+formattedSalary);
        }
    }
}
