package Q2;

import java.util.LinkedList;

public class state implements Cloneable{
    frog[] frogArray;
    state previous;
    LinkedList<state> stateList;
    int vacant;
    int noOfFrogs;
    state State;
    boolean visited;

    public state(int noOfFrogs) {
        this.noOfFrogs = noOfFrogs;
        this.frogArray = new frog[noOfFrogs + 1];
        this.stateList = new LinkedList<>();
        initiateState();
    }

    public state(int noOfFrogs, boolean check) {
        this.noOfFrogs = noOfFrogs;
        this.frogArray = new frog[noOfFrogs + 1];
        this.stateList = new LinkedList<>();
    }

    public state(){
    }

    void initiateState() {
        vacant = frogArray.length/2;
        char frog = 'A';
        for (int i = 0; i < frogArray.length; i++) {
            frogArray[i] = new frog();
            if(i != vacant){
                frogArray[i].name = frog;
                if (i < vacant){
                    frogArray[i].leftOrRight = 'R';
                }
                else{
                    frogArray[i].leftOrRight = 'L';
                }
                frog++;
            }
        }
    }

    state createState() throws CloneNotSupportedException {
        state State = (state) this.clone();
        return  State;
    }




    void setSlideOrHop(){
        for (int i = 0; i < frogArray.length; i++) {
            if(Math.abs(vacant - i) == 1){//for slide
                if(vacant < i && frogArray[i].leftOrRight == 'R'){
                    frogArray[i].canSlide = false;
                }
                else if(vacant < i && frogArray[i].leftOrRight == 'L'){
                    frogArray[i].canSlide = true;
                }
                else if(vacant > i && frogArray[i].leftOrRight == 'R'){
                    frogArray[i].canSlide = true;
                }
                else if(vacant > i && frogArray[i].leftOrRight == 'L'){
                    frogArray[i].canSlide = false;
                }
                frogArray[i].canHop = false;
            }
            else if(Math.abs(vacant - i) == 2){
                if(vacant < i && frogArray[i].leftOrRight == 'R'){
                    frogArray[i].canHop = false;
                }
                else if(vacant < i && frogArray[i].leftOrRight == 'L'){
                    frogArray[i].canHop = true;
                }
                else if(vacant > i && frogArray[i].leftOrRight == 'R'){
                    frogArray[i].canHop = true;
                }
                else if(vacant > i && frogArray[i].leftOrRight == 'L'){
                    frogArray[i].canHop = false;
                }
                frogArray[i].canSlide = false;
            }
            else{
                frogArray[i].canHop = false;
                frogArray[i].canSlide = false;
            }
        }
    }

    public String toString(){
        StringBuilder state = new StringBuilder();
        for (int i = 0; i < frogArray.length; i++) {
            if(i == vacant){
                state.append("__");
            }
            else {
                state.append(frogArray[i].name);
            }
        }
        return state.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        // Assign the shallow copy to new reference variable t
        state newState = (state) super.clone();
        newState.frogArray = this.frogArray.clone();
        for (int i = 0; i < newState.frogArray.length; i++) {
            newState.frogArray[i] = (frog) this.frogArray[i].clone();
        }
        return newState;
    }

}




