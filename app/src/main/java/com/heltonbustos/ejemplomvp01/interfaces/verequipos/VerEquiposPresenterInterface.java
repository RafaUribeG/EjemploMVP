package com.heltonbustos.ejemplomvp01.interfaces.verequipos;

import android.content.Context;

import com.heltonbustos.ejemplomvp01.interactor.modeloRecyclerView.RegistroEquiposDatos;

import java.util.ArrayList;

public interface VerEquiposPresenterInterface {
    void llenarRecycler(Context contexto);
    void exitoE(ArrayList<RegistroEquiposDatos> listaRegistros);
    void errorE();
}
