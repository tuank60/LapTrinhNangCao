/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventdriven;

/**
 *
 * @author admin
 */
import javax.swing.*;
import java.awt.event.*;
public class MyWindow extends JFrame implements ActionListener  {
    public JButton b1;
    public MyWindow()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800, 600);
        
        b1=new JButton("OK");
        b1.setBounds(100, 100, 100, 30);
        this.add(b1);
        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
            System.out.println("CLicked!!!");
    }
}
