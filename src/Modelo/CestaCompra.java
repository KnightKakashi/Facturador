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
 */
public class CestaCompra {
    private Cliente cliente; //Cliente introducido
    private ArrayList<Producto> lista; //Listado de produyctos que añade el cliente

    public CestaCompra() {
        this.lista = new ArrayList<>();
    }

    public CestaCompra(Cliente cliente) {
        this.cliente = cliente;
        this.lista = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(Producto p){
        lista.add(p);
    }
    
    public void eliminarProducto(Producto p){
        lista.remove(p);
    }

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