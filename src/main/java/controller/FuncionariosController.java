package controller;

import data.FuncionariosDao;
import domain.Funcionarios;

import java.sql.SQLException;
import java.util.List;

public class FuncionariosController {
    private FuncionariosDao funcionariosDao;

    public FuncionariosController() throws SQLException{
        
        funcionariosDao = new FuncionariosDao();
    }

    public List<Funcionarios> obtenerFuncionarios() throws SQLException {
        
        return funcionariosDao.obtenerTodosLosFuncionarios();
    }

    public void agregarFuncionario(Funcionarios funcionario) throws SQLException {
        
        funcionariosDao.agregarFuncionario(funcionario);
    }

    public Funcionarios obtenerFuncionario(int idEmpleado) throws SQLException {
        
        return funcionariosDao.obtenerFuncionarioPorID(idEmpleado);
    }

    public void actualizarFuncionario(Funcionarios funcionario) throws SQLException {
        
        funcionariosDao.actualizarFuncionario(funcionario);
    }

    public void eliminarFuncionario(int idEmpleado) throws SQLException {
        
        funcionariosDao.eliminarFuncionario(idEmpleado);
    }
}