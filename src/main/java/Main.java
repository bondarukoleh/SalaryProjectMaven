import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    //----------------------------------------------------------------
    // TODO: 11/24/2016 write a few unit tests 
    //----------------------------------------------------------------

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
            do {
                int methodNumber = print.getUsersCalcMetod();
//            print.printWorkers(company);

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

                String userEntersAboutAnotherCalc = print.getUsersDesireAboutAnotherCalculation();
                if (userEntersAboutAnotherCalc.contentEquals("y")){
                    continue;
                } else {
                    break;
                }
            } while (true);

            while(print.getUsersDesireAboutDowngradeManager().contentEquals("y")){
                int usEntDepId = print.getUsersDeptIdToDowngradeManager();
                int userEnterManagerId = print.getUsersMenegerIdToDowngrade();

                Department dept = company.getDepartments().get(usEntDepId);
                dept.downgradeManager(dept.getManagersList().get(userEnterManagerId));
            }
//            do {
//                String userEnters = print.getUsersDesireAboutDowngradeManager();
//
//                if (userEnters.contentEquals("y")) {
//                    int usEntDepId = print.getUsersDeptIdToDowngradeManager();
//                    int userEnterManagerId = print.getUsersMenegerIdToDowngrade();
//
//                    Department dept = company.getDepartments().get(usEntDepId);
//                    dept.downgradeManager(dept.getManagersList().get(userEnterManagerId));
//                    continue;
//                } else {
//                    break;
//                }
//            } while (true);

            userEnter = print.getUsersDesireAboutUpgradeWorker();
            // TODO: 11/24/2016 write same for upgrade worker
        } while (userEnter.contentEquals("y"));
    }
}
