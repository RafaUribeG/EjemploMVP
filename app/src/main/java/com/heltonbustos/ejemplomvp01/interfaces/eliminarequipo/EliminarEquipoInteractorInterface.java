package com.heltonbustos.ejemplomvp01.interfaces.eliminarequipo;

import android.content.Context;

public interface EliminarEquipoInteractorInterface {
    void eliminarEquipo(String codigo, EliminarEquipoPresenterInterface presenter, Context context);

}
