import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Producto> productos = new ArrayList<>();

        while (true) {
            try {
                System.out.println("Seleccione el tipo de producto que desea crear:");
                System.out.println("1. Bebida");
                System.out.println("2. Carne");
                System.out.println("3. Producto de Limpieza");
                System.out.println("4. Finalizar y mostrar totales");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir nueva línea

                if (opcion == 4) {
                    break;
                }

                if (opcion < 1 || opcion > 4) {
                    throw new ProductoNoCreadoException("Opción no válida. Intente de nuevo.");
                }

                System.out.println("Ingrese el nombre del producto:");
                String nombre = scanner.nextLine();
                if (nombre.isEmpty()) {
                    throw new ProductoNoCreadoException("El nombre del producto no puede estar vacío.");
                }

                System.out.println("Ingrese el precio del producto:");
                double precio;
                try {
                    precio = scanner.nextDouble();
                    scanner.nextLine(); // Consumir nueva línea
                } catch (InputMismatchException e) {
                    scanner.nextLine(); // Limpiar el buffer
                    throw new ProductoNoCreadoException("El precio debe ser un número.");
                }

                System.out.println("Ingrese la fecha de caducidad (yyyy-MM-dd):");
                String fechaCaducidadStr = scanner.nextLine();
                LocalDate fechaCaducidad;
                try {
                    fechaCaducidad = LocalDate.parse(fechaCaducidadStr, formatter);
                } catch (DateTimeParseException e) {
                    throw new ProductoNoCreadoException("Formato de fecha no válido. Use yyyy-MM-dd.");
                }

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el tipo de bebida:");
                        String tipoDeBebida = scanner.nextLine();
                        if (tipoDeBebida.isEmpty()) {
                            throw new ProductoNoCreadoException("El tipo de bebida no puede estar vacío.");
                        }

                        System.out.println("Ingrese las calorías de la bebida:");
                        int caloriasBebida;
                        try {
                            caloriasBebida = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } catch (InputMismatchException e) {
                            scanner.nextLine(); // Limpiar el buffer
                            throw new ProductoNoCreadoException("Las calorías deben ser un número entero.");
                        }

                        Bebida bebida = new Bebida(nombre, precio, fechaCaducidad, tipoDeBebida, caloriasBebida);
                        productos.add(bebida);
                        break;

                    case 2:
                        System.out.println("Ingrese el tipo de carne:");
                        String tipoDeCarne = scanner.nextLine();
                        if (tipoDeCarne.isEmpty()) {
                            throw new ProductoNoCreadoException("El tipo de carne no puede estar vacío.");
                        }

                        System.out.println("Ingrese las calorías de la carne:");
                        int caloriasCarne;
                        try {
                            caloriasCarne = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } catch (InputMismatchException e) {
                            scanner.nextLine(); // Limpiar el buffer
                            throw new ProductoNoCreadoException("Las calorías deben ser un número entero.");
                        }

                        Carne carne = new Carne(nombre, precio, fechaCaducidad, tipoDeCarne, caloriasCarne);
                        // Aplicar descuento si la caducidad es en 2 días o menos
                        if (fechaCaducidad.isBefore(LocalDate.now().plusDays(3))) {
                            carne.aplicarDescuentos(20);
                        }
                        productos.add(carne);
                        break;

                    case 3:
                        System.out.println("Ingrese el tipo de producto de limpieza:");
                        String tipoProductoLimpieza = scanner.nextLine();
                        if (tipoProductoLimpieza.isEmpty()) {
                            throw new ProductoNoCreadoException("El tipo de producto de limpieza no puede estar vacío.");
                        }

                        ProductoLimpieza productoLimpieza = new ProductoLimpieza(nombre, precio, fechaCaducidad, tipoProductoLimpieza);
                        productos.add(productoLimpieza);
                        break;

                    default:
                        throw new ProductoNoCreadoException("Opción no válida. Intente de nuevo.");
                }

            } catch (ProductoNoCreadoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
            }
        }

        // Calcular y mostrar totales
        double totalAlimentos = 0.0;
        double totalNoAlimentos = 0.0;

        for (Producto producto : productos) {
            if (producto instanceof EsAlimento && ((EsAlimento) producto).esAlimento()) {
                totalAlimentos += producto.getPrecio();
            } else {
                totalNoAlimentos += producto.getPrecio();
            }
        }

        System.out.println("Costo total de los productos que son alimentos: " + totalAlimentos);
        System.out.println("Costo total de los productos que no son alimentos: " + totalNoAlimentos);

        scanner.close();
    }
}