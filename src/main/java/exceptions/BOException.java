package exceptions;

import java.sql.SQLException;

/**
 * Created by ZafarT on 17/07/2018.
 */
public class BOException extends Exception {
    public BOException(SQLException e) {
        super(e);
    }
}
