import order_details.model.OrderDetails;
import order_details.service.OrderDetailsService;
import orders.model.Order;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OrderDetailsServiceTests {

    OrderDetailsService orderDetailsService;

    @Test

    public void GivenAvailableDataCheckIfGetsLoaded(){

        OrderDetailsService orderDetailsService1 = new OrderDetailsService();

        OrderDetails orderDetails = orderDetailsService1.findOrderDetailsById(1);

        assertEquals(1, orderDetails.getId());
    }

    @Test

    public void AfisareSiGenerare(){

        ArrayList<OrderDetails> orderDetailsList = new ArrayList<>();
        OrderDetails orderDetails = new OrderDetails(1,1,1,999.99,2);
        orderDetailsService = new OrderDetailsService(orderDetailsList);

        orderDetailsService.afisare();
        int id = orderDetailsService.generateId();


    }

    @Test

    public void GivenAvailableIdCheckIfGetsFound(){

        ArrayList<OrderDetails> orderDetailsList = new ArrayList<>();
        OrderDetails orderDetails = new OrderDetails(1,1,1,999.99,2);
        orderDetailsList.add(orderDetails);
        orderDetailsService = new OrderDetailsService(orderDetailsList);

        OrderDetails orderDetails1 = orderDetailsService.findOrderDetailsById(1);
        OrderDetails orderDetails2 = orderDetailsService.findOrderDetailsById(2);

        assertEquals(1, orderDetails1.getId());
        assertEquals(null, orderDetails2);

    }

    @Test

    public void GivenAvailableOrderDetialsCheckIfGetsAdded(){

        ArrayList<OrderDetails> orderDetailsList = new ArrayList<>();
        OrderDetails orderDetails = new OrderDetails(1,1,1,999.99,2);
        orderDetailsService = new OrderDetailsService(orderDetailsList);

        orderDetailsService.add(orderDetails);

        assertEquals(1, orderDetails.getId());

    }

    @Test

    public void GivenAvailableOrderListCheckIfOrderDetailsListGetsReturned(){

        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order(1,1,150);
        orders.add(order);
        ArrayList<OrderDetails> orderDetailsList;
        orderDetailsService = new OrderDetailsService();


        orderDetailsList = orderDetailsService.order(orders);

        assertEquals(2, orderDetailsList.get(0).getQuantity());


    }


    @Test
    public void CelMaiVandutProdus(){

        ArrayList<OrderDetails> orderDetailsList = new ArrayList<>();
        OrderDetails orderDetails = new OrderDetails(1,1,1,999.99,2);
        orderDetailsList.add(orderDetails);
        orderDetailsService = new OrderDetailsService(orderDetailsList);

        int id =orderDetailsService.celMaiVandutProdus();

        assertEquals(1, id);

    }

    @Test

    public void getOrderDetails(){

        ArrayList<OrderDetails> orderDetailsList = new ArrayList<>();
        OrderDetails orderDetails = new OrderDetails(1,1,1,999.99,2);
        orderDetailsList.add(orderDetails);
        orderDetailsService = new OrderDetailsService(orderDetailsList);

        ArrayList<OrderDetails> orderDetails1 = orderDetailsService.getOrderDetails();

        assertEquals(1, orderDetails1.get(0).getId());

    }
}
