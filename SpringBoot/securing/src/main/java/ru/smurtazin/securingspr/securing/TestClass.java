package ru.smurtazin.securingspr.securing;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestClass {

    public static void main(String[] args) {
        String encrStr = new BCryptPasswordEncoder()
                .encode("mypass");
        System.out.println(encrStr);
    }

}
