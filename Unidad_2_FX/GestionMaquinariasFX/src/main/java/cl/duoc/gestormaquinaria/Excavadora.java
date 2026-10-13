
package cl.duoc.gestormaquinaria;

public class Excavadora extends Maquina {

    public Excavadora(String codigo, int horasUso, int potencia) {
        super(codigo, horasUso, potencia);
    }

    @Override
    public String getTipo() {
        return "Excavadora";
    }
}

