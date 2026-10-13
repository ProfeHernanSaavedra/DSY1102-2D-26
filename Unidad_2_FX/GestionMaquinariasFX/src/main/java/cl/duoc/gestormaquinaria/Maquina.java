package cl.duoc.gestormaquinaria;

public abstract class Maquina {

    private String codigo;
    private int horasUso;
    private int potencia;

    public Maquina(String codigo, int horasUso, int potencia) {
        this.codigo = codigo;
        this.horasUso = horasUso;
        this.potencia = potencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getHorasUso() {
        return horasUso;
    }

    public int getPotencia() {
        return potencia;
    }

    public abstract String getTipo();
}

