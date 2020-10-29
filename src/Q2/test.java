package Q2;

public class test {
    public static void main(String args[]) throws CloneNotSupportedException {
        Graph g = new Graph();
        g.generateGraph(4);
        DFS dfs = new DFS();
        System.out.println("DFS");
        dfs.runDFS(g, "AB__CD", "CD__AB");
        System.out.println("BFS");
        BFS bfs = new BFS();
        bfs.runBFS(g,"AB__CD", "CD__AB");
    }
}
