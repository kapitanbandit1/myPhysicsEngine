package engine.game.object.components;

import engine.game.input.Mouse;
import engine.game.object.EntityObject;
import engine.game.object.Transform;
import engine.graphics.Camera;

import javax.swing.text.html.parser.Entity;

public class CameraComponent implements Component
{
    private final Camera camera;
    private final Mouse mouse;
    private Transform transform;

    private final float offsetX;
    private final float offsetY;
    private final float offsetZ;

    private float yaw;
    private float pitch;

    private double lastMouseX;
    private double lastMouseY;

    private boolean firstMouse = true;

    private final float sensitivity = 0.1f;


    public CameraComponent(Camera camera)
    {
        this(camera, null, 0.0f, 0.0f, 0.0f);
    }

    public CameraComponent(
            Camera camera,
            float offsetX, float offsetY, float offsetZ)
    {
        this(camera, null, offsetX, offsetY, offsetZ);
    }

    public CameraComponent(Camera camera, Mouse mouse)
    {
        this(camera, mouse, 0.0f, 0.0f, 0.0f);
    }

    public CameraComponent(
            Camera camera,
            Mouse mouse,
            float offsetX, float offsetY, float offsetZ)
    {
        this.camera = camera;
        this.mouse = mouse;

        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
    }

    @Override
    public void onAttach(EntityObject object)
    {
        transform = object.getTransform();
    }

    @Override
    public void update(float deltaTime)
    {
        camera.setX(transform.getPozX() + offsetX);
        camera.setY(transform.getPozY() + offsetY);
        camera.setZ(transform.getPozZ() + offsetZ);

        double mouseX = mouse.getMousePozX();
        double mouseY = mouse.getMousePozY();

        if (firstMouse)
        {
            lastMouseX = mouseX;
            lastMouseY = mouseY;
            firstMouse = false;
            return;
        }

        float deltaX = (float) (lastMouseX - mouseX);
        float deltaY = (float) (lastMouseY - mouseY);

        lastMouseX = mouseX;
        lastMouseY = mouseY;

        yaw += deltaX * sensitivity;
        pitch += deltaY * sensitivity;

        pitch = Math.max(-89.0f, Math.min(89.0f, pitch));

        camera.setYaw(yaw);
        camera.setPitch(pitch);
    }
}
