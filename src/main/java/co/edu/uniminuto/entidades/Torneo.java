
package co.edu.uniminuto.entidades;


public class Torneo {
    //atributos de torneo 
    private int idTorneo;
    private String nombreTorneo;
    private int numDeEquipos;
    private short status;


//constructores 
    public Torneo(String nombreTorneo, int numDeEquipos, short status) {
        
        this.nombreTorneo = nombreTorneo;
        this.numDeEquipos = numDeEquipos;
        this.status = status;
    }
//cosntructor vacio
    public Torneo() {
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public int getNumDeEquipos() {
        return numDeEquipos;
    }

    public void setNumDeEquipos(int numDeEquipos) {
        this.numDeEquipos = numDeEquipos;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Torneo{");
        sb.append("idTorneo=").append(idTorneo);
        sb.append(", nombreTorneo=").append(nombreTorneo);
        sb.append(", numDeEquipos=").append(numDeEquipos);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
