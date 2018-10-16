package vital.splitspace.main;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import vital.splitspace.contentManagement.Overseer;
import vital.splitspace.entity.Enemy;
import vital.splitspace.entity.Ship;
import vital.splitspace.entity.Star;

/**
 * This class represents the main game and all of its
 * various loops. 
 *
 */
public class SplitSpace extends BasicGame
{
	private Overseer overseer;
	
	public SplitSpace(String title)
	{
		super(title);
		return;
	}

	@Override
	public void render(GameContainer game, Graphics gfx) throws SlickException
	{
		overseer.draw(game, gfx);
		
		return;
	}

	@Override
	public void init(GameContainer game) throws SlickException
	{
		game.setVSync(true);
		game.setTargetFrameRate(60);
		
		overseer = new Overseer();
		
		game.setShowFPS(true);
		
		overseer.addEntity(new Star());
		
		// Adds the player to the game loop
		Ship player = new Ship();
		overseer.addEntity(player);
		
		return;
	}

	@Override
	public void update(GameContainer game, int arg1) throws SlickException
	{
		overseer.update(game.getInput());
		
		return;
	}
	
}
