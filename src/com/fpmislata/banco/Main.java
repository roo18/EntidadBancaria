/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco;

import java.math.BigDecimal;

/**
 *
 * @author alumno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntidadBancaria entidadBancaria1 = new EntidadBancaria(1, "E10", "Bankia","C10203040",TipoEntidadBancaria.BANCO);
        EntidadBancaria entidadBancaria2 = new EntidadBancaria(2, "E10", "La Caixa","B10453040",TipoEntidadBancaria.BANCO);
        
        SucursalBancaria sucursalBancaria1 = new SucursalBancaria(1,entidadBancaria1,"S10","Bankia-Quart");
            entidadBancaria1.getSucursalesBancarias().add(sucursalBancaria1);
        SucursalBancaria sucursalBancaria2 = new SucursalBancaria(2,entidadBancaria1,"S20","Bankia-Manises");
            entidadBancaria1.getSucursalesBancarias().add(sucursalBancaria2);
        SucursalBancaria sucursalBancaria3 = new SucursalBancaria(3,entidadBancaria2,"S30","Caixa-Manises");
            entidadBancaria2.getSucursalesBancarias().add(sucursalBancaria3);
   
        
        CuentaBancaria cuentaBancaria1 = new CuentaBancaria(1, sucursalBancaria1, "1122548", "27", new BigDecimal("100.2"), "48587160M");
            sucursalBancaria1.getCuentasBancarias().add(cuentaBancaria1);
        CuentaBancaria cuentaBancaria2 = new CuentaBancaria(2, sucursalBancaria1, "1897548", "27", new BigDecimal("500.75"), "48707160M");
            sucursalBancaria1.getCuentasBancarias().add(cuentaBancaria2);
        CuentaBancaria cuentaBancaria3 = new CuentaBancaria(3, sucursalBancaria2, "1122548", "80", new BigDecimal("100.2"), "48587160M");
            sucursalBancaria2.getCuentasBancarias().add(cuentaBancaria3);
            
        MovimientoBancario movimientoBancario1 = new MovimientoBancario(1, TipoMovimientoBancario.DEBE, new BigDecimal("5.10"), null, new BigDecimal("94.7"), "Factura", cuentaBancaria1);
            cuentaBancaria1.getMovimientosBancarios().add(movimientoBancario1);
        MovimientoBancario movimientoBancario2 = new MovimientoBancario(2, TipoMovimientoBancario.DEBE, new BigDecimal("4.7"), null, new BigDecimal("90.0"), "Factura", cuentaBancaria1);
            cuentaBancaria1.getMovimientosBancarios().add(movimientoBancario2);
    }
}
