package Q1;

import java.util.Stack;

import static java.lang.System.exit;

public class IDS {
    Stack<Vertex> stack;
    List graph;
    int[] previous;
    int currentLevel;
    int maxHeight;

    public IDS() {
        this.stack = new Stack<>();
        currentLevel = 1;
    }

    void runIDS(List graph, String depart, String arrive) {
        this.graph = graph;
        boolean cityFound = false;
        setHeight();
        resetVisited();
        int departIndex = -1;
        previous = new int[graph.cityList.length];

        for (int i = 0; i < graph.cityList.length; i++) {
            if (graph.cityList[i].getCity().equalsIgnoreCase(depart)) {
                departIndex = i;
            }
        }
        if (departIndex == -1) {
            System.out.println("City doesn't exist");
            exit(0);
        }
        while (currentLevel <= maxHeight && !cityFound) {
            Vertex currentCity = graph.cityList[departIndex].adjacentCities.getList();
            if (currentCity == null) {
                System.out.println("City has no neighbours");
            } else {
                resetVisited();
                graph.cityList[departIndex].visited = true;
                while (currentCity != null) {
                    int tempIndex = findIndex(graph, currentCity.getCity());
                    previous[tempIndex] = departIndex;
                    if (graph.cityList[tempIndex].height <= currentLevel) {
                        stack.push(currentCity);
                        currentCity = currentCity.next;
                    }
                }
                cityFound = false;
                while (!stack.empty() && !cityFound) {
                    currentCity = stack.pop();
                    int currentCityIndex = findIndex(graph, currentCity.getCity());
                    if (!graph.cityList[currentCityIndex].visited) {
                        graph.cityList[currentCityIndex].visited = true;
                        if (graph.cityList[currentCityIndex].getCity().equalsIgnoreCase(arrive)) {
                            System.out.println("city found");
                            cityFound = true;
                        } else {
                            currentCity = graph.cityList[currentCityIndex].adjacentCities.getList();
                            while (currentCity != null) {
                                int tempIndex = findIndex(graph, currentCity.getCity());
                                if (!graph.cityList[tempIndex].visited && graph.cityList[tempIndex].height <= currentLevel) {
                                    previous[tempIndex] = currentCityIndex;
                                    stack.push(currentCity);
                                }
                                currentCity = currentCity.next;
                            }
                        }
                    }
                }
                currentLevel++;
            }
        }
        System.out.println("Number of Iterations: " + (currentLevel-1));
        path(graph, arrive, depart);
    }

    void path(List graph, String end, String start) {
        String path = "";
        int currentIndex = findIndex(graph, end);
        String currentCity = graph.cityList[currentIndex].city;
        path = path + "-->" + currentCity;
        while (!currentCity.equals(start)) {
            int previousIndex = this.previous[currentIndex];
            String previousCity = graph.cityList[previousIndex].getCity();
            path = previousCity + "-->" + path;
            //System.out.println(path);
            currentIndex = findIndex(graph, previousCity);
            currentCity = graph.cityList[currentIndex].city;
        }
        System.out.println(path);
    }

    void resetVisited() {
        for (int i = 0; i < graph.cityList.length; i++) {
            graph.cityList[i].visited = false;
        }
    }


    int findIndex(List graph, String city) {
        int index = -1;
        for (int i = 0; i < graph.cityList.length; i++) {
            if (graph.cityList[i].getCity().equalsIgnoreCase(city)) {
                index = i;
            }
        }
        return index;
    }


    void setHeight() {
        BFS setHeight = new BFS();
        maxHeight = setHeight.runBFS(this.graph, "Arad", "Neamt", false);
    }

    void printHeight() {
        for (int i = 0; i < graph.cityList.length; i++) {
            if (graph.cityList[i].prev != null) {
                System.out.println(graph.cityList[i].prev.city + " --> " + graph.cityList[i].city + " height: " + graph.cityList[i].height);
            } else {
                System.out.println(graph.cityList[i].city + " height: " + graph.cityList[i].height);
            }
        }
    }
}
