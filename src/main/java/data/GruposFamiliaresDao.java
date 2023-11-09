package data;

import domain.GruposFamiliares;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class GruposFamiliaresDao {
    
    private Connection connection;

    public GruposFamiliaresDao() throws SQLException  {
        this.connection = ConnectionUtil.getConnection();
    }

    public void agregarFamiliar(GruposFamiliares familiar) {
        String query = "INSERT INTO GruposFamiliares (IDEmpleado, Parentezco, Nombre, Apellido) " +
                       "VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, familiar.getIDEmpleado());
            statement.setString(2, familiar.getParentezco());
            statement.setString(3, familiar.getNombre());
            statement.setString(4, familiar.getApellido());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo agregar el familiar a la base de datos");
        }
    }

    public List<GruposFamiliares> obtenerFamiliaresPorIDEmpleado(int idEmpleado) {
        List<GruposFamiliares> familiares = new ArrayList<>();
        String query = "SELECT * FROM GruposFamiliares WHERE IDEmpleado = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idEmpleado);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                GruposFamiliares familiar = construirFamiliarDesdeResultSet(resultSet);
                familiares.add(familiar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("No pudimos obtener la lista de familiares desde la base de datos");
        }

        return familiares;
    }

    public void actualizarFamiliar(GruposFamiliares familiar) {
        String query = "UPDATE GruposFamiliares SET Parentezco = ?, Nombre = ?, Apellido = ? " +
                       "WHERE IDEmpleado = ? AND ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, familiar.getParentezco());
            statement.setString(2, familiar.getNombre());
            statement.setString(3, familiar.getApellido());
            statement.setInt(4, familiar.getIDEmpleado());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo actualizar el familiar en la base de datos");
        }
    }

    public void eliminarFamiliar(int idEmpleado, int idFamiliar) {
        String query = "DELETE FROM GruposFamiliares WHERE IDEmpleado = ? AND ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idEmpleado);
            statement.setInt(2, idFamiliar);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo eliminar el familiar de la base de datos");
        }
    }

    private GruposFamiliares construirFamiliarDesdeResultSet(ResultSet resultSet) throws SQLException {
        GruposFamiliares familiar = new GruposFamiliares();
        familiar.setIDEmpleado(resultSet.getInt("IDEmpleado"));
        familiar.setParentezco(resultSet.getString("Parentezco"));
        familiar.setNombre(resultSet.getString("Nombre"));
        familiar.setApellido(resultSet.getString("Apellido"));
        return familiar;
    }
    
}
