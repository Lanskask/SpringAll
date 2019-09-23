package ru.smurtazin.justsomeexperiments.pakTest.statictests;

public class Static1 {

    public static void main(String[] args) {
        new Object() {
            void run() {
                final int[] array = {1,2,3,4,5};
                for (int i = 0; i < array.length; i++) {
                    array[i] = array[i]*2;
                }
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                }
            }
        }.run();
    }

}
