public class Carrera {

    private int idCarrera;
    private String nombreCarrera;

    public Carrera() {
    }

    public Carrera(int idCarrera, String nombre) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombre;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombreCarrera;
    }

    public void setNombre(String nombre) {
        this.nombreCarrera = nombre;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "idCarrera=" + idCarrera +
                ", nombre='" + nombreCarrera + '\'' +
                '}';
    }
}
