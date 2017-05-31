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

	liveWPC_proprety_window(){




		String[] textsizedata = {"18", "24", "30", "36"};
		String[] fontdata = {"ゴシック", "明朝", "メイリオ"};
		String[] triggerdata = {"タップ", "スライド", "表示"};
		String[] animemotiondata = {"回転","スクロール","遠近","出現","消失"};

		JComboBox textsize = new JComboBox(textsizedata);
			textsize.setEditable(true);
			textsize.setPreferredSize(new Dimension(50, 30));

		JComboBox font = new JComboBox(fontdata);
			font.setEditable(true);
			font.setPreferredSize(new Dimension(100, 30));



		JPanel p = new JPanel();
			p.setPreferredSize(new Dimension(200, 80));
			p.add(font,BorderLayout.WEST);
			p.add(textsize,BorderLayout.CENTER);

		JButton colorchange = new JButton();
			colorchange.setBackground(Color.RED);
			colorchange.setPreferredSize(new Dimension(20, 20));

		 JLabel Transparencylabel = new JLabel("透過度：");

		 JTextField Transparencytextbox = new JTextField("100");
		 	Transparencytextbox.setHorizontalAlignment(JTextField.CENTER);
		 	Transparencytextbox.setPreferredSize(new Dimension(40, 30));


		JPanel p2 = new JPanel();
			p2.setPreferredSize(new Dimension(200, 40));
			p2.add(colorchange,BorderLayout.LINE_START);
			p2.add(Transparencylabel,BorderLayout.LINE_START);
			p2.add(Transparencytextbox,BorderLayout.LINE_START);

			p.add(p2,BorderLayout.SOUTH);





		JLabel heightlabel = new JLabel("高さ：");

		 JTextField heighttextbox = new JTextField("100");
		 	heighttextbox.setHorizontalAlignment(JTextField.CENTER);
		 	heighttextbox.setPreferredSize(new Dimension(40, 30));

		JLabel widthlabel = new JLabel("幅：");

		 JTextField widthtextbox = new JTextField("100");
		 	widthtextbox.setHorizontalAlignment(JTextField.CENTER);
		 	widthtextbox.setPreferredSize(new Dimension(40, 30));

		 JPanel p3 = new JPanel();
			p3.setPreferredSize(new Dimension(200, 80));
			p3.add(heightlabel,BorderLayout.LINE_START);
			p3.add(heighttextbox,BorderLayout.LINE_START);
			p3.add(widthlabel,BorderLayout.LINE_START);
			p3.add(widthtextbox,BorderLayout.LINE_START);

		JLabel triggerlabel = new JLabel("起動条件：");

		JComboBox trigger = new JComboBox(triggerdata);
			trigger.setEditable(true);
			trigger.setPreferredSize(new Dimension(100, 30));

		JPanel p4 = new JPanel();
			p4.add(triggerlabel);
			p4.add(trigger,BorderLayout.SOUTH);

		p3.add(p4,BorderLayout.SOUTH);


		JPanel p5 = new JPanel();

		JLabel applabel = new JLabel("アプリ起動：");
			applabel.setPreferredSize(new Dimension(80, 30));

		JCheckBox appcheckbox = new JCheckBox();
			appcheckbox.setPreferredSize(new Dimension(20, 20));
			applabel.add(appcheckbox);


			p5.setPreferredSize(new Dimension(200, 80));
			p5.add(applabel,BorderLayout.LINE_START);
			p5.add(appcheckbox,BorderLayout.LINE_END);





			JPanel p6 = new JPanel();
				JLabel animespeedlabel = new JLabel("アニメ速度：");

				JTextField animespeedtextbox = new JTextField("100");
				animespeedtextbox.setHorizontalAlignment(JTextField.CENTER);
				animespeedtextbox.setPreferredSize(new Dimension(40, 30));

				p6.add(animespeedlabel,BorderLayout.LINE_START);
				p6.add(animespeedtextbox,BorderLayout.LINE_START);

				p5.add(p6,BorderLayout.SOUTH);



				JPanel p7 = new JPanel();

					JLabel animetimelabel = new JLabel("継続時間：");

					JTextField animetimetextbox = new JTextField("100");
						animetimetextbox.setHorizontalAlignment(JTextField.CENTER);
						animetimetextbox.setPreferredSize(new Dimension(40, 30));

					p7.setPreferredSize(new Dimension(200, 80));
					p7.add(animetimelabel,BorderLayout.LINE_START);
					p7.add(animetimetextbox,BorderLayout.LINE_START);

				JPanel p8 = new JPanel();

					JLabel animemotionlabel = new JLabel("アニメーション：");

					JComboBox animemotion = new JComboBox(animemotiondata);
						animemotion.setEditable(true);
						animemotion.setPreferredSize(new Dimension(50, 30));
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

}
