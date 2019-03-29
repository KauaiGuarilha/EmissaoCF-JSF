package br.com.vendaProduto.util;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

/**
*
* @author Kauai Guarilha
*/
public class HibernateUtilTest {

	@Test
	@Ignore
	public void conectar() {

		Session sessao = HibernateUtil.getFabricaDeSessao().openSession();

		sessao.close();
		HibernateUtil.getFabricaDeSessao().close();
	}
}

