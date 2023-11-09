package controller;

import data.InformacionAcademicaDao;
import domain.InformacionAcademica;

import java.sql.SQLException;
import java.util.List;

public class InformacionAcademicaController {
    private InformacionAcademicaDao informacionAcademicaDao;

    public InformacionAcademicaController() throws SQLException {
            informacionAcademicaDao = new InformacionAcademicaDao();
        }

    public void agregarInformacionAcademica(InformacionAcademica informacionAcademica) throws SQLException {
        informacionAcademicaDao.agregarInformacionAcademica(informacionAcademica);
    }

    public List<InformacionAcademica> obtenerInformacionAcademicaPorIDFuncionario(int idFuncionario) throws SQLException {
        return informacionAcademicaDao.obtenerInformacionAcademicaPorIDFuncionario(idFuncionario);
    }

    public void actualizarInformacionAcademica(InformacionAcademica informacionAcademica) throws SQLException {
        informacionAcademicaDao.actualizarInformacionAcademica(informacionAcademica);
    }

    public void eliminarInformacionAcademica(int idFuncionario, int idInformacionAcademica) throws SQLException {
        informacionAcademicaDao.eliminarInformacionAcademica(idFuncionario, idInformacionAcademica);
    }
}