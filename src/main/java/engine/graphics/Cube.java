package engine.graphics;

public class Cube
{
    private static final float[] VERTICES =
            {
                    // Front
                    -0.5f, -0.5f,  0.5f,
                    0.5f, -0.5f,  0.5f,
                    0.5f,  0.5f,  0.5f,

                    0.5f,  0.5f,  0.5f,
                    -0.5f,  0.5f,  0.5f,
                    -0.5f, -0.5f,  0.5f,

                    // Back
                    0.5f, -0.5f, -0.5f,
                    -0.5f, -0.5f, -0.5f,
                    -0.5f,  0.5f, -0.5f,

                    -0.5f,  0.5f, -0.5f,
                    0.5f,  0.5f, -0.5f,
                    0.5f, -0.5f, -0.5f,

                    // Left
                    -0.5f, -0.5f, -0.5f,
                    -0.5f, -0.5f,  0.5f,
                    -0.5f,  0.5f,  0.5f,

                    -0.5f,  0.5f,  0.5f,
                    -0.5f,  0.5f, -0.5f,
                    -0.5f, -0.5f, -0.5f,

                    // Right
                    0.5f, -0.5f,  0.5f,
                    0.5f, -0.5f, -0.5f,
                    0.5f,  0.5f, -0.5f,

                    0.5f,  0.5f, -0.5f,
                    0.5f,  0.5f,  0.5f,
                    0.5f, -0.5f,  0.5f,

                    // Top
                    -0.5f,  0.5f,  0.5f,
                    0.5f,  0.5f,  0.5f,
                    0.5f,  0.5f, -0.5f,

                    0.5f,  0.5f, -0.5f,
                    -0.5f,  0.5f, -0.5f,
                    -0.5f,  0.5f,  0.5f,

                    // Bottom
                    -0.5f, -0.5f, -0.5f,
                    0.5f, -0.5f, -0.5f,
                    0.5f, -0.5f,  0.5f,

                    0.5f, -0.5f,  0.5f,
                    -0.5f, -0.5f,  0.5f,
                    -0.5f, -0.5f, -0.5f
            };

    private final Mesh mesh;

    public Cube()
    {
        mesh = new Mesh(VERTICES);
    }

    public void draw()
    {
        mesh.draw();
    }

    public void cleanup()
    {
        mesh.cleanup();
    }
    }