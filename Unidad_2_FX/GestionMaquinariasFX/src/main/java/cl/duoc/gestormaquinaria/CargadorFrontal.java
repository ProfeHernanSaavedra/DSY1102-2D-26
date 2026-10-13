
package cl.duoc.gestormaquinaria;

public class CargadorFrontal extends Maquina {

    public CargadorFrontal(String codigo, int horasUso, int potencia) {
        super(codigo, horasUso, potencia);
    }

    @Override
    public String getTipo() {
        return "Cargador Frontal";
    }
}
