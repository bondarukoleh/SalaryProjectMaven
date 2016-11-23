import java.util.List;
import java.util.Map;
import java.util.Random;

public class GenerateCompany {
    private Company comp;
    int departmentAmount;
    int workersAmount;
    Random random;

    public GenerateCompany(int departmentAmount, int workersAmount){
        this.departmentAmount = departmentAmount;
        this.workersAmount = workersAmount;
        random = new Random();
    }

    public Company getCompany(){
        Company company = new Company("Company1");

        for (int i = 0; i < departmentAmount; i++){
            company.addDepartment(new Department("Department"+(i+1)));
        }

        for (Department d : company.getDepartments()){
            for (int i=0; i < workersAmount; i++){
                d.addWorker(new Worker("Worker" + (i+1), random.nextInt(2019-1900)+1900,
                            random.nextInt(12-1)+1,
                            random.nextInt(31-1)+1,
                            random.nextInt(10000-2000)+2000));
            }
        }

//        Department department1 = new Department("Department1");
//        department1.addWorker(new Worker("Worker1", 1990, 1, 8, 1000));
//        department1.addWorker(new Worker("Worker2", 1990, 2, 9, 1000));
//
//        Department department2 = new Department("Department2");
//        department2.addWorker(new Worker("Worker3", 1990, 3, 10, 1000));
//        department2.addWorker(new Worker("Worker4", 1990, 4, 11, 1000));
//        department2.addWorker(new Worker("Worker5", 1990, 11, 21, 1000));

//        company.addDepartment(department1);
//        company.addDepartment(department2);
        return company;
    }
}
