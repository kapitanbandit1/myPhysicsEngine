package engine.graphics;

import org.joml.Matrix4f;

import java.io.IOException;
import java.io.InputStream;
import java.nio.FloatBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.system.MemoryStack.stackPush;

public class ShaderProgram
{
    private final int programId;
    private final Map<String, Integer> uniformLocations = new HashMap<>();

    public ShaderProgram(
            String vertexPath,
            String fragmentPath
    ) throws IOException
    {
        String vertexSource = loadResource(vertexPath);
        String fragmentSource = loadResource(fragmentPath);

        int vertexShader = compile(
                GL_VERTEX_SHADER,
                vertexSource
        );

        int fragmentShader = compile(
                GL_FRAGMENT_SHADER,
                fragmentSource
        );

        programId = glCreateProgram();

        glAttachShader(programId, vertexShader);
        glAttachShader(programId, fragmentShader);

        glLinkProgram(programId);

        if (glGetProgrami(programId, GL_LINK_STATUS) == GL_FALSE)
        {
            throw new RuntimeException(
                    "Shader program link failed:\n" +
                            glGetProgramInfoLog(programId)
            );
        }

        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);
    }

    public void use()
    {
        glUseProgram(programId);
    }

    public void unbind()
    {
        glUseProgram(0);
    }

    public void setUniform(String name, Matrix4f matrix)
    {
        int location = getUniformLocation(name);

        try (var stack = stackPush())
        {
            FloatBuffer buffer = stack.mallocFloat(16);

            matrix.get(buffer);

            glUniformMatrix4fv(
                    location,
                    false,
                    buffer
            );
        }
    }

    public void cleanup()
    {
        glDeleteProgram(programId);
    }

    private int getUniformLocation(String name)
    {
        return uniformLocations.computeIfAbsent(
                name,
                key -> glGetUniformLocation(programId, key)
        );
    }

    private static int compile(
            int type,
            String source
    )
    {
        int shader = glCreateShader(type);

        glShaderSource(shader, source);
        glCompileShader(shader);

        if (glGetShaderi(shader, GL_COMPILE_STATUS) == GL_FALSE)
        {
            throw new RuntimeException(
                    "Shader compilation failed:\n" +
                            glGetShaderInfoLog(shader)
            );
        }

        return shader;
    }

    private static String loadResource(
            String path
    ) throws IOException
    {
        try (InputStream input =
                     ShaderProgram.class.getResourceAsStream(path))
        {
            if (input == null)
            {
                throw new IOException(
                        "Resource not found: " + path
                );
            }

            return new String(
                    input.readAllBytes(),
                    StandardCharsets.UTF_8
            );
        }
    }
}