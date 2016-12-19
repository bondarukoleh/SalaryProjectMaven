import org.joda.time.LocalDate;
import org.junit.Test;
import org.testng.annotations.BeforeTest;

import java.util.Map;

public class EqualPaysheetTest {

    Company companyForTest = null;

    @Test
    public void setUpCompany() {
        CompanyGenerator generateCompany = new CompanyGenerator(2, 5, 10);
        Company company = new Company("TestCompany");

        Department department1 = new Department("TestDepartment1", 100);
        Department department2 = new Department("TestDepartment2", 101);


        department1.addWorker(new Worker("Worker1", "TestDepartment1", new LocalDate(1990, 8, 15), 1500, new LocalDate(2000, 8, 15), 1));
        department1.addWorker(new Worker("Worker2", "TestDepartment1", new LocalDate(1990, 8, 16), 2000, new LocalDate(2000, 8, 15), 2));
        department1.addManager(new Manager("Manager1", "TestDepartment1", new LocalDate(1990, 8, 17), 3000, new LocalDate(2000, 8, 15), 3));
        Manager manager1 = department1.getManagersList().get(0);
        for (Worker worker : department1.getWorkersList()){
            manager1.addWorker(worker);
        }

        department2.addWorker(new Worker("Worker3", "TestDepartment2", new LocalDate(1990, 8, 18), 2500, new LocalDate(2000, 8, 15), 4));
        department2.addWorker(new Worker("Worker4", "TestDepartment2", new LocalDate(1990, 8, 19), 3500, new LocalDate(2000, 8, 15), 5));
        department2.addManager(new Manager("Manager2", "TestDepartment2", new LocalDate(1990, 8, 20), 4000, new LocalDate(2000, 8, 15), 6));
        Manager manager2 = department2.getManagersList().get(0);
        for (Worker worker : department2.getWorkersList()){
            manager2.addWorker(worker);
        }

        company.addDepartment(department1);
        company.addDepartment(department2);
        company.setSalaryFond(600000);

        companyForTest = company;

//        EqualPaysheet equalPaysheet = new EqualPaysheet();
//        Map<Worker, Float> workersSalaryMap = equalPaysheet.calculateSalary(company);
//
//        Print print = new Print();
//        print.printWorkersSalary(workersSalaryMap);
    }

    @Test
    public void salaryTest() {
        EqualPaysheet equalPaysheet = new EqualPaysheet();
        Map<Worker, Float> workersSalaryMap = equalPaysheet.calculateSalary(companyForTest);
        equalPaysheet.printWorkersSalary(workersSalaryMap);

        Print print = new Print();
        print.printWorkersSalary(workersSalaryMap);
    }
}
