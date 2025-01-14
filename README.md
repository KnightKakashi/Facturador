# Facturador

## Descripción del Proyecto
**Facturador** es una aplicación desarrollada en Java que permite a los usuarios gestionar y generar facturas electrónicas. El proyecto sigue la arquitectura **Modelo-Vista-Controlador (MVC)** y se inspira en el formato de facturación de [Facturae](https://www.facturae.gob.es/factura-electronica/Paginas/factura-electronica.aspx).

La aplicación permite:
- Crear facturas electrónicas con formato XML.
- Guardar las facturas en el sistema local.
- Generar una versión en PDF de las facturas.
- Gestionar clientes, productos y datos de facturación de manera intuitiva.

---

## Características Principales
- **Generación de Facturas en XML**: La factura se genera siguiendo un esquema XML que incluye datos como cliente, productos y totales.
- **Exportación a PDF**: Las facturas se convierten en PDF con un diseño estándar.
- **Interfaz Gráfica Intuitiva**: La aplicación incluye un formulario para introducir datos tanto del cliente como los productos a comprar (con una simulación de carrito) con el uso de JavaX y Swing.
- **Validación de Datos**: Asegura que los datos ingresados sean correctos antes de guardar o exportar.

---

## Requisitos
1. **Java Development Kit (JDK) 17+**: [Descargar JDK](https://www.oracle.com/java/technologies/downloads/)
2. **Maven (opcional)**: Para gestionar dependencias y construir el proyecto.
3. **IDE recomendado**: IntelliJ IDEA, Eclipse o NetBeans.

---

## Instalación y Ejecución
Sigue estos pasos para configurar y ejecutar la aplicación localmente:

### **1. Clona el repositorio**
- **NetBeans:** Team -> Git -> Clone -> https://github.com/KnightKakashi/Facturador.git
- **Eclipse:** Window -> Perspective -> Open Perspective -> Other -> Git -> Open -> Clone a Git repository -> https://github.com/KnightKakashi/Facturador.git

### **2. Compila el proyecto**
Usa tu IDE favorito para abrir el proyecto y compilarlo.

### **3. Ejecuta la aplicación**
Ejecuta la clase principal Main.java desde el IDE.
