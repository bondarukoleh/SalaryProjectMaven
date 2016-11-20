import org.joda.time.LocalDate;

public class Worker {
    private final String name;
    private final LocalDate birthDay; //Может я не там смотрел, но в DateTime не нашел конструктора на год/месяй/день
    private String departmentName;
    private double salary;

    public Worker(String name, int year, int monthOfYear, int dayOfMonth, double salary){
        this.name = name;
        birthDay = new LocalDate(year, monthOfYear, dayOfMonth);
        this.salary = salary;
        departmentName = Department.getDepartmentName();
        if(birthDay.getMonthOfYear() == new LocalDate().getMonthOfYear()&
                birthDay.getDayOfMonth() == new LocalDate().getDayOfMonth()){
            this.salary += 50.0;
            System.out.println("Today is DirthDay of "+ this.name + ". Lets congratulate him! He gets +50 bucks.");
        }
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public LocalDate getBirthDay(){
        return birthDay;
    }

    public String getDepartmentName(){
        return departmentName;
    }
}
