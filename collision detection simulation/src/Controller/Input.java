package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private boolean[] pressed;

    /**
     * Creates a list of pressed buttons.
     */
    public Input() {
        this.pressed = new boolean[255];
    }

    /**
     * Checks if a button was pressed.
     * @param buttonKeyCode the key code of the button in question.
     * @return whether the button was pressed (true) on not (false).
     */
    public boolean isPressed(int buttonKeyCode) {
        return pressed[buttonKeyCode];
    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Sets the value of the respective key in the pressed array to true.
     * @param e the key event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }

    /**
     * Sets the value of the respective key in the pressed array to false.
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
    }
}
