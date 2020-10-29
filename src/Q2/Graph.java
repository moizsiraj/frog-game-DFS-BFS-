package Q2;

import java.util.LinkedList;

public class Graph {

    LinkedList<state> states;

    public Graph() {
        states = new LinkedList<>();
    }

    public void generateGraph(int noOfFrogs) throws CloneNotSupportedException {
        state startState = new state(noOfFrogs);
        startState.setSlideOrHop();
        states.add(startState);
        nextState(startState);
        for (int i = 2; i < states.size(); i++) {
            nextState(states.get(i));
        }

    }

    void nextState(state State) throws CloneNotSupportedException {
        for (int i = 0; i < State.frogArray.length; i++) {
            if (i != State.vacant) {
                frog currentFrog = State.frogArray[i];
                if (currentFrog.canMove()) {
                    state newState = State.createState();
                    frog temp = newState.frogArray[newState.vacant];
                    newState.frogArray[newState.vacant] = newState.frogArray[i];
                    newState.vacant = i;
                    newState.frogArray[newState.vacant] = temp;
                    newState.setSlideOrHop();
                    State.stateList.add(newState);
                    newState.previous = State;
                    states.add(newState);
                }
            }
        }
    }
}

