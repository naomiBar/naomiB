package com.naomi.IOFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextToFileBuffered{

	public static void main(String[] args) {

		File directory = new File("c:/naomi/programs/writeBuffered");
		if(!directory.exists()) {
			directory.mkdirs(); //create the path until	the present directory
			//directory.mkdir(); //	create just the directory if the path already exists
		}
		
		//this is the file we want to write to
		File file = new File(directory,"/file.txt");
		
		//create an object that can write text to file
		boolean append = false; // add to existing content or not
		try(BufferedWriter out = new BufferedWriter(new FileWriter(file,append));) {
			out.write("this is the first line.\n");
			out.write("this is the second line.");
			out.newLine(); //go down to new line
			
			int x = 500;
			out.write(""+x); //x converts to string
			out.newLine();
			System.out.println("text written to " + file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
