package data;

import domain.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class FuncionariosDao {
    
    private Connection connection;

    public FuncionariosDao() throws SQLException  {
        this.connection = ConnectionUtil.getConnection();
    }

    public void agregarFuncionario(Funcionarios funcionario) {
        String query = "INSERT INTO funcionarios (NumeroIdentificacion, TipoIdentificacion, Nombres, Apellidos, EstadoCivil, Genero, Direccion, Telefono, FechaNacimiento) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, funcionario.getNumeroIdentificacion());
            statement.setString(2, funcionario.getTipoIdentificacion());
            statement.setString(3, funcionario.getNombres());
            statement.setString(4, funcionario.getApellidos());
            statement.setString(5, funcionario.getEstadoCivil());
            statement.setString(6, funcionario.getGenero());
            statement.setString(7, funcionario.getDireccion());
            statement.setInt(8, funcionario.getTelefono());
            statement.setString(9, funcionario.getFechaNacimiento());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Hubo un error al agregar el funcionario a la base de datos");
        }
    }

    public Funcionarios obtenerFuncionarioPorID(int idEmpleado) {
        String query = "SELECT * FROM funcionarios WHERE IDEmpleado = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idEmpleado);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return construirFuncionarioDesdeResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("No pudimos obtener el funcionario desde la base de datos");
        }

        return null;
    }

    public List<Funcionarios> obtenerTodosLosFuncionarios() {
        List<Funcionarios> funcionarios = new ArrayList<>();
        String query = "SELECT * FROM Funcionarios";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Funcionarios funcionario = construirFuncionarioDesdeResultSet(resultSet);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo obtener la lista de funcionarios desde la base de datos");
        }

        return funcionarios;
    }

    public void actualizarFuncionario(Funcionarios funcionario) {
        String query = "UPDATE funcionarios SET NumeroIdentificacion = ?, TipoIdentificacion = ?, Nombres = ?, Apellidos = ?, EstadoCivil = ?, Genero = ?, Direccion = ?, Telefono = ?, FechaNacimiento = ? " +
                       "WHERE IDEmpleado = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, funcionario.getNumeroIdentificacion());
            statement.setString(2, funcionario.getTipoIdentificacion());
            statement.setString(3, funcionario.getNombres());
            statement.setString(4, funcionario.getApellidos());
            statement.setString(5, funcionario.getEstadoCivil());
            statement.setString(6, funcionario.getGenero());
            statement.setString(7, funcionario.getDireccion());
            statement.setInt(8, funcionario.getTelefono());
            statement.setString(9, funcionario.getFechaNacimiento());
            statement.setInt(10, funcionario.getIDEmpleado());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el funcionario en la base de datos");
        }
    }

    public void eliminarFuncionario(int idEmpleado) {
        String query = "DELETE FROM funcionarios WHERE IDEmpleado = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idEmpleado);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el funcionario de la base de datos");
        }
    }

    private Funcionarios construirFuncionarioDesdeResultSet(ResultSet resultSet) throws SQLException {
        Funcionarios funcionario = new Funcionarios();
        funcionario.setIDEmpleado(resultSet.getInt("IDEmpleado"));
        funcionario.setNumeroIdentificacion(resultSet.getInt("NumeroIdentificacion"));
        funcionario.setTipoIdentificacion(resultSet.getString("TipoIdentificacion"));
        funcionario.setNombres(resultSet.getString("Nombres"));
        funcionario.setApellidos(resultSet.getString("Apellidos"));
        funcionario.setEstadoCivil(resultSet.getString("EstadoCivil"));
        funcionario.setGenero(resultSet.getString("Genero"));
        funcionario.setDireccion(resultSet.getString("Direccion"));
        funcionario.setTelefono(resultSet.getInt("Telefono"));
        funcionario.setFechaNacimiento(resultSet.getString("FechaNacimiento"));
        return funcionario;
    }
    
}
