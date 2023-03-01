//Empaqueto en PROG07_Principal
package PROG07_Principal;

//Importo las clases necesarias
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author cmora
 * Inicio de la clase principal con el método main
 */
public class Principal {

    public static void main(String[] args) {
        //Declaración de variables
        int opcion, opcionCuenta;
        boolean salir = false;//Controla el bucle del menú
        String nombre, apellidos, dni, iban, listaEntidades, infoCuenta;
        String [] listaCuentas;
        double saldo, tipoInteresAnual, comisionMantenimiento, maxDescubierto, tipoInteresDescubierto, comisionFijaDescubierto;
        Persona titular;
        Scanner teclado = new Scanner(System.in);//Lectura por teclado
        teclado.useDelimiter("\n"); //Evita posibles problemas con espacios.
        
        CuentaBancaria cuenta = null;/*Vamos a emplear polimorfismo, referenciamos el objeto cuenta de tipo CuentaBancaria
                               *para posteriormente instanciarlo de la subclase que sea necesario.
                              */
        Banco banco = new Banco(); //Creo el objeto banco donde almacenaremos las cuentas.
        
        //Muestro el menú
        do {
            try {//Va a permitir que no de error en caso de introducir algo distinto a un número
                
                System.out.println("\nIntroduzca una opción:");
                System.out.println("1. Abrir una nueva cuenta.");
                System.out.println("2. Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).");
                System.out.println("3. Obtener los datos de una cuenta concreta.");
                System.out.println("4. Realiza un ingreso en un cuenta.");
                System.out.println("5. Retirar efectivo de una cuenta.");
                System.out.println("6. Consultar el saldo actual.");
                System.out.println("7. Salir de la aplicación.\n");

                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {

                    case 1://Abrir cuenta
                        System.out.println("VA A ABRIR UNA NUEVA CUENTA.\n");
                        
                        System.out.println("Introduzca el nombre del titular: ");
                        nombre = teclado.next();
                       
                        System.out.println("\nIntroduzca los apellidos del titular: ");
                        apellidos = teclado.next();
                        
                        System.out.println("\nIntroduzca el DNI del titular: ");
                        dni = teclado.next();
                        
                        titular = new Persona(nombre, apellidos, dni);
                        
                        //No nos piden que se compruebe si el IBAN ya existe, sería una mejora a implementar
                        System.out.println("\nIntroduzca el IBAN de la cuenta. ");
                        System.out.println("(El formato debe ser ES seguido de 20 dígitos)\n");
                        iban = teclado.next();
                        iban = iban.toUpperCase();//Convierto el IBAN a mayúsculas para su comprobación de formato.
                        
                        if (!iban.matches("^ES[0-9]{20}$")) {//Compruebo formato con expresión regular
                            System.out.println("\nError en el formato. ");
                            throw new Exception("El IBAN no tiene el formato correcto.");
                        }
                        
                        System.out.println("\nIntroduce el saldo inicial: ");//Pido el saldo inicial
                        saldo = teclado.nextDouble();
 
                        System.out.println("\nIntroduzca el tipo de cuenta:");//Ofrezco menú para el tipo de cuenta
                        System.out.println("1. Cuenta de Ahorro.");
                        System.out.println("2. Cuenta Corriente Personal.");
                        System.out.println("3. Cuenta Corriente de Empresa.");
                        opcionCuenta = teclado.nextInt();
                        
                        switch (opcionCuenta) {//Creamos la cuenta en función del tipo elegido
                            
                            case 1://Cuenta de Ahorro, Hay que pedir el tipo de interés anual.
                                System.out.println("\nHa saleccionado CUENTA DE AHORRO.");
                                System.out.println("Introduzca el tipo de interés de remuneración.");
                                tipoInteresAnual = teclado.nextDouble();
                                
                                //Instanciamos el objeto, con la referencia de la clase padre, en tiempo de ejecución
                                cuenta = new CuentaAhorro(tipoInteresAnual, titular, saldo, iban);
                                break;
                                
                            case 2://Cuenta Corriente Personal. Hay que pedir la lista de entidades autorizadas.
                                   //y la comisión de mantenimiento.
                                System.out.println("\nHa saleccionado CUENTA CORRIENTE PERSONAL.");
                                System.out.println("Introduzca la lista de ENTIDADES AUTORIZADAS:");
                                listaEntidades = teclado.next();
                                System.out.println("\nIntroduzca la COMISIÓN DE MANTENIMIENTO:");
                                comisionMantenimiento = teclado.nextDouble();
                                
                                //Instanciamos el objeto, con la referencia de la clase padre, en tiempo de ejecución
                                cuenta = new CuentaCorrientePersonal(comisionMantenimiento, listaEntidades, titular, saldo, iban);
                                break;
                                
                            case 3://Cuenta Corriente de Empresa. Hay que pedir la lista de entidades autorizadas.
                                   //y el máximo descubierto, tipo interés descubierto y la comisión por descubierto.
                                System.out.println("\nHa saleccionado CUENTA CORRIENTE DE EMPRESA.");
                                System.out.println("Introduzca la lista de ENTIDADES AUTORIZADAS:");
                                listaEntidades = teclado.next();
                                System.out.println("\nIntroduzca el MÁXIMO DESCUBIERTO PERMITIDO:");
                                maxDescubierto = teclado.nextDouble();
                                System.out.println("\nIntroduzca el TIPO DE INTERÉS DE DESCUBIERTO:");
                                tipoInteresDescubierto = teclado.nextDouble();
                                System.out.println("\nIntroduzca la COMISIÓN FIJA DE DESCUBIERTO:");
                                comisionFijaDescubierto = teclado.nextDouble();
                                
                                //Instanciamos el objeto, con la referencia de la clase padre, en tiempo de ejecución
                                cuenta = new CuentaCorrienteEmpresa(maxDescubierto, tipoInteresDescubierto, comisionFijaDescubierto, listaEntidades, titular, saldo, iban);
                                break;
                                
                            default:
                                System.out.println("La opción elegida no es correcta.");;
                        }
                        //Con la cuenta ya creada, pasamos a llamar al método abrirCuenta para almacenarla.
                        
                        if (banco.abrirCuenta(cuenta))
                                System.out.println("\nLa cuenta se ha abierto y guardado.");
                        //Si no se abre, el propio método nos dice porqué.
                        
                        break;

                    case 2://Ver lista de cuentas
                        System.out.println("\nLas cuentas almacenadas son las siguientes:");
                        listaCuentas = banco.listadoCuentas();
                        for (String listaCuenta : listaCuentas) {//Usamos for each sugerido por el IDE
                            System.out.println(listaCuenta);
                    }
                        break;


                    case 3://Obtener datos de una cuenta, pidiendo el IBAN
                        System.out.println("\nIntroduzca el IBAN de la cuenta. ");
                        System.out.println("(El formato debe ser ES seguido de 20 dígitos)\n");
                        iban = teclado.next();
                        iban = iban.toUpperCase();//Convierto el IBAN a mayúsculas para su comprobación.
                        
                        infoCuenta = banco.informacionCuenta(iban);//Devolvia NULL si no existía
                        
                        if (infoCuenta != null){
                            System.out.println("\nLa información de la cuenta es la siguiente: ");
                            System.out.println(infoCuenta);
                        } else
                            System.out.println("\nEl IBAN introducido no se corresponde con ninguna cuenta.");

                        break;

                    case 4://Realizar un ingreso
                        System.out.println("\nIntroduzca el IBAN de la cuenta donde quiere hacer el ingreso. ");
                        System.out.println("(El formato debe ser ES seguido de 20 dígitos)\n");
                        iban = teclado.next();
                        iban = iban.toUpperCase();//Convierto el IBAN a mayúsculas para su comprobación.
                        
                        do {  
                            System.out.println("\nIntroduce el saldo a ingresar. Debe ser positivo: ");//Pido el saldo
                            saldo = teclado.nextDouble();
                            
                        } while (saldo<=0);//Controla que el ingreso sea positivo.
                        
                                                
                        if (banco.ingresoCuenta(iban, saldo)){
                            System.out.println("\nIngreso realizado con éxito.");
                        } else
                            System.out.println("\nEl ingreso no se ha podido realizar.");
                        break;

                    case 5://Retirar efectivo de una cuenta
                        System.out.println("\nIntroduzca el IBAN de la cuenta de donde quiere retirar el importe.");
                        System.out.println("(El formato debe ser ES seguido de 20 dígitos)\n");
                        iban = teclado.next();
                        iban = iban.toUpperCase();//Convierto el IBAN a mayúsculas para su comprobación.
                        
                        System.out.println("\nIntroduce el saldo a retirar: ");//Pido el saldo
                        saldo = teclado.nextDouble();
                                                
                        if (banco.retiradaCuenta(iban, saldo)){
                            System.out.println("\nRetirada realizado con éxito.");
                        } else
                            System.out.println("\nNo se ha podido realizar la retirada.");
                        
                        break;

                    case 6://Consultar el saldo de una cuenta
                        System.out.println("\nIntroduzca el IBAN de la cuenta. ");
                        System.out.println("(El formato debe ser ES seguido de 20 dígitos)\n");
                        iban = teclado.next();
                        iban = iban.toUpperCase();//Convierto el IBAN a mayúsculas para su comprobación.
                        
                        saldo = banco.obtenerSaldo(iban);
                        
                        if (saldo != -1)
                            System.out.printf("\nEl saldo de la cuenta es %.2f\n", saldo);
                        else
                            System.out.println("La cuenta no existe.");
                        break;
                        
                    case 7://Salir de la aplicación
                        salir = true;
                        System.out.println("\nSaliendo del programa. Hasta pronto.");
                        break;

                    default://Elección distinta de 1 a 7
                        System.out.println("\nLa opción introducida es incorrecta. Debe estar entre 1 y 7\n");

                }
            //Capturo las excepciones en caso de que se introduzca algo distinto a un numero    
            } catch (InputMismatchException e) {
                teclado.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        } while (!salir);//Repite el menú mientras las opciones estén entre 1 y 6
        
        
    }
}
