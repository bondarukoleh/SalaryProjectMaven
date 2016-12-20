import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Print print = new Print();

        int userEnerDeptAmount = print.getUsersDepartmentAmount();
        int userEnerManagersAmount = print.getUsersManagersAmount();
        int userEnerWorkersAmount = print.getUsersWorkersAmount();

        CompanyGenerator createCompany = new CompanyGenerator(userEnerDeptAmount,userEnerManagersAmount,
                userEnerWorkersAmount);

        String userEnter = "";

        do {
            Company company;
            company = createCompany.getCompany();
            Map<Worker, Float> workersSalaryMap = new LinkedHashMap<Worker, Float>();
            print.minSalary(company);
            float fond = print.getUsersSalaryFond();
            company.setSalaryFond(fond);
            print.printWorkers(company);
            do {
                int methodNumber = print.getUsersCalcMetod();

                if (methodNumber == 1) {
                    Paysheet paysheet = new EqualPaysheet();
                    workersSalaryMap = paysheet.calculateSalary(company);
                    print.printWorkersSalary(workersSalaryMap);
                } else if (methodNumber == 2) {
                    Paysheet paysheet = new DepartmentDependPaysheet();
                    workersSalaryMap = paysheet.calculateSalary(company);
                    print.printWorkersSalary(workersSalaryMap);
                } else {
                    print.ifUserEntersCrap();
                }
            } while (print.getUsersDesireAboutAnotherCalculation().contentEquals("y"));

            while(print.getUsersDesireAboutDowngradeManager().contentEquals("y")){
                int usEntDepId = print.getUsersDeptIdToDowngradeManager();
                int userEnterManagerId = print.getUsersMenegerIdToDowngrade();

                Department dept = company.getDepartments().get(usEntDepId);
                dept.downgradeManager(dept.getManagersList().get(userEnterManagerId));
                print.printWorkers(company);
            }

            while (print.getUsersDesireAboutUpgradeWorker().contentEquals("y")) {
                int usEntDepId = print.getUsersDeptIdToUpgradeWorker();
                int userEnterWorkerId = print.getUsersWorkerIdToUpgrade();

                Department dept = company.getDepartments().get(usEntDepId);
                dept.upgradeWorker(dept.getWorkersList().get(userEnterWorkerId));
                print.printWorkers(company);
            }
        } while (print.getUserDesireAboutAnotherRound().contentEquals("y"));
    }
}
