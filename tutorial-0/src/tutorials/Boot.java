package tutorials;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL11;

public class Boot {

  public Boot(){
    try{
      Display.setDisplayMode(new DisplayMode(640,480));
      Display.setTitle("LWJGL Tutorial");
      Display.create();
    }catch(LWJGLException e){
      e.printStackTrace();
    }
    
    while(!Display.isCloseRequested()){
      GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
      
      Display.update();
      Display.sync(60);
    }
  }

  public static void main(String[] args){
    new Boot();
  }
}
