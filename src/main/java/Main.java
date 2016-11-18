import java.io.IOException;

/**
 * Created by oleh.bondaruk on 11/18/2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Company company = new Company("Company1");

        Department d1 = new Department("Department1");
        d1.addWorker(new Worker("Vasia", 1990, 1, 8));
        d1.addWorker(new Worker("Petia", 1990, 2, 9));

        Department d2 = new Department("Department1");
        d2.addWorker(new Worker("Vasia", 1990, 1, 8));
        d2.addWorker(new Worker("Petia", 1990, 2, 9));

        company.addDepartment(d1);
        company.addDepartment(d2);

        company.enterFond();
        company.calcSalary();
        company.printWorkersSalary();
    }

}
