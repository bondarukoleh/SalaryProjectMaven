import java.util.Random;

public class GenerateCompany {
    private Company comp;
    private int departmentAmount;
    private int workersAmount;
    private int managersAmount;
    private Random random;

    public GenerateCompany(int departmentAmount, int workersAmount, int managersAmount){
        this.departmentAmount = departmentAmount;
        this.workersAmount = workersAmount;
        this.managersAmount = managersAmount;
        random = new Random();
    }

    public Company getCompany(){
        Company company = new Company("Company1");

        for (int i = 1; i < departmentAmount+1; i++){
            company.addDepartment(new Department("Department"+(i), i));
        }

        for (Department d : company.getDepartments()) {
            int randomManagersAmount = random.nextInt(managersAmount) + managersAmount/2;
            for (int i = 0; i < randomManagersAmount; i++) {
                d.addManager(new Manager("Manager" + (i), d.getName(),
                        random.nextInt(2010 - 1900) + 1900,
                        random.nextInt(12 - 1) + 1,
                        random.nextInt(28 - 1) + 1,
                        random.nextInt(10000 - 2000) + 2000,
                        random.nextInt(2000 - 1980) + 1900,
                        random.nextInt(12 - 1) + 1,
                        random.nextInt(28 - 1) + 1,
                        i));
            }
        }

        for (Department d : company.getDepartments()){
            int randomWorkersCount = random.nextInt(workersAmount)+workersAmount/2;
            for (int i=0; i < randomWorkersCount; i++){
                Worker worker1 = new Worker("Worker" + (i), d.getName(),
                        random.nextInt(2010 - 1900) + 1900,
                        random.nextInt(12 - 1) + 1,
                        random.nextInt(28 - 1) + 1,
                        random.nextInt(10000 - 2000) + 2000,
                        random.nextInt(2000 - 1980) + 1900,
                        random.nextInt(12 - 1) + 1,
                        random.nextInt(28 - 1) + 1,
                        i);
                d.addWorker(worker1);
                Manager manager = d.getManagersList().get(random.nextInt(d.getManagersList().size()));
                manager.addWorker(worker1);
            }
        }
        return company;
    }
}
