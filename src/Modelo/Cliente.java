/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**Clase que gestiona los clientes
 *
 * @author Miguel ignac
 * Clase que gestiona los clientes.
 */ 
public class Cliente {
    /** Nombre del cliente. */
    private String nombre;
    /** Número de identificación fiscal (NIF) del cliente. */
    private String nif;
    /** Número de teléfono del cliente. */
    private int telefono;
    /** Dirección del cliente. */
    private String direccion;

     /**
     * Constructor por defecto.
     */
    public Cliente() {
    }
  
     /**
     * Constructor con parámetros para inicializar un cliente.
     * 
     * @param nombre Nombre del cliente.
     * @param nif NIF del cliente.
     * @param telefono Número de teléfono del cliente.
     * @param direccion Dirección del cliente.
     */
    public Cliente(String nombre, String nif, int telefono, String direccion) {
        this.nombre = nombre;
        this.nif = nif;
        this.telefono = telefono;
        this.direccion = direccion;
    }

      /**
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }
    
      /**
     * Establece el nombre del cliente.
     * 
     * @param nombre Nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     /**
     * Obtiene el NIF del cliente.
     * 
     * @return NIF del cliente.
     */
    public String getNif() {
        return nif;
    }

      /**
     * Establece el NIF del cliente.
     * 
     * @param nif NIF del cliente.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     * 
     * @return Número de teléfono del cliente.
     */
    public int getTelefono() {
        return telefono;
    }

     /**
     * Establece el número de teléfono del cliente.
     * 
     * @param telefono Número de teléfono del cliente.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

     /**
     * Obtiene la dirección del cliente.
     * 
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

     /**
     * Establece la dirección del cliente.
     * 
     * @param direccion Dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}