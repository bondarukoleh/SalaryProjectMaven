import java.util.Random;

public class CompanyGenerator {
    private Company comp;
    private int departmentAmount;
    private int workersAmount;
    private int managersAmount;
    private Random random;

    public CompanyGenerator(int departmentAmount, int managersAmount, int workersAmount){
        this.departmentAmount = departmentAmount;
        this.managersAmount = managersAmount;
        this.workersAmount = workersAmount;
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
                d.addManager(new Manager("Manager" + company.getTotalWorkersCount(), d.getName(),
                        DatesGenerator.getBday(),
                        random.nextInt(10000 - 2000) + 2000,
                        DatesGenerator.getEmploymentDate(),
                        company.getTotalWorkersCount()));
            }
        }

        for (Department d : company.getDepartments()){
            int randomWorkersCount = random.nextInt(workersAmount)+workersAmount/2;
            for (int i=0; i < randomWorkersCount; i++){
                Worker worker1 = new Worker("Worker" + company.getTotalWorkersCount(), d.getName(),
                        DatesGenerator.getBday(),
                        random.nextInt(10000 - 2000) + 2000,
                        DatesGenerator.getEmploymentDate(),
                        company.getTotalWorkersCount());
                d.addWorker(worker1);
                Manager manager = d.getManagersList().get(random.nextInt(d.getManagersList().size()));
                manager.addWorker(worker1);
            }
        }
        return company;
    }
}
