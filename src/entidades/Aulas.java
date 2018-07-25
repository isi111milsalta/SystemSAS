/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Conexion.ConexionBase;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Aulas {
    private int idAula;
    private String nombreaula;
    private int capacidad;
    private String estado;

    public Aulas(int idAula) {
        this.idAula = idAula;
    }
    

    public Aulas(String nombreaula, int capacidad, String estado) {
        this.nombreaula = nombreaula;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Aulas(int idAula, String nombreaula, int capacidad, String estado) {
        this.idAula = idAula;
        this.nombreaula = nombreaula;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getIdaula() {
        return idAula;
    }

    public void setIdaula(int idAula) {
        this.idAula = idAula;
    }

    public String getNombreaula() {
        return nombreaula;
    }

    public void setNombreaula(String nombreaula) {
        this.nombreaula = nombreaula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    protected PreparedStatement Ps;
    protected ResultSet Rs;
    public void RegistrarAula(){
        Connection base=ConexionBase.conexion;
        try {
            Ps = base.prepareStatement("INSERT INTO aula(nombreaula, capacidad, estado) VALUES(?,?,?)");
            Ps.setString(1, nombreaula);
            Ps.setInt(2, capacidad);
            Ps.setString(3, estado);
            Ps.executeUpdate();// se ejcuta la consulta SQL
            JOptionPane.showMessageDialog(null, "Aula registrada");
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e, "Error al registrar Aula",1);
        }
    }
    public void ModificarAula(){
        Connection base=ConexionBase.conexion;
        try{
            Ps = base.prepareStatement("UPDATE aula SET nombreaula=?, capacidad=?, estado=? WHERE idAula=" + this.idAula);
            Ps.setString(1, nombreaula);
            Ps.setInt(2, capacidad);
            Ps.setString(3, estado);
            Ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aula modificada");
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e, "Error al modificar Aula",1);
        }
    }
    public void EliminarAula(){
        Connection base=ConexionBase.conexion;
        try{
            Ps = base.prepareStatement("DELETE FROM aula WHERE idAula=?");
            Ps.setInt(1, idAula);
            Ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aula eliminada");
        } catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e, "Error al eliminar Aula",1);
        }
    }
        
    }
