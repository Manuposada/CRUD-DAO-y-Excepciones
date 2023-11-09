package domain;

public class InformacionAcademica {
    
    private int IDFuncionario;
    private String Universidad;
    private String NivelEstudio;
    private String TituloEstudio;

    public int getIDFuncionario() {
        return IDFuncionario;
    }

    public void setIDFuncionario(int IDFuncionario) {
        this.IDFuncionario = IDFuncionario;
    }

    public String getUniversidad() {
        return Universidad;
    }

    public void setUniversidad(String Universidad) {
        this.Universidad = Universidad;
    }

    public String getNivelEstudio() {
        return NivelEstudio;
    }

    public void setNivelEstudio(String NivelEstudio) {
        this.NivelEstudio = NivelEstudio;
    }

    public String getTituloEstudio() {
        return TituloEstudio;
    }

    public void setTituloEstudio(String TituloEstudio) {
        this.TituloEstudio = TituloEstudio;
    }

    @Override
    public String toString() {
        return "El estudio " + TituloEstudio + " realizado en la " + Universidad;
    }
    
}
