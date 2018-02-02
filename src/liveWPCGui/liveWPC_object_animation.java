package liveWPCGui;

import java.awt.Color;
import java.awt.Graphics;

//アニメーションを制御するためのクラス
//create_obnjectで継承してすべてのオブジェクトにアニメーションを実装する形にする

public class liveWPC_object_animation extends liveWPC_create_object{
	private int a_rotate,a_width,a_height,a_alpha,a_x,a_y;
	private liveWPC_animation_thread animecontroll;
	public liveWPC_object_animation(){
		super();
		//パラメタの初期化
		//フェード用
		a_alpha			= 0;

		//スクロール用
		a_x 			= 100;
		a_y 			= 100;

		//回転用
		a_rotate 		= 0;

		//スケール(拡縮)用
		a_width 		= 0;
		a_height 		= 0;

	}


	//表示 非表示
	public void fade(){

	}

	public void set_scroll(int a_x,int a_y){
		this.a_x = a_x;
		this.a_y = a_y;
	}

	//スクロール
	public void scroll(){
		int animationtype=1000;
		if(animecontroll!=null){
			animecontroll.stopThread();
			reflect_variables();
		}
		animecontroll = new liveWPC_animation_thread(this, animationtype , animespeed, a_x, a_y);
		animecontroll.start();
	}
	//回転
	public void rotate(){
		int animationtype=1002;
		if(animecontroll!=null){
			animecontroll.stopThread();
			reflect_variables();
		}
		animecontroll = new liveWPC_animation_thread(this, animationtype , animespeed, a_width, a_height);
		animecontroll.start();
	}

	public void set_scale(int a_height, int a_width){
		this.a_height 	= a_height;
		this.a_width 	= a_width;

	}

	//遠近
	public void scale(){
		int animationtype=1001;
		if(animecontroll!=null){
			animecontroll.stopThread();
			reflect_variables();
		}
		animecontroll = new liveWPC_animation_thread(this, animationtype , animespeed, a_x, a_y);
		animecontroll.start();

	}

	@Override
	public void objectReSize() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public String returnValue() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void refinealpha() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public String getImagePath() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getObjectType() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void setColor(Color color) {
		// TODO 自動生成されたメソッド・スタブ

	}
	@Override
	public void onClickObject(boolean setEnable){
		super.onClickObject(setEnable);

	}
	@Override
	public void paint(Graphics g){
		setLocation(x, y);
		super.paint(g);
	}

	public int getAnimeAlpha(){
		return a_alpha;
	}
	public void setAnimeAlpha(int alpha){
		this.a_alpha=alpha;
	}
	public int getAnimeX(){
		return a_x;
	}
	public void setAnimeX(int animex){
		this.a_x=animex;
	}
	public int getAnimeY(){
		return a_y;
	}
	public void setAnimeY(int animey){
		this.a_y=animey;
	}
	public int getAnimeRotate(){
		return a_rotate;
	}
	public void setAnimeRotate(int rotate){
		this.a_rotate=rotate;
	}
	public int getAnimeWidth(){
		return a_width;
	}
	public void setAnimeWidth(int width){
		this.a_width=width;
	}
	public int getAnimeHeight(){
		return a_height;
	}
	public void setAnimeHeight(int height){
		this.a_height=height;
	}

}


