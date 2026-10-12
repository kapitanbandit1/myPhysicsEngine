package engine.game.input;

import engine.patterns.observerPattern.Observer;
import engine.patterns.observerPattern.Subject;

import java.util.ArrayList;

import static org.lwjgl.glfw.GLFW.*;

public class Keyboard
{
    private final long window;

    private int keyW = GLFW_KEY_W;
    private int keyA = GLFW_KEY_A;
    private int keyS = GLFW_KEY_S;
    private int keyD = GLFW_KEY_D;

    private boolean keyWPressed = false;
    private boolean keyAPressed = false;
    private boolean keySPressed = false;
    private boolean keyDPressed = false;

    private final ArrayList<Observer> observers = new ArrayList<>();


    public Keyboard(long window)
    {
        this.window = window;
    }

    private boolean getPressedKey(long window, int key)
    {
        return glfwGetKey(window, key) == GLFW_PRESS;
    }

    public void keyboardUpdate()
    {
        keyWPressed = (glfwGetKey(window, keyW) == GLFW_PRESS);
        keyAPressed = (glfwGetKey(window, keyA) == GLFW_PRESS);
        keySPressed = (glfwGetKey(window, keyS) == GLFW_PRESS);
        keyDPressed = (glfwGetKey(window, keyD) == GLFW_PRESS);
    }

    public boolean getPressedKeyW()
    {
        return keyWPressed;
    }

    public boolean getPressedKeyA()
    {
        return keyAPressed;
    }

    public boolean getPressedKeyS()
    {
        return keySPressed;
    }

    public boolean getPressedKeyD()
    {
        return keyDPressed;
    }

}
