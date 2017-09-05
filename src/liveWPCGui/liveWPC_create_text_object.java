package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class liveWPC_create_text_object extends liveWPC_create_object{

	private JTextArea textf= new JTextArea();
	private liveWPC_proprety_window proprety_window;

	public liveWPC_create_text_object(liveWPC_proprety_window proprety_window){
		super();

		LineBorder border = new LineBorder(Color.black);
		textf.setBorder(border);//選択範囲の確認用

		//textf.setSize(200, 40);
		MyMouseListener listener = new MyMouseListener();
		textf.addMouseListener(listener);
		textf.addMouseMotionListener(listener);
		objectReSize();

		/*this.setSize(
				textf.getWidth(),
				textf.getHeight());*/

		textf.setVisible(true);
		textf.addKeyListener(proprety_window);
		this.add(
				textf,
				BorderLayout.CENTER);

	}
	public liveWPC_create_text_object(int width,int height,String text){
		super();

		LineBorder border = new LineBorder(Color.black);
		textf.setBorder(border);//選択範囲の確認用

		textf.setSize(width, height);
		MyMouseListener listener = new MyMouseListener();
		textf.addMouseListener(listener);
		textf.addMouseMotionListener(listener);
		textf.setText(text);

		this.setSize(
				textf.getWidth(),
				textf.getHeight());

		textf.setVisible(true);
		this.add(
				textf,
				BorderLayout.CENTER);

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
		liveWPC_proprety_window.get_select_object(this,0);
		super.onClickObject(setEnable);
	}

	@Override
	public void objectReSize(){
		textf.setSize(200, 35);
		this.setSize(
				textf.getWidth(),
				textf.getHeight());
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
		str =	"{\r\n"+
				"\"type\":\"TextArea\",\r\n"+
				"\"x\":"+this.getX()+",\r\n"+
				"\"y\":"+this.getY()+",\r\n"+
				"\"width\":"+this.getWidth()+",\r\n"+
				"\"height\":"+this.getHeight()+",\r\n"+
				"\"String\":\""+textf.getText()+"\"\r\n"+
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

}
