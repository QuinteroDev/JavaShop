import java.time.LocalDate;
// 3. Define subclases de Producto para representar diferentes categorías de productos: Carne
class Carne extends Producto implements Descuentos, EsAlimento{
    private String tipoDeCarne;
    private int calorias;

    public Carne(String nombre, double precio, LocalDate fechaCaducidad, String tipoDeCarne, int calorias) {
        super(nombre, precio, fechaCaducidad);
        this.tipoDeCarne = tipoDeCarne;
        this.calorias = calorias;
    }

    public String getTipoDeCarne() {
        return tipoDeCarne;
    }

    public void setTipoDeCarne(String tipoDeCarne) {
        this.tipoDeCarne = tipoDeCarne;
    }

    @Override
    public double aplicarDescuentos(double porcentaje) {
        double descuento = getPrecio() * (porcentaje / 100);
        double nuevoPrecio = getPrecio() - descuento;
        setPrecio(nuevoPrecio);
        return nuevoPrecio;
    }

    @Override
    public boolean esAlimento(){
        return true;
    }
    @Override
    public int getCalorias(){
        return calorias;
    }
}