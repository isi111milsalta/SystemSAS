package entidades;

import Conexion.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PlanEstudio {
    private int idPlan;
    private int idCarrera;
    private int anio;
    private int notaMin;
    private String estado;
    private int cantidadMaterias;
    ConexionBase cx=new ConexionBase();
        
    public PlanEstudio(){
    
    }
    public void getIdPlan(int idPlan){
        this.idPlan=idPlan;
    }
    public int setIdPlan(){
        return idPlan;
    }
    public void getIdCarrera(int idCarrera){
        this.idCarrera=idCarrera;
    }
    public int setIdCarrera(){
        return idCarrera;
    }
    public void getAnio(int anio){
        this.anio=anio;
    }
    public int setAnio(){
        return anio;
    }
    public void getNotaMin(int notaMin){
        this.notaMin=notaMin;
    }
    public int setNotaMin(){
        return notaMin;
    }
    public void getEstado(String estado){
        this.estado=estado;
    }
    public String setEstado(){
        return estado;
    }
    public void getCantidadMaterias(int cantidadMaterias){
        this.cantidadMaterias=cantidadMaterias;
    }
    public int setCantidadMaterias(){
        return cantidadMaterias;
    }
    public void cargaPlan(){
        Connection base=cx.getConection();
        try{
            PreparedStatement valores=base.prepareStatement("INSERT INTO planestudio (idCarrera,año,estado,notaminima,cantidadMaterias) VALUES(?,?,?,?,?)");
            valores.setInt(1, this.idCarrera);
            valores.setInt(2,this.anio);
            valores.setString(3,this.estado);
            valores.setInt(4,this.notaMin);
            valores.setInt(5,this.cantidadMaterias);
            JOptionPane.showMessageDialog(null, "Carga exitosa");
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void actualizarPlan(){
        Connection base=cx.getConection();
        try{
            PreparedStatement valores=base.prepareStatement("UPDATE planestudio SET idCarrera=?,año=?,estado=?,notaminima=?,cantidadMaterias=? WHERE idPlanEstudio="+this.idPlan);
            valores.setInt(1, this.idCarrera);
            valores.setInt(2,this.anio);
            valores.setString(3,this.estado);
            valores.setInt(4,this.notaMin);
            valores.setInt(5,this.cantidadMaterias);
            valores.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualización exitosa");
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void eliminaPlan(){
        Connection base=cx.getConection();
        try {
            PreparedStatement valores=base.prepareStatement("DELETE FROM planestudios WHERE planestudio.idPlanEstudio='"+this.idPlan+"'");
            valores.executeUpdate();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
