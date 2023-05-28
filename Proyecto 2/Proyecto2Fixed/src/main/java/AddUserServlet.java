

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



@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject myResponse = new JSONObject();
        JSONArray userInterests = new JSONArray();
        String userId = request.getParameter("userId");
        try ( EmbeddedNeo4j db = new EmbeddedNeo4j( "neo4j+s://b5cf9803.databases.neo4j.io", "neo4j", "Re6HAL1dSCcb58sXzH0KfLzvaWox0j8dCNisrY0t4_8" ) ) {
            String username = request.getParameter("username");
            String age = request.getParameter("age");
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            String sex = request.getParameter("sex");
            String city = request.getParameter("city");
            String relationshipType = request.getParameter("relationshipType");
            String interests = Arrays.toString(request.getParameterValues("interests"));
            db.createUser(userId, Integer.parseInt(age), name, lastName);
            db.linkUserToCity(userId, city);
            db.linkUserToRelationshipType(userId, relationshipType);
            List<String> interestsList = new LinkedList<String>(Arrays.asList(interests.substring(1, interests.length()-1).split(", ")));
            db.linkUserToInterests(userId, interestsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        myResponse.put("userId", userId);
        myResponse.put("interests", userInterests);
        out.println(myResponse);
        out.flush();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
