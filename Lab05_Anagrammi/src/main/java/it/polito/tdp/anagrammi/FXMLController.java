package it.polito.tdp.anagrammi;

import java.net.URL;


import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtInsert;

	@FXML
	private Button btnAnagrammi;

	@FXML
	private TextArea txtRisCorretto;

	@FXML
	private TextArea txtRisErrati;

	@FXML
	private Button btnReset;

	@FXML
	void doAnagrammi(ActionEvent event) {
		String parola = txtInsert.getText();
		
		if(parola.split(" ").length>1) {
			txtRisErrati.setText("Devi inserire una sola parola!");
			return;
		}
		
		this.model.cerca(parola);
		
		String risultatoC = "";
		
		for (String p : this.model.getRisultatoCorretto()) {
			if (risultatoC.equals("")) {
				risultatoC += p.toString();
			} else {
				risultatoC += "\n" + p.toString();
			}
		}
		
		txtRisCorretto.setText(risultatoC);
		
		String risultatoE = "";
		for (String p : this.model.getRisultatoErrato()) {
			if (risultatoE.equals("")) {
				risultatoE += p.toString();
			} else {
				risultatoE += "\n" + p.toString();
			}
		}
		
		txtRisErrati.setText(risultatoE);
		
		
		
		

	}

	@FXML
	void doReset(ActionEvent event) {
		txtRisCorretto.clear();
		txtRisErrati.clear();
		txtInsert.clear();
	}

	@FXML
	void initialize() {
		assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtRisCorretto != null : "fx:id=\"txtRisCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtRisErrati != null : "fx:id=\"txtRisErrati\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
	}

}
