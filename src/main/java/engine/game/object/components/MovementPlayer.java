package engine.game.object.components;

import engine.game.input.Keyboard;

public class MovementPlayer extends Movement
{
    private final Keyboard keyboard;

    public MovementPlayer(Keyboard keyboard,
                          float speedX, float speedY, float speedZ)
    {
        this.keyboard = keyboard;
        this.speedX = speedX;
        this.speedY = speedY;
        this.speedZ = speedZ;
    }

    @Override
    public void update(float deltaTime)
    {
        if (keyboard.getPressedKeyW())
        {
            transform.translate(0, 0, -speedZ * deltaTime);
        }

        if (keyboard.getPressedKeyS())
        {
            transform.translate(0, 0, speedZ * deltaTime);
        }

        if (keyboard.getPressedKeyA())
        {
            transform.translate(-speedX * deltaTime, 0, 0);
        }

        if (keyboard.getPressedKeyD())
        {
            transform.translate(speedX * deltaTime, 0, 0);
        }
    }

}
