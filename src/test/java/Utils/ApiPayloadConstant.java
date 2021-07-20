package Utils;

public class ApiPayloadConstant {
    public static String createEmployeePayload(){
         String createEmployeePayload="{\n" +
                 "  \"emp_firstname\": \"Ram\",\n" +
                 "  \"emp_lastname\": \"ram\",\n" +
                 "  \"emp_middle_name\": \"ram\",\n" +
                 "  \"emp_gender\": \"M\",\n" +
                 "  \"emp_birthday\": \"2093-07-10\",\n" +
                 "  \"emp_status\": \"Full Time\",\n" +
                 "  \"emp_job_title\": \"Automation Tester\"\n" +
                 "}";
        return createEmployeePayload;
    }
}
