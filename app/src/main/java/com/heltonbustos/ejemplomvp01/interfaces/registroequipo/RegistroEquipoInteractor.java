package com.heltonbustos.ejemplomvp01.interfaces.registroequipo;

import android.content.Context;

public interface RegistroEquipoInteractor {
    void registrarEquipo(String codigo, String nombreCli, String marca, String modelo, String fecha,
                         String cargador, String equipo,
                         String manual,String garantia, String sistemaop, String monitor,
                         String audio, String touchpad, String observaciones, RegistroEquipoPresenter presenter, Context contexto);
}
