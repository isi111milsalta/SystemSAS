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
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author acinz
 */
public class Turnos {
    int idturno;
    String nombreturno;
    Time horainicio;
    Time horafin;

    public Turnos(int idturno) {
        this.idturno = idturno;
    }
    

    public Turnos(String nombreturno, Time horainicio, Time horafin) {
        this.nombreturno = nombreturno;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public Turnos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public String getNombreturno() {
        return nombreturno;
    }

    public void setNombreturno(String nombreturno) {
        this.nombreturno = nombreturno;
    }

    public Time getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Time horainicio) {
        this.horainicio = horainicio;
    }

    public Time getHorafin() {
        return horafin;
    }

    public void setHorafin(Time horafin) {
        this.horafin = horafin;
    }
     protected PreparedStatement Ps;
    protected ResultSet Rs;
    public void RegistrarTurno(){
        Connection base=ConexionBase.conexion;
        try {
            Ps = base.prepareStatement("INSERT INTO turnos(nombreturno, horainicio, horafin) VALUES(?,?,?)");
            Ps.setString(1,nombreturno );
            Ps.setTime(2,horainicio );
            Ps.setTime(3,horafin );
            Ps.executeUpdate();// se ejcuta la consulta SQL
            JOptionPane.showMessageDialog(null, "turno registrado");
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e, "Error al registrar turno",1);
        }
    }
        public void EliminarTurno(){
        Connection base=ConexionBase.conexion;
        try{
            Ps = base.prepareStatement("DELETE FROM turnos WHERE idTurno=?");
            Ps.setInt(1, idturno);
            Ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "turno eliminado");
        } catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e, "Error al eliminar turno",1);
        }
}
}
