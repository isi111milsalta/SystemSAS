/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import Conexion.ConexionBase;

/**
 *
 * @author Usuario
 */
public class Usuario {
    private int idusuario;
    private String usuario;
    private String clave;
    private String tipoUsu;

    public Usuario(String usuario, String clave, String tipoUsu) {
        this.usuario = usuario;
        this.clave = clave;
        this.tipoUsu = tipoUsu;
    }

    public Usuario(String usu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(String tipoUsu) {
        this.tipoUsu = tipoUsu;
    }
    
}
