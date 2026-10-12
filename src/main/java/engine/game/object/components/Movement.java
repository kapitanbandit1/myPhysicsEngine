package engine.game.object.components;

import engine.game.object.EntityObject;
import engine.game.object.Transform;

public abstract class Movement implements Component
{
    protected float speedX;
    protected float speedY;
    protected float speedZ;

    protected Transform transform;

    @Override
    public void onAttach(EntityObject object)
    {
        this.transform = object.getTransform();
    }

    public void setSpeed(float speedX, float speedY, float speedZ)
    {
        this.speedX = speedX;
        this.speedY = speedY;
        this.speedZ = speedZ;
    }
}