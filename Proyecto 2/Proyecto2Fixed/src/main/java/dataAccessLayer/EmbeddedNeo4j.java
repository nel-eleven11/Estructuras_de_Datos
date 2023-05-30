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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    public String createUser(String userId, int age, String name, String lastName) {
        try (Session session = driver.session()) {
            String result = session.writeTransaction( new TransactionWork<String>(){
                @Override
                public String execute( Transaction tx ){
                    tx.run("MERGE (u:User {userId:'"+userId+"', name: '"+name+"', lastName: '"+lastName+"', age: "+age+"})");
                    return "OK";
                }
            }
   		 );
            return result;
        } catch (Exception e) {
        	return e.getMessage();
        }
    }
    
    public String createCity(String cityName) {
    	try (Session session = driver.session()) {
            String result = session.writeTransaction( new TransactionWork<String>(){
                @Override
                public String execute( Transaction tx ){
                    tx.run("MERGE (l:Location {name: '"+cityName+"'})");
                    return "OK";
                }
            }
   		 );
            return result;
        } catch (Exception e) {
        	return e.getMessage();
        }
    }


    public String linkUserToCity(String userId, String location) {
    	try (Session session = driver.session()) {
            String result = session.writeTransaction( new TransactionWork<String>(){
                @Override
                public String execute( Transaction tx ){
                    tx.run("MATCH (u:User {userId: '"+userId+"'}), (l:Location {name: '"+location+"'}) MERGE (u)-[:LIVES_IN]->(l)");
                    return "OK";
                }
            }
   		 );
            return result;
        } catch (Exception e) {
        	return e.getMessage();
        }
    }
    
    public String createInterest(String interest) {
    	try (Session session = driver.session()) {
            String result = session.writeTransaction( new TransactionWork<String>(){
                @Override
                public String execute( Transaction tx ){
                    tx.run("MERGE (i:Interest {name:'"+interest+"'})");
                    return "OK";
                }
            }
   		 );
            return result;
        } catch (Exception e) {
        	return e.getMessage();
        }
    }


    public String linkUserToInterests(String userId, String interest) {
    	try (Session session = driver.session()) {
            String result = session.writeTransaction( new TransactionWork<String>(){
                @Override
                public String execute( Transaction tx ){
                    tx.run("MATCH (u:User {userId: '"+userId+"'}), (i:Interest {name: '"+interest+"'}) MERGE (u)-[:INTERESTED_IN]->(i)");
                    return "OK";
                }
            }
   		 );
            return result;
        } catch (Exception e) {
        	return e.getMessage();
        }
    }


    public String linkUserToRelationshipType(String userId, String relationshipType) {
    	try (Session session = driver.session()) {
            String result = session.writeTransaction( new TransactionWork<String>(){
                @Override
                public String execute( Transaction tx ){
                    tx.run("MATCH (u:User {userId: '"+userId+"'}), (r:RelationshipType {name: '"+relationshipType+"'}) MERGE (u)-[:WANTS_RELATIONSHIP]->(r)");
                    return "OK";
                }
            }
   		 );
            return result;
        } catch (Exception e) {
        	return e.getMessage();
        }
    }

    public String linkUserToSex(String userId, String sex) {
    	try (Session session = driver.session()) {
            String result = session.writeTransaction( new TransactionWork<String>(){
                @Override
                public String execute( Transaction tx ){
                    tx.run("MATCH (u:User {userId: '"+userId+"'}), (s:Sex {name: '"+sex+"'}) MERGE (u)-[:HAS_SEX]->(s)");
                    return "OK";
                }
            }
   		 );
            return result;
        } catch (Exception e) {
        	return e.getMessage();
        }
    }

    public List<Map<String, Object>> findMatches(String userId) {
        try (Session session = driver.session()) {
            List<Map<String, Object>> matches = session.readTransaction(new TransactionWork<List<Map<String, Object>>>() {
                @Override
                public List<Map<String, Object>> execute(Transaction tx) {
                    Result result = tx.run("MATCH (u:User {userId: $userId})-[:LIVES_IN]->(l:Location)<-[:LIVES_IN]-(m:User),"
                            + "(u)-[:WANTS_RELATIONSHIP]->(r:RelationshipType)<-[:WANTS_RELATIONSHIP]-(m),"
                            + "(u)-[:HAS_SEX]->(s:Sex), (m)-[:HAS_SEX]->(oppositeSex:Sex),"
                            + "(u)-[:INTERESTED_IN]->(i:Interest)<-[:INTERESTED_IN]-(m)"
                            + "WHERE NOT s = oppositeSex "
                            + "WITH u, m, collect(i) AS sharedInterests "
                            + "RETURN m AS matchedUser, sharedInterests, size(sharedInterests) AS commonInterestCount "
                            + "ORDER BY commonInterestCount DESC", parameters("userId", userId));
                    
                    List<Map<String, Object>> matches = new LinkedList<>();
                    while (result.hasNext()) {
                        Record record = result.next();
                        Map<String, Object> match = new HashMap<>();
                        match.put("matchedUser", record.get("matchedUser").asNode().asMap());
                        match.put("sharedInterests", record.get("sharedInterests").asList());
                        match.put("commonInterestCount", record.get("commonInterestCount").asInt());
                        matches.add(match);
                    }
                    return matches;
                }
            });
            return matches;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
