import java.util.Map;

public interface Paysheet {
   Map<Worker, Float> calculateSalary(Company company);

   void printWorkersSalary(Map<Worker, Float> map);
}
