package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class liveWPC_proprety_window extends liveWPC_window_base{

	private String[] textsizedata = {"18", "24", "30", "36"};
	private String[] fontdata = {"ゴシック", "明朝", "メイリオ"};
	private String[] triggerdata = {"タップ", "スライド", "表示"};
	private String[] animemotiondata = {"回転","スクロール","遠近","出現","消失"};
	private JComboBox textsize;
	private JComboBox font;
	private JPanel p = new JPanel();
	private JButton colorchange;
	private JLabel triggerlabel;
	private JComboBox trigger;
	private JLabel applabel;
	private JCheckBox appcheckbox;
	//private JLabel animespeedlabel;
	private JTextField animespeedtextbox;
	//private JLabel animetimelabel;
	private JTextField animetimetextbox;
	private JLabel animemotionlabel;
	private JComboBox animemotion;

	private liveWPC_create_object obj;//選択しているオブジェクトを格納

	liveWPC_proprety_window(){

	}
	public void call_proprety_window(){//プロパティウィンドウの起動





		colorchange = new JButton();
		colorchange.setBackground(Color.RED);
		colorchange.setPreferredSize(new Dimension(20, 20));

	JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(200, 40));
		p2.add(colorchange,BorderLayout.LINE_START);
		p2.add(create_textbox("透過度："),BorderLayout.LINE_START);

		p.add(p2,BorderLayout.SOUTH);


	 JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(200, 90));
		p3.add(create_textbox("高さ："),BorderLayout.LINE_START);
		p3.add(create_textbox("幅："),BorderLayout.LINE_START);

		triggerlabel = new JLabel("起動条件：");

		trigger = new JComboBox(triggerdata);
		trigger.setEditable(true);
		trigger.setPreferredSize(new Dimension(100, 30));

	JPanel p4 = new JPanel();
		p4.add(triggerlabel);
		p4.add(trigger,BorderLayout.SOUTH);

	p3.add(p4,BorderLayout.SOUTH);


	JPanel p5 = new JPanel();

		applabel = new JLabel("アプリ起動：");
		applabel.setPreferredSize(new Dimension(80, 30));

		appcheckbox = new JCheckBox();
		appcheckbox.setPreferredSize(new Dimension(20, 20));
		applabel.add(appcheckbox);


		p5.setPreferredSize(new Dimension(200, 80));
		p5.add(applabel,BorderLayout.LINE_START);
		p5.add(appcheckbox,BorderLayout.LINE_END);



		JPanel p6 = new JPanel();

			animespeedtextbox = new JTextField("100");
			animespeedtextbox.setHorizontalAlignment(JTextField.CENTER);
			animespeedtextbox.setPreferredSize(new Dimension(40, 30));

			p6.add(create_textbox("アニメ速度："),BorderLayout.LINE_START);

			p5.add(p6,BorderLayout.SOUTH);



			JPanel p7 = new JPanel();
			p7.setPreferredSize(new Dimension(200, 90));


					animetimetextbox = new JTextField("100");
					animetimetextbox.setHorizontalAlignment(JTextField.CENTER);
					animetimetextbox.setPreferredSize(new Dimension(40, 30));


				//p7.add(animetimelabel,BorderLayout.LINE_START);
				//p7.add(animetimetextbox,BorderLayout.LINE_START);
				p7.add(create_textbox("継続時間："),BorderLayout.LINE_START);

			JPanel p8 = new JPanel();

					animemotionlabel = new JLabel("アニメーション：");

					animemotion = new JComboBox(animemotiondata);
					animemotion.setEditable(true);
					animemotion.setPreferredSize(new Dimension(70, 30));
					p8.add(animemotionlabel);
					p8.add(animemotion);


				p7.add(p8,BorderLayout.SOUTH);

	getContentPane().add(p);
	getContentPane().add(p3);
	getContentPane().add(p5);
	getContentPane().add(p7);
	//getContentPane().add(p2, BorderLayout.CENTER);
	//getContentPane().add(font, BorderLayout.NORTH);
	//getContentPane().add(textsize, BorderLayout.NORTH);
	//getContentPane().add(colorchange,BorderLayout.LINE_START);

	setBounds(50,100,200,400);


	setVisible(true);

	}



	public void call_proprety_window(int i){//エントリーポイント
		if(i==0){
			create_text_proprety();
			call_proprety_window();//文字の時
		}
		if(i==1){
			call_proprety_window();//画像の時
			//change_text_size_box(false);
			//change_font_type_box(false);
		}
		if(i==2){
			call_proprety_window();//図形の時
		}
	}


	public  JComboBox create_combo_box(String[] str){//文字列からコンボボックスを作るメソッド
		JComboBox box = new JComboBox(str);
		box.setEditable(true);
		return box;
	}


	public void change_text_size_box(Boolean Enabled){//テキストサイズのボックスの有効無効を設定するメソッド
		textsize.setEnabled(Enabled);
	}


	public void change_font_type_box(Boolean Enabled){//フォントタイプのボックスの有効無効を設定するメソッド
		font.setEnabled(Enabled);
	}


	public JPanel create_textbox(String str){//文字列からテキストフィールドとラベルの組み合わせたパーツを作るメソッド
		JLabel label = new JLabel(str);
		JTextField textbox = new JTextField("100");
		textbox.setHorizontalAlignment(JTextField.CENTER);
	 	textbox.setPreferredSize(new Dimension(40, 30));
	 	JPanel p =new JPanel();
	 	p.add(label,BorderLayout.LINE_START);
		p.add(textbox,BorderLayout.LINE_START);
	 	return p;
	}

	public void create_text_proprety(){
		textsize = create_combo_box(textsizedata);
		textsize.setPreferredSize(new Dimension(50, 30));

		font = create_combo_box(fontdata);
		font.setPreferredSize(new Dimension(100, 30));

		p.setPreferredSize(new Dimension(200, 80));
		p.add(font,BorderLayout.WEST);
		p.add(textsize,BorderLayout.CENTER);


	}

}
