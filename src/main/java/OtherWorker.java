import org.joda.time.LocalDate;

import java.util.List;

public class OtherWorker extends Worker {
    private String description;

    public OtherWorker(String name, String departmentName, LocalDate bDay, float salary,
                       LocalDate empDay, String description, int id){
        super(name, departmentName, bDay, salary, empDay, id);
        this.description = description;
    }

    public void printDescription(){
        System.out.println("This is " + description);
    }
}
