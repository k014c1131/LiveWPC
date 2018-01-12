
package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class liveWPC_proprety_window extends liveWPC_window_base implements liveWPC_property_base,ActionListener,KeyListener,ItemListener{


	//プライベート変数の宣言
	private String[] textsize = {"12","18", "24", "30", "36"};
	private String[] fontdata = {"ゴシック", "明朝", "メイリオ"};
	private String[] triggerdata = {"タップ", "スライド", "表示","常時"};
	private String[] animemotiondata = {"なし","回転","スクロール","遠近","出現","消失"};
	private JComboBox text;
	private JComboBox font;
	private DefaultComboBoxModel textsizedata;
	private DefaultComboBoxModel fonttypedata;
	private JPanel p;
	private JButton colorchange;
	private JLabel triggerlabel;
	private JComboBox trigger;
	private JLabel applabel;
	private JCheckBox appcheckbox;
	private JButton animeplaybackbutton;
	//private JLabel animespeedlabel;
	private JTextField animespeedtextbox;
	//private JLabel animetimelabel;
	private JTextField animetimetextbox;
	private JLabel animemotionlabel;
	private JComboBox animemotion;
	private JTextField object_width;
	private JTextField object_height;
	private JTextField object_alpha_value;
	private JTextField object_animation_time;
	private JTextField object_animation_speed;
	private JTextField object_point_x;
	private JTextField object_point_y;
	private int object_type_number;

	private JTextField object_animation_x;
	private JTextField object_animation_y;
	private JTextField object_animation_fade;
	private JTextField object_animation_angle;

	private liveWPC_tool_window tool_window;
	private liveWPC_main_window main_window;

	public List <liveWPC_create_object> objs;//選択しているオブジェクトを格納
	public List <liveWPC_create_object> copyobjs;//コピーしたオブジェクトを格納

	private final static int TEXTOBJECTNUMBER = 0;


	liveWPC_proprety_window(){
		objs = new ArrayList <liveWPC_create_object>();
		copyobjs = new ArrayList <liveWPC_create_object>();
		object_type_number =1;
		object_height = new JTextField("100");
		object_width = new JTextField("100");
		object_point_x = new JTextField("100");
		object_point_y = new JTextField("100");
		object_alpha_value = new JTextField("100");;
		object_animation_time = new JTextField("100");
		object_animation_speed = new JTextField("100");
		object_animation_x = new JTextField("100");
		object_animation_y = new JTextField("100");
		object_animation_fade = new JTextField("100");
		object_animation_angle = new JTextField("100");

		call_proprety_window(1);
		//エンター押下字の処理を追加 ↓例
		//object_height.addAncestorListener(null);

	}
	public void call_proprety_window(){//プロパティウィンドウの起動
		create_text_proprety_field();
		p = new JPanel();
		p.setPreferredSize(new Dimension(200, 80));
		p.add(font,BorderLayout.WEST);
		p.add(text,BorderLayout.CENTER);

		colorchange = new JButton();
		colorchange.setBackground(Color.RED);
		colorchange.setPreferredSize(new Dimension(20, 20));
		colorchange.addActionListener(this);



	JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(200, 40));
		p2.add(colorchange,BorderLayout.LINE_START);
		p2.add(create_textbox("透過度：",object_alpha_value),BorderLayout.LINE_START);

		object_alpha_value.addActionListener(this);

		p.add(p2,BorderLayout.SOUTH);


	 JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(200, 90));
		p3.add(create_textbox("高さ：",object_height),BorderLayout.LINE_START);
		p3.add(create_textbox("幅：",object_width),BorderLayout.LINE_START);

		object_height.addActionListener(this);
		object_height.addKeyListener(this);

		object_width.addActionListener(this);
		object_width.addKeyListener(this);

		this.addKeyListener(this);


	 JPanel p4 = new JPanel();
		p4.setPreferredSize(new Dimension(300, 90));
		p4.add(create_textbox("X座標：",object_point_x),BorderLayout.LINE_START);
		p4.add(create_textbox("Y座標：",object_point_y),BorderLayout.LINE_START);
		p3.add(p4,BorderLayout.SOUTH);

		object_point_x.addActionListener(this);
		object_point_x.addKeyListener(this);

		object_point_y.addActionListener(this);
		object_point_y.addKeyListener(this);


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

		animeplaybackbutton=new JButton("再生");//アニメ再生ボタンの設定
		animeplaybackbutton.setPreferredSize(new Dimension(60, 20));


		p6.setPreferredSize(new Dimension(200, 30));
		p6.add(applabel,BorderLayout.LINE_START);
		p6.add(appcheckbox,BorderLayout.LINE_END);
		p6.add(animeplaybackbutton,BorderLayout.LINE_END);

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
			p8.add(create_textbox("継続時間：",object_animation_time),BorderLayout.LINE_START);
		JPanel p9 = new JPanel();

			animemotionlabel = new JLabel("アニメーション：");
			animemotion = new JComboBox(animemotiondata);
			animemotion.setEditable(true);
			animemotion.setPreferredSize(new Dimension(70, 30));
			p9.add(animemotionlabel);
			p9.add(animemotion);

		JPanel p10 = new JPanel();
			p10.setPreferredSize(new Dimension(200, 90));
			p10.add(create_textbox("移動先x座標：",object_animation_x),BorderLayout.LINE_START);
			p10.add(create_textbox("移動先y座標：",object_animation_y),BorderLayout.LINE_START);

			JPanel p11 = new JPanel();
			p11.setPreferredSize(new Dimension(200, 90));
			p11.add(create_textbox("アニメ透過度：",object_animation_fade),BorderLayout.LINE_START);
			p11.add(create_textbox("アニメ回転角：",object_animation_angle),BorderLayout.LINE_START);


	getContentPane().add(p);
	getContentPane().add(p3);
	getContentPane().add(p5);
	getContentPane().add(p6);
	getContentPane().add(p7);
	getContentPane().add(p8);
	getContentPane().add(p9);
	getContentPane().add(p10);
	getContentPane().add(p11);

	setBounds(50,50,220,650);//ウィンドウのサイズ指定
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
	public  JComboBox create_combo_box(DefaultComboBoxModel model){//文字列からコンボボックスを作るメソッド
		JComboBox box = new JComboBox(model);
		box.setEditable(true);
		return box;
	}

	public void change_text_size_box(Boolean Enabled){//テキストサイズのボックスの有効無効を設定するメソッド
		text.setEnabled(Enabled);
	}


	public void change_font_type_box(Boolean Enabled){//フォントタイプのボックスの有効無効を設定するメソッド
		font.setEnabled(Enabled);
	}

	public void change_animetion_x(boolean Enabled){
		object_animation_x.setEnabled(Enabled);
	}
	public void change_animetion_y(boolean Enabled){
		object_animation_y.setEnabled(Enabled);
	}
	public void change_animetion_fade(boolean Enabled){
		object_animation_fade.setEnabled(Enabled);
	}
	public void change_animetion_angle(boolean Enabled){
		object_animation_angle.setEnabled(Enabled);
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
		textsizedata = new  DefaultComboBoxModel(textsize);
		text = create_combo_box(textsizedata);
		text.addItemListener(this);
		text.setPreferredSize(new Dimension(50, 30));

		fonttypedata = new  DefaultComboBoxModel(fontdata);
		font = create_combo_box(fonttypedata);
		font.addItemListener(this);
		font.setPreferredSize(new Dimension(100, 30));
	}

	//入力された値をもとにオブジェクトのサイズを変更する
	public void refine_object_size(){
		int height = new Integer(object_height.getText());
		int width = new Integer(object_width.getText());
		objs.get(0).width = width;
		objs.get(0).height = height;
		objs.get(0).objectReSize();
		main_window.repaint();
	}

	/*
	 * オブジェクトの座標を入力値から変更する
	 */

	public void refine_object_point(){
		int x = new Integer(object_point_x.getText());
		int y = new Integer(object_point_y.getText());

		//ラベルのサイズ上限値
		if(x > 750){
			x = 750 - objs.get(0).width;
		}
		if(y > 480){
			y = 480 - objs.get(0).height;
		}
		//確認用座標表示
		//System.out.println(x+ " " +y);
		objs.get(0).setLocation(x,y);
		objs.get(0).x = x;
		objs.get(0).y = y;
	}
	public void refine_object_point(int changeValue,String xORy){//キー操作で座標変更するメソッド、strでxとyの変更する座標を判断
		int x = new Integer(object_point_x.getText());
		int y = new Integer(object_point_y.getText());

		switch (xORy){
		case "x":
			x = x + changeValue;
			break;
		case "y":
			y = y + changeValue;
			break;
		}

		//ラベルのサイズ上限値
		if(x > 750){
			x = 750 - objs.get(0).width;
		}
		if(y > 480){
			y = 480 - objs.get(0).height;
		}
		//確認用座標表示
		//System.out.println(x+ " " +y);
		objs.get(0).setLocation(x,y);
		objs.get(0).x = x;
		objs.get(0).y = y;

		object_point_x.setText(x + "");
		object_point_y.setText(y + "");
	}
	//オブジェクトから呼び出し
	//該当のオブジェクトをプロパティウィンドウで保持するメソッド
	//いずれ保持廃棄処理を分割する
	public void get_select_object(liveWPC_create_object obj,int object_type){

		if(objs.size() != 0){
			if(!objs.get(0).equals(obj)){
				objs.get(0).onClickObject(true);
				main_window.repaint();
			}
			objs.clear();
		}
		switch (obj.getObjectType()){
		case "figure":
			change_text_size_box(false);
			change_font_type_box(false);
		case "image":
			change_text_size_box(false);
			change_font_type_box(false);
			break;
		case "text":
			change_text_size_box(true);
			change_font_type_box(true);
			break;
		}

		objs.add(obj);
		tool_window.setLayer(obj);
		object_type_number = object_type;
		if (object_type == TEXTOBJECTNUMBER){
			//p.remove(textsize);
			//p.remove(font);
		}
		 get_object_size();
	}

	public void get_object_size(){
		//System.out.println(object_height.getText());
		object_height.setText(objs.get(0).height + "");
		object_width.setText(objs.get(0).width + "");
	}
