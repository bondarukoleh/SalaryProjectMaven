import java.io.IOException;

/**
 * Created by oleh.bondaruk on 11/18/2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Company company = new Company("Company1");

        Department d1 = new Department("Department1");
        d1.addWorker(new Worker("Vasia1", 1990, 1, 8, 1000));
        d1.addWorker(new Worker("Petia2", 1990, 2, 9, 1000));
       Worker a =  d1.getWorkersList().get(0);
        //a.getBirthDay().minu

        Department d2 = new Department("Department2");
        d2.addWorker(new Worker("Vasia3", 1990, 1, 8, 1000));
        d2.addWorker(new Worker("Petia4", 1990, 2, 9, 1000));

        company.addDepartment(d1);
        company.addDepartment(d2);

        company.enterFond();
        company.calcSalary();
        company.printWorkersSalary();
    }

}
