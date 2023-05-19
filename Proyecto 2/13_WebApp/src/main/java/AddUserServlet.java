import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dataAccessLayer.EmbeddedNeo4j;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AddUserServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extraer los datos del formulario
		String userId = request.getParameter("userId");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String sex = request.getParameter("sex");
		String city = request.getParameter("city");
		String relationshipType = request.getParameter("relationshipType");
		String[] interests = request.getParameterValues("interests");

		// Conectar con la base de datos Neo4j e insertar el nuevo usuario
		try ( EmbeddedNeo4j db = new EmbeddedNeo4j( "neo4j+s://b5cf9803.databases.neo4j.io", "neo4j", "Re6HAL1dSCcb58sXzH0KfLzvaWox0j8dCNisrY0t4_8" ) ) {
			db.createUser(userId, username, password, Integer.parseInt(age), name, lastName, sex);
			db.createRelationshipToCity(userId, city);
			db.createRelationshipToRelationshipType(userId, relationshipType);
			for(String interest : interests){
				db.createRelationshipToInterest(userId, interest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
