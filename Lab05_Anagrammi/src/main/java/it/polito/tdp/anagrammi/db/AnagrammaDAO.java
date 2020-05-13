package it.polito.tdp.anagrammi.db;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AnagrammaDAO {
	/*	
	public List<String> getTutteLeParole() {


	
		List<String> result = new ArrayList<>();

		String sql = "SELECT id, nome FROM parola WHERE id>0 AND id<50";

		// 2) stabilisco la connessione
		try {
			Connection conn = DBConnection.getConnection();

			// 3 preparo lo statement
			PreparedStatement st = conn.prepareStatement(sql);

			// 4)Eseguo la query
			ResultSet res = st.executeQuery();

			// 5) estrazione dei dati
			while (res.next()) {
				Parola p = new Parola(res.getString("nome"), res.getInt("id"));
				result.add(p);

			}
			st.close();

			// 6 chiudere la connessione
			conn.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
*/
	public boolean isCorrect(String anagramma) {
		String sql = "SELECT id, nome FROM parola WHERE nome=?";
		String p = null;
		// 2) stabilisco la connessione
		try {
			Connection conn = DBConnection.getConnection();

			// 3 preparo lo statement
			PreparedStatement st = conn.prepareStatement(sql);

			// 4)Eseguo la query
			st.setString(1, anagramma);
			ResultSet res = st.executeQuery();

			// 5) estrazione dei dati
			while (res.next()) {
				//p = new Parola(res.getString("nome"), res.getInt("id"));
				p = res.getString("nome");
			}
			
			if(p!=null) {
				st.close();
				conn.close();
				return true;
			}
			
			st.close();
			conn.close();

			return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}


