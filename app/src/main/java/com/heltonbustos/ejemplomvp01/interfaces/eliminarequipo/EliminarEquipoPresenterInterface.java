package com.heltonbustos.ejemplomvp01.interfaces.eliminarequipo;

import android.content.Context;

public interface EliminarEquipoPresenterInterface {
    void eliminarEquipo(String codigo, Context context);
    void exitoEli();
    void errorEli();
    void setErrorCodigo();
}
