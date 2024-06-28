import java.time.LocalDate;

// 3. Define subclases de Producto para representar diferentes categorías de productos: Producto Limpieza
class ProductoLimpieza extends Producto implements Descuentos{
    private String tipoProductoLimpieza;

    public ProductoLimpieza(String nombre, double precio, LocalDate fechaCaducidad, String tipoProductoLimpieza) {
        super(nombre, precio, fechaCaducidad);
        this.tipoProductoLimpieza = tipoProductoLimpieza;
    }

    public String getTipoProductoLimpieza() {
        return tipoProductoLimpieza;
    }

    public void setTipoProductoLimpieza(String tipoProductoLimpieza) {
        this.tipoProductoLimpieza = tipoProductoLimpieza;
    }

    @Override
    public double aplicarDescuentos(double porcentaje) {
        double descuento = getPrecio() * (porcentaje / 100);
        double nuevoPrecio = getPrecio() - descuento;
        setPrecio(nuevoPrecio);
        return nuevoPrecio;
    }

}