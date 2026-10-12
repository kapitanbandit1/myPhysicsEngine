package engine.graphics;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Camera
{
    private final Vector3f position = new Vector3f();

    private float pitch;
    private float yaw;

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

    public Vector3f getPosition()
    {
        return position;
    }

    public float getPitch()
    {
        return pitch;
    }

    public float getYaw()
    {
        return yaw;
    }

    public void setX(float x) {
        this.position.x = x;
    }

    public void setY(float y) {
        this.position.y = y;
    }

    public void setZ(float z) {
        this.position.z = z;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }
}