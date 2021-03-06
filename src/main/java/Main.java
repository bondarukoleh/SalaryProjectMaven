import essences.Company;
import essences.Department;
import essences.Worker;
import services.*;
import utilities.IOHelper;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        int userEnerDeptAmount = IOHelper.getUsersDepartmentAmount();
        int userEnerManagersAmount = IOHelper.getUsersManagersAmount();
        int userEnerWorkersAmount = IOHelper.getUsersWorkersAmount();

        CompanyGenerator createCompany = new CompanyGenerator(userEnerDeptAmount,userEnerManagersAmount,
                userEnerWorkersAmount);

        String userEnter = "";

        do {
            Company company;
            company = createCompany.getCompany();
            Map<Worker, Float> workersSalaryMap = new LinkedHashMap<Worker, Float>();
            IOHelper.minSalary(company);
            float fond = IOHelper.getUsersSalaryFond();
            company.setSalaryFond(fond);
            IOHelper.printWorkers(company);
            do {
                int methodNumber = IOHelper.getUsersCalcMetod();

                if (methodNumber == 1) {
                    Paysheet paysheet = new EqualPaysheet();
                    workersSalaryMap = paysheet.calculateSalary(company);
                    IOHelper.printWorkersSalary(workersSalaryMap);
                } else if (methodNumber == 2) {
                    Paysheet paysheet = new DepartmentDependPaysheet();
                    workersSalaryMap = paysheet.calculateSalary(company);
                    IOHelper.printWorkersSalary(workersSalaryMap);
                } else {
                    IOHelper.ifUserEntersCrap();
                }
            } while (IOHelper.getUsersDesireAboutAnotherCalculation().contentEquals("y"));

            while(IOHelper.getUsersDesireAboutDowngradeManager().contentEquals("y")){
                int usEntDepId = IOHelper.getUsersDeptIdToDowngradeManager();
                Department department = company.getDepartments().get(usEntDepId);

                int userEnterManagerId = IOHelper.getUsersMenegerIdToDowngrade();
                DepartmentService.downgradeManager(department.getManagersList().get(userEnterManagerId), department);
                IOHelper.printWorkers(company);
            }

            while (IOHelper.getUsersDesireAboutUpgradeWorker().contentEquals("y")) {
                int usEntDepId = IOHelper.getUsersDeptIdToUpgradeWorker();
                int userEnterWorkerId = IOHelper.getUsersWorkerIdToUpgrade();

                Department department = company.getDepartments().get(usEntDepId);
                DepartmentService.upgradeWorker(department.getWorkersList().get(userEnterWorkerId), department);
                IOHelper.printWorkers(company);
            }
        } while (IOHelper.getUserDesireAboutAnotherRound().contentEquals("y"));
    }
}
