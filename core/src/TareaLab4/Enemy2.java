package TareaLab4;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Enemy2 extends Actor{
	ArrayList <Image> images;
	static float positionY;
	private int imagen_actual =0;
	private float frame =0;
	static float e_posX, e_posY;
	
	Enemy2()
	{
		images = new ArrayList<Image>();
		this.setY(70);
		this.setX(650);
		images.add(new Image(new Texture("bomba01.png")));
		images.add(new Image(new Texture("bomba02.png")));
		images.add(new Image(new Texture("bomba03.png")));
			
		images.get(0).setHeight(80);
		images.get(0).setWidth(80);
		images.get(1).setHeight(80);
		images.get(1).setWidth(80);
		images.get(2).setHeight(80);
		images.get(2).setWidth(80);
		
		
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		frame += delta;
		if(frame>0.001f){
			imagen_actual++;
			frame =0;
			
		}
		if(imagen_actual >= images.size()){
				imagen_actual=0;
		}
		
		if(this.getX()<-80)
			this.remove();
		
		this.moveBy(-delta*600,0);
		e_posX= this.getX();
		e_posY= this.getY();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		images.get(imagen_actual).setX(this.getX());
		images.get(imagen_actual).setY(this.getY());
		
		images.get(imagen_actual).draw(batch, parentAlpha);
		this.setX(this.getX()+1);
	}
}
