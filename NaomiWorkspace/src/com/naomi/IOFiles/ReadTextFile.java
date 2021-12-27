package com.naomi.IOFiles;

import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

	public static void main(String[] args) {

		String path = "c:/naomi/programs/file.txt";
		try (FileReader in = new FileReader(path);){
			int c = in.read();
			while(c!=-1) {
				System.out.print((char)c);
				c = in.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("bye");
	}
}
