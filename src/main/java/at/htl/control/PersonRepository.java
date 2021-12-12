package at.htl.control;

import at.htl.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    List<Person> persons = new ArrayList<>();

    public void addPersons(){
        persons.add(new Person(1L,"Susi", new Person(2L, "Peter", new Person(3L,"Franzi", null))));
    }

    public void delete(Long id){
        Person prevPerson = null;
        Person nextPerson = null;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId().equals(id)){
                nextPerson = persons.get(i).getNextPerson();
            }

            if (persons.get(i).getNextPerson().getId().equals(id)){
                prevPerson = persons.get(i);
            }

            if (persons.get(i).getId().equals(id)){
                persons.remove(persons.get(i));
            }

        }

        if (nextPerson != null){
            if (prevPerson != null){
                prevPerson.setNextPerson(nextPerson);
            }
        }





    }
}
