/**
 *
 */
package dataAccessLayer;

import org.neo4j.driver.*;

import java.util.LinkedList;
import java.util.List;

import static org.neo4j.driver.Values.parameters;
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

    public String createUser(String Name, String lastName, String age) {
        try (Session session = driver.session()) {
            String result = session.writeTransaction(new TransactionWork<String>() {
                @Override
                public String execute(Transaction tx) {
                    tx.run("CREATE (u:User {firstName:'" + Name + "', lastName:" + lastName + "', age:" + age + ", score: 0})")
                    ;
                    return "OK";


                }
            });
            return result;
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public String linkUserToCity(String userId, String cityName) {
        try (Session session = driver.session()) {
            String result = session.writeTransaction(new TransactionWork<String>() {
                @Override
                public String execute(Transaction tx) {
                    tx.run("MATCH (u:User {userId: $userId}), (l:Location {name: $cityName})" +
                                    "MERGE (u)-[:LIVES_IN]->(l)",
                            parameters("userId", userId, "cityName", cityName));
                    return "OK";
                }
            });
            return result;
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public String linkUserToInterests(String userId, List<String> interests) {
        try (Session session = driver.session()) {
            String result = session.writeTransaction(new TransactionWork<String>() {
                @Override
                public String execute(Transaction tx) {
                    for (String interest : interests) {
                        tx.run("MATCH (u:User {userId: $userId}), (i:Interest {name: $interest})" +
                                        "MERGE (u)-[:INTERESTED_IN]->(i)",
                                parameters("userId", userId, "interest", interest));
                    }
                    return "OK";
                }
            });
            return result;
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public String linkUserToRelationshipType(String userId, String relationshipType) {
        try (Session session = driver.session()) {
            String result = session.writeTransaction(new TransactionWork<String>() {
                @Override
                public String execute(Transaction tx) {
                    tx.run("MATCH (u:User {userId: $userId}), (r:RelationshipType {name: $relationshipType})" +
                                    "MERGE (u)-[:WANTS_RELATIONSHIP]->(r)",
                            parameters("userId", userId, "relationshipType", relationshipType));
                    return "OK";
                }
            });
            return result;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String linkUserToSex(String userId, String sex) {
        try (Session session = driver.session()) {
            String result = session.writeTransaction(new TransactionWork<String>() {
                @Override
                public String execute(Transaction tx) {
                    tx.run("MATCH (u:User {userId: $userId}), (s:Sex {type: $sex})" +
                                    "MERGE (u)-[:IS_OF_SEX]->(s)",
                            parameters("userId", userId, "sex", sex));
                    return "OK";
                }
            });
            return result;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}