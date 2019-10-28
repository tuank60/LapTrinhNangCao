
package ltnc_b2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class LTNC_b2 {
JButton clearBtn, jButton1, jButton2, jButton3, jButton4, jButton5,jButton6,jButton7,jButton8,jButton9,jButton10;
  DrawArea drawArea;
  ActionListener actionListener = new ActionListener() {
 
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == clearBtn) {
        drawArea.clear();
      } else if (e.getSource() == jButton1) {
        drawArea.black();
      } else if (e.getSource() == jButton2) {
        drawArea.blue();
      } else if (e.getSource() == jButton3) {
        drawArea.green();
      } else if (e.getSource() == jButton4) {
        drawArea.red();
      } else if (e.getSource() ==jButton5) {
        drawArea.magenta();
      }
      else if (e.getSource() ==jButton6) {
        drawArea.orange();
      }
      else if (e.getSource() ==jButton7) {
        drawArea.gray();
      }
       else if (e.getSource() ==jButton8) {
        drawArea.light_gray();
      }
      else if (e.getSource() ==jButton9) {
        drawArea.pink();
      }
      else if (e.getSource() ==jButton10) {
        drawArea.cyan();
      }
 
    }
  };
 
  public static void main(String[] args) {
    new LTNC_b2().show();
  }
 
  public void show() {
    // create main frame
    JFrame frame = new JFrame("Chuong trinh paint");
    Container content = frame.getContentPane();
    // set layout on content pane
    content.setLayout(new BorderLayout());
    // create draw area
    drawArea = new DrawArea();
 
    // add to content pane
    content.add(drawArea, BorderLayout.CENTER);
 
    // create controls to apply colors and call clear feature
    JPanel controls = new JPanel();
 
    clearBtn = new JButton("Clear");
    clearBtn.addActionListener(actionListener);
    jButton1 = new JButton("Black");
    jButton1.setBackground(Color.BLACK);
    jButton1.addActionListener(actionListener);
    jButton2 = new JButton("Blue");
    jButton2.setBackground(Color.BLUE);
    jButton2.addActionListener(actionListener);
    jButton3 = new JButton("Green");
    jButton3.setBackground(Color.GREEN);
    jButton3.addActionListener(actionListener);
    jButton4 = new JButton("Red");
    jButton4.setBackground(Color.RED);
    jButton4.addActionListener(actionListener);
    jButton5 = new JButton("Magenta");
    jButton5.addActionListener(actionListener);
    jButton5.setBackground(Color.MAGENTA);
    jButton6 = new JButton("orange");
    jButton6.addActionListener(actionListener);
    jButton6.setBackground(Color.ORANGE);
    jButton7 = new JButton("Gray");
    jButton7.addActionListener(actionListener);
    jButton7.setBackground(Color.GRAY);
    jButton8 = new JButton("Light_gray");
    jButton8.addActionListener(actionListener);
    jButton8.setBackground(Color.LIGHT_GRAY);
    jButton9 = new JButton("Pink");
    jButton9.addActionListener(actionListener);
    jButton9.setBackground(Color.PINK);
    jButton10 = new JButton("Cyan");
    jButton10.addActionListener(actionListener);
    jButton10.setBackground(Color.CYAN);
    
    
    
    
    
    
    
 
    // add to panel
    controls.add(jButton1);
    controls.add(jButton2);
    controls.add(jButton3);
    controls.add(jButton4);
    controls.add(jButton5);
    controls.add(jButton6);
    controls.add(jButton7);
    controls.add(jButton8);
    controls.add(jButton9);
    controls.add(jButton10);
    controls.add(clearBtn);
    
    
    
    
    JMenuBar mb =new JMenuBar();
    JMenu file=new JMenu("File");
    JMenu home=new JMenu("Home");
    JMenu view=new JMenu("View");
    mb.add(file);mb.add(home);mb.add(view);
    frame.add(mb);
    frame.setJMenuBar(mb);
    
    
 
    // add to content pane
    content.add(controls, BorderLayout.NORTH);
 
    frame.setSize(900, 900);
    // can close frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // show the swing paint result
    frame.setVisible(true);
 
    // Now you can try our Swing Paint !!! Enjoy <img draggable="false" class="emoji" alt="😀" src="https://s.w.org/images/core/emoji/11/svg/1f600.svg">
  }
 
}
    
   