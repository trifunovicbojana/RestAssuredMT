import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {
    @Test
    //6. Verify if Sum of all Course prices matches with Purchase Amount
    public void sumOfCourses(){
        JsonPath js1=new JsonPath(payload.CoursePrice());
        int count= js1.getInt("courses.size");
        int sum=0;
        for (int i=0;i<count;i++) {
            int price = js1.getInt("courses["+i+"].price");
            int copies = js1.getInt("courses["+i+"].copies");
            int ammount=copies*price;
            sum=sum+ammount;
        }
        System.out.println(sum);
        int purchaseAmount= js1.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum, purchaseAmount);
    }
}
