/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.feesmanagementsysteminjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author muskan jaiswal
 */
public class UpdateFeesDetails extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public void displayCashFirst(){
        lbl_cn_ddn_upi.setVisible(false);
        txt_cn_ddn_upi.setVisible(false);
        lbl_bank_name.setVisible(false);
        txt_bank_name.setVisible(false);
        
    }
    boolean validation(){
        if(txt_rec_name.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please Enter receiver name first");
            return false;
        }
        
        if(datec.getDate()==null){
            JOptionPane.showMessageDialog(this,"Please Enter Date");
            return false;
        }
        
        if(txt_amount.getText().equals("") || txt_amount.getText().matches("[0-9]+")==false){
            JOptionPane.showMessageDialog(this,"Please Enter valid amount");
            return false;
        }
        if(combo_mode_pay.getSelectedItem().toString().equalsIgnoreCase("cheque")){
            
            if(txt_cn_ddn_upi.getText().equals("") || txt_cn_ddn_upi.getText().matches("[0-9]+")==false){
            JOptionPane.showMessageDialog(this,"Please Enter valid cheque number");
            return false;
            }
            
            if(txt_bank_name.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please Enter bank name");
            return false;
        }
    
        }
        
        if(combo_mode_pay.getSelectedItem().toString().equalsIgnoreCase("dd")){
            
            if(txt_cn_ddn_upi.getText().equals("") || txt_cn_ddn_upi.getText().matches("[0-9]+")==false){
            JOptionPane.showMessageDialog(this,"Please Enter valid DD number");
            return false;
            }
            
            if(txt_bank_name.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please Enter bank name");
            return false;
        }
        }
        
        if(combo_mode_pay.getSelectedItem().toString().equalsIgnoreCase("upi")){
            
            if(txt_cn_ddn_upi.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please Enter UPI ID number");
            return false;
            }
        }
            
            
        return true;
    }
    public UpdateFeesDetails() {
        initComponents();
        displayCashFirst();
        fillComboBox();
        int r=getRnum();
        r++;
        txt_receipt_num.setText(Integer.toString(r));
        setRecords();
        
    }
    
    public void setRecords(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/feesmanagementsystem?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con=DriverManager.getConnection(url,"root","2309");
        
        PreparedStatement st=con.prepareStatement("select * from fees_details order by reciept_no desc limit 1");
        ResultSet rs=st.executeQuery();
        rs.next();
        txt_receipt_num.setText(rs.getString("reciept_no"));
        combo_mode_pay.setSelectedItem(rs.getString("payment_mode"));
        String paymentMode=rs.getString("payment_mode");
        if(paymentMode.equalsIgnoreCase("cash")){
           // txt_cc_dd_upi.setText("");
           // txt_bank.setText("");
        }
        if(paymentMode.equalsIgnoreCase("cheque")){
    
            txt_cn_ddn_upi.setText(rs.getString("cheque_no"));
            
            txt_bank_name.setText(rs.getString("bank_name"));
        }
        if(paymentMode.equalsIgnoreCase("dd")){
            
            txt_cn_ddn_upi.setText(rs.getString("dd_no"));
            
            txt_bank_name.setText(rs.getString("bank_name"));
        }
        if(paymentMode.equalsIgnoreCase("upi")){
            
            txt_cn_ddn_upi.setText(rs.getString("upi"));
            
                    }
        txt_rec_name.setText(rs.getString("student_name"));
        datec.setDate(rs.getDate("date"));
        gst_num.setText(rs.getString("gstin"));
        txt_form_year.setText(rs.getString("year1"));
        txt_to_year.setText(rs.getString("year2"));
        txt_amount.setText(rs.getString("amount"));
        txt_cgst.setText(rs.getString("cgst"));
        txt_sgst.setText(rs.getString("sgst"));
        txt_total.setText(rs.getString("total_amount"));
        txt_total_in_words.setText(rs.getString("total_in_words"));
        combo_course.setSelectedItem(rs.getString("course_name"));
        txt_remark.setText(rs.getString("remark"));
        txt_roll.setText(rs.getString("roll_no"));
        
            
        }catch(Exception e){
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        txt_rec_name = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_cgst = new javax.swing.JTextField();
        txt_total_in_words = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_sgst = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_head = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txt_form_year = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_to_year = new javax.swing.JTextField();
        txt_roll = new javax.swing.JTextField();
        lbl_mode_pay = new javax.swing.JLabel();
        lbl_bank_name = new javax.swing.JLabel();
        txt_cn_ddn_upi = new javax.swing.JTextField();
        txt_receipt_num = new javax.swing.JTextField();
        gst_num = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        datec = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        combo_mode_pay = new javax.swing.JComboBox<>();
        txt_bank_name = new javax.swing.JTextField();
        lbl_receipt_num = new javax.swing.JLabel();
        lbl_cn_ddn_upi = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        combo_course = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("to");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 40, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Received Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 110, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 1070, 10));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Amount");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 70, -1));

        txt_rec_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_rec_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 220, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 102));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 190, 10));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Sr No.");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 60, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Head");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 40, -1));

        txt_cgst.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_cgst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_cgstMouseClicked(evt);
            }
        });
        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 160, -1));

        txt_total_in_words.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_total_in_words.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_in_wordsActionPerformed(evt);
            }
        });
        jPanel1.add(txt_total_in_words, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 240, -1));

        txt_total.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_totalMouseClicked(evt);
            }
        });
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, 160, -1));

        txt_amount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        jPanel1.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 210, 160, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 102));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1070, 10));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("SGST 7%");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Remark");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 70, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("CGST 7%");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, -1, -1));

        txt_sgst.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_sgst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_sgstMouseClicked(evt);
            }
        });
        txt_sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sgstActionPerformed(evt);
            }
        });
        jPanel1.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 300, 160, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Receiver Signature");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 460, 130, 20));

        txt_head.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_head.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_headActionPerformed(evt);
            }
        });
        jPanel1.add(txt_head, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 160, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Total in Words");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 110, 20));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 102));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, 190, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Total");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, 60, 20));

        jButton8.setBackground(new java.awt.Color(0, 0, 102));
        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Print");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 520, 110, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Roll No.");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 70, 20));
        jPanel1.add(txt_form_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 100, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("The Following Payment in the college office form the year");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 380, 20));
        jPanel1.add(txt_to_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 100, -1));
        jPanel1.add(txt_roll, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 100, -1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 1130, 580));

        lbl_mode_pay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_mode_pay.setText("Mode of Payment");
        jPanel3.add(lbl_mode_pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        lbl_bank_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_bank_name.setText("Bank Name");
        jPanel3.add(lbl_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        txt_cn_ddn_upi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_cn_ddn_upi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cn_ddn_upiActionPerformed(evt);
            }
        });
        jPanel3.add(txt_cn_ddn_upi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 160, -1));

        txt_receipt_num.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_receipt_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receipt_numActionPerformed(evt);
            }
        });
        jPanel3.add(txt_receipt_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 160, -1));

        gst_num.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gst_num.setText("AVC5677GHI");
        jPanel3.add(gst_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 100, 90, -1));

        lbl_date.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_date.setText("Date");
        jPanel3.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 30, -1, -1));
        jPanel3.add(datec, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 30, 120, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("GSTIN");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 100, -1, -1));

        combo_mode_pay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "DD", "UPI", "CHEQUE" }));
        combo_mode_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_mode_payActionPerformed(evt);
            }
        });
        jPanel3.add(combo_mode_pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        txt_bank_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_bank_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bank_nameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 160, -1));

        lbl_receipt_num.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_receipt_num.setText("Receipt Number");
        jPanel3.add(lbl_receipt_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        lbl_cn_ddn_upi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_cn_ddn_upi.setText("Cheque Number");
        jPanel3.add(lbl_cn_ddn_upi, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        lbl_course.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_course.setText("Course");
        jPanel3.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 170, -1, -1));

        combo_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseActionPerformed(evt);
            }
        });
        jPanel3.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 170, -1, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\search 10.png")); // NOI18N
        jButton1.setText("Search Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, 230, 35));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\home black 5.png")); // NOI18N
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 41, 230, 35));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\edit list 5.png")); // NOI18N
        jButton3.setText("Edit Course");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 212, 230, 35));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\leftaaa 5 black.png")); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 472, 230, 35));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\view 5.png")); // NOI18N
        jButton5.setText("Course List");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 295, 230, 35));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\book.png")); // NOI18N
        jButton6.setText("View all Record");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 230, 36));

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\out left 5.png")); // NOI18N
        jButton11.setText("Logout");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 553, 230, 35));

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\print simple.png")); // NOI18N
        jButton9.setText("Print");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 230, 35));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 810));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cn_ddn_upiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cn_ddn_upiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cn_ddn_upiActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed
