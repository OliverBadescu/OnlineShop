import orders.model.Order;
import orders.service.OrderService;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class OrderServiceTests {

    OrderService orderService;

    @Test

    public void GivenAvailableDataCheckIfGetsLoaded(){

        OrderService orderService1 = new OrderService();

        Order order = orderService1.findOrderById(1);

        assertEquals(1, order.getId());

    }

    @Test

    public void AfisareSiGenerare(){

        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order(1,1,999.99);
        orders.add(order);
        orderService = new OrderService(orders);

        orderService.afisare();
        int id = orderService.generateId();


    }

    @Test

    public void GivenAvailableIdCheckIfGetsFound(){

        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order(1,1,999.99);
        orders.add(order);
        orderService = new OrderService(orders);

        Order order1 = orderService.findOrderById(1);
        Order order2 = orderService.findOrderById(2);

        assertEquals(1, order1.getId());
        assertNull(order2);

    }

    @Test

    public void GivenAvailableOrderCheckIfGetsAdded(){

        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order(1,1,999.99);
        orderService = new OrderService(orders);

        orderService.add(order);

        assertEquals(1, order.getId());

    }

    @Test

    public void GivenAvailableCustomerIdCheckIfOrdersGetFound(){
        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order(1,1,999.99);
        Order order1 = new Order(2,1,999.99);
        orders.add(order);
        orders.add(order1);
        orderService = new OrderService(orders);

        ArrayList<Order> orders1 = orderService.findOrdersByCustomerId(1);

        assertEquals(1, orders1.get(0).getId());

    }

    @Test

    public void GivenAvailableOrderCheckIfGetsDeleted(){

        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order(1,1,999.99);
        orders.add(order);
        orderService = new OrderService(orders);

        orderService.stergeComanda(order);

        assertNull(orderService.findOrderById(1));

    }

    @Test

    public void ClientCuCeleMaiMulteComenzi(){

        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order(1,1,999.99);
        orders.add(order);
        orderService = new OrderService(orders);

        int id = orderService.clientCuCeleMaiMulteComenzi();

        assertEquals(1, id);


    }

}
