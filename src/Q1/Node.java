package Q1;

public class Node {
    String city;
    edgeList adjacentCities;
    Boolean visited;
    Node prev;
    int height;

    public Node(String city) {
        this.city = city;
        adjacentCities = new edgeList();
    }

    public Node() {
        adjacentCities = new edgeList();
        visited = false;
    }

    public String getCity() {
        return city;
    }

    public edgeList getAdjacentCities() {
        return adjacentCities;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
