import com.jogamp.opengl.GL2;

public class Universe {
    private final float x, y, z; // Position in 3D space
    private final float size;   // Radius of the sphere
    private final float[] color; // RGB color

    public Universe(float x, float y, float z, float size, float[] color) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
        this.color = color;
    }

    public void render(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glColor3f(color[0], color[1], color[2]);
        drawSphere(gl, size);
        gl.glPopMatrix();
    }

    private void drawSphere(GL2 gl, float radius) {
        // Simple approximation using glutSolidSphere or custom algorithm
        int slices = 20; // Sphere detail
        int stacks = 20;
        com.jogamp.opengl.util.gl2.GLUT glut = new com.jogamp.opengl.util.gl2.GLUT();
        glut.glutSolidSphere(radius, slices, stacks);
    }
}
