/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

/**
 * Clase de modelo que actúa como un contenedor para varios objetos utilizados 
 * en el sistema de gestión de compras. Contiene instancias de objetos 
 * relacionados con la cesta de compra, el cliente, el generador de XML y los productos.
 * 
 * <p>
 * Esta clase es un placeholder o modelo de ejemplo que tiene como propósito 
 * almacenar los objetos asociados a la cesta de compra y facilitar su uso en otros 
 * componentes del sistema.
 * </p>
 * 
 * @author 
 */
public class PlaceholderModelo {
     /**
     * Objeto que representa la cesta de compra en el sistema.
     */
    public CestaCompra cestita;
     /**
     * Objeto que representa al cliente que realiza la compra.
     */
    public Cliente cliente;
     /**
     * Objeto responsable de generar archivos XML para la factura.
     */
    public GeneradorXML genxml;
    /**
     * Objeto que representa un producto en la cesta de compra.
     */
    public Producto prod;

     /**
     * Constructor por defecto que inicializa un objeto {@code PlaceholderModelo}.
     * Este constructor no recibe parámetros y no inicializa los atributos de la clase.
     */
    public PlaceholderModelo() {
    }
    
     /**
     * Constructor que inicializa un objeto {@code PlaceholderModelo} con los objetos
     * proporcionados para la cesta de compra, el cliente, el generador de XML y el producto.
     *
     * @param cestita La cesta de compra asociada al modelo.
     * @param cliente El cliente asociado a la compra.
     * @param genxml El generador de XML para crear archivos de factura.
     * @param prod El producto que forma parte de la cesta de compra.
     */
    public PlaceholderModelo(CestaCompra cestita, Cliente cliente, GeneradorXML genxml, Producto prod) {
        this.cestita = cestita;
        this.cliente = cliente;
        this.genxml = genxml;
        this.prod = prod;
    }
}