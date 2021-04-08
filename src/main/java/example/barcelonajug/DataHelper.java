package example.barcelonajug;

import java.util.List;

public class DataHelper {

    public static List<User> makeUserList() {
        return List.of(
                new User("Sheldon", "Cooper"),
                new User("Leonard", "Hofstadter"),
                new User("Raj", "Koothrappali"),
                new User("Howard", "Wolowitz")
        );
    }

    public static Person makePerson() {
        return new Person("Iván", 41,
                List.of(
                        new Person("Judith", 13),
                        new Person("Adriana", 10)
                )
        );
    }
}
