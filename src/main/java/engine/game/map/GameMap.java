package engine.game.map;

import engine.game.object.components.*;
import engine.game.object.EntityObject;
import engine.graphics.Camera;
import engine.graphics.Renderer;

import java.util.ArrayList;

public class GameMap
{
    private final ArrayList<EntityObject> objects = new ArrayList<>();
    private Renderer render;

    public void addObject(EntityObject object)
    {
        objects.add(object);
    }

    public void removeObject(EntityObject object)
    {
        objects.remove(object);
    }

    public void setRender(Renderer render)
    {
        this.render = render;
    }

    private boolean checkColliders(EntityObject object)
    {
        if (object.getComponent(Collider.class) == null)
        {
            return false;
        }

        Collider collider = object.getComponent(Collider.class);

        for (EntityObject inspectableObject : objects)
        {
            if (inspectableObject == object || inspectableObject.getComponent(Collider.class) == null)
            {
                continue;
            }

            Collider other = inspectableObject.getComponent(Collider.class);

            if (collider.getMinPozX() <= other.getMaxPozX() &&
                    collider.getMaxPozX() >= other.getMinPozX() &&

                    collider.getMinPozY() <= other.getMaxPozY() &&
                    collider.getMaxPozY() >= other.getMinPozY() &&

                    collider.getMinPozZ() <= other.getMaxPozZ() &&
                    collider.getMaxPozZ() >= other.getMinPozZ())
            {
                return true;
            }
        }

        return false;
    }

    public void updateObject(float deltaTime)
    {
        for (EntityObject object : objects)
        {
            if (object.getComponent(CameraComponent.class) != null)
            {
                object.getComponent(CameraComponent.class).update(deltaTime);
            }
            if (object.getComponent(Graphics.class) != null)
            {
                render.render(object.getComponent(Graphics.class));
            }
            if (object.getComponent(Movement.class) != null && !checkColliders(object))
            {
                object.getComponent(Movement.class).update(deltaTime);
            }
        }
    }
}