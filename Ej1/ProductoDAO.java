/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author crist
 */
public final class ProductoDAO extends DAO {

    private Collection<Producto> productos = new ArrayList();
    private Producto producto = null;

    protected void insertarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debes seleccionar un producto");
            }
            String sql = "INSERT INTO producto VALUES (" + producto.getCodigo() + ", '" + producto.getNombre() + "', " + producto.getPrecio() + ", " + producto.getCodigoFabricante() + ")";  //NO SE PERMITE INGRESAR EL CODIGO PORQUE LA BD LOS GENERA POR UNSIGNED AUTO_INCREMENT PRIMARY KEY
            Update(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    protected void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debes seleccionar un producto");
            }
            String sql = "UPDATE producto SET nombre = '" + producto.getNombre() + "', precio = '" + producto.getPrecio() + "', codigo_fabricante = '" + producto.getCodigoFabricante() + "' WHERE codigo = '" + producto.getCodigo() + "'";
            Update(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    protected void eliminarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debes seleccionar un producto");
            }
            String sql = "DELETE FROM producto WHERE codigo = '" + producto.getCodigo() + "'";
            Update(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    protected void nombre() throws SQLException {

        try {
            Qwerty("SELECT nombre FROM producto");

            while (rs.next()) {
                producto = new Producto();
                producto.setNombre(rs.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            mostrarArrayList();

        } catch (SQLException e) {
            desconectarBase();
            throw e;
        }

    }

    protected void nombrePrecio() throws SQLException {
        try {
            Qwerty("SELECT nombre, precio FROM producto");

            while (rs.next()) {
                producto = new Producto();
                producto.setNombre(rs.getString(1));
                producto.setPrecio(rs.getFloat(2));
                productos.add(producto);
            }
            desconectarBase();
            mostrarArrayList();

        } catch (SQLException e) {
            desconectarBase();
            throw e;
        }
    }

    protected void buscarPorPrecio(int valor1, int valor2) throws SQLException {
        try {

            Qwerty("SELECT nombre, precio FROM producto WHERE precio BETWEEN " + valor1 + " AND " + valor2 + " ORDER BY precio");

            while (rs.next()) {
                producto = new Producto();
                producto.setNombre(rs.getString(1));
                producto.setPrecio(rs.getFloat(2));
                productos.add(producto);
            }
            desconectarBase();
            mostrarArrayList();

        } catch (SQLException e) {
            desconectarBase();
            throw e;
        }
    }

    protected void buscarPorNombre(String nombre) throws SQLException {
        try {
            Qwerty("SELECT * FROM producto WHERE nombre LIKE '%" + nombre + "%'");

            while (rs.next()) {
                producto = new Producto();
                producto.setCodigo(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getFloat(3));
                producto.setCodigoFabricante(rs.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            mostrarArrayList();

        } catch (SQLException e) {
            desconectarBase();
            throw e;
        }
    }

    protected void precioMinimo() throws SQLException {
        try {
            Qwerty("SELECT * FROM producto ORDER BY precio ASC LIMIT 1");

            while (rs.next()) {
                producto = new Producto();
                producto.setCodigo(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getFloat(3));
                producto.setCodigoFabricante(rs.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            mostrarArrayList();

        } catch (SQLException e) {
            desconectarBase();
            throw e;
        }
    }

    private void mostrarArrayList() {
        productos.forEach(i -> System.out.println(i.toString()));
        productos.clear();
    }
}
