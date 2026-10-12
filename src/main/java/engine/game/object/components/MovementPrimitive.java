package engine.game.object.components;

import engine.game.object.EntityObject;
import engine.game.object.Transform;

public class MovementPrimitive extends Movement implements Component
{
    public MovementPrimitive(float speedX, float speedY, float speedZ)
    {
        this.speedX = speedX;
        this.speedY = speedY;
        this.speedZ = speedZ;
    }

    @Override
    public void update(float deltaTime)
    {
        transform.translate(speedX*deltaTime,
                            speedY*deltaTime,
                            speedZ*deltaTime);
    }

}