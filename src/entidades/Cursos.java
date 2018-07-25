/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import Conexion.ConexionBase;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Usuario
 */
public class Cursos {
    int idCursos;
    String nombrecurso;
    int idperiodolectivo;
    ConexionBase con= new ConexionBase(); 
    public Cursos(String nombre, int idperiodo) {
        this.nombrecurso = nombre;
        this.idperiodolectivo= idperiodo;
    }

    public Cursos(int idCursos, String nombrecurso, int idperiodolectivo) {
        this.idCursos = idCursos;
        this.nombrecurso = nombrecurso;
        this.idperiodolectivo = idperiodolectivo;
    }

    public Cursos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(int idCursos) {
        this.idCursos = idCursos;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public int getIdperiodolectivo() {
        return idperiodolectivo;
    }

    public void setIdperiodolectivo(int idperiodolectivo) {
        this.idperiodolectivo = idperiodolectivo;
    }
    public void registrarCurso(){
         
        try {
            Connection base=con.getConection();
            
            PreparedStatement valores=base.prepareStatement("INSERT INTO cursos (idCursos, nombrecurso, idperiodolectivo)"
                    + " VALUES (?,?,?)");
            valores.setInt(1,idCursos);
            valores.setString(2,nombrecurso);
            valores.setInt(3,idperiodolectivo);
            valores.executeUpdate();
             JOptionPane.showMessageDialog(null,"Se registro el curso con exito");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);;
        }
        
        
    }
    public void modificarCurso(){
      try{
        Connection base=con.getConection();
        PreparedStatement consulta=base.prepareStatement("call ModificarCurso(?,?,?)" );
        consulta.setInt(1,idCursos);
        consulta.setString(2,nombrecurso);
        consulta.setInt(3,idperiodolectivo);
        consulta.executeUpdate();
        JOptionPane.showMessageDialog(null,"Se registro Modificación del curso con exito");
      } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
    }

 
   
}
