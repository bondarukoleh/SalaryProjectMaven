package services;

import essences.Company;
import essences.Department;
import essences.Manager;
import essences.Worker;
import utilities.DatesGenerator;

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

        for (int i = 0; i < departmentAmount; i++){
            company.addDepartment(new Department("Department"+(i), i));
        }

        for (Department d : company.getDepartments()) {
            int randomManagersAmount = random.nextInt(managersAmount) + managersAmount/2;
            for (int i = 0; i < randomManagersAmount; i++) {
                d.addManager(new Manager("Manager" + CompanyService.getTotalWorkersCount(company), d.getName(),
                        DatesGenerator.getBday(),
                        random.nextInt(10000 - 2000) + 2000,
                        DatesGenerator.getEmploymentDate(),
                        CompanyService.getTotalWorkersCount(company)));
            }
        }

        for (Department d : company.getDepartments()){
            int randomWorkersCount = random.nextInt(workersAmount)+workersAmount/2;
            for (int i=0; i < randomWorkersCount; i++){
                Worker worker1 = new Worker("Worker" + CompanyService.getTotalWorkersCount(company), d.getName(),
                        DatesGenerator.getBday(),
                        random.nextInt(10000 - 2000) + 2000,
                        DatesGenerator.getEmploymentDate(),
                        CompanyService.getTotalWorkersCount(company));
                d.addWorker(worker1);
                Manager manager = d.getManagersList().get(random.nextInt(d.getManagersList().size()));
                manager.addWorker(worker1);
            }
        }
        return company;
    }
}
