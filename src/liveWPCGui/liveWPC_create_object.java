package liveWPCGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

//ツールバーの各機能を持ったクラス
//コンストラクタに変数を渡すことでどのクラスかを判別する
public class liveWPC_create_object  extends JPanel{
	public JLabel label;
	public boolean enableinfo;
	liveWPC_create_object(){
		label = new JLabel();
		this.setBackground(new Color(0,0,0,0));
		// リスナーを登録
		MyMouseListener listener = new MyMouseListener();
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);

		//パネルに追加
		this.add(label);
	}

	public void objectReSize(){
	}

	public void onClickObject(boolean setEnable){
		//重くなるようならLineBorderはプライベート変数に
		if(setEnable ==false){
			//ボーダーを青くする処理
			LineBorder border = new LineBorder(Color.blue);
			label.setBorder(border);
			repaint();
			enableinfo = true;
		}else{
			//ボーダーを透明化する処理
			LineBorder border = new LineBorder(new Color(0,0,0,0));
			label.setBorder(null);
			repaint();
			enableinfo = false;
		}
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
			onClickObject(enableinfo);
			objectReSize();
			int btn = e.getButton();
			if (btn == MouseEvent.BUTTON1){
				// 押さえたところからラベルの左上の差を取っておく
				dx = e.getXOnScreen() - getX();
				dy = e.getYOnScreen() - getY();
			}else if (btn == MouseEvent.BUTTON3){
				System.out.println("右ボタンクリック");
			}
		}

	}

}
