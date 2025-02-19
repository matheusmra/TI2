package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Locatario;
import model.Usuario;

public class LocatarioDAO extends DAO {
	
	public LocatarioDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Locatario locatario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO locatario (id, nome, endereco, sexo) "
				       + "VALUES ("+locatario.getId()+ ", '" + locatario.getNome() + "', '"  
				       + locatario.getEndereco() + "', '" + locatario.getSexo() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Locatario get(int id) {
		Locatario locatario = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM locatario WHERE id=" + id;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 locatario = new Locatario(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("sexo").charAt(0));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return locatario;
	}
	
	
	public List<Locatario> get() {
		return get("");
	}

	
	public List<Locatario> getOrderByCodigo() {
		return get("id");		
	}
	
	
	public List<Locatario> getOrderByLogin() {
		return get("nome");		
	}
	
	
	public List<Locatario> getOrderBySexo() {
		return get("sexo");		
	}
	
	
	private List<Locatario> get(String orderBy) {	
	
		List<Locatario> locatarios = new ArrayList<Locatario>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM locatario" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Locatario u = new Locatario(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("sexo").charAt(0));
	            locatarios.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return locatarios;
	}


	public List<Locatario> getSexoMasculino() {
		List<Locatario> locatarios = new ArrayList<Locatario>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM locatario WHERE locatario.sexo LIKE 'M'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Locatario u = new Locatario(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("sexo").charAt(0));
	            locatarios.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return locatarios;
	}
	
	
	public boolean update(Locatario locatario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE locatario SET nome = '" + locatario.getNome() + "', endereco = '"  
				       + locatario.getEndereco() + "', sexo = '" + locatario.getSexo() + "'"
					   + " WHERE id = " + locatario.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM locatario WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean autenticar(String nome, String endereco) {
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM locatario WHERE nome LIKE '" + nome + "' AND endereco LIKE '" + endereco  + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}	
}