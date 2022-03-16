package mnsx;

import javax.swing.*;

/**
 * @Description
 * @Author Mnsx_x
 * @Email xx1527030652@gmail.com
 * @Version
 * @Date 2021--10--13   21:16
 */
public class GreedySnackMain extends JFrame {
    SnackWin snackwin;
    static final int Width = 800 , Height = 600 , LocX = 200 , LocY = 80;
    public GreedySnackMain() {
        super("GreedySncak Power by Mnsx_x");
        snackwin = new SnackWin();
        add(snackwin);
        this.setSize(Width, Height);
        this.setVisible(true);
        this.setLocation(LocX, LocY);
    }

    public static void main(String[] args) {
        new GreedySnackMain();
    }
}
