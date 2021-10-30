import SourceItems.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// lưu dạng UTF-8
// java -cp ".;sqlite-jdbc-3.27.2.1.jar" DictionaryCommandline
public class DictionaryCommandline {
	
	public static void main(String []args)  throws IOException, InterruptedException {
		// File directory = new File("");
		// final String fileDatabase = "jdbc:sqlite:" + directory.getAbsolutePath() + "\\material\\dictionary.db";
		// DictionaryCommandline.dictionarySearcher();
		// DictionaryManagement.useApiToTranslate();
		// DictionaryManagement.dictionaryExportToFile();
		// DictionaryManagement.addWord();
		// DictionaryManagement.dictionaryLookup();
		// DictionaryManagement.editWord();
		// DictionaryManagement.deleteWord();
		// DictionaryManagement.dictionaryLookup();
		// ReadText.speech("The King Kong has destroy many city");
		GG_API_Translator.excuteApiTranslate();
	}
	
	/*
	private static void showAllWords() {
		SQLiteJDBC.queryAllWordRecorded();
	}
	*/
	
	/*
	public static void dictionaryBasic() {
		;
		// showAllWords();
		DictionaryCommandline.showAllWords();
		// insertFromCommandline();
	}
	*/
	/*
	public static void dictionaryAdvanced() {
		// Method 1: showAllWords();
		DictionaryCommandline.showAllWords();
		// insertFromFile(); -- Dismissed Already.
		
		// Method 3: dictionaryLookup();
		DictionaryManagement.dictionaryLookup();
	}
	*/
	// Developing GUI version.
	public static String dictionarySearcher(String pat) {
		return SQLiteJDBC.patternSearch(pat);
	}
}