taxCount();       // TODO add your handling code here:
    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_receipt_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receipt_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receipt_numActionPerformed

    private void txt_bank_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bank_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bank_nameActionPerformed

    private void txt_total_in_wordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_in_wordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_in_wordsActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
taxCount();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed

        taxCount();




    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_sgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sgstActionPerformed
taxCount();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sgstActionPerformed

    private void txt_headActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_headActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_headActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
if(validation()){
    String s=updateData();
    if(s.equals("successfull")){
        JOptionPane.showMessageDialog(this,"recored updated successfully");
         //JOptionPane.showMessageDialog(this,"recored inserted successfully");
        PrintReciept print=new PrintReciept();
print.setVisible(true);
this.dispose();
    }
    else {
        JOptionPane.showMessageDialog(this,"recored not updated");
    }
}
    }//GEN-LAST:event_jButton8ActionPerformed

    private void combo_mode_payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_mode_payActionPerformed

if(combo_mode_pay.getSelectedIndex()==1){
    lbl_cn_ddn_upi.setText("DD Number");
    lbl_cn_ddn_upi.setVisible(true);
    txt_cn_ddn_upi.setVisible(true);
    lbl_bank_name.setVisible(true);
    txt_bank_name.setVisible(true);
    
}
if(combo_mode_pay.getSelectedIndex()==2){
    lbl_cn_ddn_upi.setText("UPI Id");
    lbl_cn_ddn_upi.setVisible(true);
    txt_cn_ddn_upi.setVisible(true);
    lbl_bank_name.setVisible(false);
    txt_bank_name.setVisible(false);
}
if(combo_mode_pay.getSelectedIndex()==3){
    lbl_cn_ddn_upi.setText("Cheque Number");
    lbl_cn_ddn_upi.setVisible(true);
    txt_cn_ddn_upi.setVisible(true);
    lbl_bank_name.setVisible(true);
    txt_bank_name.setVisible(true);
    
}
if(combo_mode_pay.getSelectedIndex()==0){
    lbl_cn_ddn_upi.setVisible(false);
        txt_cn_ddn_upi.setVisible(false);
        lbl_bank_name.setVisible(false);
        txt_bank_name.setVisible(false);
        
}
    }//GEN-LAST:event_combo_mode_payActionPerformed

    private void txt_cgstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cgstMouseClicked
