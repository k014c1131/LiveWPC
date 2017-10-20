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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
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
	private JPanel layerpanel;
	private ImageIcon icon;
	private ImageIcon geometryicon;
	private ImageIcon texticon;
	private ImageIcon imageicon;
	private ImageIcon saveicon;
	private ImageIcon loadicon;
	private File file = null;
	private liveWPC_text_write_read tw;
	private JTextField layer =new JTextField();
	private JButton recession;
	private JButton forward;
	private liveWPC_main_window main_window;
	private liveWPC_proprety_window proprety_window;
	private liveWPC_create_object obj;

	liveWPC_tool_window(){

		toolbar.setBounds(10, 10, 100, 10);
			toolbar.setFloatable(true);
			toolbar.setVisible(true);

		geometryicon	=	imageResize("img/icon1.png");//アイコンの変数作成
		texticon	=		imageResize("img/icon2.png");//アイコンの変数作成
		imageicon	=		imageResize("img/imageicon.jpg");//アイコンの変数作成
		saveicon	=		imageResize("img/saveicon.jpeg");//アイコンの変数作成
		loadicon	=		imageResize("img/loadicon.jpeg");//アイコンの変数作成

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
			toolpanel.setPreferredSize(new Dimension(160,200));
			toolpanel.setBackground(Color.WHITE);
			toolpanel.setVisible(true);
			toolpanel.setLayout(new FlowLayout(FlowLayout.LEFT));

			ToolIconAdd("img/en.png");//初期表示のアイコン設定
			ToolIconAdd("img/shikaku.png");
			ToolIconAdd("img/chouhoukei.png");
			ToolIconAdd("img/sankaku.png");

		layerpanel= new JPanel();
			layerpanel.setPreferredSize(new Dimension(160,200));
			layerpanel.setBackground(Color.WHITE);
			layerpanel.setVisible(true);
			layerpanel.setLayout(new FlowLayout(FlowLayout.LEFT));

			layerpanel.add(create_textbox("現在のレイヤー：",layer),BorderLayout.LINE_START);

			recession=setButtonSize(recession,"背面へ");
			recession.addActionListener(this);

			forward=setButtonSize(forward,"前へ");
			forward.addActionListener(this);

			JScrollPane scrollpane = new JScrollPane();//テスト中
			scrollpane.setPreferredSize(new Dimension(150,100));
			//scrollpane.setBackground(Color.WHITE);
			scrollpane.setVisible(true);

			JPanel jpanel = new JPanel();
			jpanel.setBackground(Color.WHITE);
			jpanel.setSize(50,10);
			JLabel label = new JLabel("test");
			jpanel.add(label);
			scrollpane.getViewport().setView(jpanel);


			layerpanel.add(forward);
			layerpanel.add(recession);
			layerpanel.add(scrollpane);


			getContentPane().add(toolbar,BorderLayout.CENTER);
		getContentPane().add(toolpanel,BorderLayout.SOUTH);
		getContentPane().add(layerpanel,BorderLayout.SOUTH);


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
	public JButton setButtonSize(JButton bt,String str){//ボタンのサイズを調整するメソッド
		bt = new JButton(str);
		bt.setSize(200,200);
		bt.setMargin(new Insets(0,0,0,0));
		//bt.addActionListener(this);
		return bt;
	}

	public void ToolIconAdd(String str){//ツールパネルにボタンを追加するメソッド
		icon =		imageResize(str);
		button =	new JButton(icon);
		button =	setButtonSize(button);
		button.addActionListener(//ボタンごとに処理作成ここから
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						//main_window.insert_image(str);
						main_window.insert_figure("Circle");
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
						main_window.insert_text();
					}
				}
				);									//ここまで
		toolpanel.add(button);
	}

	public void actionPerformed(ActionEvent e) {

		tw =new liveWPC_text_write_read();

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
		/*
		 * ファイル保存のメソッド
		 */
		if(e.getSource()==savebutton){
			JFileChooser filechooser =new JFileChooser() {

				@Override public void approveSelection() {	//上書き確認の処理
					file=getSelectedFile();//ファイルパスを取得


					if(file.toString().substring(file.toString().length() - 4).equals(".zip")){
						System.out.println(file.getPath());
					}
					else{
						//file = new File(file+".zip");
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
			FileNameExtensionFilter ff = new FileNameExtensionFilter(".zip(圧縮フォルダ)", "zip");
			filechooser.setFileFilter(ff);
				int selected =	filechooser.showSaveDialog(this);
				if(selected==JFileChooser.APPROVE_OPTION){

					tw.setList(main_window.getList());
					System.out.println(file.getPath());
					//file.mkdir();//フォルダを作成するメソッド
					System.out.println(file);
					tw.saveFile(file);
					}
			}
		if(e.getSource()==loadbutton){							//設定ファイルの読み込みメソッド
			JFileChooser filechooser=	new JFileChooser();
			int selected = filechooser.showOpenDialog(this);
			if(selected==JFileChooser.APPROVE_OPTION){
				file=				filechooser.getSelectedFile();//zipファイルのファイルパスを取得

				System.out.println(file.getParent()+" "+file.getName());
				try{
					String json = tw.readfile(file.getPath(), file.getParent());
					System.out.println(json);
					main_window.removeAllObject();

					//String json = "{\"enableinfo\":true,\"x\":337,\"y\":60,\"imagepath\":\"img/chouhoukei.png\",\"icon\":null}";


					ObjectMapper mapper = new ObjectMapper();

					List<liveWPC_text_value> list = mapper.readValue(json, new TypeReference<List<liveWPC_text_value>>() {});

					for(liveWPC_text_value line : list){
						//System.out.println(line.getX()+" "+line.getY()+" "+line.getWidth()+" "+line.getHeight()+" "+line.getTextString()+line.getImagepath());

						switch (line.getType()){
						case "Image":
							main_window.insert_image(line.getImagepath(),line.getX(),line.getY(),line.getWidth(),line.getHeight(),line.getLayer());
							break;
						case "TextArea":
							main_window.insert_text(line.getX(),line.getY(),line.getWidth(),line.getHeight(),line.getTextString(),line.getLayer());
							break;
						}

					}
					main_window.Sort();


					System.out.println(list.get(0));
					System.out.println(list.get(1));

				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		tw = null;//中身を初期化(これがないと同じファイルに書き込んだ時に、上書きではなく追記になる)


		if(e.getSource()==forward){//選択中のオブジェクトのレイヤーをひとつ前に動かす
			if(main_window.getPanel().getPosition(obj)-1>0){
				main_window.getPanel().setPosition(obj,main_window.getPanel().getPosition(obj)-1);
				obj.setLayer(main_window.getPanel().getPosition(obj));
				layer.setText(""+main_window.getPanel().getPosition(obj));
			}
			//main_window.getPanel().setPosition(obj,main_window.getPanel().getPosition(obj)-1);
			//layer.setText(""+main_window.getPanel().getPosition(obj));
		}
		if(e.getSource()==recession){//選択中のオブジェクトのレイヤーをひとつ後ろに動かす
			main_window.getPanel().setPosition(obj,main_window.getPanel().getPosition(obj)+1);
			obj.setLayer(main_window.getPanel().getPosition(obj));
			layer.setText(""+main_window.getPanel().getPosition(obj));
		}
	}

	public void copyFile(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(),outChannel);
			main_window.insert_image(out.getPath());

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
	public void setWindow(liveWPC_main_window main_window,liveWPC_proprety_window proprety_window){
		this.main_window=main_window;
		this.proprety_window=proprety_window;
		this.addKeyListener(proprety_window);
	}
	public JPanel create_textbox(String str,JTextField jtf){//文字列からテキストフィールドとラベルの組み合わせたパーツを作るメソッド
		//使いたいタイミングでは同期ができないためプロパティ画面からコピーした
		JLabel label = new JLabel(str);
		JTextField textbox =jtf;
		textbox.setHorizontalAlignment(JTextField.CENTER);
	 	textbox.setPreferredSize(new Dimension(40, 30));
	 	JPanel p =new JPanel();
	 	p.add(label,BorderLayout.LINE_START);
		p.add(textbox,BorderLayout.LINE_START);
	 	return p;
	}
	public void setLayer(liveWPC_create_object obj){
		this.obj=obj;
		layer.setText(""+main_window.getPanel().getPosition(this.obj));
	}

}


