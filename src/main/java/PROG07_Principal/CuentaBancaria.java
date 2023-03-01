//Empaqueto en PROG07_Principal
package PROG07_Principal;

/**
 *
 * @author cmora
 * La clase CuentaBancaria proporciona los atributos y métodos necesarios para
 * cualquier tipo de cuenta bancaria. Implementa la interfaz Imprimible.
 */
abstract class CuentaBancaria implements Imprimible{
    //Declaración de atributo
    protected Persona titular;
    protected double saldo;
    protected String iban;

    /**
     * Constructor de clase.
     * @param titular
     * @param saldo
     * @param iban 
     */
    public CuentaBancaria(Persona titular, double saldo, String iban) {
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }

    /**
     * 
     * Inserto los métodos get y set automáticamente
     */
    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * Declaro el método porque pide expresamente 3 datos, y con devolverInfoString, me devuelve todo.
     * @return un string con los datos solicitados.
     */
    @Override
    public String toString() {
        String output = String.format("\nIBAN: %s. TITULAR: %s. SALDO = %.2f €", iban,titular.devolverInfoString(), saldo);
        return output;       
    }
    
    
    /**
     * Inserto el método devolverInfoString automáticamente al introducir implements.
     * El método es en realidad un toString, que procede de una interfaz, de ahí el override.
     * @return Devuelve los atributos de la clase en un String
     */
    @Override
    public String devolverInfoString() {
        //titular tiene que se llamada, ya que es un objeto
        return "\nIBAN: " + iban + "\nTITULAR: " + titular.devolverInfoString() + "\nSALDO = " + saldo + " €";
    }

       
    
}
