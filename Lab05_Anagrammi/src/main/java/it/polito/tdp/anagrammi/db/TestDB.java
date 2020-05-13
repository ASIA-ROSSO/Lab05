package it.polito.tdp.anagrammi.db;




public class TestDB {

	public static void main(String[] args) {
		
		AnagrammaDAO adao = new AnagrammaDAO();
		//List<Parola> pp = adao.getTutteLeParole();
		
		//System.out.println(pp);

		boolean x = adao.isCorrect("uau");
		System.out.println(x);
	}

}
