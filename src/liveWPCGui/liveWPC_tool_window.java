package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class liveWPC_tool_window extends liveWPC_window_base implements ActionListener{
	private JButton button;
	private JToolBar toolbar=new JToolBar();
	private JButton geometrybutton;
	private JButton textbutton;
	private JButton imagebutton;
	private JButton savebutton;
	private JButton loadbutton;
	private JPanel toolpanel;
	private ImageIcon icon;
	private ImageIcon geometryicon;
	private ImageIcon texticon;
	private ImageIcon imageicon;
	private ImageIcon saveicon;
	private ImageIcon loadicon;
	private File file = null;
	private liveWPC_text_write_read tw =new liveWPC_text_write_read();
	liveWPC_tool_window(){

		toolbar.setBounds(10, 10, 100, 10);
			toolbar.setFloatable(true);
			toolbar.setVisible(true);

		geometryicon	=	imageResize("img/icon1.png");//アイコンの変数作成
		texticon	=		imageResize("img/icon2.png");//アイコンの変数作成
		imageicon	=		imageResize("img/imageicon.jpg");//アイコンの変数作成
		saveicon	=		imageResize("img/icon4.png");//アイコンの変数作成
		loadicon	=		imageResize("img/icon4.png");//アイコンの変数作成

		geometrybutton	=	new JButton(geometryicon);
			geometrybutton=	setButtonSize(geometrybutton);
			geometrybutton.addActionListener(//ボタンごとに処理作成ここから
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						toolpanel.removeAll();//ツールバーの中身を削除
						ToolIconAdd("img/en.png");//ツールバーのアイコンを変更ここから
						ToolIconAdd("img/shikaku.png");
						ToolIconAdd("img/chouhoukei.png");
						ToolIconAdd("img/sankaku.png");//		アイコンを変更ここまで

						toolpanel.revalidate();//ツール一覧の表示を更新
						repaint();			//ツール画面全体を再描画
					}
				}
				);										 //処理作成ここまで
			toolbar.add(geometrybutton);

		textbutton=			new JButton(imageResize(texticon));//テキストボックス挿入のボタン
			textbutton=	setButtonSize(textbutton);
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

		imagebutton=		new JButton(imageResize(imageicon));//画像挿入のボタン
			imagebutton=	setButtonSize(imagebutton);
			imagebutton.addActionListener(this);
			toolbar.add(imagebutton);

		savebutton=			new JButton(imageResize(saveicon));//保存機能のボタン
			savebutton=		setButtonSize(savebutton);
			savebutton.addActionListener(this);
			toolbar.add(savebutton);

		loadbutton=			new JButton(imageResize(loadicon));//読み込み機能のボタン
			loadbutton=		setButtonSize(loadbutton);
			loadbutton.addActionListener(this);
			toolbar.add(loadbutton);

		toolpanel=			new JPanel();	//ツール一覧の基本設定
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
		Image img =		icon.getImage() ;//画像を読み込み
		Image newimg =	img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;//サイズを変更
		icon =			new ImageIcon( newimg );//サイズ変更した画像に変更する
		return icon;
	}

	public ImageIcon imageResize(String str){//文字列からアイコンを作りをサイズ調整するメソッド
		icon =			new ImageIcon(str);
		Image img =		icon.getImage() ;//画像を読み込み
		Image newimg =	img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;//サイズを変更
		icon =			new ImageIcon( newimg );//サイズ変更した画像に変更する
		return icon;
	}

	public JButton setButtonSize(JButton bt){//ボタンのサイズを調整するメソッド
		bt.setSize(20,20);
		bt.setMargin(new Insets(0,0,0,0));
		return bt;
	}

	public void ToolIconAdd(String str){//ツールパネルにボタンを追加するメソッド
		icon =		imageResize(str);
		button =	new JButton(icon);
		button =	setButtonSize(button);
		button.addActionListener(//ボタンごとに処理作成ここから
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						liveWPC_main_window.insert_image(str);
					}
				}
				);									 //ここまで
		toolpanel.add(button);
	}
	public void ToolTextIconAdd(String str){//ツールパネルにボタンを追加するメソッド
		icon=		imageResize(str);
		button =	new JButton(icon);
		button =	setButtonSize(button);
		button.addActionListener(//ボタンごとに処理作成ここから
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						liveWPC_main_window.insert_text();
					}
				}
				);									//ここまで
		toolpanel.add(button);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==imagebutton){						//画像挿入のメソッド
			JFileChooser filechooser=	new JFileChooser();
				int selected = filechooser.showOpenDialog(this);
				if(selected==JFileChooser.APPROVE_OPTION){
					file=				filechooser.getSelectedFile();//画像のファイルパスを取得

					try{
						copyFile(file,new File("img/"+file.getName()));

					}catch(IOException ex){
						ex.printStackTrace();
					}
				}
			}

		if(e.getSource()==savebutton){						//ファイル保存のメソッド
			JFileChooser filechooser =new JFileChooser() {

				@Override public void approveSelection() {	//上書き確認の処理
					file=getSelectedFile();//ファイルパスを取得


					if(file.toString().substring(file.toString().length() - 4).equals(".zip")){
						System.out.println(file.getPath());
					}
					else{
						file = new File(file+".zip");
						System.out.println(file.getPath());
					}
					if (file.exists() && getDialogType() == SAVE_DIALOG) {
						//ここで上書き確認のウィンドウを表示する
						String m = String.format(
								"<html>%s は既に存在します。<br>上書きしますか？",
								file.getName());
						int rv = JOptionPane.showConfirmDialog(
								this, m, "Save As", JOptionPane.YES_NO_OPTION);
						if (rv != JOptionPane.YES_OPTION) {
							return;
						}
					}
					super.approveSelection();
				}
			};
			FileNameExtensionFilter ff = new FileNameExtensionFilter(".txt(テキストファイル)", "txt");
			filechooser.setFileFilter(ff);
				int selected =	filechooser.showSaveDialog(this);
				if(selected==JFileChooser.APPROVE_OPTION){

					tw.setList(liveWPC_main_window.getList());
					System.out.println(file.getPath());
					//file.mkdir();//フォルダを作成するメソッド
					tw.saveFile(file);
					//tw = null;	//中身を初期化(これがないと同じファイルに書き込んだ時に、
								//上書きではなく追記になる)
				}
			}
		if(e.getSource()==loadbutton){							//設定ファイルの読み込みメソッド
			JFileChooser filechooser=	new JFileChooser();
			int selected = filechooser.showOpenDialog(this);
			if(selected==JFileChooser.APPROVE_OPTION){
				file=				filechooser.getSelectedFile();//zipファイルのファイルパスを取得

				//System.out.println(file.getParent()+" "+file.getName());
				try{
					//tw.unzip(file.getPath(),file.getParent());
					System.out.println(tw.readfile(file.getPath(), file.getParent()));
					String json = tw.readfile(file.getPath(), file.getParent());
					System.out.println(json);

					//String json = "{\"enableinfo\":true,\"x\":337,\"y\":60,\"imagepath\":\"img/chouhoukei.png\",\"icon\":null}";


					ObjectMapper mapper = new ObjectMapper();

					List<liveWPC_text_value> list = mapper.readValue(json, new TypeReference<List<liveWPC_text_value>>() {});

					System.out.println(list.get(0));
					System.out.println(list.get(1));

					/*String json = "{\"id\":20, \"name\":\"HOGE\"}";
					System.out.println(json);
					ObjectMapper mapper = new ObjectMapper();
					Hoge hoge = mapper.readValue(json, Hoge.class);
					System.out.println(hoge);*/
					/*Hoge hoge = new Hoge();
					hoge.id = 10;
						hoge.name = "hoge";

						ObjectMapper mapper = new ObjectMapper();
						String json = mapper.writeValueAsString(hoge);

						System.out.println(json);*/
					/*String json = "[{\"id\":15, \"name\":\"hoge\"}, {\"id\":16, \"name\":\"fuga\"}]";

						ObjectMapper mapper = new ObjectMapper();

						List<Hoge> list = mapper.readValue(json, new TypeReference<List<Hoge>>() {});

						System.out.println(list.get(0));
						System.out.println(list.get(1));*/
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
	}

	public void copyFile(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(),outChannel);
			liveWPC_main_window.insert_image(out.getPath());

			if (inChannel != null){
				inChannel.close();
			}
			if (outChannel != null){
				outChannel.close();
			}
		}
		catch (IOException e) {
			throw e;
		}
		finally {
		}
	}

}


