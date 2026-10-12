package engine.game.object.components;

import engine.game.object.EntityObject;
import engine.game.object.Transform;

public class Collider implements Component
{
    private final float size;

    private final float offsetX;
    private final float offsetY;
    private final float offsetZ;

    private Transform transform;

    public Collider(float size)
    {
        this(size,0.0f,0.0f,0.0f);
    }

    public Collider(float size,
                    float offsetX, float offsetY, float offsetZ)
    {
        this.size = size;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
    }

    @Override
    public void onAttach(EntityObject object)
    {
        transform = object.getTransform();
    }

    public float getMinPozX()
    {
        return transform.getPozX() + offsetX - size / 2.0f;
    }

    public float getMaxPozX()
    {
        return transform.getPozX() + offsetX + size / 2.0f;
    }

    public float getMinPozY()
    {
        return transform.getPozY() + offsetY - size / 2.0f;
    }

    public float getMaxPozY()
    {
        return transform.getPozY() + offsetY + size / 2.0f;
    }

    public float getMinPozZ()
    {
        return transform.getPozZ() + offsetZ - size / 2.0f;
    }

    public float getMaxPozZ()
    {
        return transform.getPozZ() + offsetZ + size / 2.0f;
    }
}