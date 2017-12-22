package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Server.DictionaryService;

/**
 * Servlet implementation class DSServlet
 */
@WebServlet("/dsServlet")
public class DSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DSServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DictionaryService ds;
		try {
			ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
			ArrayList<String> words = ds.getWords();
			System.out.println(words);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String query = request.getParameter("query");
		
        PrintWriter writer = response.getWriter();
        
        String htmlRespone = "<html>";
        htmlRespone += "<h2>" + query + "</h2>";    
        htmlRespone += "</html>";
        
        writer.println(htmlRespone);
	}

}
