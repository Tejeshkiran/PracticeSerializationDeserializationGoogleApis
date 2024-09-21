import PojoDeserialization.AddPlaceApiResponce;
import PojoDeserialization.GetPlaceApiResponse;
import PojoSerialization.DataClass;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;

public class ValidateGoogleAPis {

    public static void main(String[] args) throws FileNotFoundException {

            PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));
            RequestSpecification res = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(stream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                    .setContentType(ContentType.JSON)
                    .build();
            ResponseSpecification reqs = new ResponseSpecBuilder().expectStatusCode(200)
                    .expectContentType(ContentType.JSON).build();

                // Send the request and get the response
                AddPlaceApiResponce addPlaceResponse = given().spec(res)
                        .body(DataClass.getPojoSerializationObject())
                        .when().post("/maps/api/place/add/json")
                        .then().log().all().spec(reqs).extract().response().as(AddPlaceApiResponce.class);

                System.out.println("Place ID: " + addPlaceResponse.getPlace_id());

                GetPlaceApiResponse GetPlaceResponce = given().spec(res).queryParam("place_id", addPlaceResponse.getPlace_id())
                        .when().get("/maps/api/place/get/json")
                        .then().log().all().spec(reqs).extract().response().as(GetPlaceApiResponse.class);

                //System.out.println("Get Response: " + getResponse);
                System.out.println(GetPlaceResponce.getLocation().getLatitude());
                System.out.println(GetPlaceResponce.getLocation().getLongitude());

                // update data
                String updateResponse = given().spec(res).queryParam("place_id", addPlaceResponse.getPlace_id())
                .body(StringPayloadConversion.getPayload(addPlaceResponse.getPlace_id()))
                .when().put("/maps/api/place/update/json")
                .then().log().all().spec(reqs).extract().response().asString();

                System.out.println("Update Response: " +updateResponse);

                String deleteResponse=given().spec(res).body("{\n" +
                        "    \"place_id\":\""+addPlaceResponse.getPlace_id()+"\"\n" +
                        "}").when().delete("/maps/api/place/delete/json")
                        .then().log().all().spec(reqs).extract().response().asString();

                System.out.println(deleteResponse);




        }
    }
