package bo;

import dao.OrderDao;
import exceptions.BOException;
import model.Order;

import java.sql.SQLException;

/**
 * Created by ZafarT on 17/07/2018.
 */
public class OrderBoImpl implements OrderBO {

    OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    @Override
    public boolean placeOrder(Order order) throws BOException {
        try {
           int result = orderDao.create(order);
            if(result == 0) return false;
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }

    @Override
    public boolean cancelOrder(int id) throws BOException {
        try {
            Order order = orderDao.read(id);
            order.setStatus("cancelled");
            int result = orderDao.update(order);
            if(result == 0)return false;
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }

    @Override
    public boolean deleteOrder(int id) throws BOException {
        try {
            int result = orderDao.delete(id);
            if(result == 0)return false;
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }
}
