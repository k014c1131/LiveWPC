package liveWPCGui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class liveWPC_create_figure_object extends liveWPC_create_object{
	private final String Rectangle = "Rectangle";
	private final String Circle = "Circle";
	private String Selectfigure;
	private Graphics2D g2d;
	private Color color;

	public liveWPC_create_figure_object(String figure_type,liveWPC_proprety_window proprety_window){
		super();
		setWindow(proprety_window);
		Selectfigure = figure_type;
		width = 50;
		height = 50;
		color = new Color(1,1,1);
		this.setVisible(true);
		this.repaint();
		this.setSize(1000,1000);
	}
	public liveWPC_create_figure_object(String figure_type,liveWPC_proprety_window proprety_window,int width,int height){
		super();
		setWindow(proprety_window);
		Selectfigure = figure_type;
		this.width = width;
		this.height = height;
		color = new Color(1,1,1);
		this.setVisible(true);
		this.repaint();
		this.setSize(1000,1000);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
		try{
			switch(Selectfigure){
			case Rectangle:
				//図形四角
				g2d.setColor(color);
				Rectangle2D.Double Drawfigure = new Rectangle2D.Double(0, 0, width, height);
			 	g2d.draw(Drawfigure);
		 		g2d.fill(Drawfigure);
				break;
			case Circle:
				g2d.setColor(color);
				g2d.drawOval(0,0,width,height);
				g2d.fillOval(0,0,width,height);
				//円を描画
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}


	}
	@Override
	public void objectReSize() {
		this.setSize(width,height);
		label.setSize(width,height);
		repaint();
		//サイズを再描画
	}

	@Override
	public void onClickObject(boolean setEnable){
		getWindow().get_select_object(this,0);
		super.onClickObject(setEnable);
	}
	public String getSelectfigure(){//オブジェクトがどの図形を選択しているか取得するために使用
		return Selectfigure;
	}

	@Override
	public String returnValue() {
		// TODO 自動生成されたメソッド・スタブ
		// 出力ファイル用:json式でデータを記述
		return null;
	}
	@Override
	public void refinealpha() {
		// TODO 自動生成されたメソッド・スタブ
		// 透過度の調整
		this.repaint();
	}
	@Override
	public String getImagePath() {
		// TODO 自動生成されたメソッド・スタブ
		// 不要
		return null;
	}

	@Override
	public String getObjectType() {
		// TODO 自動生成されたメソッド・スタブ
		return "figure";
	}

	@Override
	public void setColor(Color color) {
		// TODO 自動生成されたメソッド・スタブ
		this.color = color;
		System.out.println(color);
		this.repaint();

	}
}