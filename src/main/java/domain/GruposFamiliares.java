package domain;

public class GruposFamiliares {
    
    private int IDEmpleado;
    private String Parentezco;
    private String Nombre;
    private String Apellido;

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public String getParentezco() {
        return Parentezco;
    }

    public void setParentezco(String Parentezco) {
        this.Parentezco = Parentezco;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    @Override
    public String toString() {
        return "El familiar " + Nombre + " " + Apellido ;
    }
    
}
