package engine.game.object.components;

import engine.game.object.EntityObject;
import engine.game.object.Transform;
import engine.graphics.Mesh;
import engine.graphics.ShaderProgram;

public abstract class Graphics implements Component
{
    protected ShaderProgram shaderProgram;
    protected Mesh mesh;
    protected float size;

    protected float rotX;
    protected float rotY;
    protected float rotZ;

    protected float scaleX;
    protected float scaleY;
    protected float scaleZ;

    protected Transform transform;


    @Override
    public void onAttach(EntityObject object)
    {
        transform = object.getTransform();
    }

    protected abstract void updateVertices();

    public ShaderProgram getShader()
    {
        return shaderProgram;
    }

    public void draw()
    {
        mesh.draw();
    }

    public void cleanup()
    {
        mesh.cleanup();
    }

    public float getRotX()
    {
        return rotX;
    }

    public float getRotY()
    {
        return rotY;
    }

    public float getRotZ()
    {
        return rotZ;
    }

    public float getScaleX()
    {
        return scaleX;
    }

    public float getScaleY()
    {
        return scaleY;
    }

    public float getScaleZ()
    {
        return scaleZ;
    }

    public float getPozX()
    {
        return transform.getPozX();
    }

    public float getPozY()
    {
        return transform.getPozY();
    }

    public float getPozZ()
    {
        return transform.getPozZ();
    }

}