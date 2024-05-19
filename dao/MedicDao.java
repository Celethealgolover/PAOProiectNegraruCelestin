package dao;
import model.Medic;
import daoServices.DatabaseConnection;
import model.MedicGastroenterolog;

import java.sql.*;
public class MedicDao implements DaoInterface<Medic> {
    private static MedicDao medicDao;
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    private MedicDao() throws SQLException {}

    public static MedicDao getInstance() throws SQLException {
        if (medicDao == null) {
            medicDao = new MedicDao();
        }
        return medicDao;
    }

    public void create(Medic medic) throws SQLException {
        String sql = "INSERT INTO demo.MEDICI VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, medic.getIdAngajat());
            statement.setString(2, medic.getNume());
            statement.setString(3, medic.getPrenume());
            statement.setString(4, medic.getSpecializare());
            statement.setString(5, medic.getEmail());
            statement.setString(6, medic.getGrad());
            statement.setInt(7, medic.getNumarTelefon());
            statement.setInt(8, medic.getAniExperienta());
            statement.setInt(9, medic.getSalariu());
            statement.executeUpdate();
        }
    }

    public Medic read(String nume) throws SQLException {
        String sql = "SELECT * FROM demo.MEDICI WHERE nume = ?";
        ResultSet rs = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nume);
            rs = statement.executeQuery();

            if (rs.next()) {
                Medic medic = new MedicGastroenterolog();
                medic.setNume(rs.getString("nume"));
                medic.setPrenume(rs.getString("prenume"));
                medic.setSpecializare(rs.getString("specializare"));
                medic.setEmail(rs.getString("email"));
                medic.setGrad(rs.getString("grad"));
                medic.setNumarTelefon(rs.getInt("nr_telefon"));
                medic.setAniExperienta(rs.getInt("ani_experienta"));
                medic.setSalariu(rs.getInt("salariu"));
                return medic;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

    public void update(Medic medic) throws SQLException {
        String sql = "UPDATE demo.MEDICI SET prenume = ?, specializare = ?, email = ?, grad = ?, nr_Telefon = ?, ani_Experienta = ?, salariu=? WHERE nume = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, medic.getPrenume());
            statement.setString(2, medic.getSpecializare());
            statement.setString(3, medic.getEmail());
            statement.setString(4, medic.getGrad());
            statement.setInt(5, medic.getNumarTelefon());
            statement.setInt(6, medic.getAniExperienta());
            statement.setInt(7, medic.getSalariu());
            statement.setString(8, medic.getNume());
            statement.executeUpdate();
        }
    }

    public void delete(Medic medic) throws SQLException {
        String sql = "DELETE FROM demo.MEDICI WHERE nume = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, medic.getNume());
            statement.executeUpdate();
        }
    }
}
