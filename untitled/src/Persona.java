public class Persona {
    //atributos
    private String nombre;
    private String apellido;
    private int edad;
    private char sexo;

    //constructor sin parámetros
    public Persona(){
        this.nombre = "Alam";
        this.apellido = "Brito";
        this.edad = 23;
        this.sexo = 'm';
    }

    public Persona(String nombre,String apellido,int edad,char sexo)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    //métodos acceder a los atributos (getter - get) -> accesadores
    //métodos cambiar los atributos (setter -set) -> mutadores

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getEdad()
    {
        return this.edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {

        return "Nombre: " + this.getNombre() + " Apellido: " + apellido;
    }


}
