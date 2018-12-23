package net.xgs.multsort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * @Auther: TianW
 * @Date: 2018/12/23 18:19
 * @Description:
 */
public class EmployeeSort {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(5,3,5000,2));
        employeeList.add(new Employee(1,9,12000,10));
        employeeList.add(new Employee(4,5,8000,6));
        employeeList.add(new Employee(2,9,12000,17));
        employeeList.add(new Employee(6,3,5000,4));
        employeeList.add(new Employee(3,5,8000,12));
//        Employee.sortEmployeeList1(employeeList);
        employeeList.sort(Comparator.comparing(Employee::getLevel,(f,s)->Employee.compactor(f,s,true))
                .thenComparing(Employee::getYear,(f,s)->Employee.compactor(f,s,true))
                .thenComparing(Employee::getSalary,(f,s)->Employee.compactor(f,s,true)));
        employeeList.forEach(System.out::println);
//        employeeList.forEach(str-> System.out.println(str));
    }
}
