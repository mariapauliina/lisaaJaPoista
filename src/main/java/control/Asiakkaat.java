package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Asiakas;
import model.dao.Dao;

@WebServlet("/asiakkaat/*")
public class Asiakkaat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Asiakkaat() {
       System.out.println("Asiakkaat.Asiakkaat()");
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Asiakkaat.doGet()");
		String hakusana = request.getParameter("hakusana");
		Dao dao = new Dao();
		ArrayList<Asiakas> asiakkaat = dao.getAllItems();
		String strJSON = new Gson().toJson(asiakkaat);
		System.out.println(asiakkaat);
		System.out.println(strJSON);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		
		System.out.println("Asiakkaat.doPost()");
		
		String strJSONInput = request.getReader().lines().collect(Collectors.joining());
		Asiakas asiakas = new Gson().fromJson(strJSONInput, Asiakas.class);
		Dao dao = new Dao();
	
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out =response.getWriter();
		if(dao.addItem(asiakas)){
			out.println("{\"response\":1}");
		}else {
			out.println("{\"response\":0}");
			
		}
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Asiakkaat.doPut()");
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Asiakkaat.doDelete()");
		int id = Integer.parseInt(request.getParameter("id"));
		Dao dao = new Dao();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out =response.getWriter();
		if(dao.removeItem(id)){
			out.println("{\"response\":1}");
		}else {
			out.println("{\"response\":0}");
			
		}
	}

}
