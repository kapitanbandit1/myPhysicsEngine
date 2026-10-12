package engine;

import engine.game.input.Keyboard;
import engine.game.input.Mouse;
import engine.game.map.GameMap;
import engine.game.object.Transform;
import engine.game.object.components.CameraComponent;
import engine.game.object.components.Collider;
import engine.game.object.EntityObject;
import engine.game.object.components.MovementPlayer;
import engine.game.object.primitives.GraphicsCube;
import engine.game.object.components.MovementPrimitive;
import engine.graphics.Camera;
import engine.graphics.Renderer;
import engine.graphics.ShaderProgram;
import engine.graphics.Window;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        GLFW.glfwInit();

        long monitor = GLFW.glfwGetPrimaryMonitor();

        GLFWVidMode videoMode = GLFW.glfwGetVideoMode(monitor);

        Window window = new Window(
                videoMode.width(),
                videoMode.height(),
                "Game",
                monitor,
                0L
        );

        Mouse mouse = new Mouse(window.getWindow());
        Keyboard keyboard = new Keyboard(window.getWindow());

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

        GameMap map = new GameMap();

        ShaderProgram shaderCube = new ShaderProgram("/shaders/cube/vertex.glsl",
                "/shaders/cube/fragment.glsl");

        Renderer renderer = new Renderer(camera);

        GraphicsCube cubeGraphics = new GraphicsCube(
                1.0f, shaderCube,
                0.0f, 0.0f, 0.0f,
                1.0f, 1.0f, 1.0f
        );

        Collider cubeCollider = new Collider(1);

        MovementPrimitive cubeMovement = new MovementPrimitive(0.0f,0.05f,0.0f);


        GraphicsCube cube1Graphics = new GraphicsCube(
                1.0f, shaderCube,
                0.0f, 0.0f, 0.0f,
                1.0f, 1.0f, 1.0f
        );

        Collider cube1Collider = new Collider(1);

        MovementPlayer cube1Movement = new MovementPlayer(keyboard,
                0.5f, 0.5f, 0.5f);

        Transform transform = new Transform(-1f,0,0);

        Transform transform1 = new Transform(-2f,2.5f,0);

        EntityObject cube = new EntityObject(transform);
        cube.addComponent(cubeCollider);
        cube.addComponent(cubeGraphics);
        cube.addComponent(cubeMovement);

        EntityObject cube1 = new EntityObject(transform1);
        cube1.addComponent(cube1Collider);
        cube1.addComponent(cube1Graphics);

        EntityObject player = new EntityObject(new Transform(0,0,5.0f));
        player.addComponent(new MovementPlayer(keyboard,0.5f,0.5f,0.5f));
        player.addComponent(new CameraComponent(camera,mouse));


        map.addObject(cube);
        map.addObject(cube1);
        map.addObject(player);
        map.setRender(renderer);



        double lastTime = GLFW.glfwGetTime();
        double currentTime;
        float deltaTime;


        while (!window.checkWindowShouldClose())
        {
            currentTime = GLFW.glfwGetTime();
            deltaTime = (float) (currentTime - lastTime);
            lastTime = currentTime;

            window.pollEvents();

            keyboard.keyboardUpdate();

            GL11.glClear(
                    GL11.GL_COLOR_BUFFER_BIT |
                            GL11.GL_DEPTH_BUFFER_BIT
            );

            map.updateObject(deltaTime);

            window.swapBuffers();
        }

        cubeGraphics.cleanup();
        window.cleanup();

        GLFW.glfwTerminate();
    }
}