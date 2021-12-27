package com.naomi.IOFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadTextFileBuffered {

	public static void main(String[] args) {

		File file = new File("c:/naomi/programs/file.txt");
		try (BufferedReader in = new BufferedReader(new FileReader(file))){
			String line = in .readLine();
			while(line != null) {
				System.out.println(line);
				line = in .readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
