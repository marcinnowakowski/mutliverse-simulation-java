# Multiverse Simulation with JOGL

This project simulates a multiverse using JOGL (Java OpenGL). Each universe is represented as a sphere in 3D space, and the multiverse evolves by rendering these spheres with JOGL.

---

## Project Structure

```
multiverse-simulation/
├── build.gradle         # Gradle build configuration
├── settings.gradle      # Gradle settings file
├── src/
│   └── main/
│       ├── java/
│       │   ├── MultiverseSimulation.java  # Main entry point
│       │   ├── Multiverse.java            # Manages universes
│       │   └── Universe.java              # Represents a single universe
│       └── resources/
├── libs/
│   ├── jogl-all.jar                       # JOGL core library
│   ├── gluegen-rt.jar                     # JOGL utility library
│   └── natives/
│       ├── linux-amd64/                   # Native binaries for Linux (example)
│       │   ├── libjogl.so
│       │   ├── libgluegen-rt.so
```

---

## Requirements

### Software
- **Java**: OpenJDK 8 or 11 is recommended.
- **Gradle**: Ensure Gradle is installed on your system.
- **JOGL Libraries**: Include JOGL JARs and native binaries in the `libs` folder.

### Dependencies
- `jogl-all.jar`: JOGL core library.
- `gluegen-rt.jar`: GlueGen runtime library.
- Native binaries for your platform (e.g., `libjogl.so`, `libgluegen-rt.so`).

Download JOGL libraries from the [JogAmp archive](https://jogamp.org/deployment/jogamp-current/archive/).

---

## Setup

1. **Download JOGL Libraries**
   Download the JOGL distribution (`jogamp-all-platforms`) and extract it. Copy the required JAR files and native libraries into the `libs` directory of your project.

2. **Configure Gradle**

   Update `build.gradle`:

   ```gradle
   plugins {
       id 'java'
       id 'application'
   }

   repositories {
       mavenCentral()
   }

   dependencies {
       implementation files('libs/jogl-all.jar')
       implementation files('libs/gluegen-rt.jar')
   }

   application {
       applicationDefaultJvmArgs = [
           "-Djava.library.path=libs/natives/linux-amd64" // Update for your platform
       ]
       mainClass = 'MultiverseSimulation' // Update for package name if applicable
   }
   ```

3. **Build the Project**
   ```bash
   ./gradlew clean build
   ```

4. **Run the Simulation**
   ```bash
   ./gradlew run
   ```

---

## Features

- **Multiverse Simulation**: Visualizes multiple universes as spheres in 3D space.
- **OpenGL Rendering**: Uses JOGL to leverage GPU-based rendering.
- **Dynamic Properties**: Each universe has properties like size, position, and color.

---

## Troubleshooting

### Issue: "Native libraries not found"
Ensure that:
- Native binaries (e.g., `libjogl.so`, `libgluegen-rt.so`) are placed in `libs/natives/{platform}`.
- The `java.library.path` is correctly set in `build.gradle`.

### Issue: "Illegal reflective access"
- Use Java 8 or 11 for compatibility.

### Debugging
Run with the `jogamp.debug` flag to get detailed logs:
```bash
./gradlew run --args="-Djogamp.debug=all"
```

---

## References
- [JogAmp Official Website](https://jogamp.org/)
- [JogAmp Maven Repository](https://jogamp.org/deployment/maven/)
- [Gradle Documentation](https://gradle.org/)

---

## License
This project is licensed under the MIT License.

