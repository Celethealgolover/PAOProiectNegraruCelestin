package dao;

import model.Pacient;
import daoServices.DatabaseConnection;

import java.sql.*;

public class PacientDao implements DaoInterface<Pacient> {
    private static PacientDao pacientDao;
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    private PacientDao() throws SQLException {}

    public static PacientDao getInstance() throws SQLException {
        if (pacientDao == null) {
            pacientDao = new PacientDao();
        }
        return pacientDao;
    }

    public void create(Pacient pacient) throws SQLException {
        String sql = "INSERT INTO demo.PACIENTI (nume, prenume, cnp) VALUES (?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pacient.getNume());
            statement.setString(2, pacient.getPrenume());
            statement.setLong(3, pacient.getCnp());
            statement.executeUpdate();
        }
    }

    public Pacient read(String nume) throws SQLException {
        String sql = "SELECT * FROM demo.PACIENTI WHERE nume = ?";
        ResultSet rs = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nume);
            rs = statement.executeQuery();

            if (rs.next()) {
                Pacient pacient = new Pacient(
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getLong("cnp")
                );
                return pacient;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

    public void update(Pacient pacient) throws SQLException {
        String sql = "UPDATE demo.PACIENTI SET prenume = ?, cnp = ? WHERE nume = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pacient.getPrenume());
            statement.setLong(2, pacient.getCnp());
            statement.setString(3, pacient.getNume());
            statement.executeUpdate();
        }
    }

    public void delete(Pacient pacient) throws SQLException {
        String sql = "DELETE FROM demo.PACIENTI WHERE nume = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pacient.getNume());
            statement.executeUpdate();
        }
    }
}
