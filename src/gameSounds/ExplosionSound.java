package gameSounds;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class ExplosionSound {

    // Constructor for the ExplosionSound
    public ExplosionSound() {
        // Load the Explosion sound upon object creation
        loadSelectionSound();
    }

    // Method to load the Explosion sound
    void loadSelectionSound() {
        try {
            // Get the audio input stream from the specified file
            // Fields for audio input stream and clip
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./Resources/audio/spaceShip_explosion.wav"));

            // Get a clip from the audio system
            Clip clip = AudioSystem.getClip();

            // Open the clip with the loaded audio input stream
            clip.open(audioInputStream);

            // Start playing the clip
            clip.start();
        } catch (Exception ex) {
            // Print an error message if an exception occurs
            System.out.println(ex);
        }
    }
}

