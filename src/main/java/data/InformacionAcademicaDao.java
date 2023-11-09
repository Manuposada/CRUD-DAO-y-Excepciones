package data;

import domain.InformacionAcademica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class InformacionAcademicaDao {
    
    private Connection connection;

    public InformacionAcademicaDao() throws SQLException  {
        this.connection = ConnectionUtil.getConnection();
    }

    public void agregarInformacionAcademica(InformacionAcademica informacionAcademica) {
        String query = "INSERT INTO informacion_academica (IDFuncionario, Universidad, NivelEstudio, TituloEstudio) " +
                       "VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, informacionAcademica.getIDFuncionario());
            statement.setString(2, informacionAcademica.getUniversidad());
            statement.setString(3, informacionAcademica.getNivelEstudio());
            statement.setString(4, informacionAcademica.getTituloEstudio());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al agregar la información académica a la base de datos");
        }
    }

    public List<InformacionAcademica> obtenerInformacionAcademicaPorIDFuncionario(int idFuncionario) {
        List<InformacionAcademica> informacionAcademicaList = new ArrayList<>();
        String query = "SELECT * FROM informacion_academica WHERE IDFuncionario = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idFuncionario);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                InformacionAcademica informacionAcademica = construirInformacionAcademicaDesdeResultSet(resultSet);
                informacionAcademicaList.add(informacionAcademica);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la información académica desde la base de datos");
        }

        return informacionAcademicaList;
    }

    public void actualizarInformacionAcademica(InformacionAcademica informacionAcademica) {
        String query = "UPDATE informacion_academica SET Universidad = ?, NivelEstudio = ?, TituloEstudio = ? " +
                       "WHERE IDFuncionario = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, informacionAcademica.getUniversidad());
            statement.setString(2, informacionAcademica.getNivelEstudio());
            statement.setString(3, informacionAcademica.getTituloEstudio());
            statement.setInt(4, informacionAcademica.getIDFuncionario());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la información académica en la base de datos");
        }
    }

    public void eliminarInformacionAcademica(int idFuncionario, int idInformacionAcademica) {
        String query = "DELETE FROM informacion_academica WHERE IDFuncionario = ? AND ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idFuncionario);
            statement.setInt(2, idInformacionAcademica);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la información académica de la base de datos");
        }
    }

    private InformacionAcademica construirInformacionAcademicaDesdeResultSet(ResultSet resultSet) throws SQLException {
        InformacionAcademica informacionAcademica = new InformacionAcademica();
        informacionAcademica.setIDFuncionario(resultSet.getInt("IDFuncionario"));
        informacionAcademica.setUniversidad(resultSet.getString("Universidad"));
        informacionAcademica.setNivelEstudio(resultSet.getString("NivelEstudio"));
        informacionAcademica.setTituloEstudio(resultSet.getString("TituloEstudio"));
        return informacionAcademica;
    }
    
}
