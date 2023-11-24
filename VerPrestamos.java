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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hol33
 */
public class VerPrestamos {
    private String nombrecliente;
    private String username;
    private String modelo;
    private String marca;
    private String placa;
    private Date fechainicio;
    private Date fechaentrega;
    private double costoTotal;
   
    private PreparedStatement pstm;
    private Clase_Conexion claseConexion;
    private java.sql.Connection conexioDB;

    public String getNombrecliente() {
        return nombrecliente;
    }

    public String getUsername() {
        return username;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    

   
    
    private ArrayList<VerPrestamos> listaPrestamos;

    

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }


    public Date getFechainicio() {
        return fechainicio;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public VerPrestamos() {
        this.claseConexion = new Clase_Conexion();
        this.listaPrestamos = new ArrayList<VerPrestamos>();
    }
    
    // Método para obtener la lista de alquileres
    public ArrayList<VerPrestamos> obtenerAlquiler() {
        listaPrestamos.clear();

        conexioDB = claseConexion.iniciarConexion();
        String selectQuery = "SELECT c.nombre AS nombre, c.username, a.modelo, a.marca, a.placa, al.fecha_inicio, al.fecha_finalizacion, al.costo_total "
                + "FROM alquileres al "
                + "INNER JOIN clientes c ON al.cliente_id = c.cliente_id "
                + "INNER JOIN autos a ON al.auto_id = a.auto_id";

        try {
            pstm = conexioDB.prepareStatement(selectQuery);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                VerPrestamos prestamo = new VerPrestamos();
                prestamo.setUsername(resultSet.getString("username"));
                prestamo.setNombrecliente(resultSet.getString("nombre"));
                prestamo.setModelo(resultSet.getString("modelo"));
                prestamo.setMarca(resultSet.getString("marca"));
                prestamo.setPlaca(resultSet.getString("placa"));
                prestamo.setFechainicio(resultSet.getDate("fecha_inicio"));
                prestamo.setFechaentrega(resultSet.getDate("fecha_finalizacion"));
                prestamo.setCostoTotal(resultSet.getDouble("costo_total"));

                listaPrestamos.add(prestamo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar recursos
            cerrarRecursos();
        }
        return listaPrestamos;
    }

    // Método para realizar un alquiler
    public boolean realizarAlquiler() {
        conexioDB = claseConexion.iniciarConexion();

        // Modificado para obtener el ID del cliente por nombre de usuario
        String insertQuery = "INSERT INTO alquileres (cliente_id, auto_id, fecha_inicio, fecha_finalizacion, costo_total) "
                + "VALUES (?, (SELECT auto_id FROM autos WHERE placa = ?), ?, ?, ?)";

        try {
            // Obtener el ID del cliente
            int idCliente = obtenerIdClientePorUsername(username);

            // Preparar la inserción en la tabla de alquileres
            pstm = conexioDB.prepareStatement(insertQuery);
            pstm.setInt(1, idCliente);
            pstm.setString(2, placa);
            pstm.setDate(3, new java.sql.Date(fechainicio != null ? fechainicio.getTime() : System.currentTimeMillis()));
            pstm.setDate(4, new java.sql.Date(fechaentrega != null ? fechaentrega.getTime() : System.currentTimeMillis()));
            pstm.setDouble(5, costoTotal);

            int filasAfectadas = pstm.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            Logger.getLogger(VerPrestamos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            // Cerrar recursos
            cerrarRecursos();
        }
    }

    // Método para obtener la lista de alquileres por username
    public ArrayList<VerPrestamos> obtenerPrestamosPorUsername(String username) {
        listaPrestamos.clear();

        conexioDB = claseConexion.iniciarConexion();
        String selectQuery = "SELECT c.nombre AS nombre, c.username, a.modelo, a.marca, a.placa, al.fecha_inicio, al.fecha_finalizacion, al.costo_total "
                + "FROM alquileres al "
                + "INNER JOIN clientes c ON al.cliente_id = c.cliente_id "
                + "INNER JOIN autos a ON al.auto_id = a.auto_id "
                + "WHERE c.username = ?";

        try {
            pstm = conexioDB.prepareStatement(selectQuery);
            pstm.setString(1, username); // Establecer el parámetro de nombre de usuario
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                VerPrestamos prestamo = new VerPrestamos();
                prestamo.setUsername(resultSet.getString("username"));
                prestamo.setNombrecliente(resultSet.getString("nombre"));
                prestamo.setModelo(resultSet.getString("modelo"));
                prestamo.setMarca(resultSet.getString("marca"));
                prestamo.setPlaca(resultSet.getString("placa"));
                prestamo.setFechainicio(resultSet.getDate("fecha_inicio"));
                prestamo.setFechaentrega(resultSet.getDate("fecha_finalizacion"));
                prestamo.setCostoTotal(resultSet.getDouble("costo_total"));

                listaPrestamos.add(prestamo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar recursos
            cerrarRecursos();
        }
        return listaPrestamos;
    }

    // Método para eliminar datos por placa
    public boolean eliminarDatosPorPlaca(String placa) {
        conexioDB = claseConexion.iniciarConexion();
        String deleteQuery = "DELETE FROM alquileres WHERE auto_id IN (SELECT auto_id FROM autos WHERE placa = ?)";

        try {
            pstm = conexioDB.prepareStatement(deleteQuery);
            pstm.setString(1, placa);

            int filasAfectadas = pstm.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException ex) {
            Logger.getLogger(VerPrestamos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            // Cerrar recursos
            cerrarRecursos();
        }
    }

    // Método privado para obtener el ID del cliente por nombre de usuario
    private int obtenerIdClientePorUsername(String username) throws SQLException {
        // Consulta a la base de datos para obtener el ID del cliente por nombre de usuario
        String obtenerIdClienteQuery = "SELECT cliente_id FROM clientes WHERE username = ?";

        try (PreparedStatement pst = conexioDB.prepareStatement(obtenerIdClienteQuery)) {
            pst.setString(1, username);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("cliente_id");
                }
            }
        }

        throw new SQLException("No se encontró el ID del cliente para el username: " + username);
    }

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
            Logger.getLogger(VerPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
