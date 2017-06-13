package liveWPCGui;

import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class liveWPC_tool_window extends liveWPC_window_base{
	private JToolBar toolbar=new JToolBar();
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	liveWPC_tool_window(){


		toolbar.setBounds(10, 10, 100, 10);
		toolbar.setFloatable(true);
		//toolbar.setSize(50,10);
		toolbar.setVisible(true);

		ImageIcon icon = new ImageIcon("img/icon1.png");//アイコンの変数作成
		ImageIcon icon2 = new ImageIcon("img/icon2.png");//アイコンの変数作成
		ImageIcon icon3 = new ImageIcon("img/icon3.png");//アイコンの変数作成
		ImageIcon icon4 = new ImageIcon("img/icon4.png");//アイコンの変数作成
		icon= imageResize(icon);
		icon2 = imageResize(icon2);
		icon3 = imageResize(icon3);
		icon4 = imageResize(icon4);

		bt1 = new JButton(icon);
		bt1 = setButtonSize(bt1);
		toolbar.add(bt1);

		bt2 = new JButton(icon2);
		bt2 = setButtonSize(bt2);
		toolbar.add(bt2);

		bt3 = new JButton(icon3);
		bt3 = setButtonSize(bt3);
		toolbar.add(bt3);


		bt4 = new JButton(icon4);
		bt4 = setButtonSize(bt4);
		toolbar.add(bt4);



		getContentPane().add(toolbar);
		setBounds(1100,100,200,500);
		liveWPC_main_window.insert_circle();
	}
	public ImageIcon imageResize(ImageIcon icon){
		Image img = icon.getImage() ;//画像を読み込み
		Image newimg = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;//サイズを変更
		icon = new ImageIcon( newimg );//サイズ変更した画像に変更する
		return icon;
	}
	public JButton setButtonSize(JButton bt){
		bt.setSize(20,20);
		bt.setMargin(new Insets(0,0,0,0));
		return bt;
	}
}
