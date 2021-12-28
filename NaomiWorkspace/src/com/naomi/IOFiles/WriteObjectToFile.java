package com.naomi.IOFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjectToFile {

	public static void main(String[] args) {

		Person p = new Person(101, "Dan Avidan", 35, "32 Halimon st. Jerusalem");
		File file = new File("files/person.obj");
		// object serialization
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));) {

			out.writeObject(p);
			System.out.println("object wrriten: " + p);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
