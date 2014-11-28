package TareaLab4;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Personaje extends Actor{
	ArrayList<Image>images;
	private int imagen_actual=0, cont=0;
	private float frame=0, velocidad_Y=0, aceleracion_Y=0;
	private Image salto; 
	static float posX, posY;
	Personaje(){
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("run01.png")));
		images.add(new Image(new Texture("run02.png")));
		images.add(new Image(new Texture("run03.png")));
		images.add(new Image(new Texture("run04.png")));
		salto = new Image(new Texture("jump.png"));
		this.setY(65);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		images.get(imagen_actual).setX(this.getX());
		images.get(imagen_actual).setY(this.getY());
		/*if(cont==0)
		{*/
			images.get(imagen_actual).draw(batch, parentAlpha);
		/*}else
		{
			salto.draw(batch, parentAlpha);
			
		}*/
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		frame += delta;
		if(frame>0.1f){
			imagen_actual++;
			frame =0;
			
		}
		if(imagen_actual >= images.size()){
				imagen_actual=0;
		}
		//desplazamineto en Y;
		velocidad_Y+=aceleracion_Y;
		this.setY(this.getY()+velocidad_Y);
		
		//gravedad
		aceleracion_Y-=0.145;
		
		if(this.getY() <=65){//caigo al piso
			velocidad_Y=0;
			aceleracion_Y=0;
			this.setY(65);
		}
		posX= this.getX();
		posY= this.getY();
	}
	
	void saltar(){
		aceleracion_Y=2.2f;
		
	}
}
