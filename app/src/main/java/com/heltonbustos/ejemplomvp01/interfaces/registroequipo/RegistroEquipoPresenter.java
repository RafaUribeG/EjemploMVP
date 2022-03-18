package com.heltonbustos.ejemplomvp01.interfaces.registroequipo;

import android.content.Context;

public interface RegistroEquipoPresenter {

    void registrarEquipo(String codigo, String marca, String modelo, String fecha,
                         String cargador, String equipo,
                         String manual,String garantia, String sistemaop, String monitor,
                         String audio, String touchpad, String observaciones, Context contexto);
    void errorEquipo();
    void exitoEquipo();
    void setErrorCodigo();
    void setErrorMarca();
    void setErrorModelo();
}

