package liveWPCGui;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class liveWPC_create_object  extends JLabel{
	private ImageIcon icon;



		  liveWPC_create_object(){
			  icon = imageResize("./img/en.png");

		    setIcon(icon);
		    // 座標指定
		    //this.setLayout(null);
		    this.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		    //this.setLocation(0, 0);

		    // リスナーを登録
		    MyMouseListener listener = new MyMouseListener();
		    this.addMouseListener(listener);
		    this.addMouseMotionListener(listener);

		  }
		  liveWPC_create_object(String imagepath){
			  icon = imageResize(imagepath);

			    this.setIcon(icon);
			    // 座標指定
			    //this.setLayout(null);
			    this.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
			    //this.setLocation(0, 0);

			    // リスナーを登録
			    MyMouseListener listener = new MyMouseListener();
			    this.addMouseListener(listener);
			    this.addMouseMotionListener(listener);

			  }

			public ImageIcon imageResize(String str){
				icon = new ImageIcon(str);
				Image img = icon.getImage() ;//画像を読み込み
				Image newimg = img.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;//サイズを変更
				icon = new ImageIcon( newimg );//サイズ変更した画像に変更する
				return icon;
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
