package carautopilot;

public class CarWheel implements Comparable<CarWheel>{
    private float stateTire;

    CarWheel() {
        this.stateTire = 1;
    }

    CarWheel(float stateTire) {
        this.stateTire = stateTire;
    }

    public void changeTire() {
        stateTire = 1;
    }

    public void wipeTire(int percent) {
        float wipe = stateTire - (stateTire * percent / 100);
        this.stateTire = (wipe >= 0) ? wipe : 0;
    }

    public float getStateTire() {
        return stateTire;
    }

    @Override
    public String toString() {
        return "State Wheel: " + stateTire;
    }

    @Override
    public int compareTo(CarWheel anotherWheel) {
        if (this.getStateTire() == anotherWheel.getStateTire()){
            return  0;
        } else if (this.getStateTire() < anotherWheel.getStateTire()){
            return -1;
        } else {
            return  1;
        }
    }
}