taxCount();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cgstMouseClicked

    private void txt_sgstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_sgstMouseClicked
taxCount();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sgstMouseClicked

    private void txt_totalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_totalMouseClicked
taxCount();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalMouseClicked

    private void combo_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseActionPerformed
String s2=combo_course.getSelectedItem().toString();
        txt_head.setText(s2);        // TODO add your handling code here:
    }//GEN-LAST:event_combo_courseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SearchRecords search=new SearchRecords();
        search.setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EditCourse edit=new EditCourse();
        edit.setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        LogInPage lip=new LogInPage();
        lip.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
PrintReciept pr=new PrintReciept();
pr.setVisible(true);
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
ViewAllRecords var=new ViewAllRecords();
var.setVisible(true);
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
CourseList cl=new CourseList();
cl.setVisible(true);
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        PrintReciept pr=new PrintReciept();
        pr.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
void taxCount(){
        String s1= txt_amount.getText();
        float amt=Float.parseFloat(s1);
        float cgst=amt*0.07f;
        float sgst=amt*0.07f;

        float gst=cgst+sgst;
        txt_cgst.setText(Float.toString(cgst));
        txt_sgst.setText(Float.toString(sgst));

        float total=amt+gst;

        txt_total.setText(Float.toString(total));
        
        txt_total_in_words.setText(AmountToWordsConverter.convert(total));
    }


