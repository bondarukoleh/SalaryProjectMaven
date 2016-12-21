package utilities;

import org.joda.time.LocalDate;

import java.util.Random;

public class DatesGenerator {

    private static Random random = new Random();;

    public static LocalDate getBday(){
        int year = random.nextInt(2010 - 1900) + 1900;
        int month = random.nextInt(12 - 1) + 1;
        int day = random.nextInt(28 - 1) + 1;
        return new LocalDate(year,month,day);
    }

    public static LocalDate getEmploymentDate(){
        int year = random.nextInt(2000 - 1980) + 1900;
        int month = random.nextInt(12 - 1) + 1;
        int day = random.nextInt(28 - 1) + 1;
        return new LocalDate(year,month,day);
    }

}
