package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa!");
		//PrintWriter out = res.getWriter();
		
		String nomeEmpresa = req.getParameter("nome");
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		Banco banco = new Banco();
		
		banco.adiciona(empresa);
		
		RequestDispatcher rd = req.getRequestDispatcher("/novaEmpresaCriada.jsp");
		req.setAttribute("empresa", empresa.getNome());
		rd.forward(req, res);
	}

}
