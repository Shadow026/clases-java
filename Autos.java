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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hol33
 */
public class Autos {
    private String placa;
    private String modelo;
    private String marca;
    private String tipo;
    private int anioFabricacion;
    private PreparedStatement pstm;
    public String getPlaca() {
        return placa;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean getDispon(){
        return dispon;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public boolean isDispon() {
        return dispon;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

  
   

    public void setTarifaDiaria(double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }

    public void setDispon(boolean dispon) {
        this.dispon = dispon;
    }

    
   
    private double tarifaDiaria;
    private boolean dispon;

    private Clase_Conexion claseConexion;
    private java.sql.Connection conexioDB;
    
    private ArrayList<Autos> listaautos;

    public Autos() {
        this.claseConexion = new Clase_Conexion();
        this.listaautos = new ArrayList<Autos>();
    }
    public boolean agregarAuto(String placa, String modelo, String marca, String tipo, int fechaFabricacion, double tarifaDia, boolean disponibilidad) {
    try {
        // Establecer conexión a la base de datos
        conexioDB = claseConexion.iniciarConexion();
        
        // Definir la consulta SQL para la inserción
        String insertQuery = "INSERT INTO autos(placa, modelo, marca, tipo, anio_fabricacion, tarifa_dia, disponible) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        // Preparar la declaración SQL usando un PreparedStatement para evitar la inyección de SQL
        pstm = conexioDB.prepareStatement(insertQuery);
        
        // Establecer los parámetros del automóvil en la declaración preparada
        pstm.setString(1, placa);
        pstm.setString(2, modelo);
        pstm.setString(3, marca);
        pstm.setString(4, tipo); 
        pstm.setInt(5, fechaFabricacion);
        pstm.setDouble(6, tarifaDia);
        pstm.setBoolean(7, disponibilidad);
        
        // Ejecutar la consulta y obtener el número de filas afectadas
        int rowsAffected = pstm.executeUpdate();
        
        // Devolver true si al menos una fila fue afectada, indicando una inserción exitosa
        return rowsAffected > 0;
        
    } catch (SQLException ex) {
        // Manejar excepciones SQL, registrando información detallada
        Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            // Cerrar recursos (PreparedStatement y conexión) en el bloque finally
            if (pstm != null) {
                pstm.close();
            }
            if (conexioDB != null) {
                conexioDB.close();
            }
        } catch (SQLException ex) {
            // Manejar excepciones al cerrar recursos, registrando información detallada
            Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Devolver false en caso de cualquier error o fallo
    return false;
}

   public ArrayList<Autos> obtenerAutos() {
    // Limpiar la lista antes de obtener nuevos autos para evitar duplicados
    listaautos.clear();

    // Establecer conexión a la base de datos
    conexioDB = claseConexion.iniciarConexion();
    String selectQuery = "SELECT placa, modelo, marca, tipo, anio_fabricacion, tarifa_dia, disponible FROM autos";

    try {
        // Preparar la declaración SQL para la consulta SELECT
        pstm = conexioDB.prepareStatement(selectQuery);
        
        // Ejecutar la consulta y obtener el conjunto de resultados
        ResultSet resultSet = pstm.executeQuery();

        // Procesar cada fila en el conjunto de resultados
        while (resultSet.next()) {
            // Crear un objeto Autos para almacenar la información de cada automóvil
            Autos auto = new Autos();
            
            // Establecer los atributos del automóvil utilizando los datos del conjunto de resultados
            auto.setPlaca(resultSet.getString("placa"));
            auto.setModelo(resultSet.getString("modelo"));
            auto.setMarca(resultSet.getString("marca"));
            auto.setTipo(resultSet.getString("tipo"));
            auto.setAnioFabricacion(resultSet.getInt("anio_fabricacion"));
            auto.setTarifaDiaria(resultSet.getDouble("tarifa_dia"));
            auto.setDispon(resultSet.getBoolean("disponible"));
            
            // Agregar el objeto Autos a la lista
            listaautos.add(auto);
        }
    } catch (SQLException ex) {
        // Manejar excepciones SQL, registrando información detallada
        Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            // Cerrar recursos (PreparedStatement y conexión) en el bloque finally
            if (pstm != null) {
                pstm.close();
            }
            if (conexioDB != null) {
                conexioDB.close();
            }
        } catch (SQLException ex) {
            // Manejar excepciones al cerrar recursos, registrando información detallada
            Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Devolver la lista de autos después de completar la operación
    return listaautos;
}
    
    
    public ArrayList<Autos> buscarAutos(String placa, String tipo) {
    // Limpiar la lista antes de realizar una nueva búsqueda para evitar duplicados
    listaautos.clear();

    // Establecer conexión a la base de datos
    conexioDB = claseConexion.iniciarConexion();
    
    // Construir la consulta SQL con un StringBuilder
    StringBuilder selectQuery = new StringBuilder("SELECT placa, modelo, marca, tipo, anio_fabricacion, tarifa_dia, disponible FROM autos WHERE 1=1");

    // Agregar condiciones a la consulta SQL según los parámetros proporcionados
    if (placa != null && !placa.isEmpty()) {
        selectQuery.append(" AND placa = ?");
    }

    if (tipo != null && !tipo.isEmpty()) {
        selectQuery.append(" AND tipo = ?");
    }

    try {
        // Preparar la declaración SQL con la consulta construida
        pstm = conexioDB.prepareStatement(selectQuery.toString());

        // Establecer valores de parámetros según las condiciones
        int parameterIndex = 1;

        if (placa != null && !placa.isEmpty()) {
            pstm.setString(parameterIndex++, placa);
        }

        if (tipo != null && !tipo.isEmpty()) {
            pstm.setString(parameterIndex, tipo);
        }

        // Ejecutar la consulta y obtener el conjunto de resultados
        ResultSet resultSet = pstm.executeQuery();

        // Procesar cada fila en el conjunto de resultados
        while (resultSet.next()) {
            // Crear un objeto Autos para almacenar la información de cada automóvil
            Autos auto = new Autos();
            
            // Establecer los atributos del automóvil utilizando los datos del conjunto de resultados
            auto.setPlaca(resultSet.getString("placa"));
            auto.setModelo(resultSet.getString("modelo"));
            auto.setMarca(resultSet.getString("marca"));
            auto.setTipo(resultSet.getString("tipo"));
            auto.setAnioFabricacion(resultSet.getInt("anio_fabricacion"));
            auto.setTarifaDiaria(resultSet.getDouble("tarifa_dia"));
            auto.setDispon(resultSet.getBoolean("disponible"));
            
            // Agregar el objeto Autos a la lista
            listaautos.add(auto);
        }
    } catch (SQLException ex) {
        // Manejar excepciones SQL, registrando información detallada
        Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            // Cerrar recursos (PreparedStatement y conexión) en el bloque finally
            if (pstm != null) {
                pstm.close();
            }
            if (conexioDB != null) {
                conexioDB.close();
            }
        } catch (SQLException ex) {
            // Manejar excepciones al cerrar recursos, registrando información detallada
            Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Devolver la lista de autos después de completar la operación
    return listaautos;
}
    
    public int editarAuto(String placa, String modelo, String marca, String tipo, int fechaFabricacion, double tarifaDia, boolean disponibilidad) {
    try {
        // Definir la consulta SQL para actualizar un automóvil en la base de datos
        String sql = "UPDATE autos SET placa = ?, modelo = ?, marca = ?, tipo = ?, anio_fabricacion = ?, tarifa_dia = ?, disponible = ? WHERE placa = ?";
        
        // Establecer conexión a la base de datos
        this.conexioDB = this.claseConexion.iniciarConexion();
        
        // Preparar la declaración SQL con la consulta
        pstm = this.conexioDB.prepareStatement(sql);

        // Establecer los parámetros del automóvil en la declaración preparada
        pstm.setString(1, placa);
        pstm.setString(2, modelo);
        pstm.setString(3, marca);
        pstm.setString(4, tipo); 
        pstm.setInt(5, fechaFabricacion);
        pstm.setDouble(6, tarifaDia);
        pstm.setBoolean(7, disponibilidad);
        
        // Establecer el último parámetro para la condición WHERE
        pstm.setString(8, placa);

        // Ejecutar la actualización y obtener la cantidad de filas afectadas
        int respuesta = pstm.executeUpdate();

        // Devolver la cantidad de filas afectadas
        return respuesta;
    } catch (SQLException ex) {
        // Manejar excepciones SQL, registrando información detallada
        Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            // Cerrar recursos (PreparedStatement y conexión) en el bloque finally
            if (pstm != null) {
                pstm.close();
            }
            if (conexioDB != null) {
                conexioDB.close();
            }
        } catch (SQLException ex) {
            // Manejar excepciones al cerrar recursos, registrando información detallada
            Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Devolver 0 si no se pudo realizar la actualización
    return 0;
}

    
    // Método para eliminar un automóvil por su placa
public int eliminarAuto(String placa) {
    try {
        // Definir la consulta SQL para eliminar un automóvil de la base de datos
        String sql = "DELETE FROM autos WHERE placa = ?";
        
        // Establecer conexión a la base de datos
        this.conexioDB = this.claseConexion.iniciarConexion();
        
        // Preparar la declaración SQL con la consulta
        pstm = this.conexioDB.prepareStatement(sql);

        // Establecer el parámetro de la placa a eliminar
        pstm.setString(1, placa);

        // Ejecutar la eliminación y obtener la cantidad de filas afectadas
        int respuesta = pstm.executeUpdate();

        // Devolver la cantidad de filas afectadas
        return respuesta;
    } catch (SQLException ex) {
        // Manejar excepciones SQL, registrando información detallada
        Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            // Cerrar recursos (PreparedStatement y conexión) en el bloque finally
            if (pstm != null) {
                pstm.close();
            }
            if (conexioDB != null) {
                conexioDB.close();
            }
        } catch (SQLException ex) {
            // Manejar excepciones al cerrar recursos, registrando información detallada
            Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Devolver 0 si no se pudo realizar la eliminación
    return 0;
}

// Método para verificar si un automóvil está alquilado por su placa
public boolean autoEstaAlquilado(String placa) {
    try {
        // Definir la consulta SQL para contar los alquileres asociados a un auto
        String sql = "SELECT COUNT(*) FROM alquileres WHERE auto_id = (SELECT auto_id FROM autos WHERE placa = ?)";
        
        // Establecer conexión a la base de datos
        this.conexioDB = this.claseConexion.iniciarConexion();
        
        // Preparar la declaración SQL con la consulta
        pstm = this.conexioDB.prepareStatement(sql);

        // Establecer el parámetro de la placa del automóvil
        pstm.setString(1, placa);

        // Ejecutar la consulta y obtener el resultado
        ResultSet rs = pstm.executeQuery();

        // Verificar si hay al menos un alquiler asociado al auto
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Si count > 0, el auto está alquilado
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de errores: imprime la excepción, puedes modificar esto según tus necesidades
    } finally {
        // Cierre de recursos
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conexioDB != null) {
                conexioDB.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Manejo de errores: imprime la excepción, puedes modificar esto según tus necesidades
        }
    }

    // En caso de error, asumimos que el auto no está alquilado
    return false;
}

    public int eliminarRegistrosRelacionados(String placa) {
    try {
        // Antes de eliminar el auto, eliminemos los registros relacionados en la tabla de alquileres
        String sqlDeleteAlquileres = "DELETE FROM alquileres WHERE auto_id = (SELECT auto_id FROM autos WHERE placa = ?)";
        this.conexioDB = this.claseConexion.iniciarConexion();
        pstm = this.conexioDB.prepareStatement(sqlDeleteAlquileres);

        pstm.setString(1, placa);

        int registrosEliminados = pstm.executeUpdate();

        return registrosEliminados;
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de errores: imprime la excepción, puedes modificar esto según tus necesidades
    } finally {
        // Cierre de recursos
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conexioDB != null) {
                conexioDB.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Manejo de errores: imprime la excepción, puedes modificar esto según tus necesidades
        }
    }

    return 0; // En caso de error, no se eliminaron registros
}
    // Método para obtener la tarifa diaria de un automóvil por su placa
public double obtenerTarifaDiaria(String placa) {
    double tarifaDiaria = 0.0;

    // Establecer conexión a la base de datos
    conexioDB = claseConexion.iniciarConexion();
    
    // Definir la consulta SQL para obtener la tarifa diaria de un automóvil
    String selectQuery = "SELECT tarifa_dia FROM autos WHERE placa = ?";

    try {
        // Preparar la declaración SQL con la consulta
        pstm = conexioDB.prepareStatement(selectQuery);
        
        // Establecer el parámetro de la placa del automóvil
        pstm.setString(1, placa);

        // Ejecutar la consulta y obtener el resultado
        ResultSet resultSet = pstm.executeQuery();

        // Verificar si se encontró la tarifa diaria en el resultado
        if (resultSet.next()) {
            tarifaDiaria = resultSet.getDouble("tarifa_dia");
        }
    } catch (SQLException ex) {
        // Manejar excepciones SQL, registrando información detallada
        Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            // Cerrar recursos (PreparedStatement y conexión) en el bloque finally
            if (pstm != null) {
                pstm.close();
            }
            if (conexioDB != null) {
                conexioDB.close();
            }
        } catch (SQLException ex) {
            // Manejar excepciones al cerrar recursos, registrando información detallada
            Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Devolver la tarifa diaria obtenida
    return tarifaDiaria;
}

}
