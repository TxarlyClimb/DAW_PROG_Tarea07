//Empaqueto en PROG07_Principal
package PROG07_Principal;

/**
 *
 * @author cmora
 * La clase CuentaCorrientePersonal proporciona atributos y métodos para trabajar con este
 * tipo de cuentas. Hereda de CuentaCorriente.
 */
class CuentaCorrientePersonal extends CuentaCorriente{
    //Declaración de atributos
    private double comisionMantenimiento; //Comisión fija anual

    /**
     * Método constructor. Hereda de CuentaCorriente.
     * @param comisionMantenimiento
     * @param listaEntidades
     * @param titular
     * @param saldo
     * @param iban 
     */
    public CuentaCorrientePersonal(double comisionMantenimiento, String listaEntidades, Persona titular, double saldo, String iban) {
        super(listaEntidades, titular, saldo, iban);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    /**
     * Genero los métodos get y set automáticamente.
     * @return 
     */
    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    /**
     * Inserto el método devolverInfoString, que ya existe en la clase padre (override)
     * @return Devuelve los atributos de la clase en un String junto con los atributos
     * de la clase padre (llamada super.devolverInfoString)
     */
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + "\nCUENTA CORRIENTE PERSONAL" + "COMISIÓN DE MANTENIMIENTO = " + comisionMantenimiento + ".";
    }

    
    
    
}
