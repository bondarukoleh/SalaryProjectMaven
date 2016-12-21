package services;

import essences.Company;
import essences.Worker;

import java.util.Map;

public interface Paysheet {
   Map<Worker, Float> calculateSalary(Company company);
}
