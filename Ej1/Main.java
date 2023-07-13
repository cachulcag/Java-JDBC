/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ej1;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
        Services servicio = new Services();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int var;

        System.out.println("BIENVENIDO A AMAZON BEST BUY ");

        do {
            System.out.println("QUE DESEA REALIZAR?");
            System.out.println("1. Listar todos los productos ");
            System.out.println("2. Listar el nombre y el precio de los productos");
            System.out.println("3. Listar los productos que esten entre un precio deseado");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Ver el producto con menor costo");
            System.out.println("6. Ingresar un nuevo producto");
            System.out.println("7. Ingrese un nuevo fabricante");
            System.out.println("8. Modificar Producto");
            System.out.println("9. Salir");

            try {
                var = leer.nextInt();
            } catch (Exception e) {
                var = 0;
                System.out.println("Debes ingresar un número");
            }

            switch (var) {
                case 1:
                    servicio.nombreProductos();
                    break;
                case 2:
                    servicio.nombrePrecioProductos();
                    break;
                case 3:
                    servicio.buscarPrecioEntre();
                    break;
                case 4:
                    servicio.buscarNombre();
                    break;
                case 5:
                    servicio.productoMásBarato();
                    break;
                case 6:
                    servicio.ingresarProducto();
                    break;
                case 7:
                    servicio.ingrsarFabricante();
                    break;
                case 8:
                    servicio.modificarProducto();
                    break;
                case 9:
                    System.out.println("Gracias Por Preferirnos!!");
                    break;

                default:
                    System.out.println("Debes ingresar la opcion del 1 al 8");
                    break;
            }

        } while (var != 9);

    }

}
