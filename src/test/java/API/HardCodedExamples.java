package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
    /**
     * Rest Assured is DSL (Domain Specific Language)
     * Its a Java Library used to automate REST APIs
     * Rest Assured follows a behaviour driven development (BDD) approach
     * Given-Preparing a request
     * When- making the request / making the call / hitting the endpoint
     * Then- verifications / assertions
     * <p>
     * Principles of Rest Assured???
     * ---> Follows BDD approach
     * ----> Need to make some imports manually
     * ----> BaseURI is same as the BaseURL
     */
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjY2MTgyMjEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYyNjY2MTQyMSwidXNlcklkIjoiMjg0NyJ9.HbNteij580xc2ZxzFMiyQcuhV0F2VAdtryuBw42oIPo";
    static String employee_id;


    // @Test
    public void sampleTest() {
        // String baseURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json").queryParam("employee_id", "20333320");

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        System.out.println(response.asString());
    }

    @Test
    public void apostCreateEmployee() {

        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json")
                .body("{\n"
                        + "  \"emp_firstname\": \"Rammani\",\n"
                        + "  \"emp_lastname\": \"Xina\",\n"
                        + "  \"emp_middle_name\": \"Chaulagain\",\n"
                        + "  \"emp_gender\": \"F\",\n"
                        + "  \"emp_birthday\": \"1993-01-10\",\n"
                        + "  \"emp_status\": \"Employee\",\n"
                        + "  \"emp_job_title\": \"Automation Eng\"\n"
                        + "}");
        //.log().all();

        /*
         *
         * log().all() will log and print all information being sent with the request
         */

        Response response = preparedRequest.when().post("/createEmployee.php");

        /**
         * prettyPrint() does the same as System.out.println(response.asString());
         */
        response.prettyPrint();

        /**
         * jsonPath() allows us to retrieve specific data from a json object - just like an xpath with selenium
         */
        employee_id = response.jsonPath().getString("Employee.employee_id");

        System.out.println(employee_id);

        /**
         * Performing assertions
         */
        response.then().assertThat().statusCode(201);

        /**
         * Using Hamcrest Matchers class equalTo()
         */
        response.then().assertThat().body("Message", equalTo("Employee Created"));

        // Write an assertion that verifies that the response body has the name you used

        response.then().assertThat().body("Employee.emp_firstname", equalTo("Rammani"));

        /**
         * Verifying server
         */
        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
    }

    @Test
    public void bgetCreatedEmployee() {
        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json").queryParam("employee_id", employee_id);
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        String empID = response.jsonPath().getString("employee.employee_id");
        boolean comparingEmpIDs = empID.contentEquals(employee_id);
        Assert.assertTrue(comparingEmpIDs);


    }

   // @Test
    public void cgetAllEmployees() {
        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json");
        Response response = preparedRequest.when().get("/getAllEmployees.php");
        String responseFromAllEmp = response.prettyPrint();
        JsonPath js = new JsonPath(responseFromAllEmp);
        int count = js.get("Employees.size()");
        System.out.println(count);
        // print out all employee IDS from response
        for (int i = 0; i < count; i++) {
            String employeeIDs = js.getString("Employees[" + i + "].employee_id");

            //Verify stored employee ID from previous call is in response body
            if (employeeIDs.contentEquals(employee_id)) {
                //printing out the employee ID
                System.out.println("Employee ID " + employee_id + " is present in response body");
                String firstName = js.getString("Employees[" + i + "].emp_firstname");
                // Printing out the first name of the employee that we created
                System.out.println("Employee name is  " + firstName);
                break;
            }
        }
    }
@Test
    public void dPutUpdateCreateEmployee() {
        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json").body
                (" {\n" +
                        "                  \"employee_id\":"+ employee_id+"\n" +
                        "                \"emp_firstname\": \"Ram\",\n" +
                        "                \"emp_lastname\": \"ram\",\n" +
                        "                \"emp_middle_name\": \"NA\",\n" +
                        "                \"emp_gender\": \"M\",\n" +
                        "                \"emp_birthday\": \"2021-07-11\",\n" +
                        "                \"emp_status\": \"employee\",\n" +
                        "                \"emp_job_title\": \"QA\"\n" +
                        "}");

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();


    }
}