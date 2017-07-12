
package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.util.*;

public class liveWPC_proprety_window extends liveWPC_window_base implements liveWPC_property_base{


	//プライベート変数の宣言
	private String[] textsizedata = {"18", "24", "30", "36"};
	private String[] fontdata = {"ゴシック", "明朝", "メイリオ"};
	private String[] triggerdata = {"タップ", "スライド", "表示"};
	private String[] animemotiondata = {"回転","スクロール","遠近","出現","消失"};
	private static JComboBox textsize;
	private static JComboBox font;
	private static JPanel p;
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
	private static JTextField object_width;
	private static JTextField object_height;
	private JTextField object_alpha_value;
	private JTextField object_animation_time;
	private JTextField object_animation_speed;
	private static JTextField object_point_x;
	private static JTextField object_point_y;
	private static int object_type_number;

	private static List <liveWPC_create_object> objs;//選択しているオブジェクトを格納

	private final static int TEXTOBJECTNUMBER = 0;


	liveWPC_proprety_window(){
		objs = new ArrayList <liveWPC_create_object>();
		object_type_number =1;
		object_height = new JTextField("100");
		object_width = new JTextField("100");
		object_point_x = new JTextField("100");
		object_point_y = new JTextField("100");
		object_alpha_value = new JTextField("100");;
		object_animation_time = new JTextField("100");
		object_animation_speed = new JTextField("100");
		//エンター押下字の処理を追加 ↓例
		//object_height.addAncestorListener(null);

	}
	public void call_proprety_window(){//プロパティウィンドウの起動
		create_text_proprety_field();
		p = new JPanel();
		p.setPreferredSize(new Dimension(200, 80));
		p.add(font,BorderLayout.WEST);
		p.add(textsize,BorderLayout.CENTER);

		colorchange = new JButton();
		colorchange.setBackground(Color.RED);
		colorchange.setPreferredSize(new Dimension(20, 20));



	JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(200, 40));
		p2.add(colorchange,BorderLayout.LINE_START);
		p2.add(create_textbox("透過度：",object_alpha_value),BorderLayout.LINE_START);

		p.add(p2,BorderLayout.SOUTH);


