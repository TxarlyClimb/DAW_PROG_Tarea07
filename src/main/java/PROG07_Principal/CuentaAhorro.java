//Empaqueto en PROG07_Principal
package PROG07_Principal;

/**
 *
 * @author cmora
 * La clase CuentaAhorro proporciona atributos y métodos para trabajar con este
 * tipo de cuentas. Hereda de CuentaBancaria
 */
class CuentaAhorro extends CuentaBancaria{
    //Declaración de atributos
    private double tipoInteresAnual;

    /**
     * Método constructor de clase. Hereda de CuentaBancaria.
     * @param tipoInteresAnual
     * @param titular
     * @param saldo
     * @param iban 
     */
    public CuentaAhorro(double tipoInteresAnual, Persona titular, double saldo, String iban) {
        super(titular, saldo, iban);
        this.tipoInteresAnual = tipoInteresAnual;
    }

    /**
     * Métodos get y set incluidos de forma automática.
     * @return 
     */
    public double getTipoInteresAnual() {
        return tipoInteresAnual;
    }

    public void setTipoInteresAnual(double tipoInteresAnual) {
        this.tipoInteresAnual = tipoInteresAnual;
    }

    /**
     * Inserto el método devolverInfoString, que ya existe en la clase padre (override)
     * @return Devuelve los atributos de la clase en un String junto con los atributos
     * de la clase padre (llamada super.devolverInfoString)
     */
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + "\nCUENTA AHORRO: " + "TIPO DE INTERES ANUAL = " + tipoInteresAnual + "."; 
    }

    
    
    
}
