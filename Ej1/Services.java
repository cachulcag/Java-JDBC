/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej1;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Services {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private ProductoDAO productoDAO = new ProductoDAO();
    private Producto producto = null;
    private FabricanteDAO fabricanteDAO = new FabricanteDAO();
    private Fabricante fabricante = null;

    protected void nombreProductos() throws SQLException {
        productoDAO.nombre();
    }

    protected void nombrePrecioProductos() throws SQLException {
        productoDAO.nombrePrecio();
    }

    protected void buscarPrecioEntre() throws Exception {
        int valor1 = 0;
        int valor2 = 0;
        while (true)
            try {
            System.out.println("Ingrese la cantidad mínima");
            valor1 = leer.nextInt();
            System.out.println("Ingrese la cantidad máxima");
            valor2 = leer.nextInt();

            if (valor1 < valor2) {
                productoDAO.buscarPorPrecio(valor1, valor2);
                break;
            } else {
                System.out.println("El primer valor debe ser menor");
            }
        } catch (InputMismatchException e) {
            System.out.println("Solo puedes ingresar números");
            leer.next();
            //leer.next();

        }

    }

    protected void buscarNombre() throws SQLException {
        System.out.println("Ingrese tu criterio de búsqueda");
        productoDAO.buscarPorNombre(leer.next());
    }

    protected void productoMásBarato() throws SQLException {
        productoDAO.precioMinimo();
    }

    protected void ingresarProducto() throws Exception {
        producto = new Producto();

        System.out.println("Ingrese los datos del Producto");
        System.out.println("Ingrese el nombre");
        producto.setNombre(leer.next());

        while (true) {
            try {
                System.out.println("Ingrese el precio");
                producto.setPrecio(leer.nextFloat());
                System.out.println("Ingrese el código del fabricante");
                producto.setCodigoFabricante(leer.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar solo números, si es decimal; con ','");
                leer.next();
            }
        }
        productoDAO.insertarProducto(producto);
    }

    protected void ingrsarFabricante() throws Exception {
        fabricante = new Fabricante();
        System.out.println("Ingrese los datos del Fabricante");
        System.out.println("ingrese el nombre del fabricante");
        fabricante.setNombre(leer.next());
        fabricanteDAO.ingresarFabricante(fabricante);
    }

    protected void modificarProducto() throws Exception {
        producto = new Producto();

        while (true) {
            try {
                System.out.println("Que producto desea modificar? Ingrese su código ");
                producto.setCodigo(leer.nextInt());
                System.out.println("Ingrese el nuevo nombre");
                producto.setNombre(leer.next());
                System.out.println("Ingrese el nuevo precio");
                producto.setPrecio(leer.nextFloat());
                System.out.println("Ingrese el código del nuevo fabricante");
                producto.setCodigoFabricante(leer.nextInt());
                break;
            } catch (Exception e) {
                System.out.println("Debes ingresar solo números, si es decimal; usa la ','");
                leer.next();
            }
        }
        productoDAO.modificarProducto(producto);
    }
}
