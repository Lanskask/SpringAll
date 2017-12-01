package ru.smurtazin.spring.exp1;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserStorageTest {
    MemoryStorage memoryStorage;

    @Before
    public void setUp() throws Exception {
        this.memoryStorage = new MemoryStorage();
    }

    @Test
    public void add() throws Exception {
        ru.smurtazin.spring.exp1.UserStorage userStorage = new ru.smurtazin.spring.exp1.UserStorage(this.memoryStorage);
        userStorage.add(new ru.smurtazin.spring.exp1.User());
    }

    @Test
    public void testContextLoading() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memoryStorage = context.getBean(MemoryStorage.class);
        assertNotNull(memoryStorage);
    }

    @Test
    public void testContextLoadingUserStorage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        storage.add(new User());
        assertNotNull(storage);
    }

}