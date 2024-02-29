package com.betrybe.agrix.solution;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DisplayName("PersonServiceTest")
@ActiveProfiles("test")
public class PersonServiceTest {
  @Autowired
  private PersonService personService;

  @Test
  public void testGetPersonById() {
    Person person = new Person();
    person.setUsername("nathan");
    person.setPassword("123456");
    person.setRole(Role.USER);

    Long createdId = personService.create(person).getId();
    Person foundPerson = personService.getPersonById(createdId);

    assertEquals(foundPerson.getId(), createdId);
    assertEquals(foundPerson.getUsername(), person.getUsername());
    assertEquals(foundPerson.getPassword(), person.getPassword());
    assertEquals(foundPerson.getRole(), person.getRole());
  }

  @Test
  public void testPersonByIdNotFound() {
    assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(999L));
  }

  @Test
  public void testGetPersonByUsername() {
    Person person = new Person();
    person.setUsername("neita");
    person.setPassword("123456");
    person.setRole(Role.USER);

    String createdUsername = personService.create(person).getUsername();
    Person foundPerson = personService.getPersonByUsername(createdUsername);

    assertEquals(foundPerson.getUsername(), createdUsername);
    assertEquals(foundPerson.getPassword(), person.getPassword());
    assertEquals(foundPerson.getRole(), person.getRole());
  }

  @Test
  public void testPersonByUsernameNotFound() {
    assertThrows(PersonNotFoundException.class, () -> personService.getPersonByUsername("Not Found"));
  }

  @Test
  public void testPersonCreation() {
    Person person = new Person();
    person.setUsername("luiz");
    person.setPassword("123456");
    person.setRole(Role.ADMIN);

    Person createdPerson = personService.create(person);

    assertNotNull(createdPerson.getId());
    assertEquals(createdPerson.getUsername(), person.getUsername());
    assertEquals(createdPerson.getPassword(), person.getPassword());
    assertEquals(createdPerson.getRole(), person.getRole());
  }
}