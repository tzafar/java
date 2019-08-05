package bao;

import bo.OrderBO;
import bo.OrderBoImpl;
import dao.OrderDao;
import exceptions.BOException;
import model.Order;
import org.junit.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

/**
 * Created by ZafarT on 17/07/2018.
 */
public class OrderBaoImplTest {
    @Mock
    OrderDao dao;

    OrderBoImpl bo;
    Order order;

    @Before
    public void before() {
        System.out.println("Before called");
        MockitoAnnotations.initMocks(this);
        bo = new OrderBoImpl();
        bo.setOrderDao(dao);
        order = new Order();
    }

    @Test
    public void placeOrderShouldPlaceAnOrder() throws SQLException, BOException {


        when(dao.create(order)).thenReturn(new Integer(1));
        boolean result = bo.placeOrder(order);
        Assert.assertTrue(result);
        verify(dao).create(order);
    }

    @Test
    public void placeOrderShouldReturnValidErrorZero() throws SQLException, BOException {
        when(dao.create(order)).thenReturn(new Integer(0));
        boolean result = bo.placeOrder(order);
        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);

        Assert.assertFalse(result);
        verify(dao).create(order);

    }

    @Test(expected = BOException.class)
    public void placeOrderShouldThrowBOException() throws SQLException, BOException {
        when(dao.create(order)).thenThrow(SQLException.class);
        boolean result = bo.placeOrder(order);
    }

    @Test
    public void orderCancelShouldCancelTheOrder() throws SQLException, BOException {
        Order order = new Order();
        when(dao.read(123)).thenReturn(order);
        when(dao.update(order)).thenReturn(1);
        boolean result = bo.cancelOrder(123);
        Assert.assertTrue(result);
        verify(dao).read(123);
        verify(dao).update(order);
    }

    @Test
    public void orderCancelShouldNotCancelOrder() throws SQLException, BOException {
        Order order = new Order();
        when(dao.read(123)).thenReturn(order);
        when(dao.update(order)).thenReturn(0);
        boolean result = bo.cancelOrder(123);
        Assert.assertFalse(result);
        verify(dao).read(123);
        verify(dao).update(order);
    }

    @Test(expected = BOException.class)
    public void orderCancelShouldThrowBOExceptionOnDaoRead() throws SQLException, BOException {
        when(dao.read(123)).thenThrow(SQLException.class);
        bo.cancelOrder(123);
    }

    @Test(expected = BOException.class)
    public void orderCancelShouldThrowBOExceptionOnUpdate() throws SQLException, BOException {
        Order order = new Order();
        when(dao.read(123)).thenReturn(order);
        when(dao.update(order)).thenThrow(SQLException.class);
        boolean result = bo.cancelOrder(123);
    }

    @After
    public void after(){
        System.out.println("Called After");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Called before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Called after class");
    }


}
