/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import controller.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model. Barang;

/**
 *
 * @author ROZI
 */
public class daoBarang {
    Connection connection;
    final String insert = "INSERT INTO barang (kode, nama, jumlah, harga, merek) VALUES (?,?, ?, ?, ?); ";
    final String update = "UPDATE barang SET nama=?, jumlah=?, harga=?, merek=? WHERE kode=?;";
    final String delete = "DELETE FROM barang WHERE kode=?;";
    final String select = "SELECT * FROM barang ORDER BY kode ASC;";
    final String selectData = "SELECT * FROM barang where kode=?;";
    //final String cekkode - "SELECT * FROM barang where kode=?;";
    
    public daoBarang() {
        connection = koneksi.connection();
    }
    
    public void tambah (Barang brg) {
        PreparedStatement statement = null;
        try {
        statement = connection.prepareStatement (insert);
        statement.setString (1, brg.getKode () );
        statement.setString (2, brg.getNama () );
        statement.setInt(3, brg.getJumlah ());
        statement.setInt(4, brg.getHarga () );
        statement.setString (5, brg.getMerek());
        statement.executeUpdate();
        } catch (SQLException ex) {
        }
    }
}
