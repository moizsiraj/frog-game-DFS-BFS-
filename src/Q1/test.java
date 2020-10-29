package Q1;

public class test {
    public static void main(String[] args) {
        List list = new List(20);
        list.addCity("Neamt");
        list.addNeighbourCity("Neamt","Iasi");
        list.addCity("Arad");
        list.addNeighbourCity("Arad", "Zerind");
        list.addNeighbourCity("Arad", "Sibiu");
        list.addNeighbourCity("Arad", "Timisoara");
        list.addCity("Timisoara");
        list.addNeighbourCity("Timisoara", "Arad");
        list.addNeighbourCity("Timisoara", "Lugoj");
        list.addCity("Lugoj");
        list.addNeighbourCity("Lugoj", "Timisoara");
        list.addNeighbourCity("Lugoj", "Mehadia");
        list.addCity("Mehadia");
        list.addNeighbourCity("Mehadia", "Lugoj");
        list.addNeighbourCity("Mehadia", "Dobreta");
        list.addCity("Dobreta");
        list.addNeighbourCity("Dobreta", "Mehadia");
        list.addNeighbourCity("Dobreta", "Craiova");
        list.addCity("Zerind");
        list.addNeighbourCity("Zerind", "Arad");
        list.addNeighbourCity("Zerind", "Odarea");
        list.addCity("Odarea");
        list.addNeighbourCity("Odarea", "Zerind");
        list.addNeighbourCity("Odarea", "Sibiu");
        list.addCity("Sibiu");
        list.addNeighbourCity("Sibiu", "Arad");
        list.addNeighbourCity("Sibiu", "Rimnieu Vilcea");
        list.addNeighbourCity("Sibiu", "Farara");
        list.addNeighbourCity("Sibiu", "Odarea");
        list.addCity("Rimnieu Vilcea");
        list.addNeighbourCity("Rimnieu Vilcea", "Sibiu");
        list.addNeighbourCity("Rimnieu Vilcea", "Pitesti");
        list.addNeighbourCity("Rimnieu Vilcea", "Craiova");
        list.addCity("Craiova");
        list.addNeighbourCity("Craiova", "Dobreta");
        list.addNeighbourCity("Craiova", "Rimnieu Vilcea");
        list.addNeighbourCity("Craiova", "Pitesti");
        list.addCity("Pitesti");
        list.addNeighbourCity("Pitesti", "Rimnieu Vilcea");
        list.addNeighbourCity("Pitesti", "Craiova");
        list.addNeighbourCity("Pitesti", "Bucharest");
        list.addCity("Farara");
        list.addNeighbourCity("Farara", "Sibiu");
        list.addNeighbourCity("Farara", "Bucharest");
        list.addCity("Giurgui");
        list.addNeighbourCity("Giurgui", "Bucharest");
        list.addCity("Bucharest");
        list.addNeighbourCity("Bucharest", "Pitesti");
        list.addNeighbourCity("Bucharest", "Giurgui");
        list.addNeighbourCity("Bucharest", "Farara");
        list.addNeighbourCity("Bucharest", "Urziceni");
        list.addCity("Urziceni");
        list.addNeighbourCity("Urziceni", "Bucharest");
        list.addNeighbourCity("Urziceni", "Hirsova");
        list.addCity("Hirsova");
        list.addNeighbourCity("Hirsova", "Eforie");
        list.addNeighbourCity("Hirsova", "Vaslui");
        list.addNeighbourCity("Hirsova", "Urziceni");
        list.addCity("Eforie");
        list.addNeighbourCity("Eforie", "Hirsova");
        list.addCity("Vaslui");
        list.addNeighbourCity("Vaslui", "Iasi");
        list.addNeighbourCity("Vaslui", "Hirsova");
        list.addCity("Iasi");
        list.addNeighbourCity("Iasi", "Neamt");
        list.addNeighbourCity("Iasi", "Vaslui");
        list.print();

        IDS ids = new IDS();
        ids.runIDS(list, "Arad", "Bucharest");
        ids.resetVisited();

        BFS bfs = new BFS();
        bfs.runBFS(list, "Arad", "Bucharest", true);
        ids.resetVisited();

        DFS dfs = new DFS();
        dfs.runDFS(list, "Arad", "Bucharest");
        ids.resetVisited();




    }
}
