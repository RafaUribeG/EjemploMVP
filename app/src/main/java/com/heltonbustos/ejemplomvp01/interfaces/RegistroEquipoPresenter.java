package com.heltonbustos.ejemplomvp01.interfaces;

import android.content.Context;

public interface RegistroEquipoPresenter {

    void registrarEquipo(String codigo, String marca, String modelo, Context contexto);
    void errorEquipo();
    void exitoEquipo();
    void setErrorCodigo();
    void setErrorMarca();
    void setErrorModelo();
}

