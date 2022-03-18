package com.heltonbustos.ejemplomvp01.presenter.registroequipo;

import android.content.Context;

import com.heltonbustos.ejemplomvp01.interactor.registroequipo.RegistroEquipoInteractorImpl;
import com.heltonbustos.ejemplomvp01.interfaces.registroequipo.RegistroEquipoInteractor;
import com.heltonbustos.ejemplomvp01.interfaces.registroequipo.RegistroEquipoPresenter;
import com.heltonbustos.ejemplomvp01.interfaces.registroequipo.RegistroEquipoView;

public class RegistroEquipoPresenterImpl implements RegistroEquipoPresenter {

    RegistroEquipoView vista;
    RegistroEquipoInteractor interactor;

    public RegistroEquipoPresenterImpl(RegistroEquipoView vista){
        this.vista = vista;
        interactor = new RegistroEquipoInteractorImpl();
    }

    @Override
    public void registrarEquipo(String codigo, String marca, String modelo, String fecha,
                                String cargador, String equipo,
                                String manual,String garantia, String sistemaop, String monitor,
                                String audio, String touchpad, String observaciones, Context contexto) {
        interactor.registrarEquipo(codigo, marca, modelo, fecha,cargador, equipo, manual,garantia,
                                  sistemaop, monitor, audio, touchpad, observaciones, this, contexto);
    }

    @Override
    public void errorEquipo() {
        vista.errorEquipo();
    }

    @Override
    public void exitoEquipo() {
        vista.exitoEquipo();
    }

    @Override
    public void setErrorCodigo() {
        vista.setErrorCodigo();
    }

    @Override
    public void setErrorMarca() {
        vista.setErrorMarca();
    }

    @Override
    public void setErrorModelo() {
        vista.setErrorModelo();
    }
}
