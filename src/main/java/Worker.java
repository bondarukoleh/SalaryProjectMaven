import org.joda.time.LocalDate;

public class Worker {
    private final String name;
    private final LocalDate birthDay; //Может я не там смотрел, но в DateTime не нашел конструктора на год/месяй/день
    private String departmentName;
    private float salary;

    public Worker(String name, int year, int monthOfYear, int dayOfMonth, float salary){
        this.name = name;
        birthDay = new LocalDate(year, monthOfYear, dayOfMonth);
        this.salary = salary;
        departmentName = Department.getDepartmentName();
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
}
