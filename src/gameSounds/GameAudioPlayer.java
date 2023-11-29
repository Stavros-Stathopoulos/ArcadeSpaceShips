package gameSounds;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

// GameAudioPlayer class for playing space ambient audio
public class GameAudioPlayer {

    // Constructor for GameAudioPlayer
    public GameAudioPlayer() {
        // Load the space ambient audio upon object creation
        loadSpaceAmbient();
    }

    // Method to load the space ambient audio
    void loadSpaceAmbient() {
        try {
            // Get the audio input stream from the specified file
            // Fields for audio input stream and clip
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./Resources/audio/space-ambience.wav"));

            if (audioInputStream != null) {
                // Get a clip from the audio system
                Clip clip = AudioSystem.getClip();

                if (clip != null) {
                    // Open the clip with the loaded audio input stream

                    clip.open(audioInputStream);

                    // Set volume (if needed)
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-10.0f);

                    // Loop continuously
                    clip.loop(Clip.LOOP_CONTINUOUSLY);

                    // Start playing
                    clip.start();
                } else {
                    System.out.println("Clip is null");
                }
            } else {
                System.out.println("AudioInputStream is null");
            }
        } catch (Exception ex) {
            // Handle the exception by printing the error
            ex.printStackTrace();
        }
    }
}
