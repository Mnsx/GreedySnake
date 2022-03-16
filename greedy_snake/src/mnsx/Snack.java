package mnsx;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Mnsx_x
 * @Email xx1527030652@gmail.com
 * @Version
 * @Date 2021--10--13   21:19
 */
public class Snack {
    static final int DIR[][] = {{0 , -1} , {0 , 1} , {-1 , 0} , {1 , 0}};
    private List<Node> lt = new ArrayList<Node>();
    private int curDir;
    public Snack() {
        curDir = 3;
        lt.add(new Node(350 , 250));
    }
    int length() {return lt.size();}
    int getDir() {return curDir;}
    void draw(Graphics g)
    {
        g.setColor(Color.black);
        for(int i = 0; i < lt.size(); i++) {
            g.fillRect(lt.get(i).getX(), lt.get(i).getY(), 10, 10);
        }
    }
    boolean Dead() {
        for(int i = 1; i < lt.size(); i++) {
            if(lt.get(0).getX() == lt.get(i).getX() && lt.get(0).getY() == lt.get(i).getY())
                return true;
        }
        return false;
    }
    Node headMove()
    {
        int tx = lt.get(0).getX() + SnackWin.Size * DIR[curDir][0];
        int ty = lt.get(0).getY() + SnackWin.Size * DIR[curDir][1];
        if(tx > SnackWin.GameLocX + SnackWin.GameWidth - SnackWin.Size) tx = SnackWin.GameLocX;
        if(tx < SnackWin.GameLocX) tx = SnackWin.GameWidth + SnackWin.GameLocX - SnackWin.Size;
        if(ty > SnackWin.GameLocY + SnackWin.GameHeight - SnackWin.Size) ty = SnackWin.GameLocY;
        if(ty < SnackWin.GameLocY) ty = SnackWin.GameHeight + SnackWin.GameLocY - SnackWin.Size;
        Node tmp = new Node(tx, ty);
        return tmp;
    }
    void move()
    {
        Node head = headMove() , newNode = new Node();
        boolean eat = false;
        if(Math.abs(head.getX() - SnackWin.rx) < 10 && Math.abs(head.getY() - SnackWin.ry) < 10) {
            eat = true;
            newNode = new Node(lt.get(lt.size() - 1));
            SnackWin.rx = (int)(Math.random() * (SnackWin.GameWidth - 10) + SnackWin.GameLocX);
            SnackWin.ry = (int)(Math.random() * (SnackWin.GameHeight - 10) + SnackWin.GameLocY);
        }
        for(int i = lt.size() - 1; i > 0; i--)
            lt.set(i, lt.get(i - 1));
        lt.set(0, head);
        if(Dead()) {
            JOptionPane.showMessageDialog(null, "不能吃自己", "游戏结束", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        if(eat) {
            lt.add(newNode);
            SnackWin.score++;
            SnackWin.speed++;
        }
    }
    void changeDir(int dir) {curDir = dir;}
}
