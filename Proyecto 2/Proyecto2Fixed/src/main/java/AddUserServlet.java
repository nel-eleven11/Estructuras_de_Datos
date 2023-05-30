

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

import dataAccessLayer.EmbeddedNeo4j;

import org.json.simple.JSONArray;

import java.text.Normalizer;
import java.util.regex.Pattern;



@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddUserServlet() {
        super();
    }
    
    private static String removeAccents(String text) {
        String nfdNormalizedString = Normalizer.normalize(text, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject myResponse = new JSONObject();
        String userId = request.getParameter("userId");
        String age = request.getParameter("age");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String sex = request.getParameter("sex");
        String city = request.getParameter("city");
        String relationshipType = request.getParameter("relationshipType");
        String interests = request.getParameter("interests");
        try ( EmbeddedNeo4j db = new EmbeddedNeo4j( "neo4j+s://b5cf9803.databases.neo4j.io", "neo4j", "Re6HAL1dSCcb58sXzH0KfLzvaWox0j8dCNisrY0t4_8" ) ) {
            db.createUser(userId, Integer.parseInt(age), name, lastName);
            String[] interestsList = interests.split(",");
            db.createCity(city);
            db.linkUserToCity(userId, city);
            db.linkUserToRelationshipType(userId, relationshipType);
            db.linkUserToSex(userId, sex);
            for (int i = 0; i < interests.length(); i++) {
            	String interes = interestsList[i].trim();
            	interes = interes.toLowerCase();
            	interes = removeAccents(interes);
            	db.createInterest(interes);
            	db.linkUserToInterests(userId, interes);
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        myResponse.put("userId", userId);
        myResponse.put("age", age);
        myResponse.put("name", name);
        myResponse.put("lastName", lastName);
        myResponse.put("sex", sex);
        myResponse.put("city", city);
        myResponse.put("relationshipType", relationshipType);
        myResponse.put("interests", interests);
        out.println(myResponse);
        out.flush();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
