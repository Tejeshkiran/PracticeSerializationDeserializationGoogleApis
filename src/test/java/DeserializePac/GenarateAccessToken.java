package DeserializePac;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;

import static io.restassured.RestAssured.given;

public class GenarateAccessToken extends Utility{

    public static String getAccessToken() throws FileNotFoundException {

        String TokenResponse =given().spec(getRequestSpec()).formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type","client_credentials")
                .formParam("grant_type","client_credentials")
                .formParam("scope","trust")
                .when().post("/oauthapi/oauth2/resourceOwner/token")
                .then().log().all().spec(getResponseSpec()).extract().response().asString();

        JsonPath js = new JsonPath(TokenResponse);
        return js.getString("access_token");
    }


}
