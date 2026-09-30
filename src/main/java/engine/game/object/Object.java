package engine.game.object;

public abstract class Object
{
    public abstract void draw();

    public abstract float getPozX();
    public abstract float getPozY();
    public abstract float getPozZ();

    public abstract float getRotX();
    public abstract float getRotY();
    public abstract float getRotZ();

    public abstract float getScaleX();
    public abstract float getScaleY();
    public abstract float getScaleZ();
}
