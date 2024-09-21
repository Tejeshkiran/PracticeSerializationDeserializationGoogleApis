package DeserializePac;

import PojoDeserialization.coursePojo.GetCourseDetails;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class DeSerializeTest {

    public static void main(String[] args) throws FileNotFoundException {

        GetCourseDetails gcd = given().spec(Utility.getRequestSpec()).queryParam("access_token",GenarateAccessToken.getAccessToken())
                .when().get("/oauthapi/getCourseDetails")
                .then().log().all().statusCode(401).extract().response().as(GetCourseDetails.class);
        //System.out.println(response);
        for(int i = 0; i<gcd.getCourses().getWebAutomation().size();i++)
        {
            String courseTitle =gcd.getCourses().getWebAutomation().get(i).getCourseTitle();
            System.out.println(courseTitle);
        }
        int j = 0;
        while (j<gcd.getCourses().getApi().size())
        {
            System.out.println(gcd.getCourses().getApi().get(j).getCourseTitle());
            j++;
        }
        System.out.println(gcd.getCourses().getMobile().get(0).getPrice());
    }

}
