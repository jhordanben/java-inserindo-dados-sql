package pos_java_jdbc1.pos_java_jdbc1;

import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc {
	
	private static final Logger LOGGER = Logger.getLogger(UserPosDAO.class.getName());

	
	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(7);
		userposjava.setNome("GUILTY AS SIN");
		userposjava.setEmail("TTPD@gmail.com");
		
		userPosDAO.salvar(userposjava);
	}
	
	@Test
	public void initListar () {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) { //for pra varrer os objetos 
				System.out.println(userposjava); //metodo que retorna na classe userposjava depois de usar o ToString 
				System.out.println("----------------------------"); //separar os objetos
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void initBuscar () {
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava userposjava = dao.buscar(6);
			
			System.out.println(userposjava);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/* @Test
	public void initAtualizar () {
		try {
		
		UserPosDAO dao = new UserPosDAO();
		
		Userposjava objetoBanco = dao.buscarObjeto(3);
		
		objetoBanco.setNome("nome mudado com o metodo atualizar");
		
		dao.atualizar(objetoBanco);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	} */
	
	@Test
	public void initDeletar () {
		
		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(7);
						
			
		} catch (Exception e) {
			e.printStackTrace();
				
		}
		
		System.out.println(LOGGER);
	}

}
