package liveWPCGui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class liveWPC_create_object  extends JPanel{

		  private JLabel label;
		  private ImageIcon icon1;

		  liveWPC_create_object(){

		    icon1 = new ImageIcon("./img/en.png");

		    label = new JLabel(icon1);

		    // 座標指定
		    setLayout(null);
		    label.setBounds(0, 0, 100, 120);

		    // リスナーを登録
		    MyMouseListener listener = new MyMouseListener();
		    this.addMouseListener(listener);
		    this.addMouseMotionListener(listener);

		    add(label);

		  }

		  private class MyMouseListener extends MouseAdapter{
		    private int dx;
		    private int dy;

		    public void mouseDragged(MouseEvent e) {
		      // マウスの座標からラベルの左上の座標を取得する
		      int x = e.getXOnScreen() - dx;
		      int y = e.getYOnScreen() - dy;
		      setLocation(x, y);
		    }

		    public void mousePressed(MouseEvent e) {
		      // 押さえたところからラベルの左上の差を取っておく
		      dx = e.getXOnScreen() - getX();
		      dy = e.getYOnScreen() - getY();
		    }
		  }
}
