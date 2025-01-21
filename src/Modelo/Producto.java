package Modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 * La clase {@code Producto} representa un producto que puede ser añadido a una cesta de compra.
 * Contiene la información sobre el nombre del producto, cantidad, precio, descuento y la fecha
 * en la que fue agregado.
 * 
 * <p>
 * La clase ofrece métodos para obtener y establecer los valores de los atributos del producto,
 * calcular el precio con descuento y obtener una representación en forma de cadena de sus características.
 * </p>
 * @author maicol
 */
public class Producto {
    /**
     * Nombre del producto.
     */
    private String nombre;
    /**
     * Cantidad del producto disponible o en el carrito de compras.
     */
    private int cantidad;
    /**
     * Precio unitario del producto.
     */
    private double precio;
     /**
     * Descuento aplicado al producto, expresado como un porcentaje.
     */
    private double descuento;
    /**
     * Fecha en la que se agregó el producto, representada como una cadena en formato AAAA-MM-DD.
     */
    private String fecha;

     /**
     * Constructor por defecto que inicializa una nueva instancia de {@code Producto}.
     * Este constructor no asigna valores a los atributos del producto.
     */
    public Producto() {
    }

     /**
     * Constructor que inicializa una nueva instancia de {@code Producto} con los valores proporcionados.
     * 
     * @param nombre El nombre del producto.
     * @param cantidad La cantidad del producto.
     * @param precio El precio unitario del producto.
     * @param descuento El descuento aplicable al producto, en porcentaje.
     * @param fecha La fecha de creación del producto (en formato AAAA-MM-DD).
     */
    public Producto(String nombre, int cantidad, double precio, double descuento, String fecha) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.fecha = FechaActual();
    }
     /**
     * Devuelve el nombre del producto.
     * 
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }
    
  

      /**
     * Establece el nombre del producto.
     * 
     * @param nombre El nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     /**
     * Devuelve la cantidad disponible del producto.
     * 
     * @return La cantidad del producto.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto.
     * 
     * @param cantidad La cantidad del producto.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

     /**
     * Devuelve el precio unitario del producto.
     * 
     * @return El precio unitario del producto.
     */
    public double getPrecio() {
        return precio;
    }

     /**
     * Establece el precio unitario del producto.
     * 
     * @param precio El precio unitario del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

     /**
     * Devuelve el descuento aplicado al producto en porcentaje.
     * 
     * @return El descuento aplicado al producto.
     */
    public double getDescuento() {
        return descuento;
    }

      /**
     * Establece el descuento del producto en porcentaje.
     * 
     * @param descuento El descuento aplicado al producto en porcentaje.
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

      /**
     * Devuelve la fecha en la que el producto fue agregado.
     * 
     * @return La fecha en formato AAAA-MM-DD.
     */
    public String getFecha() {
        return fecha;
    }

     /**
     * Establece la fecha en la que el producto fue agregado.
     * 
     * @param fecha La fecha en formato AAAA-MM-DD.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Calcula el precio total del producto aplicando el descuento y multiplicando por la cantidad.
     * 
     * @return El precio total con el descuento aplicado.
     */
    public double precioDescuento(){
        return (precio-(precio*(descuento/100)))*cantidad;
    }
  
    @Override
     /**
     * metodo para convertir los datos del Arraylist a Strinf
     * @return String del producto y sus características asociadas
     */
    public String toString(){
        return "Producto: " + nombre + 
                " | Cantidad: " + cantidad + 
                " | Precio/u: " + String.format("%.2f", precio) + " €" + 
                " | Precio final: " + String.format("%.2f", precioDescuento()) + " €" +
                " | Descuento: " + descuento + "%" + 
                " | Fecha: " + fecha;
    }
    /**
     * Metodo paar dar el formato a al texo de los productos
     * @return cadena de texto con la informacion de los productos
     */
     public String toStringPDF(){
         Double precioD  =precioDescuento();
        return  nombre + "\t\t" +cantidad +"            "+ String.format("%.2f", precio) +  "€"  +"     "+ String.format("%.2f", precioDescuento()) + "       21%     " + String.format("%.2f", precioD)+"€";
    }
    
    
    /**
     * metodo para sacar la fecha actual del ordenador
     * @return String fecha actual AAAA-MM-DD
     */
    public static String FechaActual(){
        
        LocalDate today = LocalDate.now();
        String resultado=today.toString(); 
        return resultado;
        
    }
}