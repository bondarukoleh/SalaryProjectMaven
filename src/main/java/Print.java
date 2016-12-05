import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Print {
   private BufferedReader reader;

    public Print(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getUsersDepartmentAmount() throws IOException{
        String userEnter;
        System.out.println("Please enter department amount of your company: ");
        String departmentAmount = reader.readLine();
        int userEnerDeptAmount = Integer.parseInt(departmentAmount);
        return userEnerDeptAmount;
    }

    public int getUsersWorkersAmount() throws IOException{
        System.out.println("Please enter workers amount in your departments: ");
        String workersAmount = reader.readLine();
        int userEnerWorkersAmount = Integer.parseInt(workersAmount);
        return userEnerWorkersAmount;
    }

    public int getUsersManagersAmount() throws IOException{
        System.out.println("Please enter managers amount in your departments: ");
        String managersAmount = reader.readLine();
        int userEnerManagersAmount = Integer.parseInt(managersAmount);
        return userEnerManagersAmount;
    }

    public void minSalary (Company company){
        System.out.println("Fond cannot be less than: "+ company.getPureSalary());
    }

    public float getUsersSalaryFond()throws IOException{
        System.out.println("Please enter Salary fond for your Company: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String userEntersFond = reader.readLine();
        float fond = Float.parseFloat(userEntersFond);
        return fond;
    }

    public int getUsersCalcMetod() throws IOException{
        System.out.println("How would you like to calculate salary for your company?" +
                "\nEqual to each worker - please enter \"1\"" +
                "\nDepend on Departments - please enter \"2\"");
        String userEntersCalcMethod = reader.readLine();
        int methodNumber = Integer.parseInt(userEntersCalcMethod);
        return methodNumber;
    }

    public void printWorkers(Company company){
        System.out.println("Amount of workers is " + company.getTotalWorkersCount());
        for(Department d: company.getDepartments()){
            for (Manager m: d.getManagersList()){
                m.printManagerWorkers();
            }
            d.printManagers();
        }
    }

    public void ifUserEntersCrap(){
        System.out.println("Please enter \"1\" or \"2\" \nTry again later.");
    }

    public String getUsersDesireAboutAnotherCalculation() throws IOException{
        System.out.println("Would you like another calculation? \"Y\" / \"N\"");
        String userEnter = reader.readLine().toLowerCase();
        return userEnter;
    }

    public String getUsersDesireAboutDowngradeManager() throws IOException{
        System.out.println("Would you like to Downgrade Manager to Worker? \"Y\" / \"N\"");
        String userDesireAboutDowngradeManager = reader.readLine().toLowerCase();
        return userDesireAboutDowngradeManager;
    }

    public int getUsersDeptIdToDowngradeManager() throws IOException{
        System.out.println("Enter department id: ");
        String userEnterDepartmentId = reader.readLine();
        int usersEnterDepId = Integer.parseInt(userEnterDepartmentId);
        return usersEnterDepId;
    }

    public int getUsersMenegerIdToDowngrade() throws IOException{
        System.out.println("Enter manager id:");
        String userEnterManagertId = reader.readLine();
        int usEntManId = Integer.parseInt(userEnterManagertId);
        return usEntManId;
    }

    public String getUsersDesireAboutUpgradeWorker()throws IOException{
        System.out.println("Would you like to Upgrade Worker to Manager? \"Y\" / \"N\"");
        String userDesireAboutUpgradeWorker = reader.readLine().toLowerCase();
        return userDesireAboutUpgradeWorker;
    }


}
