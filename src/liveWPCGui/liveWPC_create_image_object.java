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
	liveWPC_create_image_object(String imagepath,liveWPC_proprety_window proprety_window){//初期生成用
		super();

		setWindow(proprety_window);
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
	liveWPC_create_image_object(String imagepath,int width,int height,liveWPC_proprety_window proprety_window
			,String animename,int a_alpha,double animespeed,double animetime,int a_x,int a_y,int a_rotate
			){//読みこみ時使用
		super();

		setWindow(proprety_window);
		this.imagepath=imagepath;
		this.width = width;
		this.height = height;
		this.setVisible(true);
		this.repaint();
		this.setSize(width,height);
		this.setAnimeName(animename);
		this.setAnimeTime(animetime);
		this.setAnimeSpeed(animespeed);
		this.setAnimeAlpha(a_alpha);
		this.setAnimeRotate(a_rotate);
		this.set_scroll(a_x, a_y);
		objectReSize();
	}
	liveWPC_create_image_object(String imagepath,int width,int height,liveWPC_proprety_window proprety_window){//読みこみ時使用
		super();

		setWindow(proprety_window);
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
		System.out.println(this.getWidth());
		label.setSize(width,height);
		repaint();
	}

	@Override
	public void onClickObject(boolean setEnable){
		//liveWPC_proprety_window.get_select_object(this,0);
		getWindow().get_select_object(this,0);
		super.onClickObject(setEnable);
	}
	@Override
	public String returnValue() {//設定値の情報を返すメソッド
		String str;
		str =	"{"+
				"\"type\":\"Image\","+
				"\"x\":"+this.getX()+","+
				"\"y\":"+this.getY()+","+
				"\"width\":"+this.getWidth()+","+
				"\"height\":"+this.getHeight()+","+
				"\"ImagePath\":\""+this.getImagePath()+"\","+
				"\"layer\":"+this.getLayer()+","+
				"\"animename\":\""+this.getAnimeName()+"\","+
				"\"animealpha\":"+this.getAnimeAlpha()+","+
				"\"animespeed\":"+this.getAnimeSpeed()+","+
				"\"animex\":"+this.getAnimeX()+","+
				"\"animey\":"+this.getAnimeY()+","+
				"\"animerotate\":"+this.getAnimeRotate()+","+
				"\"animewidth\":"+this.getAnimeWidth()+","+
				"\"animeheight\":"+this.getAnimeHeight()+""+
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