package com.heltonbustos.ejemplomvp01.interactor.modeloRecyclerView;

import android.graphics.Bitmap;

public class RegistroEquiposDatos {

    private Bitmap b1;
    private Bitmap b2;
    private String codigo;
    private String nombreCli;
    private String fecha;
    private String marca;
    private String modelo;
    private String cargador;
    private String equipo;
    private String manual;
    private String garantia;
    private String sistemaop;
    private String monitor;
    private String audio;
    private String touchpad;
    private String obs;

    public RegistroEquiposDatos(Bitmap b1, Bitmap b2, String codigo, String nombreCli, String fecha, String marca, String modelo, String cargador, String equipo, String manual, String garantia, String sistemaop, String monitor, String audio, String touchpad, String obs) {
        this.b1 = b1;
        this.b2 = b2;
        this.codigo = codigo;
        this.nombreCli = nombreCli;
        this.fecha = fecha;
        this.marca = marca;
        this.modelo = modelo;
        this.cargador = cargador;
        this.equipo = equipo;
        this.manual = manual;
        this.garantia = garantia;
        this.sistemaop = sistemaop;
        this.monitor = monitor;
        this.audio = audio;
        this.touchpad = touchpad;
        this.obs = obs;
    }

    public Bitmap getB1() {
        return b1;
    }

    public void setB1(Bitmap b1) {
        this.b1 = b1;
    }

    public Bitmap getB2() {
        return b2;
    }

    public void setB2(Bitmap b2) {
        this.b2 = b2;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCargador() {
        return cargador;
    }

    public void setCargador(String cargador) {
        this.cargador = cargador;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getSistemaop() {
        return sistemaop;
    }

    public void setSistemaop(String sistemaop) {
        this.sistemaop = sistemaop;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getTouchpad() {
        return touchpad;
    }

    public void setTouchpad(String touchpad) {
        this.touchpad = touchpad;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
