package engine;

import engine.graphics.Camera;
import engine.graphics.Renderer;
import engine.graphics.Window;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        GLFW.glfwInit();

        Window window = new Window(
                1200,
                800,
                "Game",
                0,
                0
        );

        window.showWindow();

        GL11.glEnable(GL11.GL_DEPTH_TEST);

        Camera camera = new Camera(
                0.0f,
                0.0f,
                5.0f,
                0.0f,
                0.0f,
                70.0f,
                (float) window.getWidth() / window.getHeight(),
                0.1f,
                100.0f
        );

        Renderer renderer = new Renderer(camera);

        while (!window.checkWindowShouldClose())
        {
            window.pollEvents();

            GL11.glClear(
                    GL11.GL_COLOR_BUFFER_BIT |
                            GL11.GL_DEPTH_BUFFER_BIT
            );

            renderer.renderCube(
                    0.0f, 0.0f, 0.0f,
                    25.0f, -35.0f, 0.0f,
                    1.0f, 1.0f, 1.0f
            );
            renderer.renderCube(
                    4.0f, 0.0f, 0.0f,
                    25.0f, -35.0f, 0.0f,
                    1.0f, 1.0f, 1.0f
            );
            renderer.renderCube(
                    0.0f, 1.0f, 1.0f,
                    25.0f, -35.0f, 0.0f,
                    1.0f, 1.0f, 1.0f
            );

            window.swapBuffers();
        }

        renderer.cleanup();
        window.cleanup();

        GLFW.glfwTerminate();
    }
}