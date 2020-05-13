package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	public String parola;
	public List<String> risultatoCorretto;
	public List<String> risultatoErrato;
	public AnagrammaDAO adao;

	public void cerca(String parola) {

		// prepara l'ambiente della procedura ricorsiva
		this.parola = parola.toLowerCase();
		int livello = 0;

		risultatoCorretto = new LinkedList<String>();
		risultatoErrato = new LinkedList<String>();
		adao = new AnagrammaDAO();

		List<Character> disponibili = new ArrayList<>();
		for (int i = 0; i < parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}

		// chiama la procedura ricorsiva al livello 0
		ricorsiva("", livello, disponibili);

	}
	

	public List<String> getRisultatoCorretto() {
		return risultatoCorretto;
	}


	public List<String> getRisultatoErrato() {
		return risultatoErrato;
	}


	private void ricorsiva(String parziale, int livello, List<Character> disponibili) {
		if (disponibili.size() == 0) {
			// caso terminale
			if (adao.isCorrect(parziale)) {
				if(risultatoCorretto.contains(parziale)) {
					return;
				}
				this.risultatoCorretto.add(parziale);
				System.out.println("C: "+ risultatoCorretto);
			} else {
				if(risultatoErrato.contains(parziale)) {
					return;
				}
				this.risultatoErrato.add(parziale);
				System.out.println("E:"+risultatoErrato);
			}
		}

		// caso normale
		// provare ad aggiungere a 'parziale' tutti i caratteri presenti tra
		// i 'disponibili'
		for (Character ch : disponibili) {
			String tentativo = parziale + ch;

//			if(nel dizionario esistono delle parole che iniziano con 'tentativo'?)

			List<Character> rimanenti = new ArrayList<>(disponibili);
			rimanenti.remove(ch);

			ricorsiva(tentativo, livello + 1, rimanenti);
		}
	}

}
/*
 * Dato di partenza: parola da anagrammare, di lunghezza N Soluzione parziale:
 * una parte dell'anagramma già costruito (i primi caratteri). Livello: numero
 * di lettere di cui è composta la soluzione parziale. Soluzione finale:
 * soluzione di lunghezza N -> caso terminale Caso terminale: salvare la
 * soluzione trovate (Obiettivo di ogni livello) Generazione delle nuove
 * soluzioni: provare a aggiungere una lettera, scegliendola tra quelle che non
 * sono ancora state utilizzate (nella soluzione parziale).
 */
