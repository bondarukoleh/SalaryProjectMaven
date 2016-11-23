
public class GenerateCompany {

    public Company getCompany(){
        Company company = new Company("Company1");

        Department department1 = new Department("Department1");

        department1.addWorker(new Worker("Worker1", 1990, 1, 8, 1000));
        department1.addWorker(new Worker("Worker2", 1990, 2, 9, 1000));

        Department department2 = new Department("Department2");
        department2.addWorker(new Worker("Worker3", 1990, 3, 10, 1000));
        department2.addWorker(new Worker("Worker4", 1990, 4, 11, 1000));
        department2.addWorker(new Worker("Worker5", 1990, 11, 21, 1000));

        company.addDepartment(department1);
        company.addDepartment(department2);
        return company;
    }
}
