package Q2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.exit;

public class BFS {
    Queue<state> queue;

    public BFS() {
        queue = new LinkedList<state>();
    }

    public void runBFS(Graph graph, String start, String end) {
        for (int i = 0; i < graph.states.size(); i++) {
            graph.states.get(i).visited = false;
        }
        state startCombination = findState(graph, start);
        startCombination.visited = true;
        queue.addAll(startCombination.stateList);
        boolean goalReached = false;
        while (!queue.isEmpty() && !goalReached) {
            state currentState = queue.remove();
            if (!currentState.visited) {
                currentState.visited = true;
                if (currentState.toString().equals(end)) {
                    System.out.println(path(currentState));
                    System.out.println("Goal Reached");
                    goalReached = true;
                } else {
                    for (int i = 0; i < currentState.stateList.size(); i++) {
                        state temp = startCombination.stateList.get(i);
                        queue.add(temp);
                    }
                }
            }

        }
    }


    state findState(Graph graph, String combination) {
        Iterator<state> i = graph.states.iterator();
        state found = null;
        while (i.hasNext()) {
            state temp = i.next();
            if (temp.toString().equals(combination)) {
                found = temp;
            }
        }
        return found;
    }

    String path(state end) {
        String print = "";
        state currentState = end;
        while (currentState != null) {
            print = " --> " + currentState.toString() + print;
            currentState = currentState.previous;
        }
        return print;
    }
}
