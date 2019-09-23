package ru.smurtazin.TryJdbcConnect.model;


import ru.smurtazin.TryJdbcConnect.pojos.Customer;

import java.util.List;

public interface CustomerDao {
    void insert(Customer cus);
    void inserBatch(List<Customer> customers);
    List<Customer> loadAllCustomer();
    Customer findCustomerById(long cust_id);
    String findNameById(long cust_id);
    int getTotalNumberCustomer();
}