package liveWPCGui;

import java.awt.Color;
import java.awt.Graphics;

//アニメーションを制御するためのクラス
//create_obnjectで継承してすべてのオブジェクトにアニメーションを実装する形にする

public class liveWPC_object_animation extends liveWPC_create_object{
	private int a_rotate,a_width,a_height,a_alpha,a_x,a_y;
	private double rotate;
	private long fade_speed,scroll_speed,scale_speed,rotate_speed;
	private liveWPC_animation_thread animecontroll;
	public liveWPC_object_animation(){
		//パラメタの初期化
		//フェード用
		a_alpha			= 0;
		fade_speed		= 10;

		//スクロール用
		a_x 			= 100;
		a_y 			= 100;
		scroll_speed	= 15;

		//回転用
		a_rotate 		= 0;
		rotate_speed	= 10;

		//スケール(拡縮)用
		a_width 		= 0;
		a_height 		= 0;
		scale_speed		= 10;

	}

	public void set_fade(int a_alpha, double fade_speed){
		fade_speed	= this.fade_speed;

	}

	//表示 非表示
	public void fade(){

	}

	public void set_scroll(int a_x,int a_y, double scroll_speed){
		a_x = this.a_x;
		a_y = this.a_y;
		scroll_speed = this.scroll_speed;
	}

	//スクロール
	public void scroll(){
		animecontroll = new liveWPC_animation_thread(this, 1000, scroll_speed, a_x, a_y);
		animecontroll.run();
	}

	public void set_rotate(int a_rotate){
		a_rotate = this.a_rotate;

	}
	//回転
	public void rotate(){

	}

	public void set_scale(int a_height, int a_width , double scale_speed){
		a_height 	= this.a_height;
		a_width 	= this.a_width;
		scale_speed = this.scale_speed;

	}

	//遠近
	public void scale(){

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
		//super.onClickObject(setEnable);
		scroll();

	}
	@Override
	public void paint(Graphics g){
		setLocation(x, y);
		super.paint(g);
	}

}


