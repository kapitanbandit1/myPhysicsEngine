package engine.graphics;

import org.joml.Matrix4f;
import engine.game.object.Object;

import java.io.IOException;

public class Renderer
{
    private final ShaderProgram shaderProgram;
    private final Camera camera;

    public Renderer(Camera camera, ShaderProgram shaderProgram) throws IOException
    {
        this.camera = camera;
        this.shaderProgram = shaderProgram;
    }

    public void render(Object object)
    {
        Matrix4f model = new Matrix4f()
                .identity()
                .translate(
                        object.getPozX(),
                        object.getPozY(),
                        object.getPozZ()
                )
                .rotateXYZ(
                        (float) Math.toRadians(object.getRotX()),
                        (float) Math.toRadians(object.getRotY()),
                        (float) Math.toRadians(object.getRotZ())
                )
                .scale(
                        object.getScaleX(),
                        object.getScaleY(),
                        object.getScaleZ()
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

        object.draw();

        shaderProgram.unbind();
    }

}