//Empaqueto en PROG07_Principal
package PROG07_Principal;

/**
 *
 * @author cmora
 * La clase Persona contendrá la información relativa el titular de la cuenta.
 * Implementa la interfaz Imprimible.
 */
public class Persona implements Imprimible{
    //Declaración de los atributos de la clase
    private String nombre;
    private String apellidos;
    private String dni;

    /**
     * Método constructor.
     * @param nombre
     * @param apellidos
     * @param dni 
     */
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    
    /**
     * 
     * Inserto los métodos get y set de forma automática. 
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Inserto el método devolverInfoString automáticamente al introducir implements.
     * El método es en realidad un toString, que procede de una interfaz, de ahí el override.
     * @return Devuelve los atributos de la clase en un String
     */
    @Override
    public String devolverInfoString() {
        return "NOMBRE: " + nombre + ", APELLIDOS: " + apellidos; // + ", dni=" + dni + '}';
    }

        
}
