package engine.game.input;

import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;

public class Mouse
{
    private final long window;

    private double mousePozX;
    private double mousePozY;

    public Mouse(long window)
    {
        this.window = window;

        glfwSetCursorPosCallback(window, ((windowGLFW, newMousePozX, newMousePozY) ->
    {
        mousePozX = newMousePozX;
        mousePozY = newMousePozY;
    }));
    }

    public double getMousePozX()
    {
        return mousePozX;
    }

    public double getMousePozY()
    {
        return mousePozY;
    }

}