/*
 * 選択オブジェクトの座標取得メソッド

 */
	public void get_object_point(){
		//System.out.println(object_height.getText());
		object_point_x.setText(objs.get(0).x + "");
		object_point_y.setText(objs.get(0).y + "");
	}
	/*
	 * 選択オブジェクトの透過度を調整する
	 */
	public void refine_object_alpha(){
		float alpha_value = 1;
		try{
			alpha_value = Float.parseFloat(object_alpha_value.getText());
			//System.out.println(alpha_value);
			if(alpha_value < 0){
				alpha_value = 0;
				object_alpha_value.setText("0");
			}else if(alpha_value > 100){
				alpha_value = 100;
				object_alpha_value.setText("100");
			}
			alpha_value = alpha_value / 100;
		}catch(Exception e){
			e.getStackTrace();
		}
		objs.get(0).alpha = alpha_value;
		objs.get(0).refinealpha();
		main_window.repaint();

	}

	public void actionPerformed(ActionEvent e) {


		if(e.getSource() == object_point_x || e.getSource() == object_point_y){
			refine_object_point();
		}else if(e.getSource() == object_alpha_value){
			refine_object_alpha();
		}else if(e.getSource() == object_height || e.getSource() == object_width){
			refine_object_size();
		}else if(e.getSource() == colorchange){
			JColorChooser colorchooser = new JColorChooser();

			Color color = colorchooser.showDialog(this, "色の選択", Color.white);

			if(color != null){
				colorchange.setBackground(color);
				//p.setBackground(color);

				if(objs.size()>0){
					switch(objs.get(0).getObjectType()){
					case "text":
						System.out.println("通過チェックtext");
						objs.get(0).setColor(color);
						break;
					case "figure":
						System.out.println("通過チェック");
						objs.get(0).setColor(color);
						break;
					case "image":
						break;
					}
					main_window.repaint();
				}
			}
		}

	}
	@Override
	public void keyTyped(KeyEvent e) {

	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			refine_object_point(-1,"y");
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			refine_object_point(1,"y");
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			refine_object_point(-1,"x");
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			refine_object_point(1,"x");
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {

		if(e.getModifiers() == KeyEvent.SHIFT_MASK && e.getKeyCode() == KeyEvent.VK_ENTER){
			System.out.println("SHIFT+ENTER：テキストフィールドに改行を追加");
			}

		if(e.getModifiers() == KeyEvent.CTRL_MASK && e.getKeyCode() == KeyEvent.VK_Z){
			System.out.println("Ctrl+Z：操作をひとつ戻す");
			}
		if(e.getModifiers() == KeyEvent.CTRL_MASK && e.getKeyCode() == KeyEvent.VK_C){


			if(copyobjs.size() != 0){
				copyobjs.clear();
			}
			if(objs.size() != 0){
				copyobjs.add(objs.get(0));
				System.out.println("Ctrl+C：選択中のオブジェクトをコピー領域に保存");
			}

			/*tool_window.setLayer(obj);
			object_type_number = object_type;*/
			 //get_object_size();
			}

		if(e.getModifiers() == KeyEvent.CTRL_MASK && e.getKeyCode() == KeyEvent.VK_V){
				if(copyobjs.size() != 0){
					System.out.println("Ctrl+V：保存領域にあるオブジェクトをメイン画面に追加");
					if(objs.size()>0){
						this.copyInsert(copyobjs.get(0).getObjectType());
					}
				}
			}

		if(e.getKeyCode() == KeyEvent.VK_DELETE){//選択中のオブジェクトの削除処理(仮)
			if(objs.size() != 0){
				main_window.removeObject(objs.remove(0));
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			refine_object_point(-1,"y");
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			refine_object_point(1,"y");
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			refine_object_point(-1,"x");
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			refine_object_point(1,"x");
		}


	}

	public void setWindow(liveWPC_tool_window tool_window,liveWPC_main_window main_window){
		this.tool_window=tool_window;
		this.main_window=main_window;
	}
	 public void itemStateChanged(ItemEvent e) {
		//int i = fonttypedata.getIndexOf(fonttypedata.getSelectedItem());
		if (e.getStateChange() == ItemEvent.SELECTED){
			if(e.getSource()==font){
				String data = (String) fonttypedata.getSelectedItem();
				String data2 = (String) textsizedata.getSelectedItem();
				if(0<Integer.parseInt(data2)){
					switch (data){
					case "ゴシック":
						objs.get(0).setFontType(new Font("ゴシック", 3,Integer.parseInt(data2)));
						break;
					case "明朝":
						objs.get(0).setFontType(new Font("明朝", 3,Integer.parseInt(data2)));
						break;
					case "メイリオ":
						objs.get(0).setFontType(new Font("メイリオ", 3,Integer.parseInt(data2)));
						break;
					}
				}
			}
			if(e.getSource()==animemotion){

			}

		}
	}
	public void copyInsert(String objecttype){
		try{
			liveWPC_create_object tc;
			System.out.println(copyobjs.size());
			switch(objecttype){
			case "text":
				tc = new liveWPC_create_text_object(this);
				liveWPC_create_text_object tmp=(liveWPC_create_text_object) copyobjs.get(0);
				main_window.insert_text(50,50,tmp.getWidth(),tmp.getHeight(),tmp.getTextArea().getText(),tmp.getLayer());
				//objs.get(0).setTextAreaFocus(false);
				break;
			case "figure":
				//System.out.println(copyobjs.get(0).getClass());
				liveWPC_create_figure_object tmp2=(liveWPC_create_figure_object) copyobjs.get(0);
				main_window.insert_figure(tmp2.getSelectfigure(),tmp2.width,tmp2.height);
				System.out.println(main_window.hasFocus()+" "+this.hasFocus());
				//main_window.requestFocus();
				break;
			case "image":
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
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

