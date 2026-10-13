
package cl.duoc.gestormaquinaria;

import java.util.ArrayList;
import java.util.List;

public class GestorMaquina {

    private final List<Maquina> maquinas;

    public GestorMaquina() {
        maquinas = new ArrayList<>();
    }

    public boolean agregarMaquina(Maquina maquina) {

        if (maquina == null) {
            return false;
        }

        if (buscarPorCodigo(maquina.getCodigo()) != null) {
            return false;
        }

        maquinas.add(maquina);
        return true;
    }

    public Maquina buscarPorCodigo(String codigo) {

        if (codigo == null) {
            return null;
        }

        for (Maquina maquina : maquinas) {

            if (maquina.getCodigo().equalsIgnoreCase(codigo)) {
                return maquina;
            }
        }

        return null;
    }

    public int cantidadMaquinas() {
        return maquinas.size();
    }

    public List<Maquina> listarMaquinas() {
        return new ArrayList<>(maquinas);
    }
}

