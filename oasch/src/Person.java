public class Person {

    private Long id;

    private String name;

    private Person next;

    public Person() {
    }

    public Person(String name, Person person) {
        this.name = name;
        this.next = person;
    }

    public Person(Long id, String name, Person person) {
        this.id = id;
        this.name = name;
        this.next = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return getName();
    }
}
