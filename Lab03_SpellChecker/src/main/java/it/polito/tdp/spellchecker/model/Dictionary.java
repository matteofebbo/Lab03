package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	private HashSet<String> dictionaryEnglish;
	private HashSet<String> dictionaryItalian;
	
	public Dictionary() {
		this.dictionaryEnglish= new HashSet<String>();
		this.dictionaryItalian= new HashSet<String>();
	}

	
	public void loadDictionary(String language) {
		if(language.toLowerCase().compareTo("english")==0) {
		try {
			FileReader fr= new FileReader("src/main/resources/English.txt");
			BufferedReader br= new BufferedReader(fr);
			String word;
			while((word=br.readLine()) != null) {
				dictionaryEnglish.add(word);
	    		
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erore nella lettura del file");
			
		}
		}
		if(language.toLowerCase().compareTo("italian")==0) {
			try {
				FileReader fr= new FileReader("src/main/resources/Italian.txt");
				BufferedReader br= new BufferedReader(fr);
				String word;
				while((word=br.readLine()) != null) {
					dictionaryItalian.add(word);
		    		
				}
				br.close();
			} catch (IOException e) {
				System.out.println("Erore nella lettura del file");
				
			}
		}
		
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList) {
		LinkedList<RichWord> listaTemp= new LinkedList<RichWord>();
		for(String s:inputTextList) {
			if(!this.dictionaryEnglish.contains(inputTextList) && !this.dictionaryItalian.contains(inputTextList)) {
				RichWord richWord= new RichWord();
				richWord.setCorrect(false);
				richWord.setRichWord(s);
				listaTemp.add(richWord);
			}
		}
		
		return listaTemp;
		
	}
}
