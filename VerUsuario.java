/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Conexion.Clase_Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hol33
 */
public class VerUsuario {
    private String usuarioActual;

    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public String getUsuarioActual() {
        return usuarioActual;
    }
    private int id;
    private String Nombre;
    private String direccion;
    private String telefono;
    private String Email;
    private PreparedStatement pstm;
    private String username;
    private String contraseña;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return Email;
    }


    public String getUsername() {
        return username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    

    private Clase_Conexion claseConexion;
    private java.sql.Connection conexioDB;
    
    private ArrayList<VerUsuario> listaUsuarios;

    public VerUsuario() {
        this.claseConexion = new Clase_Conexion();
        this.listaUsuarios = new ArrayList<VerUsuario>();
    }
    
   public ArrayList<VerUsuario> obtenerUsuarios() {
        listaUsuarios.clear();
        conexioDB = claseConexion.iniciarConexion();
        String selectQuery = "SELECT cliente_id, nombre, direccion, telefono, email, username,contrasena FROM clientes";

        try {
            pstm = conexioDB.prepareStatement(selectQuery);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                VerUsuario usuario = new VerUsuario();
                usuario.setId(resultSet.getInt("cliente_id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setDireccion(resultSet.getString("direccion"));
                usuario.setTelefono(resultSet.getString("telefono"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setUsername(resultSet.getString("username"));
                usuario.setContraseña(resultSet.getString("contrasena"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar recursos
            cerrarRecursos();
        }
        return listaUsuarios;
    }

    // Método para insertar un nuevo usuario
    public boolean insertarUsuario(VerUsuario usuario) {
        conexioDB = claseConexion.iniciarConexion();
        String insertQuery = "INSERT INTO clientes (nombre, direccion, telefono, email, username, contrasena) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            pstm = conexioDB.prepareStatement(insertQuery);
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getDireccion());
            pstm.setString(3, usuario.getTelefono());
            pstm.setString(4, usuario.getEmail());
            pstm.setString(5, usuario.getUsername());
            pstm.setString(6, usuario.getContraseña());

            int filasAfectadas = pstm.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            Logger.getLogger(VerUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            // Cerrar recursos
            cerrarRecursos();
        }
    }

    // Métodos de acceso adicionales (getters y setters)
    // ...

    // Método privado para cerrar recursos (PreparedStatement y conexión)
    private void cerrarRecursos() {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conexioDB != null) {
                conexioDB.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
