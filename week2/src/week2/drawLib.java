/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

/**
 *
 * @author admin
 */
import javax.swing.*;
import java.awt.*;
import java.math.*;
public class drawLib {
    public void drawSin(double xmin,double xmax,int res,JPanel p)
    {
        double ymin,ymax,Xs,Ys,tmp,x1,y1;
        int i,x11,y11,x12,y12,X0,Y0,xold=0,yold=0;
        Graphics g=p.getGraphics();
        g.setColor(Color.red);
        // tim ymin va ymax
        ymax=ymin=Math.sin(xmin);
        for(i=1;i<res;i++)
        {
            tmp=Math.sin(xmin+(xmax-xmin)/res*i);
            if(ymin>tmp) ymin=tmp;
            if(ymax<tmp) ymax=tmp;
        }
        Xs=p.getWidth()/(xmax-xmin);
        Ys=p.getHeight()/(ymax-ymin);
        X0=-(int)(xmin*Xs);
        Y0=(int)(ymax*Ys);
        System.out.println("Ymin="+ymin+" , ymax="+ymax+" , Xs="+Xs+" , Ys="+Ys+", X0="+X0+",Y0="+Y0);
        
        for(i=0;i<res;i++)
        {
            x1=xmin+(xmax-xmin)/res*i;
            y1=Math.sin(x1);
            // Quy ve mien pixel
            x11=(int)(x1*Xs);
            y11=(int)(y1*Ys);
            // Quy ve he truc man hinh may tinh
            x12=X0+x11;
            y12=Y0-y11;
            
            if(i>0)
            {
                g.drawLine(xold, yold,x12, y12);
               // System.out.print("("+x12+","+y12+")");
            }
            xold=x12;
            yold=y12;
        }
    }

   
}
