package Q2;


import java.util.Iterator;
import java.util.Stack;


public class DFS {
    Stack<state> stack;

    public DFS() {
        this.stack = new Stack<>();
    }

    void runDFS(Graph graph, String start, String end) {
        for (int i = 0; i < graph.states.size(); i++) {
            graph.states.get(i).visited = false;
        }
        state startCombination = findState(graph, start);
        startCombination.visited = true;
        for (int i = 0; i < startCombination.stateList.size(); i++) {
            state temp = startCombination.stateList.get(i);
            stack.push(temp);
        }
        boolean goalReached = false;
        while (!stack.empty() && !goalReached) {
            state currentState = stack.pop();
            if (!currentState.visited) {
                currentState.visited = true;
                if (currentState.toString().equals(end)) {
                    System.out.println(path(currentState));
                    System.out.println("Goal Reached");
                    goalReached = true;
                } else {
                    for (int i = 0; i < currentState.stateList.size(); i++) {
                        state temp = startCombination.stateList.get(i);
                        stack.push(temp);
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