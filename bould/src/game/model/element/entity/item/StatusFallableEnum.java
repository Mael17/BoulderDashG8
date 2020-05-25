package game.model.element.entity.item;

/**
 * This indicates all the movement states of an item <p>
 * Falling: falling down <bz>
 * sliding right / left: sliding <bz>
 * idle: still.
 *
 */
public enum StatusFallableEnum
{
	FALLINGOFF,
	FALLING,
	SLIDINGRIGHT,
	SLIDINGLEFT,
	PUSHEDRIGHT,
	PUSHEDLEFT,
	CONVERT,
	IDLE,
	DEAD
}
