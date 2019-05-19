package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        int x1,x2,x3,x4,y1,y2,y3,y4;
        double d1,d2,d3,d4,d5,p1,p2,area;
        DecimalFormat df = new DecimalFormat("0.###");

        Derivada der = new Derivada();

        x1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Coordenada X do Ponto 1"));
        y1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Coordenada Y do Ponto 1"));
        x2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Coordenada X do Ponto 2"));
        y2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Coordenada Y do Ponto 2"));
        x3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Coordenada X do Ponto 3"));
        y3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Coordenada Y do Ponto 3"));
        x4 = Integer.parseInt(JOptionPane.showInputDialog(null, "Coordenada X do Ponto 4"));
        y4 = Integer.parseInt(JOptionPane.showInputDialog(null, "Coordenada Y do Ponto 4"));
        d1 = der.distancia(x1, y1, x2, y2);
        d2 = der.distancia(x2, y2, x3, y3);
        d3 = der.distancia(x3, y3, x4, y4);
        d4 = der.distancia(x1, y1, x4, y4);
        d5 = der.distancia(x1, y1, x3, y3);
        p1 = (d1+d2+d5)/2;p2 = (d3+d4+d5)/2;
        area = der.calculaArea(p1*(p1-d1)*(p1-d2)*(p1-d5));
        area += der.calculaArea(p2*(p2-d3)*(p2-d4)*(p2-d5));
        area = Integer.parseInt(df.format(area));
        new Draw(x1,x2,x3,x4,y1,y2,y3,y4);
        JOptionPane.showMessageDialog(null, "Area: "+area, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
    
}

class Draw{
        @SuppressWarnings("empty-statement")
        Polygon poly;
        JFrame f;
        public Draw(int x1,int x2,int x3,int x4,int y1,int y2,int y3,int y4){
            f = new JFrame();
            int xPoly[] = {x1*10,x2*10,x3*10,x4*10};
            int yPoly[] = {y1*10,y2*10,y3*10,y4*10};
           poly = new Polygon(xPoly,yPoly,4);
           
           JPanel p = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.BLUE);
                    g.fillPolygon(poly);
                }
             };
           f.getContentPane().add(p);
           f.setSize(700,700);
           //f.pack();
           f.setVisible(true);
           f.setDefaultCloseOperation(EXIT_ON_CLOSE);
           f.setLocationRelativeTo(null);
           }

    }