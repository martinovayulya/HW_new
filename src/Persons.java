import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Persons {
    private List<Person> list = new ArrayList<>();

    public void add(Person person) {
        list.add(person);
    }

    public List<Person> getAll() {
        return Collections.unmodifiableList(list);
    }

    public Person findHighest() {
        Person highestPerson = null;
        for (Person person : list) {
            if (highestPerson == null || person.getHeight() > highestPerson.getHeight() ) {
                highestPerson = person;
            }
        }
        return highestPerson;
    }


    public Person findOldest() {
        Person oldestPerson = null;
        for (Person person : list) {
            if (oldestPerson == null || person.getAge() > oldestPerson.getAge()) {
                oldestPerson = person;
            }
        }
        return oldestPerson;
    }

    public Person findPersonWithLargestWeight() {
        Person personWithLargestWeight = null;
        for (Person person : list) {
            if (personWithLargestWeight == null || person.getWeight() > personWithLargestWeight.getWeight()) {
                personWithLargestWeight = person;
            }
        }
        return personWithLargestWeight;
    }

    public List <Person> getPersonsWithSimilarName(String name) {
        List<Person> peoples = new ArrayList<>();
        for (Person person : list) {
            if (person.getName().toLowerCase().contains(name.toLowerCase())) {
                peoples.add(person);
            }
        }
        return peoples;
    }
}
