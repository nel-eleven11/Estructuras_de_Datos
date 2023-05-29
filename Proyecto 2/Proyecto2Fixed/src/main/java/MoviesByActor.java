/*

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dataAccessLayer.EmbeddedNeo4j;

import org.json.simple.JSONArray;


@WebServlet("/MoviesByActor")
public class MoviesByActor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MoviesByActor() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
	 	response.setContentType("application/json");
	 	response.setCharacterEncoding("UTF-8");
	 	JSONObject myResponse = new JSONObject();
	 	
	 	JSONArray PeliculasActor = new JSONArray();
	 	
	 	String myActor = request.getParameter("actor_name");
	 	 try ( EmbeddedNeo4j greeter = new EmbeddedNeo4j( "bolt://3.231.25.113:7687", "neo4j", "wax-pitches-grove" ) )
	        {
			 	LinkedList<String> myactors = greeter.getMoviesByActor(myActor);
			 	
			 	for (int i = 0; i < myactors.size(); i++) {
			 		 //out.println( "<p>" + myactors.get(i) + "</p>" );
			 		PeliculasActor.add(myactors.get(i));
			 	}
	        	
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	
	 	myResponse.put("conteo", PeliculasActor.size()); //Guardo la cantidad de actores
	 	myResponse.put("peliculas", PeliculasActor);
	 	out.println(myResponse);
	 	out.flush();  
	 	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
*/
