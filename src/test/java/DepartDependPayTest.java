import essences.Company;
import essences.Department;
import essences.Manager;
import essences.Worker;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import services.DepartmentDependPaysheet;
import services.EqualPaysheet;
import utilities.IOHelper;

import java.util.HashMap;
import java.util.Map;

public class DepartDependPayTest {
    public static final int SALARY_FOND = 16000;
    static Company company = null;
    static Map<Worker, Float> workersSalaryMap = null;


    @BeforeClass
    public static void setUpCompany() {
        company = new Company("TestCompany");

        Department department1 = new Department("TestDepartment1", 100);
        Department department2 = new Department("TestDepartment2", 101);


        department1.addWorker(new Worker("Worker2", "TestDepartment1", new LocalDate(1990, 8, 16), 2000,
                new LocalDate(2000, 8, 15), 1));
        department1.addWorker(new Worker("Worker3", "TestDepartment1", new LocalDate(1990, 8, 11), 2000,
                new LocalDate(2000, 9, 16), 2));
        department1.addManager(new Manager("Manager1", "TestDepartment1", new LocalDate(1990, 8, 17), 3000,
                new LocalDate(2000, 8, 15), 3));
        Manager manager1 = department1.getManagersList().get(0);
        for (Worker worker : department1.getWorkersList()){
            manager1.addWorker(worker);
        }

        department2.addWorker(new Worker("Worker4", "TestDepartment2", new LocalDate(), 3500,
                new LocalDate(2000, 12, 15), 4));
        department2.addManager(new Manager("Manager2", "TestDepartment2", new LocalDate(1990, 8, 20), 4000,
                new LocalDate(2000, 8, 15), 5));
        Manager manager2 = department2.getManagersList().get(0);
        for (Worker worker : department2.getWorkersList()){
            manager2.addWorker(worker);
        }

        company.addDepartment(department1);
        company.addDepartment(department2);
        company.setSalaryFond(SALARY_FOND);

        IOHelper.minSalary(company);
        IOHelper.printWorkers(company);

        DepartmentDependPaysheet departmentDependPaysheet = new DepartmentDependPaysheet();
        workersSalaryMap = departmentDependPaysheet.calculateSalary(company);
        IOHelper.printWorkersSalary(workersSalaryMap);
    }

    @Test
    public void firstWorkerSalaryTest() {
        HashMap.Entry<Worker, Float> firstEntry = workersSalaryMap.entrySet().iterator().next();
        float salary = firstEntry.getValue();

        Assert.assertEquals(2216.67, salary, 0.01);
    }

    @Test
    public void secondWorkerSalaryTest() {
        HashMap.Entry<Worker, Float> testWorker = null;

        for(HashMap.Entry<Worker, Float> entry : workersSalaryMap.entrySet()){
            if(entry.getKey().getName() == "Worker3"){
                testWorker = entry;
            }
        }
        float salary = testWorker.getValue();

        Assert.assertEquals(2216.67, salary, 0.01);
    }

    @Test
    public void thirdWorkerSalaryTest() {
        HashMap.Entry<Worker, Float> testWorker = null;

        for(HashMap.Entry<Worker, Float> entry : workersSalaryMap.entrySet()){
            if(entry.getKey().getName() == "Manager1"){
                testWorker = entry;
            }
        }
        float salary = testWorker.getValue();

        Assert.assertEquals(3316.67, salary, 0.01);
    }

    @Test
    public void forthWorkerSalaryTest() {
        HashMap.Entry<Worker, Float> testWorker = null;

        for(HashMap.Entry<Worker, Float> entry : workersSalaryMap.entrySet()){
            if(entry.getKey().getName() == "Worker4"){
                testWorker = entry;
            }
        }
        float salary = testWorker.getValue();

        Assert.assertEquals(3875.00, salary, 0.01);
    }

    @Test
    public void fifthWorkerSalaryTest() {
        HashMap.Entry<Worker, Float> testWorker = null;

        for(HashMap.Entry<Worker, Float> entry : workersSalaryMap.entrySet()){
            if(entry.getKey().getName() == "Manager2"){
                testWorker = entry;
            }
        }
        float salary = testWorker.getValue();

        Assert.assertEquals(4375.00, salary, 0.01);
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
