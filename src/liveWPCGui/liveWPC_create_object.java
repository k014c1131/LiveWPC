package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//ツールバーの各機能を持ったクラス
//コンストラクタに変数を渡すことでどのクラスかを判別する
public abstract class liveWPC_create_object  extends JPanel{
	public JLabel label;
	public boolean enableinfo;
	protected int x,y;
	protected int width = -1;
	protected int height = -1;
	protected float alpha;
	liveWPC_create_object(){
		label = new JLabel();
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(new BorderLayout());
		// リスナーを登録
		MyMouseListener listener = new MyMouseListener();
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		//オブジェクト座標
		x = 0;
		y = 0;
		//パネルに追加;
		this.add(label);

		//透過度
		alpha = 1;
	}

	public abstract void objectReSize();
	public abstract String returnValue();
	public abstract void refinealpha();

	public void onClickObject(boolean setEnable){
		//重くなるようならLineBorderはプライベート変数に
		System.out.println(returnValue());
		if(setEnable ==false){
			//ボーダーを青くする処理
			LineBorder border = new LineBorder(Color.blue);
			this.setBorder(border);
			repaint();
			enableinfo = true;
			liveWPC_proprety_window.get_object_size();
			liveWPC_proprety_window.get_object_point();
		}else{
			//ボーダーを透明化する処理
			this.setBorder(null);
			repaint();
			enableinfo = false;
		}
	}


	protected class MyMouseListener extends MouseAdapter{
		private int dx;
		private int dy;

		public void mouseDragged(MouseEvent e) {
			// マウスの座標からラベルの左上の座標を取得する
			x = e.getXOnScreen() - dx;
			y = e.getYOnScreen() - dy;
			setLocation(x, y);
			liveWPC_proprety_window.get_object_size();
			liveWPC_proprety_window.get_object_point();
		}

		public void mousePressed(MouseEvent e) {
			onClickObject(enableinfo);
			setLocation(x, y);
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
	/*@Override
	public void paint(Graphics g){//現在使用してない
		setLocation(x, y);
		super.paint(g);
	}*/

}
