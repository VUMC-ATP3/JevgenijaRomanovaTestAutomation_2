package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String []args) {
        System.out.println("This is maven projects");
        Employee employee = new Employee("Janis", "Programmetajs", 1000.32);
        System.out.println(employee.toString());
        Faker faker = new Faker();
        Employee employeeTwo = new Employee(faker.name().firstName(),faker.company().profession(),
                faker.number().randomDouble(2,100,2000));
        System.out.println(employeeTwo.toString());

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.company().profession());

        System.out.println(faker.country().countryCode3());

        Employee employeeThree = new Employee();
        System.out.println(employeeThree);


        //cikls
        for (int i = 0; i < 10; i++) {
            Employee employeeA = new Employee();
            System.out.println(employeeA.toString() + i);
        }









    }
}
