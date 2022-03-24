package com.heltonbustos.ejemplomvp01.presenter.eliminarequipo;

import android.content.Context;

import com.heltonbustos.ejemplomvp01.interactor.eliminarequipo.EliminarEquipoInteractorImpl;
import com.heltonbustos.ejemplomvp01.interfaces.eliminarequipo.EliminarEquipoInteractorInterface;
import com.heltonbustos.ejemplomvp01.interfaces.eliminarequipo.EliminarEquipoPresenterInterface;
import com.heltonbustos.ejemplomvp01.interfaces.eliminarequipo.EliminarEquipoViewInterface;

public class EliminarEquipoPresenterImpl implements EliminarEquipoPresenterInterface {

    EliminarEquipoViewInterface vista;
    EliminarEquipoInteractorInterface interactor;

    public EliminarEquipoPresenterImpl(EliminarEquipoViewInterface vista){
        this.vista = vista;
        this.interactor = new EliminarEquipoInteractorImpl();
    }

    @Override
    public void eliminarEquipo(String codigo, Context context) {
        interactor.eliminarEquipo(codigo,this, context);
    }

    @Override
    public void exitoEli() {
        vista.exitoEli();
    }

    @Override
    public void errorEli() {
        vista.errorEli();
    }

    @Override
    public void setErrorCodigo() {
        vista.setErrorCodigo();
    }
}
