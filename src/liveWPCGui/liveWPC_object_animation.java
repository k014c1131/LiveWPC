package liveWPCGui;

//アニメーションを制御するためのクラス
//create_obnjectで継承してすべてのオブジェクトにアニメーションを実装する形にする

public class liveWPC_object_animation(){
	private int a_width,a_height,a_alpha,a_x,a_y;
	private double rotate,fade_speed,scroll_speed,scale_speed,rotate_speed;
	public liveWPC_object_animation(){
		//パラメタの初期化
		//フェード用
		a_alpha			= 0;
		fade_speed		= 0;
		
		//スクロール用
		a_x 			= 0;
		a_y 			= 0;
		scroll_speed	= 0;

		//回転用
		a_rotate 		= 0;
		rotate_speed	= 0;

		//スケール(拡縮)用
		a_width 		= 0;
		a_height 		= 0;
		scale_speed		= 0;

	}

	public void set_fade(int a_alpha, double fade_speed){
		fade_speed	= this.fade_speed;

	}

	//表示　非表示
	public void fade(){

	}

	public void set_scroll(int a_x,int a_y, double scroll_speed){
		a_x = this.a_x;
		a_y = this.a_y;
		scroll_speed = this.scroll_speed;
	}

	//スクロール
	public void scroll(){

	}

	public void set_rotate(int a_rotate){
		a_rotate = this.a_rotate

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
}