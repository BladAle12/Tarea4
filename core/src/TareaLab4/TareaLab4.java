package TareaLab4;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TareaLab4 extends ApplicationAdapter implements
		InputProcessor {
	Texture img;
	static float enemy_position;
	Rectangle recP;
	Rectangle enemy,enemy1;
	Stage stage;
	PersonajeAnimado run;
	ExplosionAnimada boom;
	Music musica;
	Personaje personaje;
	int pos = 0;
	SpriteBatch batch;
    Texture texture;
    Sprite sprite;
    float posX, posY;
    Texture img1, img3, img4,img5;
   	Stage GameOver;
	Image lose;
	@Override
	public void create() {

		recP = new Rectangle(0, 65, 245, 245);
		enemy = new Rectangle(800, 70, 75,75);
		enemy1 = new Rectangle(800, 70, 75,75);
		GameOver= new Stage();
		
		
		
		

		musica = Gdx.audio.newMusic(Gdx.files.getFileHandle("musica.mp3",FileType.Internal));
		musica.setLooping(true);
		musica.play();

		batch = new SpriteBatch();
		
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        
        texture = new Texture(Gdx.files.internal("Endless Run/vol.png"));
        sprite = new Sprite(texture);
        posX = w/2 - sprite.getWidth()/2;
        posY = h/2 - sprite.getHeight()/2;
        sprite.setPosition(posX,posY);
       
		

		stage = new Stage();
		personaje = new Personaje();

		Image g = new Image(new Texture("GAMEOVER.png"));
		g.setHeight(500);
		g.setWidth(650);
		
		stage.addActor(new Plataforma());
		stage.addActor(personaje);

		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//stage.draw();
		//stage.act();
		
		sprite.setPosition(posX,posY);
        batch.begin();
        	    
	    sprite.draw(batch);
        batch.end();
        stage.draw();
        stage.draw();
		stage.act();
		
		
			
		
		
		
		
		
	    
		System.out.println("en Y per: " + Personaje.posY+ " en  X enem: " + Enemy1.e_posX+ " en X rec: "+enemy.getX());
		enemy.setX(Enemy1.e_posX);
		enemy.setY(Enemy1.e_posY);

		System.out.println("en Y per: " + Personaje.posY+ " en  X enem: " + Enemy2.e_posX+ " en X rec: "+enemy.getX());
		enemy.setX(Enemy2.e_posX);
		enemy.setY(Enemy2.e_posY);

		recP.setX(Personaje.posX);
		recP.setY(Personaje.posY);
		
		
		if (recP.overlaps(enemy) || recP.overlaps(enemy1)) {
			System.out.println("P\nE\nR\nD\nI\nS\nT\nE\nS\nGameOver");
		}

		if (pos % 300 == 0) {
			addEnemy();
		}

		if (pos % 110 == 0) {
			addPlataforma();
		}

				
		pos++;
		
		
	}



	void addEnemy() {
		Enemy1 e = new Enemy1();
		Enemy2 ed = new Enemy2();
		// e.setHeight(50);
		stage.addActor(e);
		stage.addActor(ed);
		
	}

	void addPlataforma() {
		Plataforma p = new Plataforma();
		stage.addActor(p);
	}

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public boolean keyDown(int keycode) {
        float moveAmount = 1.0f;
        if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT))
            moveAmount = 10.0f;
        
        if(keycode == Keys.LEFT)
            posX-=moveAmount;
        if(keycode == Keys.RIGHT)
            posX+=moveAmount;
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
       personaje.saltar();
    	if(button == Buttons.LEFT){
            posX = screenX - sprite.getWidth()/2;
            posY = Gdx.graphics.getHeight() - screenY - sprite.getHeight()/2;
        }
        if(button == Buttons.RIGHT){
            posX = Gdx.graphics.getWidth()/2 - sprite.getWidth()/2;
            posY = Gdx.graphics.getHeight()/2 - sprite.getHeight()/2;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
	
}
