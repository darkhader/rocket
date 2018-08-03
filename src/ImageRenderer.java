
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hiep Nguyen
 */
public class ImageRenderer implements Renderer{
    public BufferedImage image;
    public int width,height;
public ImageRenderer(String path,int width,int height){
    this.width = width;
    this.height = height;
    this.image = loadImage(path);
}
private BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void render(Graphics g, Vector2D position) {
     g.drawImage(image, (int)position.x-width/2, (int)position.y-height/2, width, height, null);

//To change body of generated methods, choose Tools | Templates.
    }
    
}
