package com.naomi.IOFiles;

import java.io.File;
import java.io.IOException;

public class FileExists {

	public static void main(String[] args) {
		
		try {
			String path = "c:/naomi/programs/file.txt";
			File file = new File(path);
			
			if(file.exists()) {
				System.out.println("file exists: " + file);
			}else {
				System.out.println("file NOT exists: " + file);
				file.createNewFile();
				System.out.println("file created");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
