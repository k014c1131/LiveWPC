package liveWPCGui;
/*
    アニメーション制御用スレッド
    引数にアニメーションさせるオブジェクト、アニメーションのタイプを引き渡す
    **第一引数 int型
    1000 = スクロール
    1001 = フェード
    1002 = 回転

    **第二引数 double型
    アニメーションの速度

    **第三引数以降 double型
    アニメーションに使うパラメータ
    スクロールなら移動後のxy座標
*/

public class liveWPC_animation_thread extends Thread {
        private int animationtype;
        private int a_rotate,a_width,a_height,a_alpha,a_x,a_y;
        private long speed;
        private static final int SCROLL = 1000;
        private static final int FADE = 1001;
        private static final int ROTATE = 1002;
        private liveWPC_create_object animationobject;

        //コンストラクタ
        public liveWPC_animation_thread(liveWPC_create_object animationobject,int animationtype,double animationspeed,double firstvalue,double secondvalue){
            this.animationtype = animationtype;
            this.animationobject = animationobject;
            long tmp = (long) (100 - animationspeed);
            if(tmp <= 0){
            	tmp = 1;
            }
            speed =tmp;
            if(animationtype == SCROLL){
                a_x = (int) firstvalue;
                a_y = (int) secondvalue;
            }else if(animationtype == FADE){
               a_alpha = (int) firstvalue;
            }else if(animationtype == ROTATE){
                a_rotate = (int) firstvalue;
            }


        }

        @Override
        public void run() {
        	if(animationtype == SCROLL){
            	for(int i = 0;i<a_x || i < a_y;i++){

                    if(i<+a_x){
                        animationobject.x++;
                    }
                    if(animationobject.y_base+i<animationobject.y_base+a_y){
                        animationobject.y++;
                    }
                    animationobject.repaint();
                    try {
                    	Thread.sleep(speed);
					}catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
                }
            }else if(animationtype == FADE){
            	if(a_alpha<0){
            		for(int i = (int) animationobject.alpha;i>a_alpha;i--){
                        animationobject.alpha--;
                        animationobject.repaint();
                    }
            	}else{
            		for(int i = (int) animationobject.alpha;i<a_alpha;i++){
                        animationobject.alpha++;
                        animationobject.repaint();
                    }
            	}

            	/*for(int i = 0;i<a_alpha;i++){
                    animationobject.alpha++;
                    animationobject.repaint();
            	}*/
            }else if(animationtype == ROTATE){
            	//回転処理
            }
        	//値の初期化処理
        	//Todo:stopThreadでやった方がいいかも？
        	animationobject.reflect_variables();
        	animationobject.getWindow().get_object_point();
        	animationobject.repaint();
        }
       //スレッド終了時に呼び出し
        public void stopThread(){
        }

}