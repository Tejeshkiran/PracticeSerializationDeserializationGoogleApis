package DeserializePac;

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

public class Utility {
    static PrintStream stream;
    public static RequestSpecification getRequestSpec() throws FileNotFoundException {
        stream = new PrintStream(new FileOutputStream("logging2.txt"));
        RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addFilter(RequestLoggingFilter.logRequestTo(stream))
                .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                .build();
        return req;
    }
    public static ResponseSpecification getResponseSpec()
    {

        ResponseSpecification resq  =new ResponseSpecBuilder()
                .expectStatusCode(200).expectContentType(ContentType.JSON)
                .build();
        return resq;
    }
}
