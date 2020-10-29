package Q1;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.exit;

public class BFS {
    Queue<Vertex> queue;
    int[] previous;
    boolean mainCall;
    int maxHeight;

    public BFS() {
        queue = new LinkedList<Vertex>();
    }

    public int runBFS(List graph, String depart, String arrive, boolean mainCall) {
        int departIndex = -1;
        previous = new int[graph.cityList.length];
        this.mainCall = mainCall;
        maxHeight = 0;

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
            graph.cityList[departIndex].height = 0;
            while (currentCity != null) {
                int tempIndex = findIndex(graph, currentCity.getCity());
                previous[tempIndex] = departIndex;
                graph.cityList[tempIndex].prev = graph.cityList[departIndex];
                graph.cityList[tempIndex].height = graph.cityList[departIndex].height + 1;
                queue.add(currentCity);
                currentCity = currentCity.next;
            }
            boolean cityFound = false;
            while (!queue.isEmpty() && !cityFound) {
                currentCity = queue.remove();
                int currentCityIndex = findIndex(graph, currentCity.getCity());
                if (!graph.cityList[currentCityIndex].visited) {
                    graph.cityList[currentCityIndex].visited = true;
                    if (graph.cityList[currentCityIndex].getCity().equalsIgnoreCase(arrive)) {
                        if(mainCall){System.out.println("city found");}
                        cityFound = true;
                    } else {
                        currentCity = graph.cityList[currentCityIndex].adjacentCities.getList();
                        while (currentCity != null) {
                            int tempIndex = findIndex(graph, currentCity.getCity());
                            if (!graph.cityList[tempIndex].visited) {
                                previous[tempIndex] = currentCityIndex;
                                graph.cityList[tempIndex].prev = graph.cityList[currentCityIndex];
                                graph.cityList[tempIndex].height = graph.cityList[currentCityIndex].height + 1;
                                if (maxHeight < graph.cityList[tempIndex].height) {
                                    maxHeight = graph.cityList[tempIndex].height;
                                }
                            }
                            queue.add(currentCity);
                            currentCity = currentCity.next;
                        }
                    }
                }

            }
        }
        if (this.mainCall) {
            path(graph, arrive, depart);
        }
        return maxHeight;
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
