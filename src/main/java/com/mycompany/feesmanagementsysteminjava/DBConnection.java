/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.feesmanagementsysteminjava;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author muskan jaiswal
 */
public class DBConnection {
    public static Connection getConnection(){
        Connection con=null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/feesmanagementsystem?zeroDateTimeBehavior=CONVERT_TO_NULL";
        con=DriverManager.getConnection(url,"root","2309");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
