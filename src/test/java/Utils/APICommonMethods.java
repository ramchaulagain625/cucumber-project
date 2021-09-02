package Utils;

import APIWorkflowSteps.GenerateTokenSteps;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class APICommonMethods {
   static RequestSpecification request;
    public static  RequestSpecification createEmployeeRequest(String createEmployeePaylod){
        request = given().header(apiConstants.Header_Content_type,apiConstants.Content_type)
                .header(apiConstants.Header_Authorization, GenerateTokenSteps.token).body(createEmployeePaylod);

    return request;

    }


}