public class AmountToWordsConverter {

    private static final String[] units = {
        "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
        "",        // 0
        "",        // 1
        "Twenty",  // 2
        "Thirty",  // 3
        "Forty",   // 4
        "Fifty",   // 5
        "Sixty",   // 6
        "Seventy", // 7
        "Eighty",  // 8
        "Ninety"   // 9
    };

    public static String convert(double amount) {
        if (amount == 0) {
            return "Zero Rupees";
        }

        long rupees = (long) amount;
        int paise = (int) Math.round((amount - rupees) * 100);

        String rupeePart = convertNumberToWords(rupees);
        String paisePart = convertNumberToWords(paise);

        return rupeePart + " Rupees " + (paise > 0 ? "and " + paisePart + " Paise" : "");
    }

    private static String convertNumberToWords(long number) {
        if (number < 20) {
            return units[(int) number];
        }

        if (number < 100) {
            return tens[(int) (number / 10)] + ((number % 10 != 0) ? " " + units[(int) (number % 10)] : "");
        }

        if (number < 1000) {
            return units[(int) (number / 100)] + " Hundred" + ((number % 100 != 0) ? " " + convertNumberToWords(number % 100) : "");
        }

        if (number < 100000) {
            return convertNumberToWords(number / 1000) + " Thousand" + ((number % 1000 != 0) ? " " + convertNumberToWords(number % 1000) : "");
        }

        if (number < 10000000) {
            return convertNumberToWords(number / 100000) + " Lakh" + ((number % 100000 != 0) ? " " + convertNumberToWords(number % 100000) : "");
        }

        return convertNumberToWords(number / 10000000) + " Crore" + ((number % 10000000 != 0) ? " " + convertNumberToWords(number % 10000000) : "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount in rupees: ");
        double amount = scanner.nextDouble();

        System.out.println("Amount in words: " + convert(amount));
    }
}

void fillComboBox(){
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/feesmanagementsystem?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con=DriverManager.getConnection(url,"root","2309");
        
        String sql="select cname from course";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            combo_course.addItem(rs.getString("cname"));
        }  
    }
    catch(Exception e){
        e.printStackTrace();
    }
}
int getRnum(){
    int rno=0;
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/feesmanagementsystem?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con=DriverManager.getConnection(url,"root","2309");
        
        String sql="select max(reciept_no) from fees_details";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            rno=rs.getInt(1);
        }  
    }
    catch(Exception e){
        e.printStackTrace();
    }
    return rno;
}

