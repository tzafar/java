package bo;

import exceptions.BOException;
import model.Order;

/**
 * Created by ZafarT on 17/07/2018.
 */
public interface OrderBO {
    boolean placeOrder(Order order) throws BOException;
    boolean cancelOrder(int id) throws BOException;
    boolean deleteOrder(int id) throws BOException;
}
