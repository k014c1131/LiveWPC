package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class liveWPC_tool_window extends liveWPC_window_base{
	private JButton button;
	private JToolBar toolbar=new JToolBar();
	private JButton geometrybutton;
	private JButton textbutton;
	private JButton imagebutton;
	private JButton bt4;
	private JPanel toolpanel;
	private ImageIcon geometryicon;
	private ImageIcon texticon;
	private ImageIcon imageicon;
	private ImageIcon icon4;

	liveWPC_tool_window(){


		toolbar.setBounds(10, 10, 100, 10);
		toolbar.setFloatable(true);
		//toolbar.setSize(50,10);
		toolbar.setVisible(true);

		geometryicon = new ImageIcon("img/icon1.png");//アイコンの変数作成
		texticon = new ImageIcon("img/icon2.png");//アイコンの変数作成
		imageicon = new ImageIcon("img/imageicon.jpg");//アイコンの変数作成
		icon4 = new ImageIcon("img/icon4.png");//アイコンの変数作成
		geometryicon= imageResize(geometryicon);
		texticon = imageResize(texticon);
		imageicon = imageResize(imageicon);
		icon4 = imageResize(icon4);

		geometrybutton = new JButton(geometryicon);
		geometrybutton = setButtonSize(geometrybutton);
		geometrybutton.addActionListener(//ボタンごとに処理作成ここから
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						toolpanel.removeAll();//ツールバーの中身を削除
						ToolIconAdd(new ImageIcon("img/en.png"),toolpanel);
						ToolIconAdd(new ImageIcon("img/shikaku.png"),toolpanel);
						ToolIconAdd(new ImageIcon("img/chouhoukei.png"),toolpanel);
						ToolIconAdd(new ImageIcon("img/sankaku.png"),toolpanel);

						toolpanel.revalidate();//ツール画面全体を更新
						//toolpanel.repaint();//ツール画面全体を更新
					}
				}
				);											 //ここまで
		toolbar.add(geometrybutton);

		textbutton = new JButton(texticon);
		textbutton = setButtonSize(textbutton);
		textbutton.addActionListener(//ボタンごとに処理作成ここから
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						toolpanel.removeAll();//ツールバーの中身を削除
						ToolIconAdd(texticon,toolpanel);
						toolpanel.revalidate();//ツール画面全体を更新
					}
				}
				);										 //ここまで
		toolbar.add(textbutton);

		imagebutton = new JButton(imageicon);
		imagebutton = setButtonSize(imagebutton);
		toolbar.add(imagebutton);


		bt4 = new JButton(icon4);
		bt4 = setButtonSize(bt4);
		toolbar.add(bt4);

		toolpanel = new JPanel();
			toolpanel.setPreferredSize(new Dimension(160,400));
			toolpanel.setBackground(Color.WHITE);
			toolpanel.setVisible(true);
			toolpanel.setLayout(new FlowLayout(FlowLayout.LEFT));

			ImageIcon testicon = new ImageIcon("img/icon1.png");//アイコンの変数作成
			ToolIconAdd(testicon,toolpanel);




		getContentPane().add(toolbar,BorderLayout.CENTER);
		getContentPane().add(toolpanel,BorderLayout.SOUTH);

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
	public void ToolIconAdd(ImageIcon icon,JPanel toolpanel){
		icon= imageResize(icon);
		button = new JButton(icon);
		button = setButtonSize(button);
		toolpanel.add(button);
		//toolpanel.repaint();
		//toolpanel.removeAll();

	}
}
