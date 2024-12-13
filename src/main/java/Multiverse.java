import com.jogamp.opengl.GL2;

import java.util.ArrayList;
import java.util.List;

public class Multiverse {
    private final List<Universe> universes;

    public Multiverse() {
        this.universes = new ArrayList<>();
    }

    public void addUniverse(Universe universe) {
        universes.add(universe);
    }

    public void render(GL2 gl) {
        for (Universe universe : universes) {
            universe.render(gl);
        }
    }
}
