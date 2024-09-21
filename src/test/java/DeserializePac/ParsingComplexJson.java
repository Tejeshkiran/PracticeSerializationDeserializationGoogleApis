package DeserializePac;

import PojoDeserialization.coursePojo.GetCourseDetails;
import io.restassured.path.json.JsonPath;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class ParsingComplexJson {

    public static void main(String[] args) throws FileNotFoundException {
       String Response = given().spec(Utility.getRequestSpec()).queryParam("access_token",GenarateAccessToken.getAccessToken())
                .when().get("/oauthapi/getCourseDetails")
                .then().log().all().statusCode(401).extract().response().asString();
        System.out.println(Response);
        JsonPath js = new JsonPath(Response);
        System.out.println(js.getString("instructor"));
        int numofCourses =js.getInt("courses.size()");
        System.out.println(numofCourses);
        String WebAutomation1stcourseTitle=js.getString("courses.webAutomation[0].courseTitle");
        System.out.println(WebAutomation1stcourseTitle);
        System.out.println(js.getString("courses.mobile.courseTitle"));
        System.out.println(js.getString("courses.webAutomation.courseTitle"));
        int webaAutomationSize = js.getInt("courses.webAutomation.size()");
        System.out.println(webaAutomationSize);

        int i = 0;
        int count = 0;

        while (i<webaAutomationSize)
        {
           int price = js.getInt("courses.webAutomation["+i+"].price");
           count= count+price;
           i++;
        }
        System.out.println("total price of courses are : "+count);
        System.out.println(js.getString("courses.webAutomation"));
        System.out.println(js.getString("courses"));

    }
}
