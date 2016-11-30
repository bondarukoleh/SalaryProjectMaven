import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    //----------------------------------------------------------------
    // TODO: 11/24/2016 write a few unit tests 
    //----------------------------------------------------------------

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;
        String userEnter;
        System.out.println("Please enter department amount of your company: ");
        String departmentAmount = reader.readLine();
        int userEnerDeptAmount = Integer.parseInt(departmentAmount);
        System.out.println("Please enter workers amount in your departments: ");
        String workersAmount = reader.readLine();
        int userEnerWorkersAmount = Integer.parseInt(workersAmount);
        System.out.println("Please enter managers amount in your departments: ");
        String managersAmount = reader.readLine();
        int userEnerManagersAmount = Integer.parseInt(managersAmount);

        GenerateCompany createCompany = new GenerateCompany(userEnerDeptAmount, userEnerWorkersAmount,
                                                            userEnerManagersAmount);

        do {
            Company company = createCompany.getCompany();
            Map<Worker, Float> workersSalaryMap = new LinkedHashMap<Worker, Float>();
            System.out.println("Fond cannot be less than: "+ company.getPureSalary()+
                            "\nPlease enter Salary fond for your Company: ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            String userEntersFond = reader.readLine();
            float fond = Float.parseFloat(userEntersFond);
            company.setSalaryFond(fond);

            System.out.println("How would you like to calculate salary for your company?" +
                    "\nEqual to each worker - please enter \"1\"" +
                    "\nDepend on Departments - please enter \"2\"");
            String userEntersCalcMethod = reader.readLine();
            int methodNumber = Integer.parseInt(userEntersCalcMethod);

//            System.out.println("Amount of workers is " + company.getTotalWorkersCount());
            for(Department d: company.getDepartments()){
//                for (Manager m: d.getManagersList()){
//                    m.printManagerWorkers();
//                }
                d.printManagers();
            }

            if (methodNumber == 1) {
                workersSalaryMap = Paysheet.calcEqualBonusForEachWorker(company);
            } else if (methodNumber == 2) {
                workersSalaryMap = Paysheet.calcSalaryDependOnBranches(company);
            } else {
                System.out.println("Please enter \"1\" or \"2\" \nTry again later.");
            }
            Paysheet.printWorkersSalary(workersSalaryMap);
            System.out.println("Would you like another calculation? \"Y\" / \"N\"");
            userEnter = reader.readLine().toLowerCase();

            System.out.println("Would you like to downgrade manager to worker? \n Enter department id:");
            String userEnterDepartmentId = reader.readLine();
            int usEntDepId = Integer.parseInt(userEnterDepartmentId);
            System.out.println("Enter manager id:");
            String userEnterManagertId = reader.readLine();
            int usEntManId = Integer.parseInt(userEnterManagertId);

            Department d = company.getDepartments().get(usEntDepId);
            d.downgradeManager(d.getManagersList().get(usEntManId));
        } while (userEnter.contentEquals("y"));

    }
}
