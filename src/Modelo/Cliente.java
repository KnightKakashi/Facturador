/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**Clase que gestiona los clientes
 *
 * @author Miguel ignac
 */ 
public class Cliente {
  private String nombre;
  private String nif;
  private int tlf;
  private String direccion;

    public Cliente() {
    }
  
    public Cliente(String nombre, String nif, int tlf, String direccion) {
        this.nombre = nombre;
        this.nif = nif;
        this.tlf = tlf;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
  
}
