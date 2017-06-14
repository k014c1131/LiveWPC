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
	private ImageIcon icon;
	private ImageIcon geometryicon;
	private ImageIcon texticon;
	private ImageIcon imageicon;
	private ImageIcon icon4;

	liveWPC_tool_window(){


		toolbar.setBounds(10, 10, 100, 10);
		toolbar.setFloatable(true);
		//toolbar.setSize(50,10);
		toolbar.setVisible(true);

		geometryicon = imageResize("img/icon1.png");//アイコンの変数作成
		texticon = imageResize("img/icon2.png");//アイコンの変数作成
		imageicon = imageResize("img/imageicon.jpg");//アイコンの変数作成
		icon4 = imageResize("img/icon4.png");//アイコンの変数作成

		geometrybutton = new JButton(geometryicon);
		geometrybutton = setButtonSize(geometrybutton);
		geometrybutton.addActionListener(//ボタンごとに処理作成ここから
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						toolpanel.removeAll();//ツールバーの中身を削除
						ToolIconAdd("img/en.png");
						ToolIconAdd("img/shikaku.png");
						ToolIconAdd("img/chouhoukei.png");
						ToolIconAdd("img/sankaku.png");

						toolpanel.revalidate();//ツール一覧の表示を更新
						repaint();//ツール画面全体を更新
					}
				}
				);											 //ここまで
		toolbar.add(geometrybutton);

		textbutton = new JButton(imageResize(texticon));
		textbutton = setButtonSize(textbutton);
		toolbar.add(textbutton);
		textbutton.addActionListener(//ボタンごとに処理作成ここから
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						toolpanel.removeAll();//ツールバーの中身を削除
						ToolIconAdd("img/icon2.png");
						toolpanel.revalidate();//ツール画面全体を更新
						repaint();

					}
				}
				);										 //ここまで


		imagebutton = new JButton(imageResize(imageicon));
		imagebutton = setButtonSize(imagebutton);
		toolbar.add(imagebutton);


		bt4 = new JButton(imageResize(icon4));
		bt4 = setButtonSize(bt4);
		toolbar.add(bt4);

		toolpanel = new JPanel();
			toolpanel.setPreferredSize(new Dimension(160,400));
			toolpanel.setBackground(Color.WHITE);
			toolpanel.setVisible(true);
			toolpanel.setLayout(new FlowLayout(FlowLayout.LEFT));

			ImageIcon testicon = new ImageIcon("img/icon1.png");//アイコンの変数作成
			ToolIconAdd("img/icon1.png");



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
	public ImageIcon imageResize(String str){
		icon = new ImageIcon(str);
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
	public void ToolIconAdd(String str){//ツールパネルにボタンを追加するメソッド

		icon =imageResize(str);
		button = new JButton(icon);
		button = setButtonSize(button);
		button.addActionListener(//ボタンごとに処理作成ここから
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						liveWPC_main_window.insert_circle(str);
					}
				}
				);										 //ここまで

		toolpanel.add(button);
		//toolpanel.repaint();
		//toolpanel.removeAll();

	}
}
