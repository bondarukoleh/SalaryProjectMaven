import org.joda.time.LocalDate;

public class Worker {
    private final String name;
    private final LocalDate birthDay;
    private final LocalDate employmentDate;
    private String departmentName;
    private float salary;
    private final int id;

    public Worker(String name, String departmentName, int year, int monthOfYear, int dayOfMonth, float salary,
    int empYear, int empMonthOfYear, int empDayOfMonth, int id){
        this.name = name;
        birthDay = new LocalDate(year, monthOfYear, dayOfMonth);
        this.salary = salary;
        this.departmentName = departmentName;
        employmentDate = new LocalDate(empYear, empMonthOfYear, empDayOfMonth);
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
}
