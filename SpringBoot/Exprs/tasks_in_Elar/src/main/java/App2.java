import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class App2 {

    final Collection<Number> nums = new ArrayList<>();
    final Collection<Integer> ints = new ArrayList<>();
    final Collection<Double> flts = new ArrayList<>();

    public static void main(String[] args) {
        App2 app2 = new App2();
        app2.run();
    }

    void run() {
        var1();
        var5();

        System.out.println(new ArrayList<String>(Arrays.asList( "1", "3", "5")));
    }

    void var1() {
        System.out.println("It's var1");
        nums.add(3.14);
        System.out.println(nums);

    }
    /*void var2() {
        System.out.println("It's var2");
        ints.add(3.14);
        System.out.println(ints);
    }*/
    /*void var3() {
        System.out.println("It's var3");
        flts.add(42);
        System.out.println(nums);
    }*/

    /*void var4() {
        System.out.println("It's var4");
        printNumbers(flts);
    }*/
    void var5() {
        System.out.println("It's var5");
        printFloats(ints);
    }
    /*void var6() {
        System.out.println("It's var6");
        printInts(nums);
    }*/

    public static void printNumbers(Collection<Number> strs) {
        System.out.println(strs);
    }

    public static void printFloats(Collection<? extends Number> strs) {
        System.out.println(strs);
    }

    public static void printInts(Collection<Integer> strs) {
        System.out.println(strs);
    }



}
