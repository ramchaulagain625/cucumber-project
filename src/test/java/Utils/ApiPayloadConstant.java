package Utils;

import org.json.JSONObject;

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

    /**
     * We imported a dependency for JSONObject
     * @return
     */
    public static String createEmployeeBody(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Rammani");
        obj.put("emp_middle_name","xina");
        obj.put("emp_lastname","Chaulagain");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2093-07-10");
        obj.put("emp_status","Full Time");
        obj.put("emp_job_title","Automation Tester");
        return obj.toString();
    }

    public static String createEmployeeDynamic(String firstName,String lastName,String middleName,String gender,String bDay,String status,String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname",firstName);
        obj.put("emp_middle_name",middleName);
        obj.put("emp_lastname",lastName);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday",bDay);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();
    }

}
