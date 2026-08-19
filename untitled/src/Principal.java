public class Principal {

    //main + tab
    public static void main(String[] args) {

        Persona per1 = new Persona();
        System.out.println("Hola " + per1.getNombre());
        System.out.println("tienes " + per1.getEdad() + " años");

        //per1.nombre = "Maria";
        per1.setNombre("Maria");
        System.out.println("Hola " + per1.getNombre());

        Persona per2 = new Persona("Armando","Casas",30,'m');
        System.out.println("Hola " + per2.getNombre());
        System.out.println("tienes " + per2.getEdad() + " años");

        System.out.println("************************");
        System.out.println("USANDO TOSTRING");
        Persona per3 = new Persona();
        System.out.println(per3);
    }
}
