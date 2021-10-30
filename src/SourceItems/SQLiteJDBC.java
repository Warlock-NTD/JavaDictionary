package SourceItems;
import java.io.FileWriter;
import java.sql.*;
import java.util.Scanner;

// lưu ở dạng UTF-8
// MOST IMPORTANT FILE PART
public class SQLiteJDBC {
	
	public static void insertToDatabase(Word w) {
		Connection c = null;
		Statement stmt = null;
		 try {
			 Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:dictionary.db");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String sql = "INSERT INTO EngToVie (word,description,pronounce) " +
	                        "VALUES ('" + w.getTarget() +"','" + w.getExplain() + "','" +
	                        	w.getPronounce() + "');"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.commit();
	         c.close();
	      	} catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      	 System.out.println("Records created successfully");
		}
	/*
	public static String queryAllWordRecorded() {
		 Connection c = null;
		 Statement stmt = null;
		 String res = "";
		 try {
			  Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:dictionary.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT id, word, description FROM EngToVie;");
		      res = res + String.format("%8s | %-50s | %-5s %n", "No", "English", "Vietnamese");
		      
		      while (rs.next()) {
		         int id = rs.getInt("id");
		         String w = rs.getString("word");
		         String d = rs.getString("description");
		         res = res + String.format("%8d | %-50s | %-5s %n", id, w, d);
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		   } catch (Exception e) {
		    System.err.println(e.getClass().getName() + ": " + e.getMessage());
		    System.exit(0);
		   }
		   	// System.out.println("Operation Show All done successfully");
		 return  res;
	}
	*/
	public static Word queryLookup(String w) {
		Word res;
		Connection c = null;
		Statement stmt = null;
		try {
			 Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:dictionary.db");
		     c.setAutoCommit(false);
		     stmt = c.createStatement();
		     ResultSet rs = stmt.executeQuery("SELECT word, description, pronounce FROM EngToVie Where word ='" + w + "';" );
		     res = new Word(rs.getString("word"), rs.getString("description"), rs.getString("pronounce"));
		     rs.close();
		     stmt.close();
		     c.close(); 
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		    System.exit(0);
		}
		return new Word("No Result Found");
	}
	
	public static String patternSearch(String pat) {
		// System.out.println("Enter the Pattern Need to Search:");
		String res = "";
		Connection c = null;
		Statement stmt = null;
		 try {
			  Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:dictionary.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT word FROM EngToVie Where word LIKE '" + pat + "%';");
		      // System.out.printf("%8s | %-50s | %-5s %n", "No", "English", "Vietnamese");
		      while (rs.next()) {
		         // int id = rs.getInt("id");
		         String w = rs.getString("word");
		         res = w + "\n";
		         // String d = rs.getString("description");
		         // System.out.printf("%8d | %-50s | %-5s %n", id, w, d);
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		   } catch (Exception e) {
		    System.err.println(e.getClass().getName() + ": " + e.getMessage());
		    System.exit(0);
		   }
		   	// System.out.println("Operation Searching done successfully");
		 return res;
	}
	
	public static void DatabaseToTextFile() {
		Connection c = null;
		Statement stmt = null;
		try {
		     FileWriter myWriter = new FileWriter("ExportedFromJava.txt");
		     // myWriter.write("This is a sample test of Duy!");
		     Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:dictionary.db");
		     c.setAutoCommit(false);
		     stmt = c.createStatement();
		     ResultSet rs = stmt.executeQuery("SELECT id, word, description FROM EngToVie;");
		     myWriter.write(String.format("%8s | %-50s | %-5s %n", "No", "English", "Vietnamese"));
		     
		     while (rs.next()) {
		         int id = rs.getInt("id");
		         String w = rs.getString("word");
		         String d = rs.getString("description");
		         myWriter.write(String.format("%8d | %-50s | %-5s %n", id, w, d));
		     }
		     rs.close();
		     stmt.close();
		     c.close();
		     myWriter.close();
		     System.out.println("Successfully wrote to the file.");
		    } catch (Exception e) {
		     System.err.println(e.getClass().getName() + ": " + e.getMessage());
			 System.exit(0);
		    }
	}
	
	public static void modifyDatabase() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Word need to Edit:");
		String s = sc.nextLine();
		System.out.println("Choose Method to Edit:");
		System.out.printf("%s%n%s%n%s%n", "1 : Word", "2 : Description", "3 : Pronounce");
		Connection c = null;
		Statement stmt = null;
		String mod;
		int met = sc.nextInt();
		@SuppressWarnings("unused")
		String catchEnter = sc.nextLine();
		try {
			 Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:dictionary.db");
		     c.setAutoCommit(false);
		     stmt = c.createStatement();
		     switch(met) {
		     case 1: {
		    	 System.out.println("Enter the new Word Modify: ");
		    	 mod = sc.nextLine();
		    	 stmt.executeUpdate("UPDATE EngToVie SET word ='" + mod + "' WHERE word ='" + s + "';");
		    	 break;
		     }
		     case 2: {
		    	 System.out.println("Enter the new Description Modify: ");
		    	 mod = sc.nextLine();
		    	 stmt.executeUpdate("UPDATE EngToVie SET description ='" + mod + "' WHERE word ='" + s + "';");
		    	 break;
		     }
		     case 3: {
		    	 System.out.println("Enter the new Pronounce Modify: ");
		    	 mod = sc.nextLine();
		    	 stmt.executeUpdate("UPDATE EngToVie SET pronounce ='" + mod + "' WHERE word ='" + s + "';");
		    	 break;
		     }
		     default:
		    	 System.out.println("Not Found Method to update... Escaping");
		     }
		     stmt.close();
		     c.commit();
		     c.close();
		     
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
			System.out.println("Edit done Successful");
	}
	
	public static void deleteRowWithKey() {
		System.out.println("Enter the Word Need to be Removed: ");
		Scanner sc = new Scanner(System.in);
		String del = sc.nextLine();
		Connection c = null;
		Statement stmt = null;
		try {
			 Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:dictionary.db");
		     c.setAutoCommit(false);
		     stmt = c.createStatement();
			 stmt.executeUpdate("DELETE FROM EngToVie WHERE word = '" + del + "';");
			 stmt.close();
		     c.commit();
		     c.close();
		} catch (Exception e) {
			System.err.println("No Word Found, Escaped Method!");
			return;
		}
		System.out.println("Word has been Removed Successful");
	}
}
