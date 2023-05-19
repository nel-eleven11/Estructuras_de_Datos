/**
 * 
 */
package dataAccessLayer;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;
import org.neo4j.driver.summary.ResultSummary;

import static org.neo4j.driver.Values.parameters;

import java.util.LinkedList;
import java.util.List;
/**
 * @author Administrator
 *
 */
public class EmbeddedNeo4j implements AutoCloseable{

    private final Driver driver;
    

    public EmbeddedNeo4j( String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    public void printGreeting( final String message )
    {
        try ( Session session = driver.session() )
        {
            String greeting = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run( "CREATE (a:Greeting) " +
                                                     "SET a.message = $message " +
                                                     "RETURN a.message + ', from node ' + id(a)",
                            parameters( "message", message ) );
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println( greeting );
        }
    }
    
    public LinkedList<String> getActors()
    {
    	 try ( Session session = driver.session() )
         {
    		 
    		 
    		 LinkedList<String> actors = session.readTransaction( new TransactionWork<LinkedList<String>>()
             {
                 @Override
                 public LinkedList<String> execute( Transaction tx )
                 {
                     Result result = tx.run( "MATCH (people:Person) RETURN people.name");
                     LinkedList<String> myactors = new LinkedList<String>();
                     List<Record> registros = result.list();
                     for (int i = 0; i < registros.size(); i++) {
                    	 //myactors.add(registros.get(i).toString());
                    	 myactors.add(registros.get(i).get("people.name").asString());
                     }
                     
                     return myactors;
                 }
             } );
             
             return actors;
         }
    }
    
    public LinkedList<String> getMoviesByActor(String actor)
    {
   	 try ( Session session = driver.session() )
        {
   		 
   		 
   		 LinkedList<String> actors = session.readTransaction( new TransactionWork<LinkedList<String>>()
            {
                @Override
                public LinkedList<String> execute( Transaction tx )
                {
                    Result result = tx.run( "MATCH (tom:Person {name: \"" + actor + "\"})-[:ACTED_IN]->(actorMovies) RETURN actorMovies.title");
                    LinkedList<String> myactors = new LinkedList<String>();
                    List<Record> registros = result.list();
                    for (int i = 0; i < registros.size(); i++) {
                   	 //myactors.add(registros.get(i).toString());
                   	 myactors.add(registros.get(i).get("actorMovies.title").asString());
                    }
                    
                    return myactors;
                }
            } );
            
            return actors;
        }
   }

    public void createUser(String userId, String username, String password, int age, String name, String lastName, String sex) {
        String query = "MERGE (u:User {userId: $userId}) " +
                "ON CREATE SET u.username = $username, u.password = $password, u.age = $age, u.name = $name, u.lastName = $lastName, u.sex = $sex";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("username", username);
        parameters.put("password", password);
        parameters.put("age", age);
        parameters.put("name", name);
        parameters.put("lastName", lastName);
        parameters.put("sex", sex);

        try (Session session = driver.session()) {
            session.run(query, parameters);
        }
    }

    public void createRelationshipToCity(String userId, String cityName) {
        String query = "MATCH (u:User {userId: $userId}) " +
                "MERGE (c:City {name: $cityName}) " +
                "MERGE (u)-[:LIVES_IN]->(c)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("cityName", cityName);

        try (Session session = driver.session()) {
            session.run(query, parameters);
        }
    }

    public void createRelationshipToInterest(String userId, String interestName) {
        String query = "MATCH (u:User {userId: $userId}) " +
                "MERGE (i:Interest {name: $interestName}) " +
                "MERGE (u)-[:INTERESTED_IN]->(i)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("interestName", interestName);

        try (Session session = driver.session()) {
            session.run(query, parameters);
        }
    }

    public void createRelationshipToSex(String userId, String sex) {
        String query = "MATCH (u:User {userId: $userId}) " +
                "MERGE (s:Sex {name: $sex}) " +
                "MERGE (u)-[:HAS_SEX]->(s)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("sex", sex);

        try (Session session = driver.session()) {
            session.run(query, parameters);
        }
    }

    public void createRelationshipToRelationshipType(String userId, String relationshipType) {
        String query = "MATCH (u:User {userId: $userId}) " +
                "MERGE (r:RelationshipType {name: $relationshipType}) " +
                "MERGE (u)-[:SEEKS]->(r)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("relationshipType", relationshipType);

        try (Session session = driver.session()) {
            session.run(query, parameters);
        }
    }

}
