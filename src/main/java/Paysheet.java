import org.joda.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class Paysheet {

    static public  Map<Worker, Float> calcEqualBonusForEachWorker(Company company){
        Map<Worker, Float> workersSalaryMap = new LinkedHashMap<Worker, Float>();
        LocalDate today = new LocalDate();
        float remainsOnBonuses = company.getSalaryFond() - company.getPureSalary();
        float eachWorkerBonus = remainsOnBonuses / company.getTotalWorkersCount();

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
            }
        return workersSalaryMap;
    }

    static public  Map<Worker, Float> calcSalaryDependOnBranches(Company company){
        Map<Worker, Float> workersSalaryMap = new LinkedHashMap<Worker, Float>();
        LocalDate today = new LocalDate();
        float remainsOnBonuses = company.getSalaryFond() - company.getPureSalary();
        float toEachDepartment = remainsOnBonuses / company.getDepartmentsCount();

        for (Department department : company.getDepartments()){
            float toEachWorkerInDepartment = toEachDepartment / department.getWorkersCount();
            for (Worker worker : department.getWorkersList()){
                float toEachWorker = worker.getSalary() + toEachWorkerInDepartment;
                if(worker.getBirthDay().getMonthOfYear() == today.getMonthOfYear()){
                    toEachWorker += 50;
                    System.out.println("Today is BirthDay of "+ worker.getName() +
                            ". Lets congratulate him! He gets +50 bucks.");
                }
                workersSalaryMap.put(worker, toEachWorker);
            }
        }
        return workersSalaryMap;
    }

    static public void printWorkersSalary(Map<Worker, Float> workersSalaryMap){
        for (Map.Entry<Worker, Float> workerAndSalaryEntry : workersSalaryMap.entrySet()){
            String formattedSalary = String.format("%.2f", workerAndSalaryEntry.getValue());
            System.out.println(workerAndSalaryEntry.getKey().getName()+" from "+
                    workerAndSalaryEntry.getKey().getDepartmentName()+" gets "+formattedSalary);
        }
    }
}
