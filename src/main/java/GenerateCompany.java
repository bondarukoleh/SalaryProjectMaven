import java.util.Random;

public class GenerateCompany {
    private Company comp;
    private int departmentAmount;
    private int workersAmount;
    private Random random;

    public GenerateCompany(int departmentAmount, int workersAmount){
        this.departmentAmount = departmentAmount;
        this.workersAmount = workersAmount;
        random = new Random();
    }

    //@SuppressWarnings("rawtypes")
    public Company getCompany(){
        Company company = new Company("Company1");

        for (int i = 1; i < departmentAmount+1; i++){
            company.addDepartment(new Department("Department"+(i)));
        }

        for (Department d : company.getDepartments()){
            int randomWorkersCount = random.nextInt(workersAmount)+workersAmount/2;
            for (int i=1; i <  randomWorkersCount+1; i++){
                d.addWorker(new Worker("Worker" + (i), d.getName(),
                        random.nextInt(2010-1900)+1900,
                        random.nextInt(12-1)+1,
                        random.nextInt(28-1)+1,
                        random.nextInt(10000-2000)+2000,
                        random.nextInt(2000-1980)+1900,
                        random.nextInt(12-1)+1,
                        random.nextInt(28-1)+1));
            }

            int randomManagersAmount = random.nextInt(workersAmount)+workersAmount/5;
            for (int i=1; i < randomManagersAmount+1; i++){
                d.addWorker(new Manager("Manager" + (i), d.getName(),
                        random.nextInt(2010-1900)+1900,
                        random.nextInt(12-1)+1,
                        random.nextInt(28-1)+1,
                        random.nextInt(10000-2000)+2000,
                        random.nextInt(2000-1980)+1900,
                        random.nextInt(12-1)+1,
                        random.nextInt(28-1)+1));
            }

            for (Worker w : d.getWorkersList()){
                if (w instanceof Manager){
                    d.addManager((Manager) w);
                }
            }
        }
        return company;
    }
}
