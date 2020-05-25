package game.model.element.entity.actor;

import game.model.element.Position;
import game.model.element.ElementTypes;

/**
 * Firefly Class. It does an hourly rotation.
 */
public class Firefly extends Enemy
{

	/**
	 * Firefly constructor .
	 * 
	 * @param pos
	 */
	public Firefly(Position pos)
	{
		super(pos);
		this.setElementType(ElementTypes.Firefly);
		this.state = StatusActorEnum.MOVINGUP;
	}

	@Override
	public void rotate()
	{
		switch (this.state)
		{
			case MOVINGUP:
				this.state = StatusActorEnum.MOVINGRIGHT;
				break;
			case MOVINGRIGHT:
				this.state = StatusActorEnum.MOVINGDOWN;
				break;
			case MOVINGDOWN:
				this.state = StatusActorEnum.MOVINGLEFT;
				break;
			case MOVINGLEFT:
				this.state = StatusActorEnum.MOVINGUP;
				break;
			default:
				break;
		}
	}
}
