package engine.graphics;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

public class Window
{
    private final int width;
    private final int height;
    private final String name;
    private final long window;

    public Window(
            int width,
            int height,
            String name,
            int monitor,
            int share
    )
    {
        this.width = width;
        this.height = height;
        this.name = name;

        window = GLFW.glfwCreateWindow(
                width,
                height,
                name,
                monitor,
                share
        );

        if (window == 0)
        {
            throw new RuntimeException(
                    "Failed to create GLFW window"
            );
        }
    }

    public void showWindow()
    {
        GLFW.glfwMakeContextCurrent(window);

        GL.createCapabilities();

        GLFW.glfwSwapInterval(1);
        GLFW.glfwShowWindow(window);
    }

    public boolean checkWindowShouldClose()
    {
        return GLFW.glfwWindowShouldClose(window);
    }

    public void swapBuffers()
    {
        GLFW.glfwSwapBuffers(window);
    }

    public void pollEvents()
    {
        GLFW.glfwPollEvents();
    }

    public long getWindow()
    {
        return window;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public String getName()
    {
        return name;
    }

    public void cleanup()
    {
        GLFW.glfwDestroyWindow(window);
    }
}