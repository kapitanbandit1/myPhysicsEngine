package engine.game.object.primitives;

import engine.game.object.components.Graphics;
import engine.graphics.Mesh;
import engine.graphics.ShaderProgram;

public class GraphicsCube extends Graphics
{
    public GraphicsCube(
            float size, ShaderProgram shaderProgram,
            float rotX, float rotY, float rotZ,
            float scaleX, float scaleY, float scaleZ)
    {
        this.size = size;
        this.shaderProgram = shaderProgram;

        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;

        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;

        updateVertices();
    }

    @Override
    protected void updateVertices()
    {
        float x = size / 2.0f;

        float[] vertices = new float[]
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
}
