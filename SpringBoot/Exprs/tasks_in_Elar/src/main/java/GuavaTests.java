import java.util.Objects;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;

import static com.google.common.base.MoreObjects.toStringHelper;

public class GuavaTests {

    public static void main(String[] args) {
        GuavaTests app = new GuavaTests();
        app.run();
    }

    void run() {
        System.out.println(objToToStr(new Person("Peter", 42, null)));

//        someMeth(-2.4);

        splittering(" foo, ,bar, quux,");
    }

    void someMeth(Double doubl) {
        Preconditions.checkArgument(doubl > 0);
    }

    Iterable<String> splittering(String str) {
        return Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split(str);
    }

    String objToToStr(Person person) {
                return toStringHelper(Person.class)
                        .add("name", person.name)
                        .add("age", person.age)
                        .add("petName", person.petName)
                        .omitNullValues()
                        .toString();
    }

    class Person {
        String name;
        Integer age;
        String petName;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Person(String name, Integer age, String petName) {
            this.name = name;
            this.age = age;
            this.petName = petName;
        }
    }

}
