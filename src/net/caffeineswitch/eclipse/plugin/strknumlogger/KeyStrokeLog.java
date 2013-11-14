package net.caffeineswitch.eclipse.plugin.strknumlogger;

public class KeyStrokeLog {
	static private int num;
	static void incrementLog(){
		num++;
	}
	static int getNum(){
		return num;
	}
	static void resetNum(){
		num = 0;
	}
}
