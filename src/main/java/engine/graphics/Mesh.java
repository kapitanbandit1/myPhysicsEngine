
package engine.graphics;

import java.nio.FloatBuffer;

import static org.lwjgl.BufferUtils.createFloatBuffer;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class Mesh
{
    private final int vao;
        private final int vbo;
    private final int vertexCount;

    public Mesh(float[] vertices)
    {
        vertexCount = vertices.length / 3;

        vao = glGenVertexArrays();
        vbo = glGenBuffers();

        glBindVertexArray(vao);

        glBindBuffer(GL_ARRAY_BUFFER, vbo);

        FloatBuffer buffer = createFloatBuffer(vertices.length);
        buffer.put(vertices).flip();

        glBufferData(
                GL_ARRAY_BUFFER,
                buffer,
                GL_STATIC_DRAW
        );

        glVertexAttribPointer(
                0,
                3,
                GL_FLOAT,
                false,
                3 * Float.BYTES,
                0
        );

        glEnableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);
    }

    public void draw()
    {
        glBindVertexArray(vao);

        glDrawArrays(
                GL_TRIANGLES,
                0,
                vertexCount
        );

        glBindVertexArray(0);
    }

    public void cleanup()
    {
        glDeleteVertexArrays(vao);
        glDeleteBuffers(vbo);
    }
}