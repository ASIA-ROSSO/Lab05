package it.polito.tdp.anagrammi.model;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class TestModel {

	public static void main(String[] args) {
		Model ric = new Model() ;
		
		ric.cerca("dog") ;
		List<String> ana_dogC = ric.getRisultatoCorretto();
		System.out.println(ana_dogC) ;
		
	}

}