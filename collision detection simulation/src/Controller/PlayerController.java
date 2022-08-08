package Controller;

import Controller.Controller;

import java.awt.event.KeyEvent;

public class PlayerController implements Controller {

    private Input input;

    public PlayerController(Input input) {
        this.input = input;
    }

    /**
     * Checks to see if the up button was pressed.
     * @return true if pressed.
     */
    @Override
    public boolean isRequestingUp() {
        return input.isPressed(KeyEvent.VK_UP);
    }

    /**
     * Checks to see if the down button was pressed.
     * @return true if pressed.
     */
    @Override
    public boolean isRequestingDown() {
        return input.isPressed(KeyEvent.VK_DOWN);
    }

    /**
     * Checks to see if the left button was pressed.
     * @return true if pressed.
     */
    @Override
    public boolean isRequestingLeft() {
        return input.isPressed(KeyEvent.VK_LEFT);
    }

    /**
     * Checks to see if the right button was pressed.
     * @return true if pressed.
     */
    @Override
    public boolean isRequestingRight() {
        return input.isPressed(KeyEvent.VK_RIGHT);
    }
}
