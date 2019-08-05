package dao;

import model.Order;

import java.sql.SQLException;

/**
 * Created by ZafarT on 17/07/2018.
 */
public class OrderDaoImpl implements OrderDao {
    public int create(Order order){
        return 0;
    }

    @Override
    public Order read(int id) throws SQLException {
        return null;
    }

    @Override
    public int update(Order order) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }
}
