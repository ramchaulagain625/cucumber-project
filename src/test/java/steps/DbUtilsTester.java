package steps;

import Utils.DbUtils;

import java.util.List;
import java.util.Map;

public class DbUtilsTester {
    public static void main(String[] args) {
       List<Map<String,String>> dataTable;
        dataTable = DbUtils.getTableDataAsList("select emp_firstname,emp_middle_name,emp_lastname from hs_hr_employees where employee_id='17551';");
        System.out.print(dataTable);
    }
}
