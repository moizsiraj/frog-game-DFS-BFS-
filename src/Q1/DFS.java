package Q1;

import java.util.Stack;

import static java.lang.System.exit;

public class DFS {
    Stack<Vertex> stack;
    int[] previous;

    public DFS() {
        this.stack = new Stack<>();
    }

    void runDFS(List graph, String depart, String arrive) {
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
        Vertex currentCity = graph.cityList[departIndex].adjacentCities.getList();
        if (currentCity == null) {
            System.out.println("City has no neighbours");
        } else {
            graph.cityList[departIndex].visited = true;
            //System.out.print(graph.cityList[departIndex].city + "-->");
            while (currentCity != null) {
                int tempIndex = findIndex(graph, currentCity.getCity());
                previous[tempIndex] = departIndex;
                stack.push(currentCity);
                currentCity = currentCity.next;
            }
            boolean cityFound = false;
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
                            if (!graph.cityList[tempIndex].visited) {
                                previous[tempIndex] = currentCityIndex;
                            }
                            stack.push(currentCity);
                            currentCity = currentCity.next;
                        }
                    }
                }

            }
        }
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
            currentIndex = findIndex(graph, previousCity);
            currentCity = graph.cityList[currentIndex].city;
        }
        System.out.println(path);
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


}
