
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kushal
 */
public class forgot_password extends javax.swing.JFrame {

    /**
     * Creates new form forgot_password
     */
    public forgot_password() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        b1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        t4 = new javax.swing.JPasswordField();
        t3 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 504));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.cyan);
        jLabel2.setText("FORGOT PASSWORD?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 10, 230, 40);

        jLabel1.setText("ENTER USER_ID :-");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 80, 100, 20);

        jLabel3.setText("ENTER PIN :-");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(220, 120, 90, 30);
        getContentPane().add(t1);
        t1.setBounds(330, 70, 140, 30);
        getContentPane().add(t2);
        t2.setBounds(330, 120, 140, 30);

        b1.setText("CLICK TO CONFIRM AND RESET");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1);
        b1.setBounds(240, 180, 270, 30);

        jLabel4.setText("ENTER NEW PASSWORD :-");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 260, 140, 14);

        jLabel5.setText("CONFRIM PASSWORD :-");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 300, 140, 20);

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 222, 750, 10);

        jButton2.setText("CLICK TO UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(300, 360, 150, 30);

        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 430, 73, 23);
        getContentPane().add(t4);
        t4.setBounds(340, 300, 160, 30);
        getContentPane().add(t3);
        t3.setBounds(340, 250, 160, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team-building-png-hd-team-hands-png-1920.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-620, 0, 1370, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
try{
    Class.forName("java.sql.DriverManager");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/salarymanagement","root","");
    String A,B,sql;
    A=t1.getText();
    B=t2.getText();
    sql="select * from USERS where USER_ID="+A;
    System.out.print(sql);
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery(sql);
     
 if(!rs.next())
    
       JOptionPane.showMessageDialog(null,"INCORRECT USER_ID AND PIN PLEASE CROSS-CHECK"); 
 
    else{
       
         String a=rs.getString("USER_ID");
        String b=rs.getString("PIN");
    String UA,PA,UA1,PA1;            
        UA = t1.getText();
     PA= t2.getText();            
    
      
 if(UA.equals(a) && PA.equals(b))
{
    JOptionPane.showMessageDialog(null,"NOW YOU CAN RESET YOUR PASSWORD");
     b1.setVisible(false);
      t1.setEditable(false);
      t2.setEditable(false);
      t3.setVisible(true);
      t4.setVisible(true);
}
else{
     JOptionPane.showMessageDialog(null,"INCORRECT USER_ID AND PIN PLEASE CROSS-CHECK");
        } 
 
 }}
catch(Exception e)
{
    
    JOptionPane.showMessageDialog(null,e.getMessage());
    JOptionPane.showMessageDialog(null,"INCORRECT USER_ID AND PIN PLEASE CROSS-CHECK");
    
}
    }//GEN-LAST:event_b1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try{
    Class.forName("java.sql.DriverManager");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/salarymanagement","root","");
    String A,B,sql,c;
    c=t1.getText();
    A=new String(t3.getPassword());
    B=new String(t4.getPassword());
    if(A.equals(B)){ sql="Update USERS set password ='"+A+"' where  USER_ID ="+c;
         Statement st=con.createStatement();
         System.out.println(sql);
    st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"PASSWORD HAS BEEN UPDATED PLEASE LOGIN AGAIN");
        log_in q = new log_in();
        q.setVisible(true);
        this.dispose();
        
    }
    else{
        JOptionPane.showMessageDialog(null,"PASSWORD HAS NOT BEEN UPDATED PLEASE TRY AGAIN");
    }
}
catch(Exception e)
{
    
    JOptionPane.showMessageDialog(null,e.getMessage());
    JOptionPane.showMessageDialog(null,"INCORRECT USER_ID AND PIN PLEASE CROSS-CHECK");
    
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
dispose();
log_in w = new log_in();
w.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgot_password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JPasswordField t3;
    private javax.swing.JPasswordField t4;
    // End of variables declaration//GEN-END:variables
}
