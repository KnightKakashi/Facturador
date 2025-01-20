/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * Esta clase muestra los datos fijos de nuestra empresa
 * @author SIU LEE<3  
 */
public class Empresa { 

    /** Nombre de la empresa. */
    // Nombre de nuestra empresa (String porque es texto)
    public static final String nombre = "Empresa S.L.";
     /** NIF de la empresa. */
    // NIF de nuestra empresa (String porque incluye letras y números)
    public static final String nif = "S1648992";
    
     /** Dirección de la empresa. */
    // Dirección de nuestra empresa (String porque es texto con caracteres alfanuméricos)
    public static final String direccion = "C/ Valeras, Aranjuez, 3";
    
    /** Código postal de la empresa. */
    // Código postal de nuestra empresa (int porque es un número entero)
    public static final int codigoPostal = 28300;
    
     /** País de la empresa. */
    // País (String porque puede incluir tanto texto como caracteres especiales)
    public static final String pais = "Madrid, España";
    
     /** Número de teléfono de la empresa. */
    // Número de teléfono (String porque aunque es un número, no se realizan operaciones matemáticas con él)
    public static final String telefono = "662010948";
    
      /** Correo electrónico de la empresa. */
    // Correo electrónico de nuestra empresa (String porque es texto con símbolos especiales)
    public static final String correo = "dam2empresa@sl.com"; 

     /**
     * Obtiene el nombre de la empresa.
     * @return Nombre de la empresa.
     */
    public static String getNombre() {
        return nombre;
    }

      /**
     * Obtiene el NIF de la empresa.
     * @return NIF de la empresa.
     */
    public static String getNif() {
        return nif;
    }

     /**
     * Obtiene la dirección de la empresa.
     * @return Dirección de la empresa.
     */
    public static String getDireccion() {
        return direccion;
    }

     /**
     * Obtiene el código postal de la empresa.
     * @return Código postal de la empresa.
     */
    public static int getCodigo_Postal() {
        return codigoPostal;
    }

     /**
     * Obtiene el país de la empresa.
     * @return País de la empresa.
     */
    public static String getPais() {
        return pais;
    }

    /**
     * Obtiene el número de teléfono de la empresa.
     * @return Número de teléfono de la empresa.
     */
    public static String getTelefono() {
        return telefono;
    }

     /**
     * Obtiene el correo electrónico de la empresa.
     * @return Correo electrónico de la empresa.
     */
    public static String getCorreo() {
        return correo;
    }
    
    /**
     * Muestra la información de la empresa en la consola.
     */
    //Método para mostrar la información de nuestra empresa
    public static void mostrarInformacion() {
        System.out.println("Información de la Empresa:");
        System.out.println("Nombre: " + nombre);
        System.out.println("NIF: " + nif);
        System.out.println("Dirección: " + direccion);
        System.out.println("Código Postal: " + codigoPostal);
        System.out.println("País: " + pais);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo Electrónico: " + correo);
    }
}