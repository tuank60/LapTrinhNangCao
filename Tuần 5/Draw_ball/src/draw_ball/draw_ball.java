/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawball;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
/*
 *
 *
 * @author Halam
 */
public class draw_ball extends javax.swing.JFrame implements Runnable{
    
    /**
     * Creates new form draw_ball
     */
    public int x,y,maxX,maxY,speed;
    public double dx,dy;
    public long score;
    boolean isRunning;
    public draw_ball() {
        initComponents();
        isRunning=false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP = new javax.swing.JPanel();
        jB = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jP.setBackground(new java.awt.Color(255, 255, 255));
        jP.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPLayout = new javax.swing.GroupLayout(jP);
        jP.setLayout(jPLayout);
        jPLayout.setHorizontalGroup(
            jPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jB)
                .addContainerGap(580, Short.MAX_VALUE))
        );
        jPLayout.setVerticalGroup(
            jPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Stop");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(414, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        x=jB.getX();
        y=jB.getY();
        dx=1;
        dy=1;
        speed=10; //20milisecond
        score=0;
        try {
            // TODO add your handling code here:
            BufferedImage img=ImageIO.read(new File("ball1.png"));
            jB.setIcon(new ImageIcon(img));
            jB.setText("");
            Thread t=new Thread(this);
            t.start();
            isRunning=true;
        } catch (IOException ex) {
            Logger.getLogger(draw_ball.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        isRunning=false;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBMousePressActionPerformed(java.awt.ActiveEvent evt) {
        
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
            java.util.logging.Logger.getLogger(draw_ball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(draw_ball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(draw_ball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(draw_ball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new draw_ball().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jP;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        //To change body of generated methods, choose Tools | Templates.
        while(isRunning)
        {
            try {
                Thread.sleep(speed);
                x+=dx; y+=dy;
                if(x<0)
                {
                    x=0; dx=-dx;
                }
                else if((x+jB.getWidth())>jP.getWidth())
                {
                    x=jP.getWidth()-jB.getWidth(); dx=-dx;
                }
                if(y<0)
                {
                    y=0; dy=-dy;
                }
                else if((y+jB.getHeight())>jP.getHeight())
                {
                    y=jP.getHeight()-jB.getHeight(); dy=-dy;
                }
                jB.setLocation(x, y);
            } catch (InterruptedException ex) {
                Logger.getLogger(draw_ball.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
