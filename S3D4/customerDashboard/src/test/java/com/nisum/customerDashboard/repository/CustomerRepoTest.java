//package com.nisum.customerDashboard.repository;
//
//import com.nisum.customerDashboard.entity.Customer;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//public class CustomerRepoTest {
//
//    @Autowired
//    private com.nisum.customerDashboard.repository.CustomerRepo repository;
//
//    @Test
//    void testFindByEmailContaining() {
//        Customer c = new Customer();
//        c.setName("John");
//        c.setEmail("john@example.com");
//        c.setRegisteredDate(LocalDate.now());
//        repository.save(c);
//
//        List<Customer> results = repository.findByEmailContaining("john");
//        assertThat(results).isNotEmpty();
//    }
//
//    @Test
//    void testFindByRegisteredDateAfter() {
//        Customer c = new Customer();
//        c.setName("Jane");
//        c.setEmail("jane@example.com");
//        c.setRegisteredDate(LocalDate.now().minusDays(1));
//        repository.save(c);
//
//        List<Customer> results = repository.findByRegisteredDateAfter(LocalDate.now().minusDays(2));
//        assertThat(results).contains(c);
//    }
//
//    @Test
//    void testFindByName() {
//        Customer c = new Customer();
//        c.setName("Alice");
//        c.setEmail("alice@example.com");
//        c.setRegisteredDate(LocalDate.now());
//        repository.save(c);
//
//        List<Customer> results = repository.findByName("Alice");
//        assertThat(results).contains(c);
//    }
//}
