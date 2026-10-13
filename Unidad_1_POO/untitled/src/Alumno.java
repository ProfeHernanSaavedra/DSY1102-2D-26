public class Alumno extends Persona{

    private Asignatura asignatura;
    private Profesor profe;
    private Carrera carrera;
    private String sede;
    private int idAlumnos;

    public Alumno() {
    }

    public Alumno(Asignatura asignatura, Profesor profe, Carrera carrera, String sede, int idAlumnos) {
        this.asignatura = asignatura;
        this.profe = profe;
        this.carrera = carrera;
        this.sede = sede;
        this.idAlumnos = idAlumnos;


    }

    public Alumno(String nombre, String apellido, int edad, char sexo, Asignatura asignatura, Profesor profe, Carrera carrera, String sede, int idAlumnos) {
        super(nombre, apellido, edad, sexo);
        this.asignatura = asignatura;
        this.profe = profe;
        this.carrera = carrera;
        this.sede = sede;
        this.idAlumnos = idAlumnos;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Profesor getProfe() {
        return profe;
    }

    public void setProfe(Profesor profe) {
        this.profe = profe;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getIdAlumnos() {
        return idAlumnos;
    }

    public void setIdAlumnos(int idAlumnos) {
        this.idAlumnos = idAlumnos;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "asignatura=" + asignatura +
                ", profe=" + profe +
                ", carrera=" + carrera +
                ", sede='" + sede + '\'' +
                ", idAlumnos=" + idAlumnos +
                '}';
    }
}
