package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;

import spring.config.AppConfig;
import spring.config.PersonClient;
import spring.model.Person;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        PersonClient client = applicationContext.getBean(PersonClient.class);

        System.out.println("Getting list of all people:");

        for (Person p : client.getAllPerson()) {
            System.out.println(p);
        }

        System.out.println("\nGetting person with ID 2");

        Person personById = client.getById(2L);

        System.out.println(personById);

        System.out.println("Adding a Person");
        Person p = new Person();
        p.setAge(50);
        p.setFirstName("David");
        p.setLastName("Blain");
        HttpStatus status = client.addPerson(p);
        System.out.println("Add Person Response = " + status);

        applicationContext.close();
    }
}
