package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class liveWPC_create_text_object extends liveWPC_create_object{
	private int height = 0;
	private int width = 0;

	private JTextField textf= new JTextField();

	liveWPC_create_text_object(){
		super();

		this.setLayout(new BorderLayout());

		LineBorder border = new LineBorder(Color.blue);
		this.setBorder(border);//選択範囲の確認用


		//textf.setText("ここに入力してください。");
		textf.setSize(200, 40);
		MyMouseListener listener = new MyMouseListener();
		textf.addMouseListener(listener);
		textf.addMouseMotionListener(listener);

		//label.setSize(textf.getWidth()+10, textf.getHeight()+10);
		this.setSize(textf.getWidth(), textf.getHeight());
		//textf.setBorder(null);




		//textf.setOpaque(false);
		//textf.setBorder(null);
		textf.setVisible(true);
		//textf.setLocation(5,5);
		this.add(textf,BorderLayout.CENTER);
		//label.add(textf);
		//label.setVisible(true);




	}
	public void setMargin(){
		textf.setMargin(new Insets(10,10,10,10));
	}


}
