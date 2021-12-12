package at.htl.entity;

import javax.persistence.*;

@Entity
@Table(name = "D_PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    private Long id;

    @Column(name = "P_NAME")
    private String name;

    @OneToOne
    @Column(name = "P_NEXT")
    private Person nextPerson;

    public Person() {
    }

    public Person(Long id, String name, Person nextPerson) {
        this.id = id;
        this.name = name;
        this.nextPerson = nextPerson;
    }

    public Person(String name, Person nextPerson) {
        this.name = name;
        this.nextPerson = nextPerson;
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

    public Person getNextPerson() {
        return nextPerson;
    }

    public void setNextPerson(Person person) {
        this.nextPerson = person;
    }

    @Override
    public String toString() {
        return String.format("%d: %s -> %s", id, name, nextPerson.name);
    }
}

