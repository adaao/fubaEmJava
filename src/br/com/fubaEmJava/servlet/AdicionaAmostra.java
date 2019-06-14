package br.com.fubaEmJava.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fubaEmJava.model.Amostra;
import br.com.fubaEmJava.model.dao.AmostraDao;
import br.com.fubaEmJava.model.dao.ArmazemDao;
import br.com.fubaEmJava.model.dao.OperacaoDao;
import br.com.fubaEmJava.model.dao.ProdutoDao;
import br.com.fubaEmJava.model.dao.TipoDeAmostraDao;

/**
 * Servlet implementation class AdicionaAmostra
 */
@WebServlet("/AdicionaAmostra")
public class AdicionaAmostra extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException{
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		TipoDeAmostraDao ta = new TipoDeAmostraDao();
		List tas = ta.listaTiposDeAmostra();
		session.setAttribute("tiposDeAmostra", tas);
		
		ProdutoDao p = new ProdutoDao();
		List ps = p.listaProdutos();
		session.setAttribute("produtos", ps);
		
		ArmazemDao ad = new ArmazemDao();
		List armazens = ad.listaArmazens();
		session.setAttribute("armazens", armazens);
		
		OperacaoDao o = new OperacaoDao();
		List os = o.listaOperacoes();
		session.setAttribute("operacoes", os);
		
				
		int quantidade = Integer.parseInt(request.getParameter("ds_quantidade"));
		int idTipopDeAmostra = Integer.parseInt(request.getParameter("id_tipoDeAmostra"));
		int idProduto = Integer.parseInt(request.getParameter("id_produto"));
		int idArmazem = Integer.parseInt(request.getParameter("id_armazem"));
		String nomeDoInspetor = request.getParameter("nm_inspetor");
		String lacre = request.getParameter("ds_lacre");
		int idTipoDeOperacao = Integer.parseInt(request.getParameter("id_tipodDeOperacao"));
		
		Amostra amostra = new Amostra();
		amostra.setDsQuantidade(quantidade);
		amostra.setIdTipoDeAmostra(idTipopDeAmostra);
		amostra.setIdProduto(idProduto);
		amostra.setIdArmazem(idArmazem);
		amostra.setNomeDoInspetor(nomeDoInspetor);
		amostra.setLacre(lacre);
		amostra.setIdTipoDeOperacao(idTipoDeOperacao);
		
		AmostraDao amostraDao = new AmostraDao();
		amostraDao.adicionaAmostra(amostra);
		out.println("<html>");
		out.println("<body>");
		out.println("Amostra adicionada!");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaAmostra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
