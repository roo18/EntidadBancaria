/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAO {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public EntidadBancariaDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco", "banco", "banco");

    }

    EntidadBancaria read(int idEntidadBancaria) throws SQLException {
        EntidadBancaria entidadBancaria;

        String selectSQL = "SELECT idEntidad, codigoEntidad, nombre, cif, tipoEntidadBancaria FROM entidadbancaria WHERE idEntidad = ?";
        preparedStatement = connection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, idEntidadBancaria);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next() == true) {
            entidadBancaria = new EntidadBancaria();
            entidadBancaria.setIdEntidad(resultSet.getInt("idEntidad"));
            entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
            entidadBancaria.setNombre(resultSet.getString("nombre"));
            entidadBancaria.setCif(resultSet.getString("cif"));
            String tipoEntidadBancaria = resultSet.getString("tipoEntidadBancaria");
            entidadBancaria.setEntidad(TipoEntidadBancaria.valueOf(tipoEntidadBancaria));

            if (resultSet.next() == true) {
                throw new RuntimeException("Existe mas de una entidad bancaria " + idEntidadBancaria);
            }
        } else {
            //Devuelve null si no existe la entidad.
            entidadBancaria = null;
        }

        return entidadBancaria;
    }

    void insert(EntidadBancaria entidadBancaria) throws SQLException {
        String insertTableSQL = "INSERT INTO entidadbancaria"
                + "(idEntidad, codigoEntidad, nombre, cif, tipoEntidadBancaria) VALUES"
                + "(?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, entidadBancaria.getIdEntidad());
        preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
        preparedStatement.setString(3, entidadBancaria.getNombre());
        preparedStatement.setString(4, entidadBancaria.getCif());
        preparedStatement.setString(5, entidadBancaria.getEntidad().toString());
        preparedStatement.executeUpdate();
    }

    void update(EntidadBancaria entidadBancaria) throws SQLException {
        String updateTableSQL = "UPDATE entidadBancaria SET codigoEntidad = ?, nombre = ? , cif= ?, tipoEntidadBancaria = ? WHERE idEntidad = ?";
        preparedStatement = connection.prepareStatement(updateTableSQL);
        preparedStatement.setString(1, entidadBancaria.getCodigoEntidad());
        preparedStatement.setString(2, entidadBancaria.getNombre());
        preparedStatement.setString(3, entidadBancaria.getCif());
        preparedStatement.setString(4, entidadBancaria.getEntidad().toString());
        preparedStatement.setInt(5, entidadBancaria.getIdEntidad());

        preparedStatement.executeUpdate();

    }

    void delete(int idEntidadBancaria) throws SQLException {
        String deleteSQL = "DELETE FROM entidadbancaria WHERE idEntidad = ?";
        preparedStatement = connection.prepareStatement(deleteSQL);
        preparedStatement.setInt(1, idEntidadBancaria);
        int lineasActualizadas = preparedStatement.executeUpdate();

        if (lineasActualizadas > 1) {
             throw new RuntimeException("Se han borrado mas de un registro de la entidad: " + idEntidadBancaria);
        } 

    }

    List<EntidadBancaria> findAll() {
        return null;
    }

    List<EntidadBancaria> findByCodigo(String codigo) {
        return null;
    }
}
