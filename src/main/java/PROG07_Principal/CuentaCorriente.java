//Empaqueto en PROG07_Principal
package PROG07_Principal;

/**
 *
 * @author cmora
 * La clase CuentaCorriente es una clase abstracta que hereda de CuentaBancaria
 */
abstract class CuentaCorriente extends CuentaBancaria{
    //Declaración de atributos
    private String listaEntidades;

    /**
     * Método constructor de clase. Hereda de CuentaBancaria.
     * @param listaEntidades
     * @param titular
     * @param saldo
     * @param iban 
     */
    public CuentaCorriente(String listaEntidades, Persona titular, double saldo, String iban) {
        super(titular, saldo, iban);
        this.listaEntidades = listaEntidades;
    }

    /**
     * Genero los métodos get y set automáticamente.
     * @return 
     */
    public String getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }

    /**
     * Inserto el método devolverInfoString, que ya existe en la clase padre (override)
     * @return Devuelve los atributos de la clase en un String junto con los atributos
     * de la clase padre (llamada super.devolverInfoString)
     */
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + "\nCUENTA CORRIENTE: " + "LISDA DE ENTIDADES: " + listaEntidades + ".";
    }

}
