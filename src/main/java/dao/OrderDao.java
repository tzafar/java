package dao;

import model.Order;

import java.sql.SQLException;

/**
 * Created by ZafarT on 17/07/2018.
 */
public interface OrderDao {
    int create(Order order) throws SQLException;
    Order read(int id) throws SQLException;
    int update(Order order) throws SQLException;
    int delete(int id) throws SQLException;
}
