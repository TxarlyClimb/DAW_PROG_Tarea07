//Empaqueto en PROG07_Principal
package PROG07_Principal;

/**
 *
 * @author cmora
 * La clase CuentaCorrieteEmpresa proporciona atributos y métodos para trabajar con este
 * tipo de cuentas. Hereda de CuentaCorriente
 */
class CuentaCorrienteEmpresa extends CuentaCorriente{
    //Declaracion de atributos
    private double maxDescubierto;
    private double tipoInteresDescubierto;
    private double comisionFijaDescubierto;

    /**
     * Método constructor de clase. Hereda de CuentaCorriente
     * @param maxDescubierto
     * @param tipoInteresDescubierto
     * @param comisionFijaDescubierto
     * @param listaEntidades
     * @param titular
     * @param saldo
     * @param iban 
     */
    public CuentaCorrienteEmpresa(double maxDescubierto, double tipoInteresDescubierto, double comisionFijaDescubierto, String listaEntidades, Persona titular, double saldo, String iban) {
        super(listaEntidades, titular, saldo, iban);
        this.maxDescubierto = maxDescubierto;
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    /**
     * Métodos get y set generados automáticamente.
     * @return 
     */
    public double getMaxDescubierto() {
        return maxDescubierto;
    }

    public void setMaxDescubierto(double maxDescubierto) {
        this.maxDescubierto = maxDescubierto;
    }

    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    public double getComisionFijaDescubierto() {
        return comisionFijaDescubierto;
    }

    public void setComisionFijaDescubierto(double comisionFijaDescubierto) {
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    /**
     * Inserto el método devolverInfoString, que ya existe en la clase padre (override)
     * @return Devuelve los atributos de la clase en un String junto con los atributos
     * de la clase padre (llamada super.devolverInfoString)
     */
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + "\nCUENTA CORRIENTE EMPRESA: " + "DESCUBIERTO MÁX = " + maxDescubierto + ", TIPO DE INTERÉS DESCUBIERTO = " + tipoInteresDescubierto + ", COMISIÓN FIJA DESCUBIERTO = " + comisionFijaDescubierto + "."; 
    }

    
}
