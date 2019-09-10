package com.Learning.comparator.thenComparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ThenComparing2 {

    public static void main(String... args) {
        System.out.println("-- with thenComparing --");
       List <Employee> employee = createEmployee();
        System.out.printf("before sort: %s%n", employee);

        Comparator <Employee>  compareByName = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);

        Collections.sort(employee,compareByName);

        //Combining comparator and sorting togather
        //Collections.sort(employee , Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName));
        System.out.printf("after sort: %s%n", employee);
    }


    private static List<Employee> createEmployee(){
        return Arrays.asList(
                new Employee("bob","miller"),
                new Employee("bob","abc"),
                new Employee("john","miller"),
                new Employee("john","test"),
                new Employee("test","test1"),
                new Employee("test1","test")
        );

    };


    private static class Employee {
        private String firstName;
        private String lastName;

        public Employee(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return firstName + " - " + lastName;
        }
    }
}
