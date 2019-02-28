package carautopilot;

public class CarDoor {
    private boolean isDoorClosed;
    private boolean isWindowClosed;

    CarDoor() {
        this.isDoorClosed = true;
        this.isWindowClosed = true;
    }

    CarDoor(boolean stateDoor, boolean stateWindow) {
        this.isDoorClosed = stateDoor;
        this.isWindowClosed = stateWindow;
    }


    public void openDoor() {
        this.isDoorClosed = false;
    }

    public void closeDoor() {
        this.isDoorClosed = true;
    }

    public void changeStateDoor() {
        this.isDoorClosed = (isDoorClosed) ? false : true;
    }

    public void openWindow() {
        this.isWindowClosed = false;
    }

    public void closeWindow() {
        this.isWindowClosed = true;
    }

    public void changeStateWindow() {
        this.isWindowClosed = (isWindowClosed) ? false : true;
    }

    @Override
    public String toString() {
        return "Door state: " + echoState(isDoorClosed)
                + "\nWindow state: " + echoState(isWindowClosed);
    }


    private String echoState(boolean state) {
        return (state) ? "closed" : "open";
    }


}
