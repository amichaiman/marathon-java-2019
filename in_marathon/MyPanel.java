package in_marathon;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        JPanel panel = new JPanel();

        frame.add(panel);
        frame.setSize(new Dimension(400,400));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.repaint();
    }

    @Override
    public void paintComponents(Graphics graphics) {
        super.paintComponents(graphics);
        graphics.setColor(Color.RED);
        int []x = {0, getWidth()/2, getWidth(), getWidth()/2};
        int []y = {getHeight()/2, 0, getHeight()/2, getHeight()};
        graphics.drawPolygon(x,y,4);

    }
}
