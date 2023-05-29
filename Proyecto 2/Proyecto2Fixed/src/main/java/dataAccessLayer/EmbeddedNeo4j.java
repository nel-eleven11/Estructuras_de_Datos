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
                    tx.run("MERGE (n:Location {name:'"+cityName+"'})");
                    return "OK";
                }
            }
   		 );
            return result;
        } catch (Exception e) {
        	return e.getMessage();
        }
    }


    public String linkUserToCity(String userId, String cityName) {
    	try (Session session = driver.session()) {
            String result = session.writeTransaction( new TransactionWork<String>(){
                @Override
                public String execute( Transaction tx ){
                    tx.run("MATCH (u:User {userId: '"+ userId +"'}), (n:Location {name: '" + cityName +"'}) MERGE (u)-[:LIVES_IN]->(l)");
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
                    tx.run("MERGE (n:Interest {name:'"+interest+"'})");
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
                    tx.run("MATCH (u:User {userId: '"+userId+"'}), (r:RelationshipType {name: '"+relationshipType+"'}) MERGE (u)-[:INTERESTED_IN]->(r)");
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
                    tx.run("MATCH (u:User {userId: '"+userId+"'}), (s:Sex {name: '"+sex+"'}) MERGE (u)-[:IS_A]->(s)");
                    return "OK";
                }
            }
   		 );
            return result;
        } catch (Exception e) {
        	return e.getMessage();
        }
    }
}
