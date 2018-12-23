package net.xgs.multsort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: TianW
 * @Date: 2018/12/23 18:12
 * @Description:
 */
public class Employee {
    private Integer id;
    private Integer level;
    private Integer salary;
    private Integer year;
    public Employee(){}

    public Employee(Integer id, Integer level, Integer salary, Integer year) {
        this.id = id;
        this.level = level;
        this.salary = salary;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getYear() {
        return year;
    }



    /**
     *
     * @param a
     * @param b
     * @param desc 是否降序
     * @return
     */
    public static int compactor(Integer a,Integer b,boolean desc){
        if(desc){
            return -compactorInteger(a,b);
        }else {
            return compactorInteger(a,b);
        }
    }

    private static int compactorInteger(Integer a, Integer b) {
        if(a>b)
            return 1;
        if(a<b)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", level=" + level +
                ", year=" + year +
                ", salary=" + salary +
                '}';
    }
    public void sortEmployeeList(List<Employee> finalList){
        Collections.sort(finalList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.level-o2.level;
            }
        });
    }
    public static void sortEmployeeList1(List<Employee> finalList){
        Collections.sort(finalList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.level==o2.level){
                    if (o1.year == o2.year) {
                        return -(o1.salary - o2.salary);
                    }else {
                        return -(o1.year - o2.year);
                    }
                }else {
                    return -(o1.level - o2.level);
                }
            }
        });
    }
}
