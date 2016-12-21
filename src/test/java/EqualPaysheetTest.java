import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class EqualPaysheetTest {

    Company company = null;

    @Before
    public void setUpCompany() {
        company = new Company("TestCompany");

        Department department1 = new Department("TestDepartment1", 100);
        Department department2 = new Department("TestDepartment2", 101);


        department1.addWorker(new Worker("Worker2", "TestDepartment1", new LocalDate(1990, 8, 16), 2000,
                new LocalDate(2000, 8, 15), 2));
        department1.addManager(new Manager("Manager1", "TestDepartment1", new LocalDate(1990, 8, 17), 3000,
                new LocalDate(2000, 8, 15), 3));
        Manager manager1 = department1.getManagersList().get(0);
        for (Worker worker : department1.getWorkersList()){
            manager1.addWorker(worker);
        }

        department2.addWorker(new Worker("Worker4", "TestDepartment2", new LocalDate(1990, 8, 19), 3500,
                new LocalDate(2000, 8, 15), 5));
        department2.addManager(new Manager("Manager2", "TestDepartment2", new LocalDate(1990, 8, 20), 4000,
                new LocalDate(2000, 8, 15), 6));
        Manager manager2 = department2.getManagersList().get(0);
        for (Worker worker : department2.getWorkersList()){
            manager2.addWorker(worker);
        }

        company.addDepartment(department1);
        company.addDepartment(department2);
        company.setSalaryFond(14500);
    }

    @Test
    public void salaryTest() {
        IOHelper.printWorkers(company);

        EqualPaysheet equalPaysheet = new EqualPaysheet();
        Map<Worker, Float> workersSalaryMap = equalPaysheet.calculateSalary(company);

        IOHelper.printWorkersSalary(workersSalaryMap);


        HashMap.Entry<Worker, Float> firstEntry = workersSalaryMap.entrySet().iterator().next();

        float firstPhrase = firstEntry.getValue();

        Assert.assertEquals(2475.00, firstPhrase);
    }
}
