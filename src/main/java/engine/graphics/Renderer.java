package engine.graphics;

import org.joml.Matrix4f;

import java.io.IOException;

public class Renderer
{
    private final ShaderProgram shaderProgram;
    private final Cube cube;
    private final Camera camera;

    public Renderer(Camera camera) throws IOException
    {
        this.camera = camera;

        shaderProgram = new ShaderProgram(
                "/shaders/cube.vert",
                "/shaders/cube.frag"
        );

        cube = new Cube();
    }

    public void renderCube(
            float posX,
            float posY,
            float posZ,
            float rotX,
            float rotY,
            float rotZ,
            float scaleX,
            float scaleY,
            float scaleZ
    )
    {
        Matrix4f model = new Matrix4f()
                .identity()
                .translate(
                        posX,
                        posY,
                        posZ
                )
                .rotateXYZ(
                        (float) Math.toRadians(rotX),
                        (float) Math.toRadians(rotY),
                        (float) Math.toRadians(rotZ)
                )
                .scale(
                        scaleX,
                        scaleY,
                        scaleZ
                );

        shaderProgram.use();

        shaderProgram.setUniform(
                "model",
                model
        );

        shaderProgram.setUniform(
                "view",
                camera.getViewMatrix()
        );

        shaderProgram.setUniform(
                "projection",
                camera.getProjectionMatrix()
        );

        cube.draw();

        shaderProgram.unbind();
    }

    public void cleanup()
    {
        cube.cleanup();
        shaderProgram.cleanup();
    }
}