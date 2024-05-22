package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {
	
	public Connection connection;
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Userposjava userposjava) {
		try { //try é pra capturar as exceções 
			
			String sql = "insert into userposjava (id, nome, email) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setInt(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
			insert.execute();
			connection.commit(); //conecta no banco de dados
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		public List<Userposjava> listar () throws Exception { //metodo que vai retornar uma lista, 1 objeto ou vários
			List<Userposjava> list = new ArrayList<Userposjava>(); //instancia a lista para nao dar null interception, e retorna
			//lá embaixo com return list; pra retornar com algum resultado ou retornar vazia
			
			String sql = "select * from userposjava"; //conecta com o sql
			
			PreparedStatement statement = connection.prepareStatement(sql); //preparestatement passa o objeto pro sql
			ResultSet resultado = statement.executeQuery(); //executa no banco de dados
			
			while (resultado.next()) { //iterar o resultado enquanto for true, boolean
				Userposjava userposjava = new Userposjava(); //criando novo objeto
				userposjava.setId(resultado.getInt("id")); 
				userposjava.setNome(resultado.getString("nome"));
				userposjava.setEmail(resultado.getString("email")); //setando os atributos de id, nome e email
				
				
				list.add(userposjava); //adicionando na lista
			}
		
			return list; //e essa lista retorna no final
		
	}
		
		public Userposjava buscarObjeto (int id) throws Exception { //metodo buscar nao retorna em uma lista
			Userposjava retorno = new Userposjava(); //instancia a lista para nao dar null interception, e retorna
			//lá embaixo com return list; pra retornar com algum resultado ou retornar vazia
			
			String sql = "select * from userposjava where id " + id; //conecta com o sql
			
			PreparedStatement statement = connection.prepareStatement(sql); //preparestatement passa o objeto pro sql
			ResultSet resultado = statement.executeQuery(); //executa no banco de dados
			
			while (resultado.next()) { //vai retornar apenas um ou nenhum
				
				retorno.setId(resultado.getInt("id")); 
				retorno.setNome(resultado.getString("nome"));
				retorno.setEmail(resultado.getString("email")); //setando os atributos de id, nome e email
				
				
				
			}
		
			return retorno; //e essa lista retorna no final

		}
		
		public void atualizar (Userposjava userposjava) {
			try {
			
			String sql = "update userposjava set nome = ? where id = " + userposjava.getId();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userposjava.getNome());
			
			statement.execute();
			connection.commit();
			
		} catch (Exception e) {
			
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
				
			}	e.printStackTrace();
			
		}	
			
		}	
		
		public void deletar(int id) {
			try {
				
				String sql = "delete from userposjava where id = " + id;
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.execute();
				connection.commit();
				
			} catch (Exception e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
}
