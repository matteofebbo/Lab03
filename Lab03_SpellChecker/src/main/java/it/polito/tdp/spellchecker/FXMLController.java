/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.*;

import it.polito.tdp.spellchecker.model.*;
import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class FXMLController {
	
	ObservableList <String> lista =FXCollections.observableArrayList();
	Dictionary dictionary= new Dictionary();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextArea txtTestoDaTradurre;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtWrongWords;

    @FXML
    private Label txtTime;

    @FXML
    private Label txtNumberError;

    @FXML
    private Button btnClearText;

    @FXML
    void doClearText(ActionEvent event) {
    	
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	String language=choiceBox.getValue();
    	txtTestoDaTradurre.clear();
    	txtWrongWords.clear();
    	dictionary.loadDictionary(language);
    	long start=System.nanoTime();
    	String inputText=txtTestoDaTradurre.getText().replaceAll("\\p{P}", "").toLowerCase();
    	List<String> inputTextList=new ArrayList<String>();
    	for(String s: inputText.split(" ")) {
    		inputTextList.add(s);
    	}
    	List<RichWord> listaTemp= dictionary.spellCheckText(inputTextList);
    	for(RichWord r:listaTemp) {
    		txtWrongWords.setText(r.getRichWord()+"\n");
    	}
    	
    	long end= System.nanoTime();
    	txtNumberError.setText("The text contains "+listaTemp.size()+" errors!");
    	long durata= end-start;
    	txtTime.setText("Spell Check completed in  "+durata+" sec!");
    	
    	
    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTestoDaTradurre != null : "fx:id=\"txtTestoDaTradurre\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWrongWords != null : "fx:id=\"txtWrongWords\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumberError != null : "fx:id=\"txtNumberError\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        
        lista.addAll("Italian","English");
        choiceBox.setItems(lista);
    }
}


