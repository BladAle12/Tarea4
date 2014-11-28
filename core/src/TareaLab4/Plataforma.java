package TareaLab4;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Plataforma extends Image {
	Plataforma(){
		super(new Texture("tierra.png"));
		this.setX(500);
		this.setY(-200);
		
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		if(this.getX()< -500)
			this.remove();
		
		this.moveBy(-delta*300,0);
		
	}
}
