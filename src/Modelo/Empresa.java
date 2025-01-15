/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * Esta clase muestran los datos fijos de nuestra empresa
 * @author SIU LEE<3
 */
public class Empresa { 

    // Nombre de nuestra empresa (String porque es texto)
    public static final String NOMBRE = "Empresa S.L.";

    // NIF de nuestra empresa (String porque incluye letras y números)
    public static final String NIF = "S1648992";

    // Dirección de nuestra empresa (String porque es texto con caracteres alfanuméricos)
    public static final String DIRECCION = "C/ Valeras, Aranjuez, 3";

    // Código postal de nuestra empresa (int porque es un número entero)
    public static final int CODIGO_POSTAL = 28300;

    // País (String porque puede incluir tanto texto como caracteres especiales)
    public static final String PAIS = "Madrid, España";

    // Número de teléfono (String porque aunque es un número, no se realizan operaciones matemáticas con él)
    public static final String TELEFONO = "662010948";

    // Correo electrónico de nuestra empresa (String porque es texto con símbolos especiales)
    public static final String CORREO = "dam2empresa@sl.com"; 

    // Método para mostrar la información de nuestra empresa
    public static void mostrarInformacion() {
        System.out.println("Información de la Empresa:");
        System.out.println("Nombre: " + NOMBRE);
        System.out.println("NIF: " + NIF);
        System.out.println("Dirección: " + DIRECCION);
        System.out.println("Código Postal: " + CODIGO_POSTAL);
        System.out.println("País: " + PAIS);
        System.out.println("Teléfono: " + TELEFONO);
        System.out.println("Correo Electrónico: " + CORREO);
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        // Llamamos al método para mostrar la información de nuestra linda empresa<3
        mostrarInformacion();
    }
}