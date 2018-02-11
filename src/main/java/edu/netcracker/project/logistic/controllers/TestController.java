package edu.netcracker.project.logistic.controllers;



import edu.netcracker.project.logistic.dao.PersonCrudDao;
import edu.netcracker.project.logistic.model.Person;
import edu.netcracker.project.logistic.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Optional;


@Controller
public class TestController {

    @Autowired
    PersonService personService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/test")
    public String test(Model model) {
        Optional<Person> person = personService.findOne((long) 2);
        LocalDate localDate = LocalDate.now();
        personService.delete((long) 23);
        Person person1 = new Person((long)23,"kek", "kek"," nick_name", "1121212", localDate, "sdfffsfsdf","1232123123");
        Person person2 = new Person((long)23,"lol", "lol"," nick_name", "1121212", localDate, "sdfffsfsdf","1232123123");
        personService.savePerson(person1);
        personService.savePerson(person2);
        System.out.println( personService.exists((long) 23));
        System.out.println(person1);
        System.out.println(person2);
        return "test";
    }
}
