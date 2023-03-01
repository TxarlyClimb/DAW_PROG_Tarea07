//Empaqueto en PROG07_Principal
package PROG07_Principal;


/**
 *
 * @author cmora
 * La clase Banco contiene la estructura que almacena las cuentas
 */
class Banco {
    //Atributos
    private CuentaBancaria[] cuentas;//Array de tipo CuentaBancaria
    private final int MAX_CUENTAS = 100; //Máximo de cuentas.
    private int numCuentas;//Controla el nº de cuentas existentes

    /**
     * Método constructor, inicializa contador a 0 y crea el array de 100.
    */
    
    public Banco() {
        this.cuentas = new CuentaBancaria[this.MAX_CUENTAS];
        this.numCuentas = 0;
    }
  
    /**
     * Recibe por parámetro una CuentaBancaria y lo almacena.
     * Devuelve TRUE o FALSE si la operación se realiza con éxito
    */
    public boolean abrirCuenta (CuentaBancaria cuenta){
        //En un principio cree estructuras IF/ELSE pero no es necesario, ya que los return
        //de los IF impiden que se ejecute el resto del código.
        if (this.numCuentas >= this.MAX_CUENTAS){
            System.out.println("El Banco no acepta más cuentas.\n");
            return false;
        } 
        CuentaBancaria existe = this.buscarCuenta(cuenta.getIban());
        if (existe != null){
            System.out.println("\nNO SE PUDO CREAR. La cuenta ya existe.\n");
            return false;
        }
        this.cuentas[this.numCuentas]= cuenta;//Solo se ejecuta si hay hueco y la cuenta no existe.
        this.numCuentas++;
        return true;       
        
        
    }
    
    /**
     * Recibe una cuenta por parámetro y la busca para ver si existe en el array.
     * @param cuenta
     * @return si no encuentra la cuenta devuelve null, sino devuelve la cuenta.
     */
    private CuentaBancaria buscarCuenta (String iban){
        
        for (int i = 0; i < this.numCuentas; i++) { //Recorremos el array hasta el numero de cuentas existentes.
            if (this.cuentas[i].getIban().equals(iban)) //Compara si existe el IBAN
                return this.cuentas[i]; //Si existe devuelve la cuenta
        }
        return null;//Si no existe, devuelve null
    }
    
    /**
     * No recibe nada por parámetro. 
     * @return Devuelve un array de tipo String con información de las cuentas existentes.
    */
    public String[] listadoCuentas (){
        String[] infoCuentas = new String[this.numCuentas];//Declaro el array del tamaño del numero de cuentas existentes.
        for (int i = 0; i < this.numCuentas; i++) {//Recorro todo el array de cuentas
            infoCuentas[i] = this.cuentas[i].toString();//Llamada para recibir la información de cada cuenta
        }
        return infoCuentas;//Devuelvo la información
    }
    
    /**
     * Recibe un IBAN por parámetro.
     * @return devuelve un String con información de la cuenta o NULL si no existe.
    */
    public String informacionCuenta (String iban){
        CuentaBancaria existe = this.buscarCuenta(iban);
        if (existe != null){
            return existe.devolverInfoString();
        }
        return null;
    }
    
    /**
     * Recibe un IBAN y una cantidad por parámetro e ingresa esa cantidad en la 
     * cuenta. 
     * @return Devuelve TRUE si la operación se realiza con éxito, sino FALSE. 
    */
    public boolean ingresoCuenta (String iban, double cantidadIngreso){
        CuentaBancaria existe = this.buscarCuenta(iban);
        if (existe != null){//La cuenta existe
            existe.setSaldo(existe.getSaldo() + cantidadIngreso);
            return true;
        }
        return false;
    } 
    
    /**
     * Recibe un IBAN y una cantidad por parámetro y retira esa cantidad de la 
     * cuenta si es posible.
     * @return Devuelve TRUE si la operación se realiza con éxito, sino FALSE. 
    */
    public boolean retiradaCuenta (String iban, double cantidadRetirada){
        CuentaBancaria existe = this.buscarCuenta(iban);
        
        boolean haySaldo = false; //Controla que la retirada se puede hacer de una cuenta con saldo
        if (existe != null){//La cuenta existe
        //Como las CuentasCorrientesEmpresa admiten descubiertos, vamos a plantear esa situación
        
            if (existe.getSaldo() - cantidadRetirada >= 0){//Compueba que hay saldo suficiciente
                haySaldo = true;
            }
            else
                if (existe instanceof CuentaCorrienteEmpresa){//Si la cuenta es instancia de CCEmpresa
                    CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa)existe;//Casting a la clase correspondiente
                    if (Math.abs(existe.getSaldo() - cantidadRetirada) <= aux.getMaxDescubierto())
                        //Comprubea que la cantidad a retirar deja un descubierto menor al permitido
                        haySaldo = true;
                }
            }
                
        if (haySaldo){//Si hay saldo suficiente lo retira de la cuenta.
            existe.setSaldo(existe.getSaldo() - cantidadRetirada);
            }
        
        return haySaldo;//Devuelve el valor correcto
    } 
    
    /**
     * Recibe un IBAN por parámetro y devuelve el saldo de la cuenta si existe.
     * @return Devuelve -1 en caso de que no existe la cuenta. 
    */
    public double obtenerSaldo (String iban){
        CuentaBancaria existe = this.buscarCuenta(iban);
        if (existe != null){//La cuenta existe
            return existe.getSaldo();
        }
        return -1;//Si la cuenta no existe
    } 
      
    
    
}
