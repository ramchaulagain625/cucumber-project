package Utils;

public class ApiPayloadConstant {
    public static String createEmployeePayload(){
         String createEmployeePayload="{\n" +
                 "  \"emp_firstname\": \"Rammani\",\n" +
                 "  \"emp_lastname\": \"xina\",\n" +
                 "  \"emp_middle_name\": \"Chaulagain\",\n" +
                 "  \"emp_gender\": \"M\",\n" +
                 "  \"emp_birthday\": \"2093-07-10\",\n" +
                 "  \"emp_status\": \"Full Time\",\n" +
                 "  \"emp_job_title\": \"Automation Tester\"\n" +
                 "}";
        return createEmployeePayload;
    }
}
