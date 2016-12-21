package services;

import essences.Department;
import essences.Manager;
import essences.Worker;

import java.util.List;
import java.util.Random;

public class DepartmentService {
    public static synchronized void downgradeManager(Manager manager, Department department){
        List<Manager> managers = department.getManagersList();
        if (managers.size() > 1){
            Random random = new Random();
            Manager assignManager;
            do {
                assignManager = managers.get(random.nextInt(managers.size()));
                if (!manager.equals(assignManager)) {
                    assignManager.addWorkers(manager.getWorkersList());
                    Worker worker = new Worker(("Used to be " + manager.getName()),
                            department.getName(),
                            manager.getBirthDay(),
                            manager.getSalary(),
                            manager.getEmploymentDate(),
                            manager.getId());
                    department.addWorker(worker);
                    assignManager.addWorker(worker);
                    System.out.println("You've got new worker " + worker.getName());
                    department.removeManager(manager);
                    break;
                }
            } while (true);
        }
        else {
            System.out.println("Sorry, it is last manager in this department. Hire another one.");
        }
    }

    public static synchronized void upgradeWorker(Worker worker, Department department){
        Manager manager = new Manager("Used to be " + worker.getName(),
                department.getName(),
                worker.getBirthDay(),
                worker.getSalary(),
                worker.getEmploymentDate(),
                worker.getId());
        department.addManager(manager);
        department.removeWorker(worker);
        System.out.println("You've got new worker " + manager.getName());
    }
}
