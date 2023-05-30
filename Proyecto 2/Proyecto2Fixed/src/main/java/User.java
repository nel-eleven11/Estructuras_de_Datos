import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private String lastName;
    private String city;
    private String sex;
    private String relationshipType;
    private List<String> interests;
    private int commonInterests;

    // Constructor
    public User() {
        interests = new ArrayList<>();
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public int getCommonInterests() {
        return commonInterests;
    }

    public void setCommonInterests(int commonInterests) {
        this.commonInterests = commonInterests;
    }
}