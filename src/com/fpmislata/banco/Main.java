/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        EntidadBancaria entidadBancaria1 = new EntidadBancaria(1, "E10", "Bankia", "C10203040", TipoEntidadBancaria.BANCO);
//        EntidadBancaria entidadBancaria2 = new EntidadBancaria(2, "E10", "La Caixa", "B10453040", TipoEntidadBancaria.BANCO);
//
//        SucursalBancaria sucursalBancaria1 = new SucursalBancaria(1, entidadBancaria1, "S10", "Bankia-Quart");
//        entidadBancaria1.getSucursalesBancarias().add(sucursalBancaria1);
//        SucursalBancaria sucursalBancaria2 = new SucursalBancaria(2, entidadBancaria1, "S20", "Bankia-Manises");
//        entidadBancaria1.getSucursalesBancarias().add(sucursalBancaria2);
//        SucursalBancaria sucursalBancaria3 = new SucursalBancaria(3, entidadBancaria2, "S30", "Caixa-Manises");
//        entidadBancaria2.getSucursalesBancarias().add(sucursalBancaria3);
//
//
//        CuentaBancaria cuentaBancaria1 = new CuentaBancaria(1, sucursalBancaria1, "1122548", "27", new BigDecimal("0.0"), "48587160M");
//        sucursalBancaria1.getCuentasBancarias().add(cuentaBancaria1);
//        CuentaBancaria cuentaBancaria2 = new CuentaBancaria(2, sucursalBancaria1, "1897548", "27", new BigDecimal("0.0"), "48707160M");
//        sucursalBancaria1.getCuentasBancarias().add(cuentaBancaria2);
//        CuentaBancaria cuentaBancaria3 = new CuentaBancaria(3, sucursalBancaria2, "1122548", "80", new BigDecimal("0.0"), "48587160M");
//        sucursalBancaria2.getCuentasBancarias().add(cuentaBancaria3);
//
//        MovimientoBancario movimientoBancario1 = new MovimientoBancario(1, TipoMovimientoBancario.DEBE, new BigDecimal("5.10"),new GregorianCalendar(2013,9,13).getTime(), cuentaBancaria1.getSaldo(), "Factura", cuentaBancaria1);
//        cuentaBancaria1.getMovimientosBancarios().add(movimientoBancario1);
//        MovimientoBancario movimientoBancario2 = new MovimientoBancario(2, TipoMovimientoBancario.HABER, new BigDecimal("4.7"), new GregorianCalendar(2013,9,14).getTime(), cuentaBancaria1.getSaldo(), "Factura", cuentaBancaria1);
//        cuentaBancaria1.getMovimientosBancarios().add(movimientoBancario2);
//
//        imprimirCuenta(cuentaBancaria1);
//    }
//   
//
//    public static void imprimirCuenta(CuentaBancaria cuentaBancaria) {
//        System.out.print(cuentaBancaria.getSucursalBancaria().getEntidadBancaria().getCodigoEntidad());
//        System.out.print(" " + cuentaBancaria.getSucursalBancaria().getCodigoSucursal());
//        System.out.print(" " + cuentaBancaria.getDc());
//        System.out.println(" " + cuentaBancaria.getNumeroCuenta());
//
//        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println("Movimientos:");
//        for (MovimientoBancario movimientoBancario : cuentaBancaria.getMovimientosBancarios()) {
//            System.out.println(" " + movimientoBancario.getTipoMovimientoBancario() + " | " + formateador.format(movimientoBancario.getFecha()) + " | " + movimientoBancario.getImporte() +" | "+movimientoBancario.getSaldoTotal());
//        }
//    

        EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAO();
        EntidadBancaria entidadBancaria = entidadBancariaDAO.read(1);

        System.out.println(entidadBancaria.getNombre());
    }
}
