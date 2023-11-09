package controller;

import data.GruposFamiliaresDao;
import domain.GruposFamiliares;

import java.sql.SQLException;
import java.util.List;

public class GruposFamiliaresController {
    private GruposFamiliaresDao gruposFamiliaresDao;

    public GruposFamiliaresController() throws SQLException{
            gruposFamiliaresDao = new GruposFamiliaresDao();
    }

    public void agregarFamiliar(GruposFamiliares familiar) throws SQLException {
        gruposFamiliaresDao.agregarFamiliar(familiar);
    }

    public List<GruposFamiliares> obtenerFamiliaresPorIDEmpleado(int idEmpleado) throws SQLException {
        return gruposFamiliaresDao.obtenerFamiliaresPorIDEmpleado(idEmpleado);
    }

    public void actualizarFamiliar(GruposFamiliares familiar) throws SQLException {
        gruposFamiliaresDao.actualizarFamiliar(familiar);
    }

    public void eliminarFamiliar(int idEmpleado, int idFamiliar) throws SQLException {
        gruposFamiliaresDao.eliminarFamiliar(idEmpleado, idFamiliar);
    }
}