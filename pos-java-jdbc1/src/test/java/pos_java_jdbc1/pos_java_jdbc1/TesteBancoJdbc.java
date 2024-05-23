package pos_java_jdbc1.pos_java_jdbc1;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64Encoder;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
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
	

	/* @Test
	public void initBuscar () {
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava userposjava = dao.buscar(6);
			
			System.out.println(userposjava);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	} */
	
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
	
	public void testeInsertTelefone () {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(11) 93554557");
		telefone.setTipo("Casa");
		telefone.setUsuarioPessoa(5);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
		
		
	}
	
	
	public void testeCarregaFonesUser () {
		
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(12L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("---------------------------------");
			
		}
	}
	
	public void testeDeleteUserFone () {
		
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(3L);
		
	}

}
