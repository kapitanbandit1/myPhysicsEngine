package engine.game.object;

import engine.game.object.components.Component;

import java.util.ArrayList;
import java.util.List;

public class EntityObject
{
    private final List<Component> components = new ArrayList<>();
    private final Transform transform;

    public EntityObject(Transform transform)
    {
        this.transform = transform;
    }

    public Transform getTransform()
    {
        return transform;
    }

    public void addComponent(Component component)
    {
        components.add(component);
        component.onAttach(this);
    }

    public void removeComponent(Component component)
    {
        components.remove(component);
    }

    public <T extends Component> T getComponent(Class<T> type)
    {
        for (Component component : components)
        {
            if (type.isInstance(component))
            {
                return type.cast(component);
            }
        }

        return null;
    }


}
