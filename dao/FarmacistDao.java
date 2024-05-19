package dao;

import model.Farmacist;
import daoServices.DatabaseConnection;

import java.sql.*;

public class FarmacistDao implements DaoInterface<Farmacist> {
    private static FarmacistDao farmacistDao;
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    private FarmacistDao() throws SQLException {}

    public static FarmacistDao getInstance() throws SQLException {
        if (farmacistDao == null) {
            farmacistDao = new FarmacistDao();
        }
        return farmacistDao;
    }

    public void create(Farmacist farmacist) throws SQLException {
        String sql = "INSERT INTO demo.FARMACISTI (id, nume, prenume, email, nr_Telefon, ani_Experienta, salariu) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, farmacist.getIdAngajat());
            statement.setString(2, farmacist.getNume());
            statement.setString(3, farmacist.getPrenume());
            statement.setString(4, farmacist.getEmail());
            statement.setInt(5, farmacist.getNrTelefon());
            statement.setInt(6, farmacist.getAniExperienta());
            statement.setInt(7, farmacist.getSalariu());
            statement.executeUpdate();
        }
    }

    public Farmacist read(String nume) throws SQLException {
        String sql = "SELECT * FROM demo.FARMACISTI WHERE nume = ?";
        ResultSet rs = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nume);
            rs = statement.executeQuery();

            if (rs.next()) {
                Farmacist farmacist = new Farmacist(
                        rs.getInt("salariu"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("email"),
                        rs.getInt("nr_Telefon"),
                        rs.getInt("ani_Experienta")
                );
                return farmacist;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

    public void update(Farmacist farmacist) throws SQLException {
        String sql = "UPDATE demo.FARMACISTI SET salariu = ?, prenume = ?, email = ?, nr_Telefon = ?, ani_Experienta = ? WHERE nume = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, farmacist.getSalariu());
            statement.setString(2, farmacist.getPrenume());
            statement.setString(3, farmacist.getEmail());
            statement.setInt(4, farmacist.getNrTelefon());
            statement.setInt(5, farmacist.getAniExperienta());
            statement.setString(6, farmacist.getNume());
            statement.executeUpdate();
        }
    }

    public void delete(Farmacist farmacist) throws SQLException {
        String sql = "DELETE FROM demo.FARMACISTI WHERE nume = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, farmacist.getNume());
            statement.executeUpdate();
        }
    }
}
