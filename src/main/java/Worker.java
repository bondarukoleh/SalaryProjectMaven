import org.joda.time.LocalDate;

/**
 * Created by oleh.bondaruk on 11/18/2016.
 */
public class Worker {
    private String name;
    private LocalDate birthDay = new LocalDate();
    private double salary;

    public Worker(String name, int year,int monthOfYear,int dayOfMonth){
        this.name = name;
        birthDay = new LocalDate(year, monthOfYear, dayOfMonth);
    }

    public String getName(){
        return name;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public LocalDate getBirthDay(){
        return  birthDay;
    }
}
