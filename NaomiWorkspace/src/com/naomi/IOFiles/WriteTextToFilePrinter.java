package com.naomi.IOFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteTextToFilePrinter{

	public static void main(String[] args) {

		File directory = new File("c:/naomi/programs/writePrinter");
		if(!directory.exists()) {
			directory.mkdirs(); //create the path until	the present directory
			//directory.mkdir(); //	create just the directory if all the path exists
		}
		
		//this is the file we want to write to
		File file = new File(directory,"/file.txt");
		
		//create an object that can write text to file
		boolean append = false; // add to existing content or not
		try(PrintWriter out = new PrintWriter(new FileWriter(file, append));) {
			out.println("this is first line");
			out.println(8);
			out.println(8.3);
			
			System.out.println("text writeen to " + file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
