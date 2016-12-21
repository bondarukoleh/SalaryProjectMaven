import essences.Company;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompanyTest {

    Company company = new Company("Test essences.Company");

    @Test
    public void testCompanyName(){
        try {
            Assert.assertEquals("Test essences.Company", company.getName());
            System.out.println("We got company name");
        } catch (Exception e) {
            System.out.println("Trouble with company name " +e);
        }
    }


}
