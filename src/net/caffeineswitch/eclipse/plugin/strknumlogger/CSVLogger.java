package net.caffeineswitch.eclipse.plugin.strknumlogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVLogger {
	static BufferedWriter writer;
	static{
		try {
			writer = new BufferedWriter(new FileWriter(new File("log.txt"),true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void logging(long lastTime,int num){
		try {
			writer.write(""+lastTime+","+(lastTime+60l)+","+num);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void freeResouce(){
		try {
			writer.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
