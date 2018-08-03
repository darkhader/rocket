
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hiep Nguyen
 */
public class PolygonRenderer implements Renderer {

    private List<Vector2D> vertices;

    private Polygon polygon;

    public double angle = 0.0;
    private Color color;
/// khoi tao mang ... xep o cuoi cung
    public PolygonRenderer(Color color, Vector2D... vertices) {
        this.polygon = new Polygon();
        this.color = color;
        this.vertices = Arrays.asList(vertices);
    }

    @Override
    public void render(Graphics g, Vector2D position) {
        g.setColor(color);

        updateTriangle(position);
        
        g.fillPolygon(this.polygon);
    }

    private void updateTriangle(Vector2D position) {
        this.polygon.reset();
        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))
                .multiply(1.0f / (float) this.vertices.size())
                .rotate(this.angle);

        Vector2D translate = position.subtract(center);

        this.vertices
                .stream()
                .map(vector2D -> vector2D.rotate(angle))
                .map(vector2D -> vector2D.add(translate))
                .forEach(vector2D -> polygon.addPoint((int) vector2D.x, (int) vector2D.y));
    }
}
