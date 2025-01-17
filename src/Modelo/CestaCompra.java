/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *Clse encargada de la estructura principal para gestioanr el listado de productos
 * 
 * @author Miguel ignac
 * Clase encargada de la estructura principal para gestionar el listado de productos.
 */
public class CestaCompra {
	/** Cliente asociado a la cesta de compra. */
    private Cliente cliente; //Cliente introducido
    /** Listado de productos añadidos por el cliente. */
    private ArrayList<Producto> lista; //Listado de productos que añade el cliente

    /**
     * Constructor por defecto que inicializa una cesta vacía.
     */
    public CestaCompra() {
        this.lista = new ArrayList<>();
    }

     /**
     * Constructor que inicializa una cesta con un cliente.
     * @param cliente Cliente asociado a la cesta.
     */
    public CestaCompra(Cliente cliente) {
        this.cliente = cliente;
        this.lista = new ArrayList<>();
    }

     /**
     * Obtiene el cliente asociado a la cesta.
     * @return Cliente de la cesta.
     */
    public Cliente getCliente() {
        return cliente;
    }

      /**
     * Asigna un cliente a la cesta.
     * @param cliente Cliente a asignar.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

     /**
     * Agrega un producto a la lista de compra.
     * @param p Producto a agregar.
     */
    public void agregarProducto(Producto p){
        lista.add(p);
    }
    
      /**
     * Elimina un producto de la lista de compra.
     * @param p Producto a eliminar.
     */
    public void eliminarProducto(Producto p){
        lista.remove(p);
    }

     /**
     * Obtiene la lista de productos en la cesta.
     * @return Lista de productos.
     */
    public ArrayList<Producto> getLista() {
        return lista;
    }
    
    /**
     * Metodo para imprimir los productos que se añadan a la lista
     * @return un String con el listado de los prodcutos añadidos
     */
    public String imprimirLista(){
       String res = "";
        for(Producto p: lista){
            res = res + p.toString()+ "\n" + 
            "------------------------------------------------------------------------------------------------------" + "\n";
        }
        
        return res + ("Total: " + Double.toString(calcularTotal()) +  "€");
    }
    /**
     * metodo para calcualr el precio final de la listad e compra
     * @return double con el importe total de los prodiuctos teniendo enc ueta el descuento
     */
    public double calcularTotal(){
        double total = 0;
        for(Producto p: lista){
            total += p.precioDescuento();
        }
        double resultado = Math.round(total * 100.0) / 100.0;
        
        return resultado;
    }  
}