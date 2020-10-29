package Q1;

public class edgeList {
    Vertex head;

    public edgeList() {
    }

    public void addCity(String cityName) {
        Vertex vertex = new Vertex(cityName);
        if (head == null) {
            head = vertex;
        } else {
            Vertex tempVertex = head;
            while (tempVertex.next != null) {
                tempVertex = tempVertex.next;
            }
            tempVertex.next = vertex;
        }
    }

    public Vertex getList() {
        return head;
    }


}
