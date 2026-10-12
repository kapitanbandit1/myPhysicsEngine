package engine.graphics;

import engine.game.object.components.Graphics;
import org.joml.Matrix4f;

import java.io.IOException;

public class Renderer
{
    private final Camera camera;

    public Renderer(Camera camera) throws IOException
    {
        this.camera = camera;
    }

    public void render(Graphics graphicsObject)
    {
        ShaderProgram shaderProgram = graphicsObject.getShader();

        Matrix4f model = new Matrix4f()
                .identity()
                .translate(
                        graphicsObject.getPozX(),
                        graphicsObject.getPozY(),
                        graphicsObject.getPozZ()
                )
                .rotateXYZ(
                        (float) Math.toRadians(graphicsObject.getRotX()),
                        (float) Math.toRadians(graphicsObject.getRotY()),
                        (float) Math.toRadians(graphicsObject.getRotZ())
                )
                .scale(
                        graphicsObject.getScaleX(),
                        graphicsObject.getScaleY(),
                        graphicsObject.getScaleZ()
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

        graphicsObject.draw();

        shaderProgram.unbind();
    }

}