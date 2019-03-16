package game;

public class Player {
    private PlayerController controller;


    public Player(PlayerController controller){
        this.controller = controller;
    }

    public PlayerController getController() {
        return controller;
    }

    public void setController(PlayerController controller) {
        this.controller = controller;
    }
}
