package dao;

import model.Asistent;
import daoServices.DatabaseConnection;

import java.sql.*;

public class AsistentDao implements DaoInterface<Asistent> {
    private static AsistentDao asistentDao;
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    private AsistentDao() throws SQLException {}

    public static AsistentDao getInstance() throws SQLException {
        if (asistentDao == null) {
            asistentDao = new AsistentDao();
        }
        return asistentDao;
    }

    public void create(Asistent asistent) throws SQLException {
        String sql = "INSERT INTO demo.ASISTENTI (salariu, nume, prenume, email, nr_telefon) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, asistent.getSalariu());
            statement.setString(2, asistent.getNume());
            statement.setString(3, asistent.getPrenume());
            statement.setString(4, asistent.getEmail());
            statement.setInt(5, asistent.getNr_telefon());
            statement.executeUpdate();
        }
    }

    public Asistent read(String nume) throws SQLException {
        String sql = "SELECT * FROM demo.ASISTENTI WHERE nume = ?";
        ResultSet rs = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nume);
            rs = statement.executeQuery();

            if (rs.next()) {
                Asistent asistent = new Asistent(
                        rs.getInt("salariu"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("email"),
                        rs.getInt("nr_telefon")
                );
                return asistent;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

    public void update(Asistent asistent) throws SQLException {
        String sql = "UPDATE demo.ASISTENTI SET salariu = ?, prenume = ?, email = ?, nr_telefon = ? WHERE nume = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, asistent.getSalariu());
            statement.setString(2, asistent.getPrenume());
            statement.setString(3, asistent.getEmail());
            statement.setInt(4, asistent.getNr_telefon());
            statement.setString(5, asistent.getNume());
            statement.executeUpdate();
        }
    }

    public void delete(Asistent asistent) throws SQLException {
        String sql = "DELETE FROM demo.ASISTENTI WHERE nume = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, asistent.getNume());
            statement.executeUpdate();
        }
    }
}