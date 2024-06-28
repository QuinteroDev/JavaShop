import java.time.LocalDate;
// 3. Define subclases de Producto para representar diferentes categorías de productos: Bebida
class Bebida extends Producto implements Descuentos, EsAlimento{
    private String tipoDeBebida;
    private int calorias;

    public Bebida(String nombre, double precio, LocalDate fechaCaducidad, String tipoDeBebida, int calorias) {
        super(nombre, precio, fechaCaducidad);
        this.tipoDeBebida = tipoDeBebida;
        this.calorias = calorias;
    }

    public String getTipoDeBebida() {
        return tipoDeBebida;
    }

    public void setTipoDeBebida(String tipoDeBebida) {
        this.tipoDeBebida = tipoDeBebida;
    }

    @Override
    public double aplicarDescuentos(double porcentaje) {
        double descuento = getPrecio() * (porcentaje / 100);
        double nuevoPrecio = getPrecio() - descuento;
        setPrecio(nuevoPrecio);
        return nuevoPrecio;
    }

    @Override
    public boolean esAlimento() {
        return true;
    }

    @Override
    public int getCalorias() {
        return calorias;
    }


}
