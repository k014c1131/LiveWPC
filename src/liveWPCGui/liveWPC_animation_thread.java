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
        private static int animationtype;
        private int a_rotate,a_width,a_height,a_alpha,a_x,a_y;
        private double speed;
        private static final int SCROLL = 1000;
        private static final int FADE = 1001;
        private static final int ROTATE = 1002;
        private liveWPC_create_object animationobject;
        public liveWPC_animation_thread(liveWPC_create_object animationobject,int animationtype,double animationspeed,double firstvalue,double secondvalue){
            animationtype = liveWPC_animation_thread.animationtype;
            animationobject = this.animationobject;
            speed = animationspeed;
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
                scroll();
            }else if(animationtype == FADE){
                fade();
            }else if(animationtype == ROTATE){
                rotate();
            }

        }

        private void scroll(){
            for(int i = 0;i<a_x && i < a_y;i++){
                if(animationobject.x<a_x){
                    animationobject.x++;
                }
                if(animationobject.y<a_y){
                    animationobject.y++;
                }
                animationobject.repaint();
            }
        }
        private void fade(){
            //todo フェード用アニメーション用処理

            animationobject.repaint();
        }
        private void rotate(){
            //todo 回転アニメーション用処理

            animationobject.repaint();
        }

}