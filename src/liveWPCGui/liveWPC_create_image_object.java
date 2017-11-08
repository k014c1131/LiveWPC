package liveWPCGui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class liveWPC_create_image_object extends liveWPC_object_animation{
	private String imagepath;
	private BufferedImage image;
	private Graphics2D g2d;
	liveWPC_create_image_object(String imagepath){//初期生成用
		super();
		this.imagepath=imagepath;
		this.setVisible(true);
		this.repaint();
		this.setSize(1000,1000);

		/*
		label.setBackground(null);
		label.setIcon(icon);
		label.setVisible(true);
		// 座標指定
		objectReSize();
		*/
	}
	liveWPC_create_image_object(String imagepath,int width,int height){//読みこみ時使用
		super();
		this.imagepath=imagepath;
		this.width = width;
		this.height = height;
		this.setVisible(true);
		this.repaint();
		objectReSize();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
		try {
			image = ImageIO.read(new File(imagepath));
			if(width == -1 && height == -1){
				width = image.getWidth();
				height = image.getHeight();this.setSize(image.getWidth(),image.getHeight());
			}
			g2d.drawImage(image,0,0,width,height, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	@Override
	public void objectReSize(){
		this.setSize(width,height);
		label.setSize(width, height);
		label.setSize(width,height);
		repaint();
	}

	@Override
	public void onClickObject(boolean setEnable){
		liveWPC_proprety_window.get_select_object(this,0);
		super.onClickObject(setEnable);
	}
	@Override
	public String returnValue() {//設定値の情報を返すメソッド
		String str;
		str =	"{\r\n"+
				"\"type\":\"Image\",\r\n"+
				"\"x\":"+this.getX()+",\r\n"+
				"\"y\":"+this.getY()+",\r\n"+
				"\"width\":"+this.getWidth()+",\r\n"+
				"\"height\":"+this.getHeight()+",\r\n"+
				"\"ImagePath\":\""+this.getImagePath()+"\",\r\n"+
				"\"layer\":"+this.getLayer()+"\r\n"+
				"}";

		return str;
	}
	public String getImagePath(){

		return imagepath.replace("\\", "/");
	}

	public void refinealpha(){
		this.repaint();
	}
	@Override
	public String getObjectType() {
		return "image";
	}
	@Override
	public void setColor(Color color) {
		this.color=color;
	}



}