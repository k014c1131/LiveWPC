package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class liveWPC_tool_window extends liveWPC_window_base implements ActionListener{
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
	private File file = null;

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
						ToolIconAdd("img/en.png");//ツールバーのアイコンを変更　ここから
						ToolIconAdd("img/shikaku.png");
						ToolIconAdd("img/chouhoukei.png");
						ToolIconAdd("img/sankaku.png");//						ここまで

						toolpanel.revalidate();//ツール一覧の表示を更新
						repaint();//ツール画面全体を再描画
					}
				}
				);											 //ここまで
			toolbar.add(geometrybutton);

		textbutton = new JButton(imageResize(texticon));//テキストボックス挿入のボタン
			textbutton = setButtonSize(textbutton);
			toolbar.add(textbutton);
			textbutton.addActionListener(//ボタンごとに処理作成ここから
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						toolpanel.removeAll();//ツールバーの中身を削除
						ToolTextIconAdd("img/icon2.png");//ツールバーのアイコンを変更

						toolpanel.revalidate();//ツール画面全体を更新
						repaint();

					}
				}
				);										 //ここまで


		imagebutton = new JButton(imageResize(imageicon));//画像挿入のボタン
			imagebutton = setButtonSize(imagebutton);
			imagebutton.addActionListener(this);
			toolbar.add(imagebutton);


		bt4 = new JButton(imageResize(icon4));//その他機能のボタン
			bt4 = setButtonSize(bt4);
			toolbar.add(bt4);


		toolpanel = new JPanel();	//ツール一覧の基本設定
			toolpanel.setPreferredSize(new Dimension(160,400));
			toolpanel.setBackground(Color.WHITE);
			toolpanel.setVisible(true);
			toolpanel.setLayout(new FlowLayout(FlowLayout.LEFT));


			ToolIconAdd("img/en.png");//初期表示のアイコン設定
			ToolIconAdd("img/shikaku.png");
			ToolIconAdd("img/chouhoukei.png");
			ToolIconAdd("img/sankaku.png");



		getContentPane().add(toolbar,BorderLayout.CENTER);
		getContentPane().add(toolpanel,BorderLayout.SOUTH);

		setBounds(1100,100,200,500);

	}


	public ImageIcon imageResize(ImageIcon icon){//アイコンをサイズ調整するメソッド
		Image img = icon.getImage() ;//画像を読み込み
		Image newimg = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;//サイズを変更
		icon = new ImageIcon( newimg );//サイズ変更した画像に変更する
		return icon;
	}


	public ImageIcon imageResize(String str){//文字列からアイコンを作りをサイズ調整するメソッド
		icon = new ImageIcon(str);
		Image img = icon.getImage() ;//画像を読み込み
		Image newimg = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;//サイズを変更
		icon = new ImageIcon( newimg );//サイズ変更した画像に変更する
		return icon;
	}


	public JButton setButtonSize(JButton bt){//ボタンのサイズを調整するメソッド
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
						liveWPC_main_window.insert_image(str);
					}
				}
				);										 //ここまで

		toolpanel.add(button);
		//toolpanel.repaint();
		//toolpanel.removeAll();

	}
	public void ToolTextIconAdd(String str){//ツールパネルにボタンを追加するメソッド

		icon =imageResize(str);
		button = new JButton(icon);
		button = setButtonSize(button);
		button.addActionListener(//ボタンごとに処理作成ここから
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						liveWPC_main_window.insert_text();
					}
				}
				);										 //ここまで

		toolpanel.add(button);
		//toolpanel.repaint();
		//toolpanel.removeAll();

	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==imagebutton){
			 JFileChooser filechooser =new JFileChooser();
				int selected = filechooser.showOpenDialog(this);
				if(selected==JFileChooser.APPROVE_OPTION){
					file=filechooser.getSelectedFile();//ファイルパスを取得


					//jl1.setText(file.getName());


					try(BufferedReader in=new BufferedReader(new FileReader(file));){
						copyFile(file,new File("./tmp/"+file.getName()));

					}catch(IOException ex){
						ex.printStackTrace();
					}
				}
			}
		}


	 public static void copyFile(File in, File out) throws IOException {
	        FileChannel inChannel = new FileInputStream(in).getChannel();
	        FileChannel outChannel = new FileOutputStream(out).getChannel();
	        try {
	            inChannel.transferTo(0, inChannel.size(),outChannel);
	            //System.out.println(out.getPath());
				liveWPC_main_window.insert_image(out.getPath());
	        }
	        catch (IOException e) {
	            throw e;
	        }
	        finally {
	            if (inChannel != null) inChannel.close();
	            if (outChannel != null) outChannel.close();
	        }
	    }

}
