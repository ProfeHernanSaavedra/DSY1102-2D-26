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
        per2.validarEdad();
        per3.validarEdad();
        per1.validarEdad();
        per2.setEdad(25);
        per2.validarEdad();

        Persona per4 = new Persona("Maria",null,0,'f' );
        Persona per5 = new Persona("Maria",'f' );
        per5.validarEdad();
        per4.validarEdad();

        //lamar al metodo validad edad con parámetro
        //System.out.println(per1.validarEdad(per3.getEdad()));
        if (per1.validarEdad(per4.getEdad()))
        {
            System.out.println("La edad es válida");
        }
        else{
            System.out.println("No es válidad la edad");
        }



    }
}
