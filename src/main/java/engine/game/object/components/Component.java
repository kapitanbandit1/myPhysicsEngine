package engine.game.object.components;

import engine.game.object.EntityObject;

public interface Component
{
    default void onAttach(EntityObject object) {}
    default void update(float deltaTime) {}
}
