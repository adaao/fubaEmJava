package br.com.fubaEmJava.testes;

import java.util.*;

import br.com.fubaEmJava.model.Amostra;
import br.com.fubaEmJava.model.dao.AmostraDao;

public class TestaAmostraDao {
	static Amostra a = new Amostra();
	static AmostraDao ad = new AmostraDao();
	
	public static void main(String[] args) {
		//adiciona();
		//alterarAmostra();
		printaAmostras();
		

	}
	
	public static void adiciona() {
		a.setDsQuantidade(2000);
		a.setIdProduto(1);
		a.setIdArmazem(1);
		a.setNomeDoInspetor("teste");
		a.setIdTipoDeAmostra(1);
		ad.adicionaAmostra(a);
		System.out.println("amostra inserida");
	}
	
	public static void alterarAmostra() {
		a.setDsQuantidade(2000);
		a.setIdProduto(1);
		a.setIdArmazem(1);
		a.setNomeDoInspetor("teste arrombado");
		a.setIdTipoDeAmostra(1);
		a.setIdAmostra(2);
		a.setIdTipoDeOperacao(1);
		ad.alteraAmostra(a);
		
	}
	
	public static void printaAmostras() {
		List<Amostra> amostras = ad.listaAmostras();
		System.out.println("============== amostras registradas =======================");
		for(Amostra a : amostras) {
			System.out.println("id amstra: " + a.getIdAmostra());
			System.out.println("lacre: " + a.getLacre());
			System.out.println("qntdde: " + a.getDsQuantidade());
			System.out.println("armazem: " + a.getIdArmazem());
			System.out.println("produto: " + a.getIdProduto());
			System.out.println("inspetor: " + a.getNomeDoInspetor());
			System.out.println("operacao: " + a.getIdTipoDeOperacao());
			System.out.println("data da coleta: " + a.getDataDaColeta());
			System.out.println("=====================================");
		}
		
	}
}
