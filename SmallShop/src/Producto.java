// Define una clase abstracta Producto que represente los productos que se venden en el supermercado. Esta clase debe tener
//propiedades como nombre, precio y fechaCaducidad.
// 2. Implementa métodos para establecer y obtener estas propiedades en la clase Producto

import java.time.LocalDate;
abstract class Producto {
    private String nombre;
    private double precio;
    private LocalDate fechaCaducidad;

    public Producto(String nombre, double precio, LocalDate fechaCaducidad){
        this.nombre = nombre;
        this.precio = precio;
        this.fechaCaducidad = fechaCaducidad;
    }
    public String getNombre () {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio () {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaCaducidad () {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
}
