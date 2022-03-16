package mnsx;

/**
 * @Description
 * @Author Mnsx_x
 * @Email xx1527030652@gmail.com
 * @Version
 * @Date 2021--10--13   21:19
 */
public class Node {
    private int x , y;
    public Node() {}
    public Node(int a , int b) {x = a; y = b;}
    public Node(Node tmp) {x = tmp.getX(); y = tmp.getY();}
    int getX() {return x;}
    int getY() {return y;}
    void setX(int a) {x = a;}
    void setY(int b) {y = b;}
}
