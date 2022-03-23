package com.heltonbustos.ejemplomvp01.presenter.verequipo;

import android.content.Context;

import com.heltonbustos.ejemplomvp01.interactor.modeloRecyclerView.RegistroEquiposDatos;
import com.heltonbustos.ejemplomvp01.interactor.verequipo.VerEquipoInteractorImpl;
import com.heltonbustos.ejemplomvp01.interfaces.verequipos.VerEquiposInteractorInterface;
import com.heltonbustos.ejemplomvp01.interfaces.verequipos.VerEquiposPresenterInterface;
import com.heltonbustos.ejemplomvp01.interfaces.verequipos.VerEquiposViewInterface;

import java.util.ArrayList;

public class VerEquipoPresenterImpl implements VerEquiposPresenterInterface {

    VerEquiposViewInterface vista;
    VerEquiposInteractorInterface interactor;

    public VerEquipoPresenterImpl(VerEquiposViewInterface vista) {
        this.interactor = new VerEquipoInteractorImpl();
        this.vista = vista;
    }

    @Override
    public void llenarRecycler(Context contexto) {
        interactor.llenarRecycler(this, contexto);
    }

    @Override
    public void exitoE(ArrayList<RegistroEquiposDatos> listaRegistros) {
        vista.exitoE(listaRegistros);
    }

    @Override
    public void errorE() {
        vista.errorE();
    }
}
