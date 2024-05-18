package dao;
import java.sql.*;
public interface DaoInterface<T> {
       public void create(T ob) throws SQLException;
       public T read(String nume) throws SQLException;
       public void update(T ob) throws SQLException;
       public void delete(T ob) throws SQLException;
}
