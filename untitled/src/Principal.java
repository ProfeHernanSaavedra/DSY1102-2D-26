public class Principal {

    //main + tab
    public static void main(String[] args) {

        Persona per1 = new Persona();
        System.out.println("Hola " + per1.nombre);
        System.out.println("tienes " + per1.edad + " años");

        per1.nombre = "Maria";
        System.out.println("Hola " + per1.nombre);

        Persona per2 = new Persona("Armando","Casas",30,'m');
        System.out.println("Hola " + per2.nombre);
        System.out.println("tienes " + per2.edad + " años");
    }
}
