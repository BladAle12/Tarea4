package TareaLab4;

import java.util.ArrayList;




import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ExplosionAnimada extends Actor {


	ArrayList<Image> imagenes;
	int dibujo_actual =0, llamadas_act=0;
	float tiempo_act=0, actual;
	public ExplosionAnimada(ArrayList<Image> i){
		imagenes = i;
		
		
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		
		tiempo_act += delta;
		if(tiempo_act>0.3f){
		dibujo_actual++;
			tiempo_act=0;
		}
		if(dibujo_actual >= imagenes.size()){
			dibujo_actual=0;
		}
		llamadas_act++;
		
		
		
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		
		imagenes.get(dibujo_actual).draw(batch, parentAlpha);
	}
	
	

}
