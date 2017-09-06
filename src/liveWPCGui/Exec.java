package liveWPCGui;

public class Exec {
	 public static void main(String args[]){
		 liveWPC_main_window main= new liveWPC_main_window();
		 liveWPC_tool_window tool = new liveWPC_tool_window();
		 liveWPC_proprety_window proprety = new liveWPC_proprety_window();
		 main.setWindow(tool, proprety);
		 tool.setWindow(main, proprety);
		 proprety.setWindow(tool, main);
	 }
}
