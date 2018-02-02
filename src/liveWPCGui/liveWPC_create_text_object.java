package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class liveWPC_create_text_object extends liveWPC_object_animation{

	private JTextArea textf= new JTextArea();

	public liveWPC_create_text_object(liveWPC_proprety_window proprety_window){
		super();

		setWindow(proprety_window);
		LineBorder border = new LineBorder(Color.black);
		textf.setBorder(border);//選択範囲の確認用

		//textf.setSize(200, 40);
		MyMouseListener listener = new MyMouseListener();
		textf.addMouseListener(listener);
		textf.addMouseMotionListener(listener);
		width=200;
		height=40;
		objectReSize();

		/*this.setSize(
				textf.getWidth(),
				textf.getHeight());*/

		textf.setVisible(true);
		textf.addKeyListener(proprety_window);
		this.add(
				textf,
				BorderLayout.CENTER);
		textf.setFont(new Font("ゴシック", 3,12));

		objectReSize();

	}
	public liveWPC_create_text_object(int width,int height,String text,liveWPC_proprety_window proprety_window){
		super();

		setWindow(proprety_window);
		LineBorder border = new LineBorder(Color.black);
		textf.setBorder(border);//選択範囲の確認用

		textf.setSize(width, height);
		this.setSize(width, height);
		MyMouseListener listener = new MyMouseListener();
		textf.addMouseListener(listener);
		textf.addMouseMotionListener(listener);
		textf.setText(text);

		textf.setVisible(true);
		this.add(
				textf,
				BorderLayout.CENTER);
		textf.setFont(new Font("ゴシック", 3,12));

		this.width=width;
		this.height=height;
		objectReSize();

	}
	public liveWPC_create_text_object(int width,int height,String text,liveWPC_proprety_window proprety_window
			,String animename,int a_alpha,double animespeed,double animetime,int a_x,int a_y,int a_rotate
			,Color color){
		super();

		setWindow(proprety_window);
		LineBorder border = new LineBorder(Color.black);
		textf.setBorder(border);//選択範囲の確認用

		textf.setSize(width, height);
		this.setSize(width, height);
		MyMouseListener listener = new MyMouseListener();
		textf.addMouseListener(listener);
		textf.addMouseMotionListener(listener);
		textf.setText(text);

		textf.setVisible(true);
		this.add(
				textf,
				BorderLayout.CENTER);
		textf.setFont(new Font("ゴシック", 3,12));

		this.width=width;
		this.height=height;
		objectReSize();
		this.setColor(color);
		this.setAnimeName(animename);
		this.setAnimeTime(animetime);
		this.setAnimeSpeed(animespeed);
		this.setAnimeAlpha(a_alpha);
		this.setAnimeRotate(a_rotate);
		this.set_scroll(a_x, a_y);

	}
	@Override
	public void onClickObject(boolean setEnable){
		//このオブジェクトではlabelを使わないためメソッド内容を変更
		//重くなるようならLineBorderはプライベート変数に
		if(setEnable ==false){
			//ボーダーを青くする処理
			LineBorder border = new LineBorder(Color.blue);
			textf.setBorder(border);
			repaint();
			enableinfo = true;
		}else{
			//ボーダーを透明化する処理
			LineBorder border = new LineBorder(Color.black);
			textf.setBorder(border);
			repaint();
			enableinfo = false;
		}
		getWindow().get_select_object(this,0);
		super.onClickObject(setEnable);
	}

	@Override
	public void objectReSize(){
		textf.setSize(width,height);
		this.setSize(
				textf.getWidth(),
				textf.getHeight());
		this.onClickObject(!enableinfo);
	}
	public void objectReSize(int x,int y,int width,int height){
		textf.setSize(width, height);
		this.setSize(
				textf.getWidth(),
				textf.getHeight());
		this.repaint();
	}
	@Override
	public String returnValue() {
		String str;
		str =	"{"+
				"\"type\":\"TextArea\","+
				"\"x\":"+this.getX()+","+
				"\"y\":"+this.getY()+","+
				"\"width\":"+this.getWidth()+","+
				"\"height\":"+this.getHeight()+","+
				"\"String\":\""+textf.getText()+"\","+
				"\"layer\":"+this.getLayer()+","+
				"\"animename\":\""+this.getAnimeName()+"\","+
				"\"animealpha\":"+this.getAnimeAlpha()+","+
				"\"animespeed\":"+this.getAnimeSpeed()+","+
				"\"animex\":"+this.getAnimeX()+","+
				"\"animey\":"+this.getAnimeY()+","+
				"\"animerotate\":"+this.getAnimeRotate()+","+
				"\"animewidth\":"+this.getAnimeWidth()+","+
				"\"animeheight\":"+this.getAnimeHeight()+","+
				"\"color\":"+this.getColor().getRGB()+""+
				"}";

		return str;
	}
	@Override
	public String getImagePath() {//プログラムの仕様上必要
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	@Override
	public void refinealpha() {
		// TODO 自動生成されたメソッド・スタブ

	}
	@Override
	public String getObjectType() {
		return "text";
	}
	@Override
	public void setColor(Color color) {
		this.textf.setForeground(color);

	}
	public Color getColor(){
		return this.textf.getForeground();
	}
	public void setFontType(Font f){
		textf.setFont(f);
	}
	public  JTextArea getTextArea(){
		return textf;
	}
	public void setTextAreaFocus(boolean b){
		textf.setFocusable(b);
	}

}
