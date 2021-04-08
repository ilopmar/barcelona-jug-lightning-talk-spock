package example.barcelonajug;

import java.util.Collections;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private List<Person> childs = Collections.emptyList();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, List<Person> childs) {
        this.name = name;
        this.age = age;
        this.childs = childs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Person> getChilds() {
        return childs;
    }

    public void setChilds(List<Person> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", childs=" + childs +
                '}';
    }
}
