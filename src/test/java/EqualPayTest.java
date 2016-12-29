import essences.Company;
import essences.Department;
import essences.Manager;
import essences.Worker;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import services.EqualPaysheet;
import utilities.IOHelper;

import java.util.HashMap;
import java.util.Map;

public class EqualPayTest {

    public static final int SALARY_FOND = 14500;
    static Company company = null;
    static Map<Worker, Float> workersSalaryMap = null;


    @BeforeClass
    public static void setUpCompany() {
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

        department2.addWorker(new Worker("Worker4", "TestDepartment2", new LocalDate(), 3500,
                new LocalDate(2000, 12, 15), 5));
        department2.addManager(new Manager("Manager2", "TestDepartment2", new LocalDate(1990, 8, 20), 4000,
                new LocalDate(2000, 8, 15), 6));
        Manager manager2 = department2.getManagersList().get(0);
        for (Worker worker : department2.getWorkersList()){
            manager2.addWorker(worker);
        }

        company.addDepartment(department1);
        company.addDepartment(department2);
        company.setSalaryFond(SALARY_FOND);

        IOHelper.minSalary(company);
        IOHelper.printWorkers(company);

        EqualPaysheet equalPaysheet = new EqualPaysheet();
        workersSalaryMap = equalPaysheet.calculateSalary(company);
        IOHelper.printWorkersSalary(workersSalaryMap);
    }

    @Test
    public void firstWorkerSalaryTest() {
        HashMap.Entry<Worker, Float> firstEntry = workersSalaryMap.entrySet().iterator().next();
        float salary = firstEntry.getValue();

        Assert.assertEquals(2462.50, salary, 0.0001);
    }

    @Test
    public void secondWorkerSalaryTest() {
        HashMap.Entry<Worker, Float> testWorker = null;

        for(HashMap.Entry<Worker, Float> entry : workersSalaryMap.entrySet()){
            if(entry.getKey().getName() == "Manager1"){
                testWorker = entry;
            }
        }
        float salary = testWorker.getValue();

        Assert.assertEquals(3512.50, salary, 0.0001);
    }

    @Test
    public void thirdWorkerSalaryTest() {
        HashMap.Entry<Worker, Float> testWorker = null;

        for(HashMap.Entry<Worker, Float> entry : workersSalaryMap.entrySet()){
            if(entry.getKey().getName() == "Worker4"){
                testWorker = entry;
            }
        }
        float salary = testWorker.getValue();

        Assert.assertEquals(4012.50, salary, 0.0001);
    }

    @Test
    public void forthWorkerSalaryTest() {
        HashMap.Entry<Worker, Float> testWorker = null;

        for(HashMap.Entry<Worker, Float> entry : workersSalaryMap.entrySet()){
            if(entry.getKey().getName() == "Manager2"){
                testWorker = entry;
            }
        }
        float salary = testWorker.getValue();

        Assert.assertEquals(4512.50, salary, 0.0001);
    }

    @Test
    public void fondTest() {
        float calculatedSalary = 0;

        for(HashMap.Entry<Worker, Float> entry : workersSalaryMap.entrySet()){
            calculatedSalary += entry.getValue();
        }

        Assert.assertEquals(SALARY_FOND, calculatedSalary, 0.0001);
    }
}
