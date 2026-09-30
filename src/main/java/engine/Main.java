package engine;

import engine.game.object.Cube;
import engine.graphics.Camera;
import engine.graphics.Renderer;
import engine.graphics.ShaderProgram;
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
                1800,
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
        ShaderProgram shaderCube = new ShaderProgram("/shaders/cube/vertex.glsl",
                                              "/shaders/cube/fragment.glsl");
        Renderer renderer = new Renderer(camera, shaderCube);

        Cube cube1 = new Cube(
                0.0f, 0.0f, -5.0f,
                0.0f, 0.0f, 0.0f,
                1.0f, 1.0f, 1.0f,
                1.0f
        );

        Cube cube2 = new Cube(
                2.0f, 0.0f, -5.0f,
                0.0f, 45.0f, 0.0f,
                1.0f, 1.0f, 1.0f,
                1.5f
        );

        Cube cube3 = new Cube(
                -2.0f, 1.0f, -6.0f,
                45.0f, 0.0f, 30.0f,
                0.8f, 0.8f, 0.8f,
                1.0f
        );

        Cube cube4 = new Cube(
                0.0f, -1.5f, -4.0f,
                0.0f, 0.0f, 90.0f,
                1.0f, 1.0f, 1.0f,
                0.75f
        );

        while (!window.checkWindowShouldClose())
        {
            window.pollEvents();

            GL11.glClear(
                    GL11.GL_COLOR_BUFFER_BIT |
                            GL11.GL_DEPTH_BUFFER_BIT
            );
            cube1.setRot(0.5f,0.5f,0.5f);
            cube2.setRot(0.5f,0.5f,0.5f);
            cube3.setRot(0.5f,0.5f,0.5f);
            cube4.setRot(0.5f,0.5f,0.5f);

            renderer.render(cube1);
            renderer.render(cube2);
            renderer.render(cube3);
            renderer.render(cube4);

            window.swapBuffers();
        }

        cube1.cleanup();
        cube2.cleanup();
        cube3.cleanup();
        cube4.cleanup();
        window.cleanup();

        GLFW.glfwTerminate();
    }
}