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

    void insert(EntidadBancaria entidadBancaria) {
    }

    void update(EntidadBancaria entidadBancaria) {
    }

    void delete(int idEntidadBancaria) {
    }

    List<EntidadBancaria> findAll() {
        return null;
    }

    List<EntidadBancaria> findByCodigo(String codigo) {
        return null;
    }
}
