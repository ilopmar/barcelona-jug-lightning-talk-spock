package example.barcelonajug

import spock.lang.Specification

class AmazingSpockSpec extends Specification {


/*



















    _                        _               ____                   _
   / \   _ __ ___   __ _ ___(_)_ __   __ _  / ___| _ __   ___   ___| | __
  / _ \ | '_ ` _ \ / _` |_  / | '_ \ / _` | \___ \| '_ \ / _ \ / __| |/ /
 / ___ \| | | | | | (_| |/ /| | | | | (_| |  ___) | |_) | (_) | (__|   <
/_/   \_\_| |_| |_|\__,_/___|_|_| |_|\__, | |____/| .__/ \___/ \___|_|\_\
                                     |___/        |_|

                                               Barcelona-JUG 8 Abril 2021

Iván López (@ilopmar)




























 */


    void 'should reverse a string'() {
        given: 'a string'
        String myString = 'Hello World!'

        when: 'reversing it'
        String reversed = new StringBuilder(myString).reverse().toString()
        // String reversed = myString.reverse() // Using Groovy!

        then: 'it is reversed'
        reversed == '!dlroW olleH'
    }


    void 'should reverse a string (II)'() {
        expect:
        'Hello World!'.reverse() == '!dlroW olleH'
    }


    void 'should make some assertions in elements in a list'() {
        when: 'getting a list of users'
        List<User> users = DataHelper.makeUserList()

        then: 'we check some conditions'
        users.size() == 4
        users.name == ['Sheldon', 'Leonard', 'Raj', 'Howard']
        users.name.sort() == ['Howard', 'Leonard', 'Raj', 'Sheldon']
        users.lastName.collect { it.size() } == [6, 10, 12, 8]
        users.name.min { it.length() } == 'Raj'

//        println users.name
//        println users.stream().map({ User u -> u.getName() }).collect(Collectors.toList())
    }


    void 'show how amazing power asserts are'() {
        when:
        Person person = DataHelper.makePerson()

        then:
        person.childs.first().name == 'Adriana'
    }


    void 'should check that minimum of #x and #y is #result'() {
        expect:
        Math.min(x, y) == result

        where:
        x  | y  | result
        1  | 2  | 1
        -1 | -2 | -2
        0  | 1  | 0
    }


    void 'should send a notification to new registered users'() {
        given:
        def mockedNotificationService = Mock(NotificationService)
        UserService userService = new UserService(mockedNotificationService)

        when:
        userService.createUser('Iván', 'López')

        then:
        1 * mockedNotificationService.sendNotification(_, 'User created')
//        1 * mockedNotificationService.sendNotification({ it.name == 'Iván' }, 'User created')
    }


    void 'should return different values in every call'() {
        given:
        def stubbedRepository = Stub(UserRepository) {
            findById(_) >>> [
                new User('John', 'Doe'),
                new User('Jane', 'Doe')
            ]
        }

        when:
        def user1 = stubbedRepository.findById(1)
        def user2 = stubbedRepository.findById(1)
        def user3 = stubbedRepository.findById(1)

        then:
        user1.name == 'John'
        user2.name == 'Jane'
        user3.name == 'Jane'
    }


    void 'should increase the size of the list when adding a number (I)'() {
        given:
        List<Integer> fibonacci = [1, 1, 2, 3, 5, 8, 13]
        int oldListSize = fibonacci.size()

        when:
        fibonacci << 21 // or fibonacci.add(21)

        then:
        fibonacci.size() == oldListSize + 1
    }


/*

  ____                _             _
 / ___|_ __ __ _  ___(_) __ _ ___  | |
| |  _| '__/ _` |/ __| |/ _` / __| | |
| |_| | | | (_| | (__| | (_| \__ \ |_|
 \____|_|  \__,_|\___|_|\__,_|___/ (_)


https://spockframework.org/
https://spockframework.org/spock/docs/2.0-M5/index.html
https://blog.jetbrains.com/tag/tutorial-spock/



Iván López (@ilopmar)

 */


}
