import files.payload;
import io.restassured.path.json.JsonPath;

import java.sql.SQLOutput;

public class ComplexJsonParse {
    public static void main(String[] args) {
        JsonPath js = new JsonPath(payload.CoursePrice());

        //1. Print No of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println(count);

        //2.Print Purchase Amount (Child element)
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        //3. Print Title of the first course (when we have array)
        String tittleFirstCourse = js.get("courses[2].title");
        System.out.println(tittleFirstCourse);

        //4. Print All course titles and their respective Prices

        for(int i =0;i<count; i++){
        String courseTitles= js.get("courses["+i+"].title");
        js.get("courses["+i+"].price");
            System.out.println(courseTitles);
            System.out.println(js.get("courses["+i+"].price").toString());

        }
        // 5. Print no of copies sold by RPA Course
        for (int i=0; i<count; i++) {
          String tittle=  js.get("courses["+i+"].title");
            if (tittle.equalsIgnoreCase("RPA"))
            {
                int copies= js.get("courses["+1+"].copies");
                System.out.println("copies for rpa "+ copies);
break;
            }
        }

    }
}
