package view;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import static com.itextpdf.text.Font.ITALIC;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.DocGiaController;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.DocGia;
import static view.MainFrame.setJTableColumnsWidth;

public class GDTimKiemDG extends javax.swing.JFrame {

    public ArrayList<DocGia> listDG;
    public DocGiaController dc;

    /**
     * Creates new form GDTimKiemDG
     */
    public GDTimKiemDG() {
        initComponents();
        this.setTitle("Thư viện Trường Đại học Bách Khoa Hà Nội");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setSize(900, 400);
        listDG = new ArrayList<DocGia>();
        dc = new DocGiaController();
        // Chia tỉ lệ độ rộng cho các cột
        setJTableColumnsWidth(jTable1, 1028, 10, 20, 15, 20, 15, 20);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tìm Kiếm Độc Giả");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo mã độc giả", "Theo tên độc giả", "Tất cả độc giả" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã độc giả", "Tên độc giả", "Ngày sinh", "Lớp học", "Số điện thoại", "Quê quán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Xuất File");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Trở lại");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(23, 23, 23))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jComboBox1, jTextField1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            this.dispose();
            MainFrame mf = new MainFrame();
            mf.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GDThemSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        dc = new DocGiaController();
        // Khi mà jTextFiled1 đã được người dùng điền vào gì đó
        if (jTextField1.getText().length() != 0) {
            if (jComboBox1.getSelectedIndex() == 0) {
                //ComboBox chọn cái thứ nhất
                try {
                    // Tìm kiếm theo mã độc giả
                    listDG = dc.getListDocGia(Integer.parseInt(jTextField1.getText()), "");
                    // Làm cho bảng hiển thị rỗng
                    model.setRowCount(0);
                    dc.show_DocGia_On_JTable(listDG, model);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (jComboBox1.getSelectedIndex() == 1) {
                // ComboBox chọn cái thứ 2
                try {
                    // Tìm kiếm theo tên độc giả
                    listDG = dc.getListDocGia(0, jTextField1.getText());
                    // Làm cho bảng hiển thị rỗng
                    model.setRowCount(0);
                    dc.show_DocGia_On_JTable(listDG, model);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else {// Khi mà jTextField1 bị để trống
            // ComboBox chọn cái thứ 3
            if (jComboBox1.getSelectedIndex() == 2) {
                try {
                    // Tìm kiếm tất cả độc giả
                    listDG = dc.getListDocGia(0, "");
                    // Làm cho bảng hiển thị rỗng
                    model.setRowCount(0);
                    dc.show_DocGia_On_JTable(listDG, model);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        if (model1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa có dữ liệu để xuất file !");
        } else {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter ft = new FileNameExtensionFilter("PDF Documents", "pdf");
            chooser.addChoosableFileFilter(ft);
            int returnVal = chooser.showSaveDialog(this);
            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                try {
                    String fileName = chooser.getSelectedFile().getName();
                    String dir = chooser.getCurrentDirectory().toString();
                    File f = new File(dir + "\\" + fileName + ".pdf");

                    if (f.exists()) {
                        JOptionPane.showMessageDialog(this, "Tên file đã tồn tại, mời bạn chọn tên khác !");
                    } else {
                        Document document = new Document(PageSize.A4, 50, 50, 10, 50);
                        PdfWriter writer;
                        writer = PdfWriter.getInstance(document, new FileOutputStream(dir + "\\" + fileName + ".pdf"));
                        document.open();

                        Font f1 = new Font(BaseFont.createFont("/assets/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                        f1.setSize(10);
                        f1.setColor(BaseColor.BLACK);
                        document.add(new Paragraph("THƯ VIỆN BÁCH KHOA\n         IN ẤN SAO KÊ", f1));

                        Font f2 = new Font(BaseFont.createFont("/assets/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                        f2.setSize(16);
                        f2.setColor(BaseColor.BLACK);
                        Paragraph p = new Paragraph("Danh Sách Độc Giả", f2);
                        p.setAlignment(Element.ALIGN_CENTER);
                        document.add(p);

                        Font f5 = new Font(BaseFont.createFont("/assets/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                        f5.setSize(8);
                        f5.setColor(BaseColor.BLACK);
                        f5.setStyle(ITALIC);

                        Font f3 = new Font(BaseFont.createFont("/assets/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                        f3.setSize(8);
                        f3.setColor(BaseColor.BLACK);

                        Font f6 = new Font(BaseFont.createFont("/assets/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                        f6.setSize(8);
                        f6.setColor(BaseColor.BLACK);
                        f6.setStyle(ITALIC);
                        Paragraph p5 = new Paragraph("\n\n", f6);
                        p5.setAlignment(Element.ALIGN_LEFT);
                        document.add(p5);

                        Font f7 = new Font(BaseFont.createFont("/assets/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                        f7.setSize(8);
                        f7.setColor(BaseColor.BLACK);
                        PdfPTable t1 = new PdfPTable(new float[]{1, 1, 1, 1, 1, 1});
                        t1.setWidthPercentage(100);
                        t1.setTotalWidth(1200);
                        t1.setSpacingBefore(0);
                        t1.setSpacingAfter(0);

                        PdfPCell c11 = new PdfPCell(new Phrase("Mã độc giả", f7));
                        t1.addCell(c11);
                        PdfPCell c12 = new PdfPCell(new Phrase("Tên độc giả", f7));
                        t1.addCell(c12);
                        PdfPCell c13 = new PdfPCell(new Phrase("Ngày sinh", f7));
                        t1.addCell(c13);
                        PdfPCell c14 = new PdfPCell(new Phrase("Lớp học", f7));
                        t1.addCell(c14);
                        PdfPCell c15 = new PdfPCell(new Phrase("Số điện thoại", f7));
                        t1.addCell(c15);
                        PdfPCell c16 = new PdfPCell(new Phrase("Quê quán", f7));
                        t1.addCell(c16);
                        for (int i = 0; i < model1.getRowCount(); i++) {
                            t1.addCell(new Phrase(model1.getValueAt(i, 0).toString(), f3));
                            t1.addCell(new Phrase(model1.getValueAt(i, 1).toString(), f3));
                            t1.addCell(new Phrase(model1.getValueAt(i, 2).toString(), f3));
                            t1.addCell(new Phrase(model1.getValueAt(i, 3).toString(), f3));
                            t1.addCell(new Phrase(model1.getValueAt(i, 4).toString(), f3));
                            t1.addCell(new Phrase(model1.getValueAt(i, 5).toString(), f3));
                        }
                        document.add(t1);

                        Calendar cal = new GregorianCalendar();
                        int year = cal.get(Calendar.YEAR);
                        int month = cal.get(Calendar.MONTH);
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        String date = (day + "/" + (month + 1) + "/" + year);
                        Font f4 = new Font(BaseFont.createFont("/assets/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                        f4.setSize(10);
                        f4.setColor(BaseColor.BLACK);
                        Paragraph p1 = new Paragraph("\nHà Nội , " + date, f4);
                        p1.setAlignment(Element.ALIGN_RIGHT);
                        document.add(p1);

                        document.close();
                        JOptionPane.showMessageDialog(this, "Lưu file thành công !");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hủy bỏ !");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(GDTimKiemDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDTimKiemDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDTimKiemDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDTimKiemDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDTimKiemDG().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
