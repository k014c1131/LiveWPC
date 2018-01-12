package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
	protected int x,y,x_base,y_base;
	protected int width = -1;
	protected int width_base = -1;
	protected int height = -1;
	protected int height_base = -1;
	protected float alpha,alpha_base;
	protected Color color;
	protected boolean action;	//アクショントリガーの有無判別する
	protected String animename;	//アニメーションの種類と時間速度を設定
	protected int animetime;	//アニメーションの時間を設定
	protected int animespeed;	//アニメーションの速度を設定
	protected int layer;
	private liveWPC_proprety_window proprety_window;

	//アニメーションの種類と時間速度を設定

	liveWPC_create_object(){
		label = new JLabel();
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(new BorderLayout());
		// リスナーを登録
		MyMouseListener listener = new MyMouseListener();
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		//オブジェクト座標
		x_base = 0;
		x = x_base;
		y_base = 0;
		y = y_base;
		//パネルに追加;
		this.add(label);

		//透過度
		alpha_base = 1;
		alpha = alpha_base;
	}

	public abstract void objectReSize();
	public abstract String returnValue();
	public abstract void refinealpha();
	public abstract String getImagePath();
	public abstract String getObjectType();
	public abstract void setColor(Color color);

	public void onClickObject(boolean setEnable){
		//重くなるようならLineBorderはプライベート変数に
		if(setEnable ==false){
			//ボーダーを青くする処理
			LineBorder border = new LineBorder(Color.blue);
			this.setBorder(border);
			repaint();
			enableinfo = true;
			proprety_window.get_object_size();
			proprety_window.get_object_point();
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
			x_base = e.getXOnScreen() - dx;
			y_base = e.getYOnScreen() - dy;
			reflect_variables();
			setLocation(x, y);
			proprety_window.get_object_size();
			proprety_window.get_object_point();
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
	public int getLayer(){//仮置き
		return layer;
	}
	public void setLayer(int layer){//仮置き
		this.layer=layer;
	}

	protected void setWindow(liveWPC_proprety_window proprety_window){
		this.proprety_window=proprety_window;
	}

	protected liveWPC_proprety_window getWindow(){
		return	proprety_window;
	}
	protected void setFontType(Font f){

	}

	public void reflect_variables(){
		x 		=	x_base;
		y 		=	y_base;
		alpha 	=	alpha_base;
	}
	public Component getTextArea() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public void setTextAreaFocus(boolean b){
	}

	/*@Override
	public void paint(Graphics g){//現在使用してない
		setLocation(x, y);
		super.paint(g);
	}*/

}
