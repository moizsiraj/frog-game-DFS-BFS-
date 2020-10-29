package Q1;

import static java.lang.System.exit;

public class List implements Cloneable {
    Node[] cityList;
    private int currentIndex;

    public List(int noOfCities) {
        cityList = new Node[noOfCities];
        for (int i = 0; i < noOfCities; i++) {
            cityList[i] = new Node();
        }
        currentIndex = 0;
    }

    public List(List list) {
        list.cityList = this.cityList; // you can access
    }

    public void addCity(String cityName){
        cityList[currentIndex].setCity(cityName);
        currentIndex++;
    }

    public void addNeighbourCity(String city, String neighbour){
        int cityIndex = 0;
        for (int i = 0; i < cityList.length; i++) {
            if(city.equalsIgnoreCase(cityList[i].city)){
                cityIndex = i;
                break;
            }
        }
        if(cityIndex>cityList.length-1){
            System.out.println("City doesn't exist");
            exit(0);
        }
        cityList[cityIndex].adjacentCities.addCity(neighbour);
    }

    public void print(){
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < currentIndex; i++) {
            print.append(i).append("--").append(cityList[i].getCity()).append(" - ");
            Vertex temp = cityList[i].adjacentCities.getList();
            while (temp != null){
                print.append(temp.getCity());
                print.append(", ");
                temp = temp.next;
            }
            print.append("\n");
        }
        System.out.println(print);
    }


}