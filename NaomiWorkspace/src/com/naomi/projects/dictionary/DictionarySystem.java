package com.naomi.projects.dictionary;

import java.util.Scanner;

public class DictionarySystem {
	
	private Dictionary dictionary = new Dictionary();
	private Scanner sc = new Scanner(System.in);
	private boolean systemOn;
	
	public void start() {
		this.systemOn = true;
		while(systemOn) {
			try {
				printMenu();
				String choice = sc.nextLine();
				switch (choice) {
				case "add":
					toAdd();
					break;
				case "get":
					toGetDef();
					break;
				case "edit":
					toEdit();
					break;
				case "del":
					toDelete();
					break;
				case "disp":
					displayAllEntries();
					break;
				case "print":
					printDictionary();
					break;
				case "q":
					systemOn = false;
					this.sc.close();
					System.out.println("\n\t BYE! :)");
					break;
				default:
					System.out.println(choice + " is not a supported action");
					break;
				}
			}catch (Exception e) {
				System.err.println("ERROR!! " + e.getMessage());
			}
		}
	}
	
	public void printMenu() {
		System.out.println("\n== Menu =========");
		System.out.println("Add Entry ........... add");
		System.out.println("Get Definition ...... get");
		System.out.println("Edit Definition ..... edit");
		System.out.println("Delete entry ........ del");
		System.out.println("Display allEntries .. disp");
		System.out.println("Print Dictionary ...  print");
		System.out.println("exit ...............  q");
		System.out.print("Enter Choice: ");
	}

	private void toAdd() throws DictionaryException {
		System.out.print("enter the new entry: ");
		String entry = sc.nextLine();
		System.out.print("enter definition: ");
		String definition = sc.nextLine();
		this.dictionary.addEntry(entry, definition);		
	}

	private void toGetDef() throws DictionaryException {
		System.out.print("enter the entry to get definition: ");
		String entry = sc.nextLine();
		String def = this.dictionary.getDefinition(entry);
		System.out.println("\t" + entry + ": " + def);		
	}

	private void toEdit() throws DictionaryException {
		System.out.print("enter the entry to edit: ");
		String entry = sc.nextLine();
		System.out.print("enter the new definition: ");
		String definition = sc.nextLine();
		this.dictionary.editEntry(entry, definition);
		System.out.println("\t" + entry + " edited");
	}

	private void toDelete() throws DictionaryException {
		System.out.print("enter the entry to delete: ");
		String entry = sc.nextLine();	
		this.dictionary.deleteEntry(entry);
		System.out.println("\t" + entry + " delete");
	}

	private void displayAllEntries() {
		for (String entry : this.dictionary.getAllEntriesSorted()) {
			System.out.print("\t" + entry + " ");
		}
	}

	private void printDictionary() throws DictionaryException {
		for (String entry : this.dictionary.getAllEntriesSorted()) {
			System.out.println("\t" + entry + ": " + this.dictionary.getDefinition(entry));
		}
	}

}
