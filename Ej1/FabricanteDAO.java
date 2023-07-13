/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej1;

import java.sql.SQLException;

/**
 *
 * @author crist
 */
public class FabricanteDAO extends DAO{

    private Fabricante fabricante;
    
    public void ingresarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("No se pueden ingresar datos vacios");
            }
            Update("INSERT INTO fabricante VALUES ("+fabricante.getCodigo()+", '"+fabricante.getNombre()+"')");
        } catch (SQLException e) {
            throw e;
        }
    }
    

}
