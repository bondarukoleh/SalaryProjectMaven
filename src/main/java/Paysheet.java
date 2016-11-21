import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paysheet {

    Company company;
    Map<Worker, Double> workersSalaryMap;
    double moneyWithoutSalaryAndBonus;

    public Paysheet(Company company){
        this.company = company;
        workersSalaryMap = new HashMap<Worker, Double>();
    }

    public Map<Worker, Double> setUpWorkersAndSalaryMap(){
        Map<Worker, Double> workersAndSalaryList = new HashMap<Worker, Double>();
        List<Worker> allWorkers;
        for (Department department : company.getDepartments()){
            allWorkers = department.getWorkersList();
            for (Worker worker: allWorkers){
                workersAndSalaryList.put(worker, worker.getSalary());
            }
        }
        return workersAndSalaryList;
    }

    public void calcEqualBonusForEachWorker(Map<Worker, Double> workersAndSalaryList){
        double remainsOnBonuses = company.getSalaryFond() - company.getPureSalary();
        moneyWithoutSalaryAndBonus = remainsOnBonuses % company.getTotalWorkersCount();
        double workersBonusMoney = remainsOnBonuses - moneyWithoutSalaryAndBonus;
        double eachWorkerBonus = workersBonusMoney / company.getTotalWorkersCount();

        for (Map.Entry<Worker, Double> workerSalaryEntry : workersAndSalaryList.entrySet()){
            Double salaryAndBonusMoney = workerSalaryEntry.getValue() + eachWorkerBonus;
            workerSalaryEntry.setValue(salaryAndBonusMoney);
        }
    }

    public void calcSalaryDependOnBranches(Map<Worker, Double> workersAndSalaryMap){
        double remainsOnBonuses = company.getSalaryFond() - company.getPureSalary();
        double toEachDepartment = remainsOnBonuses / company.getDepartmentsCount();

        for (Department department : company.getDepartments()){
            double toEachWorkerInDepartment = toEachDepartment / department.getWorkersList().size();
            for (Worker worker : department.getWorkersList()){
                double toEachWorker = worker.getSalary() + toEachWorkerInDepartment;
                workersSalaryMap.put(worker, toEachWorker);
            }
        }
    }

    public void printWorkersSalary(Map<Worker, Double> workersSalaryMap){
        for (Map.Entry<Worker, Double> workerAndSalaryEntry : workersSalaryMap.entrySet()){
            String formattedSalary = String.format("%.2f", workerAndSalaryEntry.getValue());
            System.out.println(workerAndSalaryEntry.getKey().getName()+" from "+
                    workerAndSalaryEntry.getKey().getDepartmentName()+" gets "+formattedSalary);
        }
    }
}
