package SourceItems;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.sql.*;

//lưu dạng UTF-8
// test 1
public class DictionaryManagement {
	
	/* Dismiss Since We Develope New Version. 
	 * SQLite Database took place of File input.
	 */
//	public static void insertFromCommandline() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Number of Word:");
//		int scale = sc.nextInt();
//		for (int i = 0; i < scale; ++i) {
//			System.out.println("Enter new Word:");
//			String w = sc.nextLine();
//			String d = sc.nextLine();
//			Dictionary.addWord(new Word(w,d));
//		}
//	}
	
	/* Dismiss Since We Develope New Version. 
	 * SQLite Database took place of File input.
	public static void insertFromFile() {;}
	*/
	
	public static void dictionaryLookup() {
		System.out.println("Enter The Word Need To Lookup: ");
		Scanner sc = new Scanner(System.in);
		String w = sc.nextLine();
		Word res = SQLiteJDBC.queryLookup(w);
		System.out.println(res.getExplain());
	}
	
	public static void addWord() {
		
		String w, d, p;
		System.out.println("Enter Word, Description, Pronounce Need to Add.");
		System.out.println("if Any Part You Ignored, Typing 'NONE'.");
		Scanner sc = new Scanner(System.in);
		w = sc.nextLine();
		d = sc.nextLine();
		p = sc.nextLine();
		SQLiteJDBC.insertToDatabase(new Word(w, d, p));
	}
	
	public static void editWord() {
		SQLiteJDBC.modifyDatabase();
	}
	
	public static void deleteWord() {
		SQLiteJDBC.deleteRowWithKey();
	}
	
	public static void dictionaryExportToFile() {
		SQLiteJDBC.DatabaseToTextFile();
	}
	
	public static void useApiToTranslate() throws IOException {
		GG_API_Translator.excuteApiTranslate();
	}
}
