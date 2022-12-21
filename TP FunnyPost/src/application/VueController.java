package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Modele.derby;

import org.json.JSONArray;
import org.json.JSONObject;


public class VueController {

	
	@FXML
	private Button button;
	
	@FXML
	private Label label;
	
	@FXML
	private Button button_init;
	
	
	public void clickMe(ActionEvent e) throws ClassNotFoundException, SQLException {
		System.out.println("Cliqué");

		derby.RecupChamps();
		
		//label.setText(derby.RecupChamps());
		label.setText("");
		
		for (int i = 0; i < derby.getListePost().size(); i++ ) {
			
			label.setText( label.getText() + derby.getListePost().get(i).postPrinte());
		}
		
	}
	
	
	
	
	//webservice
	public void clickMe_Init(ActionEvent b) throws ClassNotFoundException, SQLException {
		
		System.out.println("Cliqué init");
        label.setText(derby.getPost());
		/*
		try {
            // Envoyer la requête GET
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

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                jsonObject.get("title").toString();
                jsonObject.get("body").toString();
                System.out.println(jsonObject);
                }
            reader.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        */
     
		
	}
	
	
}