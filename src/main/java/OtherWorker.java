import java.util.List;

public class OtherWorker extends Worker {
    private String description;

    public OtherWorker(String name, String departmentName, int year, int monthOfYear, int dayOfMonth, float salary,
                       int empYear, int empMonthOfYear, int empDayOfMonth, String description){
        super(name, departmentName, year, monthOfYear, dayOfMonth, salary, empYear, empMonthOfYear, empDayOfMonth);
        this.description = description;
    }

    public void printDescription(){
        System.out.println("This is " + description);
    }
}
