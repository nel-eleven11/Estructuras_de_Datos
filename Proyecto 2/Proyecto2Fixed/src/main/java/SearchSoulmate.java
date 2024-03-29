
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dataAccessLayer.EmbeddedNeo4j;

import org.json.simple.JSONArray;

import java.util.List;
import java.util.Map;


@WebServlet("/SearchSoulmate")
public class SearchSoulmate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SearchSoulmate() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        JSONArray matchesJson = new JSONArray();
        try (EmbeddedNeo4j db = new EmbeddedNeo4j("neo4j+s://b5cf9803.databases.neo4j.io", "neo4j", "Re6HAL1dSCcb58sXzH0KfLzvaWox0j8dCNisrY0t4_8")) {
            List<Map<String, Object>> matches = db.findMatches(userId);
            for (Map<String, Object> match : matches) {
                JSONObject matchJson = new JSONObject();
                matchJson.put("matchedUser", match.get("matchedUser"));
                matchJson.put("sharedInterests", match.get("sharedInterests"));
                matchJson.put("commonInterestCount", match.get("commonInterestCount"));
                matchesJson.add(matchJson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println(matchesJson);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

