package Q1;

public class Vertex {
    String city;
    Vertex next;

    public Vertex() {
    }

    public Vertex(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public Vertex getNext() {
        return next;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setNext(Vertex next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "vertex{" +
                "city='" + city + '\'' +
                '}';
    }
}
