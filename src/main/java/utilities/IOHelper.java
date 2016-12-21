package utilities;

import essences.Company;
import essences.Department;
import essences.Worker;
import essences.Manager;
import services.CompanyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class IOHelper {
   private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int getUsersDepartmentAmount() throws IOException{
        String userEnter;
        System.out.println("Please enter department amount of your company: ");
        String departmentAmount = reader.readLine();
        int userEnerDeptAmount = Integer.parseInt(departmentAmount);
        return userEnerDeptAmount;
    }

    public static int getUsersWorkersAmount() throws IOException{
        System.out.println("Please enter workers amount in your departments: ");
        String workersAmount = reader.readLine();
        int userEnerWorkersAmount = Integer.parseInt(workersAmount);
        return userEnerWorkersAmount;
    }

    public static int getUsersManagersAmount() throws IOException{
        System.out.println("Please enter managers amount in your departments: ");
        String managersAmount = reader.readLine();
        int userEnerManagersAmount = Integer.parseInt(managersAmount);
        return userEnerManagersAmount;
    }

    public static void minSalary (Company company){
        System.out.println("Fond cannot be less than: "+ CompanyService.getPureSalary(company));
    }

    public static float getUsersSalaryFond()throws IOException{
        System.out.println("Please enter Salary fond for your essences.Company: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String userEntersFond = reader.readLine();
        float fond = Float.parseFloat(userEntersFond);
        return fond;
    }

    public static int getUsersCalcMetod() throws IOException{
        System.out.println("How would you like to calculate salary for your company?" +
                "\nEqual to each worker - please enter \"1\"" +
                "\nDepend on Departments - please enter \"2\"");
        String userEntersCalcMethod = reader.readLine();
        int methodNumber = Integer.parseInt(userEntersCalcMethod);
        return methodNumber;
    }

    public static void printWorkers(Company company){
        System.out.println("Amount of workers is " + CompanyService.getTotalWorkersCount(company));
        for(Department d: company.getDepartments()){
            System.out.println("You have " + d.getName() +" with id "+d.getId()+
                    " index "+company.getDepartments().indexOf(d));
            System.out.println("In it you have:");
            for (Manager manager: d.getManagersList()){
                System.out.println(manager.getName() + " with id - " + manager.getId()+
                        " with Bday - " + manager.getBirthDay()+ " with salary - "+ manager.getSalary()
                        + " with index - "  + d.getManagersList().indexOf(manager));
            }
            for (Worker worker: d.getWorkersList()){
                System.out.println(worker.getName() + " with id - " + worker.getId()+
                        " with Bday - " + worker.getBirthDay()+ " with salary - "+ worker.getSalary()+
                        " with index - "  + d.getWorkersList().indexOf(worker));
            }
        }
    }

    public static void ifUserEntersCrap(){
        System.out.println("Please enter \"1\" or \"2\" \nTry again later.");
    }

    public static String getUsersDesireAboutAnotherCalculation() throws IOException{
        System.out.println("Would you like another calculation? \"Y\" / \"N\"");
        String userEnter = reader.readLine().toLowerCase();
        return userEnter;
    }

    public static String getUsersDesireAboutDowngradeManager() throws IOException{
        System.out.println("Would you like to Downgrade essences.Manager to essences.Worker? \"Y\" / \"N\"");
        String userDesireAboutDowngradeManager = reader.readLine().toLowerCase();
        return userDesireAboutDowngradeManager;
    }

    public static int getUsersDeptIdToDowngradeManager() throws IOException{
        System.out.println("Enter department id(index): ");
        String userEnterDepartmentId = reader.readLine();
        int usersEnterDepId = Integer.parseInt(userEnterDepartmentId);
        return usersEnterDepId;
    }

    public static int getUsersMenegerIdToDowngrade() throws IOException{
        System.out.println("Enter manager id(index):");
        String userEnterManagertId = reader.readLine();
        int usEntManId = Integer.parseInt(userEnterManagertId);
        return usEntManId;
    }

    public static String getUsersDesireAboutUpgradeWorker()throws IOException{
        System.out.println("Would you like to Upgrade essences.Worker to essences.Manager? \"Y\" / \"N\"");
        String userDesireAboutUpgradeWorker = reader.readLine().toLowerCase();
        return userDesireAboutUpgradeWorker;
    }

    public static int getUsersDeptIdToUpgradeWorker() throws IOException{
        System.out.println("Enter department id(index): ");
        String userEnterDepartmentId = reader.readLine();
        int usersEnterDepId = Integer.parseInt(userEnterDepartmentId);
        return usersEnterDepId;
    }

    public static int getUsersWorkerIdToUpgrade() throws IOException{
        System.out.println("Enter worker id(index):");
        String userEnterManagertId = reader.readLine();
        int usEntWorkId = Integer.parseInt(userEnterManagertId);
        return usEntWorkId;
    }

    public static String getUserDesireAboutAnotherRound()throws IOException{
        System.out.println("Would you like another round? \"Y\" / \"N\"");
        String userDesireAbouAnotherRound = reader.readLine().toLowerCase();
        return userDesireAbouAnotherRound;
    }

    public static void printWorkersSalary(Map<Worker, Float> workersSalaryMap){
        for (Map.Entry<Worker, Float> workerAndSalaryEntry : workersSalaryMap.entrySet()){
            String formattedSalary = String.format("%.2f", workerAndSalaryEntry.getValue());
            System.out.println(workerAndSalaryEntry.getKey().getName()+" from "+
                    workerAndSalaryEntry.getKey().getDepartmentName()+" gets "+formattedSalary);
        }
    }


}
