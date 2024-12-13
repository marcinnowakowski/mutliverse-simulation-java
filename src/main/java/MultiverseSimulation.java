import com.jogamp.opengl.*;
import com.jogamp.opengl.util.Animator;
import com.jogamp.newt.opengl.GLWindow;

public class MultiverseSimulation {
    public static void main(String[] args) {
        // Setup OpenGL profile and capabilities
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLWindow window = GLWindow.create(capabilities);
        window.setSize(800, 600);
        window.setTitle("JOGL Multiverse Simulation");

        // Create the multiverse
        Multiverse multiverse = new Multiverse();
        multiverse.addUniverse(new Universe(0, 0, -5, 1, new float[]{1, 0, 0}));
        multiverse.addUniverse(new Universe(-2, 1, -7, 0.8f, new float[]{0, 1, 0}));
        multiverse.addUniverse(new Universe(2, -1, -6, 1.2f, new float[]{0, 0, 1}));

        // Add rendering logic
        window.addGLEventListener(new GLEventListener() {
            @Override
            public void init(GLAutoDrawable drawable) {
                GL2 gl = drawable.getGL().getGL2();
                gl.glEnable(GL.GL_DEPTH_TEST); // Enable depth testing
            }

            @Override
            public void display(GLAutoDrawable drawable) {
                GL2 gl = drawable.getGL().getGL2();
                gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

                // Render the multiverse
                multiverse.render(gl);

                gl.glFlush();
            }

            @Override
            public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
                GL2 gl = drawable.getGL().getGL2();
                gl.glViewport(0, 0, width, height);

                gl.glMatrixMode(GL2.GL_PROJECTION);
                gl.glLoadIdentity();
                com.jogamp.opengl.glu.GLU glu = new com.jogamp.opengl.glu.GLU();
                glu.gluPerspective(45.0, (double) width / height, 1.0, 20.0);

                gl.glMatrixMode(GL2.GL_MODELVIEW);
                gl.glLoadIdentity();
            }

            @Override
            public void dispose(GLAutoDrawable drawable) {
                System.out.println("Cleaning up OpenGL resources.");
            }
        });

        // Run the simulation
        Animator animator = new Animator(window);
        animator.start();

        window.setVisible(true);
    }
}
