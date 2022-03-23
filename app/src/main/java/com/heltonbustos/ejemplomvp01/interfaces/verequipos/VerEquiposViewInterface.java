package com.heltonbustos.ejemplomvp01.interfaces.verequipos;

import com.heltonbustos.ejemplomvp01.interactor.modeloRecyclerView.RegistroEquiposDatos;

import java.util.ArrayList;

public interface VerEquiposViewInterface {
    void exitoE(ArrayList<RegistroEquiposDatos> listaRegistros);
    void errorE();
}
