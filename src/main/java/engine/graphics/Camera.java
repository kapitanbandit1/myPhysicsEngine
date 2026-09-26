package engine.graphics;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Camera
{
    private final Vector3f position = new Vector3f();

    private final float pitch;
    private final float yaw;

    private final float fov;
    private final float aspect;
    private final float nearPlane;
    private final float farPlane;

    public Camera(
            float x,
            float y,
            float z,
            float pitch,
            float yaw,
            float fov,
            float aspect,
            float nearPlane,
            float farPlane
    )
    {
        position.set(x, y, z);

        this.pitch = pitch;
        this.yaw = yaw;

        this.fov = fov;
        this.aspect = aspect;
        this.nearPlane = nearPlane;
        this.farPlane = farPlane;
    }

    public Matrix4f getViewMatrix()
    {
        return new Matrix4f()
                .identity()
                .rotateX((float) Math.toRadians(-pitch))
                .rotateY((float) Math.toRadians(-yaw))
                .translate(
                        -position.x,
                        -position.y,
                        -position.z
                );
    }

    public Matrix4f getProjectionMatrix()
    {
        return new Matrix4f()
                .perspective(
                        (float) Math.toRadians(fov),
                        aspect,
                        nearPlane,
                        farPlane
                );
    }
}