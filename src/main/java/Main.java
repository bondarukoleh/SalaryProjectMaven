import org.joda.time.LocalDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Company company = new Company("Company1");
        Paysheet paysheet = new Paysheet(company);

        Department department1 = new Department("Department1");
        department1.addWorker(new Worker("Worker1", 1990, 1, 8, 1000));
        department1.addWorker(new Worker("Worker2", 1990, 2, 9, 1000));

        Department department2 = new Department("Department2");
        department2.addWorker(new Worker("Worker3", 1990, 3, 10, 1000));
        department2.addWorker(new Worker("Worker4", 1990, 4, 11, 1000));
        department2.addWorker(new Worker("Worker5", 1990, 11, 22, 1000));

        company.addDepartment(department1);
        company.addDepartment(department2);

        System.out.println("Fond cannot be less than: "+ company.getPureSalary()+
                        "\nPlease enter Salary fond for your Company: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userEntersFond = reader.readLine();
        float fond = Float.parseFloat(userEntersFond);
        company.setSalaryFond(fond);

        System.out.println("How would you like to calculate salary for your company?" +
                "\nEqual to each worker - please enter \"1\"" +
                "\nDepend on Departments - please enter \"2\"");
        String userEntersCalcMethod = reader.readLine();
        int methodNumber = Integer.parseInt(userEntersCalcMethod);

        paysheet.workersSalaryMap = paysheet.setUpWorkersAndSalaryMap();

        if (methodNumber == 1) {
            paysheet.calcEqualBonusForEachWorker(paysheet.workersSalaryMap);
        } else if (methodNumber == 2) {
            paysheet.calcSalaryDependOnBranches(paysheet.workersSalaryMap);
        } else {
            System.out.println("Please enter \"1\" or \"2\" \nTry again later.");
        }

        paysheet.printWorkersSalary(paysheet.workersSalaryMap);
        System.out.println("Money that left in the fond after salary calculation: "+
                            paysheet.moneyWithoutSalaryAndBonus);
    }
}
