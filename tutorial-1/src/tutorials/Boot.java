package tutorials;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.LWJGLException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import tutorials.render.Mesh;
import tutorials.render.MeshLoader;

public class Boot {

  public Boot(){
    try{
      Display.setDisplayMode(new DisplayMode(640,480));
      Display.setTitle("OpenGL Bootcamp");
      Display.create();
    }catch(LWJGLException e){
      e.printStackTrace();
    }
    
    float[] vertices = {-0.5f,-0.5f, 0f,
                         0.5f,-0.5f, 0f,
                         0.0f, 0.5f, 0f};
    int[] indices = {0,1,2};
    
    Mesh meshmeyek = MeshLoader.createMesh(vertices,indices);
    
    while(!Display.isCloseRequested()){
      GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
      
      GL30.glBindVertexArray(meshmeyek.getVaoID());
	    GL20.glEnableVertexAttribArray(0);
	    GL11.glDrawElements(GL11.GL_TRIANGLES, meshmeyek.getVertexCount(), GL11.GL_UNSIGNED_INT,0);
    	GL20.glDisableVertexAttribArray(0);
	    GL30.glBindVertexArray(0);
      
	    Display.update();
	    Display.sync(60);
    }
  }

  public static void main(String[] args){
    new Boot();
  }
}
