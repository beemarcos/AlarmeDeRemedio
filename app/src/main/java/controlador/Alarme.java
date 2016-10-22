package controlador;

/**
 * Created by Pantufa on 18/10/2016.
 */
public class Alarme {
    private long id;
    private int horario;
    private String dias;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }
}
