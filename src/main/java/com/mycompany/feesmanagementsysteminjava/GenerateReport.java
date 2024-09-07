/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.feesmanagementsysteminjava;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author muskan jaiswal
 */
public class GenerateReport extends javax.swing.JFrame {

    /**
     * Creates new form ReportPage
     */
    DefaultTableModel model;
    
    public GenerateReport() {
        initComponents();
        
        fillComboBox();
        
        lbl_course.setText("");
        lbl_amount.setText("");
        lbl_in_words.setText("");
    }

    
    
    public void setRecordsToTable(){
        String cname=combo_course.getSelectedItem().toString();
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
        String fromDate=dateFormat.format(jDateChooserFrom.getDate());
        String toDate=dateFormat.format(jDateChooserTo.getDate());
        
        Float totalAmount=0f;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/feesmanagementsystem?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con=DriverManager.getConnection(url,"root","2309");
        String sql="select* from fees_details where date between ? and ? and course_name=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, fromDate);
        st.setString(2, toDate);
        st.setString(3, cname);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
            String receiptNo=rs.getString("reciept_no");
            String rollNo=rs.getString("roll_no");
            String studentName=rs.getString("student_name");
            String paymentMode=rs.getString("payment_mode");
            String courseName=rs.getString("course_name");
            float amount=rs.getFloat("total_amount");
            String remark=rs.getString("remark");
            
            totalAmount=totalAmount+amount;
            lbl_amount.setText(totalAmount.toString());
            lbl_course.setText(cname);
            lbl_in_words.setText(NumberToWordsConverter.convert(totalAmount.intValue()));
            
            Object[] obj={receiptNo,rollNo,studentName,courseName,paymentMode,amount,remark};
            model =(DefaultTableModel)tbl_student_detail.getModel();
            model.addRow(obj);
            
            
        }
        
        }catch(Exception e){
            e.printStackTrace();
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
    
    
    public void clearTable(){
        DefaultTableModel model=(DefaultTableModel)tbl_student_detail.getModel();
        model.setRowCount(1);
    }
    
    public void exportToExcel(){
        XSSFWorkbook wb=new XSSFWorkbook();
        XSSFSheet ws=wb.createSheet();
        
        TreeMap<String,Object[]>map=new TreeMap<>();
        
        DefaultTableModel model=(DefaultTableModel)tbl_student_detail.getModel();
        map.put("0",new Object[]{model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),model.getColumnName(3),model.getColumnName(4),model.getColumnName(5),model.getColumnName(6)});
        
        
        for(int i=1;i<model.getRowCount();i++){
            map.put(Integer.toString(i), new Object[]{model.getValueAt(i, 0),model.getValueAt(i, 1),model.getValueAt(i, 2),model.getValueAt(i, 3),model.getValueAt(i, 4),model.getValueAt(i, 5),model.getValueAt(i, 6)});
           
        }
        Set<String> id=map.keySet();
        
        XSSFRow fRow;
        int rowId=0;
        for(String key:id){
            fRow=ws.createRow(rowId++);
            Object[] value=map.get(key);
            int cellId=0;
            for(Object object:value){
                XSSFCell cell=fRow.createCell(cellId++);
                cell.setCellValue(object.toString());
                
            }
        }
        
        try{
            FileOutputStream fos=new FileOutputStream(new File(txt_file_path.getText()));
            wb.write(fos);
            fos.close();
            JOptionPane.showMessageDialog(this, "file exported successfully"+ txt_file_path.getText());
        }
        catch(Exception e){
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        combo_course = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        jDateChooserFrom = new com.toedter.calendar.JDateChooser();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        txt_file_path = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_student_detail = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbl_in_words = new javax.swing.JLabel();
        lbl_amount = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 160, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("From Date :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 100, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("To Date :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 70, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Select Date :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, -1));
        jPanel1.add(jDateChooserTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 140, -1));
        jPanel1.add(jDateChooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 140, -1));

        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\print simple.png")); // NOI18N
        jButton12.setText("Print");
        jButton12.setPreferredSize(new java.awt.Dimension(97, 32));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 100, 30));

        jButton13.setBackground(new java.awt.Color(0, 0, 102));
        jButton13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Submit");
        jButton13.setPreferredSize(new java.awt.Dimension(97, 32));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 100, 30));
        jPanel1.add(txt_file_path, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 370, -1));

        jButton10.setText("browse");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        jButton11.setText("Export to Excel");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 130, -1));

        tbl_student_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Receipt No.", "Roll No.", "Student Name", "Course", "Payment Mode", "Amount", "Remark"
            }
        ));
        jScrollPane1.setViewportView(tbl_student_detail);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 292, 1170, 470));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Course Selected :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        lbl_in_words.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_in_words.setText("Select Course :");
        jPanel2.add(lbl_in_words, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 410, -1));

        lbl_amount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_amount.setText("Select Course :");
        jPanel2.add(lbl_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 100, -1));

        lbl_course.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_course.setText("Select Course :");
        jPanel2.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 100, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Total Amount in Words :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 160, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Total Amount Collected :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 160, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 630, 130));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Select Course :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1260, 810));

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

        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\out left 5.png")); // NOI18N
        jButton14.setText("Logout");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 553, 230, 35));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 810));

        setSize(new java.awt.Dimension(1534, 817));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
SimpleDateFormat Date_Format = new SimpleDateFormat("YYYY-MM-dd"); 
        String datefrom=  Date_Format.format(jDateChooserFrom.getDate());
      String dateto=  Date_Format.format(jDateChooserTo.getDate());
       
        MessageFormat header=new MessageFormat("Report From "+datefrom+" To " +dateto);
MessageFormat footer=new MessageFormat("page{0,number,integer}");
        try {
            tbl_student_detail.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
        } catch (Exception e) {
            e.getMessage();
        }     
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        clearTable();
        setRecordsToTable(); 
// TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
     JFileChooser fileChooser=new JFileChooser();
     fileChooser.showOpenDialog(this);
     SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
     String date=dateFormat.format(new Date());
     
     try{
         File f=fileChooser.getSelectedFile();
         String path=f.getAbsolutePath();
         
         path=path+"_"+".xlsx";
         txt_file_path.setText(path);
         
     }
     catch(Exception e){
         
     }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
exportToExcel();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CourseList cl=new CourseList();
        cl.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ViewAllRecords var=new ViewAllRecords();
        var.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        LogInPage lip=new LogInPage();
        lip.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

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
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooserFrom;
    private com.toedter.calendar.JDateChooser jDateChooserTo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_amount;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_in_words;
    private javax.swing.JTable tbl_student_detail;
    private javax.swing.JTextField txt_file_path;
    // End of variables declaration//GEN-END:variables
}
