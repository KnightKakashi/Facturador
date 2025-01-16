package Modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author maicol
 */
public class Producto {
    
    private String nombre;
    private int cantidad;
    private double precio;
    private double descuento;
    private String fecha;

    public Producto() {
    }

    public Producto(String nombre, int cantidad, double precio, double descuento, String fecha) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.fecha = FechaActual();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

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
     * metodo para sacar la fecha actual del ordenador
     * @return String fecha actual AAAA-MM-DD
     */
    public static String FechaActual(){
        
        LocalDate today = LocalDate.now();
        String resultado=today.toString(); 
        return resultado;
        
    }
}