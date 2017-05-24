package liveWPCGui;

public interface liveWPC_toolbar_base {
	//初期値
	public static final int Default_number = 0;


	//図形ボタンが押された時のアクション
	//図形一覧を表示する
	public default void geometry_display(){}

	//図形一覧から該当する図形を選択された場合のアクション
	//メイン画面にその図形を表示する
	//引数値でどの図形か判断する
	//初期値は正方形
	public default int selected_geometry(){	return Default_number;}

	//アイコンボタンを押された時のアクション
	//アイコン一覧を表示する
	public default void icon_display(){}

	//アイコン一覧から該当するアイコンを選択された場合のアクション
	//メイン画面にそのアイコンを表示する
	//引数値でどのアイコンか判断する
	//初期値は天気(Todo:要詰め)
	public default int selected_icon(){ return Default_number; }


	//テキストボタンを押された時のアクション
	//画面にテキストを表示する
	//初期値は[helloWorld](todo:要詰め)

	public default void selected_text(){}

}
