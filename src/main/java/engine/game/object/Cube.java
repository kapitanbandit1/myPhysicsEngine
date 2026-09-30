package engine.game.object;

import engine.graphics.Mesh;

public class Cube extends Object
{
    private float pozX;
    private float pozY;
    private float pozZ;

    private float rotX;
    private float rotY;
    private float rotZ;

    private float scaleX;
    private float scaleY;
    private float scaleZ;

    private Mesh mesh;
    private float size;
    private float[] vertices;

    public Cube(
            float pozX, float pozY, float pozZ,
            float rotX, float rotY, float rotZ,
            float scaleX, float scaleY, float scaleZ,
            float size
    )
    {
        this.pozX = pozX;
        this.pozY = pozY;
        this.pozZ = pozZ;

        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;

        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;

        this.size = size;

        updateVertices();
    }

    private void updateVertices()
    {
        float x = size / 2.0f;

        vertices = new float[]
                {
                        // Front
                        -x, -x, x,
                        x, -x, x,
                        x, x, x,

                        x, x, x,
                        -x, x, x,
                        -x, -x, x,

                        // Back
                        x, -x, -x,
                        -x, -x, -x,
                        -x, x, -x,

                        -x, x, -x,
                        x, x, -x,
                        x, -x, -x,

                        // Left
                        -x, -x, -x,
                        -x, -x, x,
                        -x, x, x,

                        -x, x, x,
                        -x, x, -x,
                        -x, -x, -x,

                        // Right
                        x, -x, x,
                        x, -x, -x,
                        x, x, -x,

                        x, x, -x,
                        x, x, x,
                        x, -x, x,

                        // Top
                        -x, x, x,
                        x, x, x,
                        x, x, -x,

                        x, x, -x,
                        -x, x, -x,
                        -x, x, x,

                        // Bottom
                        -x, -x, -x,
                        x, -x, -x,
                        x, -x, x,

                        x, -x, x,
                        -x, -x, x,
                        -x, -x, -x
                };

        if (mesh != null)
        {
            mesh.cleanup();
        }

        mesh = new Mesh(vertices);
    }

    //    потом удалить
    public void setRot(float newRotX, float newRotY, float newRotZ)
    {
        this.rotX += newRotX;
        this.rotY += newRotY;
        this.rotZ += newRotZ;
    }


    public void setSize(float size)
    {
        this.size = size;
        updateVertices();
    }

    @Override
    public void draw()
    {
        mesh.draw();
    }

    public void cleanup()
    {
        mesh.cleanup();
    }

    @Override
    public float getPozX()
    {
        return pozX;
    }

    @Override
    public float getPozY()
    {
        return pozY;
    }

    @Override
    public float getPozZ()
    {
        return pozZ;
    }

    @Override
    public float getRotX()
    {
        return rotX;
    }

    @Override
    public float getRotY()
    {
        return rotY;
    }

    @Override
    public float getRotZ()
    {
        return rotZ;
    }

    @Override
    public float getScaleX()
    {
        return scaleX;
    }

    @Override
    public float getScaleY()
    {
        return scaleY;
    }

    @Override
    public float getScaleZ()
    {
        return scaleZ;
    }

}
