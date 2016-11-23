import org.joda.time.LocalDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        String userEnter;
        GenerateCompany createCompany = new GenerateCompany();
        Company company = createCompany.getCompany();
        Paysheet paysheet = new Paysheet(company);

        do {
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

            paysheet.workersSalaryMap = paysheet.setUpWorkersAndSalaryMap();

            if (methodNumber == 1) {
                paysheet.calcEqualBonusForEachWorker(paysheet.workersSalaryMap);
            } else if (methodNumber == 2) {
                paysheet.calcSalaryDependOnBranches(paysheet.workersSalaryMap);
            } else {
                System.out.println("Please enter \"1\" or \"2\" \nTry again later.");
            }
            paysheet.printWorkersSalary(paysheet.workersSalaryMap);
            System.out.println("Would you like another calculation? \"Y\" / \"N\"");
            userEnter = reader.readLine().toLowerCase();
        } while (userEnter.contentEquals("y"));
    }
}