	 JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(200, 90));
		p3.add(create_textbox("高さ：",object_height),BorderLayout.LINE_START);
		p3.add(create_textbox("幅：",object_width),BorderLayout.LINE_START);

	 JPanel p4 = new JPanel();
		p4.setPreferredSize(new Dimension(300, 90));
		p4.add(create_textbox("X座標：",object_point_x),BorderLayout.LINE_START);
		p4.add(create_textbox("Y座標：",object_point_y),BorderLayout.LINE_START);

		p3.add(p4,BorderLayout.SOUTH);

	JPanel p5 = new JPanel();
		triggerlabel = new JLabel("起動条件：");
		trigger = new JComboBox(triggerdata);
		trigger.setEditable(true);
		trigger.setPreferredSize(new Dimension(100, 30));

		p5.add(triggerlabel);
		p5.add(trigger,BorderLayout.SOUTH);


	JPanel p6 = new JPanel();

		applabel = new JLabel("アプリ起動：");
		applabel.setPreferredSize(new Dimension(80, 30));

		appcheckbox = new JCheckBox();
		appcheckbox.setPreferredSize(new Dimension(20, 20));
		applabel.add(appcheckbox);


		p6.setPreferredSize(new Dimension(200, 30));
		p6.add(applabel,BorderLayout.LINE_START);
		p6.add(appcheckbox,BorderLayout.LINE_END);

		JPanel p7 = new JPanel();

		animespeedtextbox = new JTextField("100");
		animespeedtextbox.setHorizontalAlignment(JTextField.CENTER);
		animespeedtextbox.setPreferredSize(new Dimension(40, 30));

		p7.add(create_textbox("アニメ速度：",object_animation_speed),BorderLayout.LINE_START);

		JPanel p8 = new JPanel();
			p8.setPreferredSize(new Dimension(200, 40));


			animetimetextbox = new JTextField("100");
			animetimetextbox.setHorizontalAlignment(JTextField.CENTER);
			animetimetextbox.setPreferredSize(new Dimension(40, 30));
			//p7.add(animetimelabel,BorderLayout.LINE_START);
			//p7.add(animetimetextbox,BorderLayout.LINE_START);
			p8.add(create_textbox("継続時間：",object_animation_time),BorderLayout.LINE_START);
		JPanel p9 = new JPanel();

			animemotionlabel = new JLabel("アニメーション：");
			animemotion = new JComboBox(animemotiondata);
			animemotion.setEditable(true);
			animemotion.setPreferredSize(new Dimension(70, 30));
			p9.add(animemotionlabel);
			p9.add(animemotion);

	getContentPane().add(p);
	getContentPane().add(p3);
	getContentPane().add(p5);
	getContentPane().add(p6);
	getContentPane().add(p7);
	getContentPane().add(p8);
	getContentPane().add(p9);
	//getContentPane().add(p2, BorderLayout.CENTER);
	//getContentPane().add(font, BorderLayout.NORTH);
	//getContentPane().add(textsize, BorderLayout.NORTH);
	//getContentPane().add(colorchange,BorderLayout.LINE_START);

	setBounds(50,100,220,450);
	setResizable(false);


	setVisible(true);

	}



	public void call_proprety_window(int i){//エントリーポイント
		if(i==0){
			call_proprety_window();//文字の時
		}
		if(i==1){
			call_proprety_window();//画像の時
			change_text_size_box(false);
			change_font_type_box(false);
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


	public JPanel create_textbox(String str,JTextField jtf){//文字列からテキストフィールドとラベルの組み合わせたパーツを作るメソッド
		JLabel label = new JLabel(str);
		JTextField textbox =jtf;
		textbox.setHorizontalAlignment(JTextField.CENTER);
	 	textbox.setPreferredSize(new Dimension(40, 30));
	 	JPanel p =new JPanel();
	 	p.add(label,BorderLayout.LINE_START);
		p.add(textbox,BorderLayout.LINE_START);
	 	return p;
	}
	//テキストフィールドオブジェクト用プロパティウィンドウ生成部分
	public void create_text_proprety_field(){
		textsize = create_combo_box(textsizedata);
		textsize.setPreferredSize(new Dimension(50, 30));

		font = create_combo_box(fontdata);
		font.setPreferredSize(new Dimension(100, 30));
	}

	//入力された値をもとにオブジェクトのサイズを変更する
	public void refine_object_size(){
		int height = new Integer(object_height.getText());
		int width = new Integer(object_width.getText());
		objs.get(0).width = width;
		objs.get(0).height = height;
		objs.get(0).objectReSize();

	}
	//オブジェクトから呼び出し
	//該当のオブジェクトをプロパティウィンドウで保持するメソッド
	//いずれ保持廃棄処理を分割する
	public static void get_select_object(liveWPC_create_object obj,int object_type){
		if(objs.size() != 0){
			objs.clear();
		}
		objs.add(obj);
		object_type_number = object_type;
		if (object_type == TEXTOBJECTNUMBER){
			//p.remove(textsize);
			//p.remove(font);
		}
		get_object_size();
	}

	public static void get_object_size(){
		System.out.println(object_height.getText());
		object_height.setText(objs.get(0).height + "");
		object_width.setText(objs.get(0).width + "");
	}
/*
 * 選択オブジェクトの座標取得メソッド
 * 座標を表示する場所がないため現在コメントアウト
 */
	public static void get_object_point(){
		System.out.println(object_height.getText());
		object_point_x.setText(objs.get(0).x + "");
		object_point_y.setText(objs.get(0).y + "");
	}


class IntegerInputVerifier extends InputVerifier {
	  @Override public boolean verify(JComponent c) {
	    boolean verified = false;
	    JTextField textField = (JTextField) c;
	    try {
	      Integer.parseInt(textField.getText());
	      verified = true;
	    } catch (NumberFormatException e) {
	      UIManager.getLookAndFeel().provideErrorFeedback(c);
	      //Toolkit.getDefaultToolkit().beep();
	    }
	    return verified;
	  }
	}

}
