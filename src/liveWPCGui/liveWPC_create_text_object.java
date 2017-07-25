package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class liveWPC_create_text_object extends liveWPC_create_object{

	private JTextArea textf= new JTextArea();

	liveWPC_create_text_object(){
		super();

		LineBorder border = new LineBorder(Color.black);
		textf.setBorder(border);//選択範囲の確認用

		textf.setSize(200, 40);
		MyMouseListener listener = new MyMouseListener();
		textf.addMouseListener(listener);
		textf.addMouseMotionListener(listener);

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
	}

	@Override
	public void objectReSize(){
	}
	@Override
	public String returnValue() {
		String str;
		str =	"{\r\n"+
				"type:TextArea\r\n"+
				"x:"+this.getX()+"\r\n"+
				"y:"+this.getY()+"\r\n"+
				"width:"+this.getWidth()+"\r\n"+
				"heigth:"+this.getHeight()+"\r\n"+
				"String:"+textf.getText()+"\r\n"+
				"}\r\n";

		return str;
	}
	@Override
	public void refinealpha() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