String updateData(){
   
    int recipetno=Integer.parseInt(txt_receipt_num.getText());
    String sname=txt_rec_name.getText();
    String rollno=txt_roll.getText();
    String paymentmode=combo_mode_pay.getSelectedItem().toString();
    String cdd=selection();
    String bankname=txt_bank_name.getText();
    String coursename=combo_course.getSelectedItem().toString();
    String gst=gst_num.getText();
    float total=Float.parseFloat(txt_total.getText());
    SimpleDateFormat s1= new SimpleDateFormat("yyyy-MM-dd");
        String date=s1.format(datec.getDate());
    float amount=Float.parseFloat(txt_amount.getText());
    float cgst=Float.parseFloat(txt_cgst.getText());
    float sgst=Float.parseFloat(txt_sgst.getText());
    String totalinwords=txt_total_in_words.getText();
    String remark=txt_remark.getText();
    int year1=Integer.parseInt(txt_form_year.getText());
    int year2=Integer.parseInt(txt_to_year.getText());
    
    String status="";
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/feesmanagementsystem?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con=DriverManager.getConnection(url,"root","2309");
        
        String sql="update fees_details set student_name=?,roll_no=?,payment_mode=?,cheque_no=?,bank_name=?,dd_no=?,upi_id=?,course_name=?,gstin=?,total_amount=?,date=?,amount=?,cgst=?,sgst=?,total_in_words=?,remark=?,year1=?,year2=? where reciept_no=?";
        PreparedStatement st=con.prepareStatement(sql);
        
        st.setString(1,sname);
        st.setString(2,rollno);
        st.setString(3,paymentmode);
        if(combo_mode_pay.getSelectedIndex()==3){
            st.setString(4,cdd);
            st.setString(5,bankname);
            st.setString(6, null);
            st.setString(7, null);
        }
        
        if(combo_mode_pay.getSelectedIndex()==1){
            st.setString(4, null);
            st.setString(5,bankname);
            st.setString(6,cdd);
            
            st.setString(7, null);
        }
        if(combo_mode_pay.getSelectedIndex()==2){
            
            st.setString(4, null);
            st.setString(5,null);
            st.setString(6, null);
            st.setString(7,cdd);
        }
        if(combo_mode_pay.getSelectedIndex()==0){
            
            st.setString(4, null);
            st.setString(5,null);
            st.setString(6, null);
            st.setString(7,null);
        }
        st.setString(8,coursename);
        st.setString(9,gst);
        st.setFloat(10,total);
        st.setString(11,date);
        st.setFloat(12,amount);
        st.setFloat(13,cgst);
        st.setFloat(14,sgst);
        st.setString(15,totalinwords);
        st.setString(16,remark);
        st.setInt(17,year1);
        st.setInt(18,year2);
        st.setInt(19, recipetno);
        
        
        
        int rowc=st.executeUpdate();
        
        if(rowc==1){
            status="successfull";
        }
        else{
            status="failed";
        }
        
    }
    catch(Exception e){
        e.printStackTrace();
    }
    return status;
}

String selection(){
    if(combo_mode_pay.getSelectedIndex()==3){
        String chequeno=txt_cn_ddn_upi.getText();
        
        return chequeno;
        
    }
    if(combo_mode_pay.getSelectedIndex()==0){
        String ddno="";
        
        return ddno;
    }
    if(combo_mode_pay.getSelectedIndex()==1){
        String ddno=txt_cn_ddn_upi.getText();
        
        return ddno;
    }
    if(combo_mode_pay.getSelectedIndex()==2){
        String upi=txt_cn_ddn_upi.getText();
        //String bankname=txt_bank_name.getText();
        
        return upi;
    }
    return null;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateFeesDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JComboBox<String> combo_mode_pay;
    private com.toedter.calendar.JDateChooser datec;
    private javax.swing.JLabel gst_num;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_bank_name;
    private javax.swing.JLabel lbl_cn_ddn_upi;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_mode_pay;
    private javax.swing.JLabel lbl_receipt_num;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bank_name;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_cn_ddn_upi;
    private javax.swing.JTextField txt_form_year;
    private javax.swing.JTextField txt_head;
    private javax.swing.JTextField txt_rec_name;
    private javax.swing.JTextField txt_receipt_num;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_roll;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_to_year;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_in_words;
    // End of variables declaration//GEN-END:variables
}
