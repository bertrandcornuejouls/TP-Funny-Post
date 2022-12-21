package Modele;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.json.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;


public class derby {
	private static String URL = "jdbc:derby:cciDB;create=true";
	private static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static String USERNAME = "";
	private static String PASSWORD = "";
	private static String LOGIN = "";
	private static String PWD = "";
	private static List<Post> listePost = new ArrayList<>();
	private static String s;
	
	public derby() throws ClassNotFoundException {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			
			//Table exo 2 : lecture de WebService
			/*
			String createTableSQL = "CREATE TABLE poste (userId INTEGER,id INTEGER PRIMARY KEY, title VARCHAR(255), body VARCHAR(1023))";
            PreparedStatement createTableStmt = conn.prepareStatement(createTableSQL);
            createTableStmt.executeUpdate();
			*/
            
            
            /*
		    //Table exo 1
		    String createTableSQL = "CREATE TABLE eleve (id INTEGER PRIMARY KEY, nom VARCHAR(255), prenom VARCHAR(255))";
		    PreparedStatement createTableStmt = conn.prepareStatement(createTableSQL);
		    createTableStmt.executeUpdate();
		     
		    String insertSQL = "INSERT INTO eleve (id, nom, prenom) VALUES (?, ?, ?)";
		    PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
		    insertStmt.setInt(1, 1);
		    insertStmt.setString(2, "Dupont");
		    insertStmt.setString(3, "Jean");
		    insertStmt.executeUpdate();

		    insertStmt.setInt(1, 2);
		    insertStmt.setString(2, "Durand");
		    insertStmt.setString(3, "Marie");
		    insertStmt.executeUpdate();
		     
		      
*/
		     //System.out.println("Enregistrements ajoutés avec succès !");
			/*
			String insertSQL = "INSERT INTO eleve (id, nom, prenom) VALUES (?, ?, ?)";
		    PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
			insertStmt.setInt(1, 3);
		    insertStmt.setString(2, "Dupont");
		    insertStmt.setString(3, "Michel");
		    insertStmt.executeUpdate();
		    */
			
			/*
			String insertSQL = "INSERT INTO eleve (id, nom, prenom) VALUES (?, ?, ?)";
		    PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
			insertStmt.setInt(1, 4);
		    insertStmt.setString(2, "truc");
		    insertStmt.setString(3, "Jean claude");
		    insertStmt.executeUpdate();
			*/
			
			
			
		    String selectSQL = "SELECT * FROM eleve";
		    Statement selectStmt = conn.createStatement();
		    ResultSet rs = selectStmt.executeQuery(selectSQL);

		    /*
		    while (rs.next()) {
		    	int id = rs.getInt("id");
		        String nom = rs.getString("nom");
		        String prenom = rs.getString("prenom");
		        System.out.println("id : " + id + ", nom : " + nom + ", prénom : " + prenom);
		    }
		    */
		    
		    rs.close();
		    selectStmt.close();
		    //insertStmt.close();
		    //createTableStmt.close();
		    conn.close();
		} catch (SQLException e) {
		      e.printStackTrace();
	    }
	}
	
	public static List<Post> getListePost() {
		return listePost;
	}


	public static void setListePost(List<Post> listePost) {
		derby.listePost = listePost;
	}
	
	
	   public static void ConnectBDD() {
	       try {
	           Class.forName(DRIVER);
	           Connection cn = DriverManager.getConnection(URL, LOGIN, PWD);
	           System.out.println("Connection à la base de données");
	           //Statement st = cn.createStatement();
	           //st.execute("create table eleve (code int, nom varchar(20), prenom varchar(20))");
	           //st.executeUpdate("INSERT INTO eleve VALUES (1, 'DURAND','Jacques')");
	           //st.executeUpdate("INSERT INTO eleve VALUES (2, 'DUPOND','Daniel')");
	       }catch (ClassNotFoundException e) {
	            
	               e.printStackTrace();
	           }

	           catch (SQLException e) {
	              
	               e.printStackTrace();
	           }
	   }
	   
	   /*
	   public static String RecupChamps() throws ClassNotFoundException, SQLException {
		   String s = "";
		   
		   
		   Class.forName("org.apache.derby.jdbc.ClientDriver");
		
		   Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		   
		   String selectSQL = "SELECT * FROM eleve";
		   Statement selectStmt = conn.createStatement();
		   ResultSet rs = selectStmt.executeQuery(selectSQL);

		    
		   while (rs.next()) {
		    	int id = rs.getInt("id");
		        String nom = rs.getString("nom");
		        String prenom = rs.getString("prenom");
		        //System.out.println("id : " + id + ", nom : " + nom + ", prénom : " + prenom);
		        s = s + "id : " + id + ", nom : " + nom + ", prénom : " + prenom + "\n";
		   }
		    
		   rs.close();
		   selectStmt.close();
		   
		   return s;
		   
	   }
	   */
	   
	   
	   public static List<Post> RecupChamps() throws ClassNotFoundException, SQLException {
		   
		   //List<Post> listePost = null;
		   
		   
		   Class.forName("org.apache.derby.jdbc.ClientDriver");
		
		   Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		   
		   String selectSQL = "SELECT * FROM eleve";
		   Statement selectStmt = conn.createStatement();
		   ResultSet rs = selectStmt.executeQuery(selectSQL);

		    
		   while (rs.next()) {
		    	int id = rs.getInt("id");
		        String nom = rs.getString("nom");
		        String prenom = rs.getString("prenom");
		        Post post = new Post(id, nom, prenom);
		        //System.out.println("test");
		        listePost.add(post);
		        //s = s + "id : " + id + ", nom : " + nom + ", prénom : " + prenom + "\n";
		   }
		    
		   rs.close();
		   selectStmt.close();
		   return getListePost();
		   
	   }
	   
	   
	   
	   
	   
	   
	   
	   public static String getPost() throws ClassNotFoundException,SQLException{
	         try {
	                // Envoyer la requête GET
	                Class.forName("org.apache.derby.jdbc.ClientDriver");
	                Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	                URL url = new URL("https://jsonplaceholder.typicode.com/posts");
	                HttpURLConnection con = (HttpURLConnection) url.openConnection();
	                con.setRequestMethod("GET");
	                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

	                // Lire la réponse
	                String line;
	                StringBuilder response = new StringBuilder();
	                while ((line = reader.readLine()) != null) {
	                    response.append(line);
	                }

	                JSONArray jsonArray = new JSONArray(response.toString());

	                String insertSQL = "INSERT INTO poste (userId, id, title, body) VALUES (?, ?, ?, ?)";
	                PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
	                for (int i = 0; i < jsonArray.length(); i++) {
	                    JSONObject jsonObject = jsonArray.getJSONObject(i);
	                    insertStmt.setInt(1,(int) jsonObject.get("userId"));
	                    insertStmt.setInt(2,(int) jsonObject.get("id"));
	                    insertStmt.setString(3, jsonObject.get("title").toString());
	                    insertStmt.setString(4, jsonObject.get("body").toString());
	                    insertStmt.executeUpdate();
	                    System.out.println(jsonObject);
	                    }
	                  String selectSQL = "SELECT FROM poste";
	                  Statement selectStmt = conn.createStatement();
	                  ResultSet rs = selectStmt.executeQuery(selectSQL);
	                  while (rs.next()) {
	                        Post test = new Post(rs.getInt("userId"),rs.getInt("id"), rs.getString("title"), rs.getString("body"));
	                        s = s  +" "+test.postPrinte()+ "\n";
	                      }

	                  rs.close();
	                reader.close();

	            } catch (Exception e1) {
	                e1.printStackTrace();
	            }
	        return s;

	        } 
	    


}