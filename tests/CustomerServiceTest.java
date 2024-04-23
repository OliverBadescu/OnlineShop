import customers.model.Customer;
import customers.service.CustomerService;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomerServiceTest {

    CustomerService customerService;

    @Test

    public void AfisareSiGenerare(){

        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer = new Customer(1, "test@email", "pw13", "Test name", "adress", "address", "ro", 7222);
        customers.add(customer);
        customerService = new CustomerService(customers);

        customerService.afisare();
        int id = customerService.generateId();

    }

    @Test

    public void GivenAvailabeIdCheckIfGetsFound(){

        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer = new Customer(1, "test@email", "pw13", "Test name", "adress", "address", "ro", 7222);
        customers.add(customer);
        customerService = new CustomerService(customers);

        Customer customer1 = customerService.findCustomerById(1);
        Customer customer2 = customerService.findCustomerById(2);


        assertEquals("pw13", customer1.getPassword());
        assertEquals(null, customer2);


    }

    @Test

    public void GivenAvailableCustomerAccountCheckIfGetsDeleted(){

        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer1 = new Customer(2, "test@email1", "pw133", "Te3st name", "adress", "address", "ro", 7222);
        Customer customer = new Customer(1, "test@email", "pw13", "Test name", "adress", "address", "ro", 7222);
        customers.add(customer);
        customerService = new CustomerService(customers);


        customerService.stergeCont(customer);
        customerService.stergeCont(customer1);

        assertEquals(null, customerService.findCustomerById(1));
        assertEquals(2,  customer1.getId());
    }

    @Test

    public void GivenAvailableCustomerCheckIfGetsRegistred(){
        ArrayList<Customer> customers = new ArrayList<Customer>();

        Customer customer2 = new Customer(3, "test@email", "pw13", "Test name", "adress", "address", "ro", 7222);
        Customer customer1 = new Customer(2, "test@email1", "pw133", "Te3st name", "adress", "address", "ro", 7222);
        Customer customer = new Customer(1, "test@email", "pw13", "Test name", "adress", "address", "ro", 7222);
        customers.add(customer);
        customerService = new CustomerService(customers);


        customerService.inregistrare(customer1);
        customerService.inregistrare(customer2);

        assertEquals(customer1, customerService.findCustomerById(2));
        assertEquals(null, customerService.findCustomerById(3));

    }

    @Test

    public void GivenAvailableUserAndPasswordCheckIfGetsLogedIn(){
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer = new Customer(1, "test@email", "pw13", "Test name", "adress", "address", "ro", 7222);
        customers.add(customer);
        customerService = new CustomerService(customers);

        Customer login = customerService.login("test@email", "pw13");
        Customer login2 = customerService.login("test@email2", "pw133");

        assertEquals("pw13", login.getPassword());
        assertEquals(null, login2);


    }

    @Test

    public void GivenAvailableCustomerCheckIfGetsDeleted(){

        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer = new Customer(1, "test@email", "pw13", "Test name", "adress", "address", "ro", 7222);
        customers.add(customer);
        customerService = new CustomerService(customers);

        customerService.stergereClient(customer);

        assertEquals(null, customerService.findCustomerById(1));

    }

}
