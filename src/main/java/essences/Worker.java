package essences;

import org.joda.time.LocalDate;

public class Worker {
    private final String name;
    private final LocalDate birthDay;
    private final LocalDate employmentDate;
    private String departmentName;
    private float salary;
    private final int id;

    public Worker(String name, String departmentName, LocalDate bDay, float salary,
    LocalDate empDate, int id){
        this.name = name;
        birthDay = bDay;
        this.salary = salary;
        this.departmentName = departmentName;
        employmentDate = empDate;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public float getSalary(){
        return salary;
    }

    public LocalDate getBirthDay(){
        return birthDay;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public LocalDate getEmploymentDate(){
        return employmentDate;
    }

    public int getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        if (Float.compare(worker.salary, salary) != 0) return false;
        if (id != worker.id) return false;
        if (!name.equals(worker.name)) return false;
        if (!birthDay.equals(worker.birthDay)) return false;
        if (!employmentDate.equals(worker.employmentDate)) return false;
        return departmentName.equals(worker.departmentName);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + birthDay.hashCode();
        result = 31 * result + employmentDate.hashCode();
        result = 31 * result + departmentName.hashCode();
        result = 31 * result + (salary != +0.0f ? Float.floatToIntBits(salary) : 0);
        result = 31 * result + id;
        return result;
    }
}
