package ru.smurtazin.ghostgroup.controllers;

import ru.smurtazin.ghostgroup.model.Department;
import ru.smurtazin.ghostgroup.model.Employee;
import ru.smurtazin.ghostgroup.model.Order;

import java.util.Calendar;
import java.util.Date;

public class MyUtils {

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static Order fakeOrder() {
        Order item = new Order();
        item.setName("Order N Uno");
        item.setOrderDate(new Date());
        item.setTermEnd(MyUtils.addDays(new Date(), 2));
        return item;
    }

    public static Employee fakeEmployee() {
        Employee item = new Employee();
        item.setFullName("Full Empl Name1");
//        item.setDepartment(2);
//        item.setOrders(3);
        return item;
    }

    public static Department fakeDepartment() {
        Department item = new Department();
        item.setType("New Depart Type 1");
//        item.setOrders(3);
        return item;
    }
}
