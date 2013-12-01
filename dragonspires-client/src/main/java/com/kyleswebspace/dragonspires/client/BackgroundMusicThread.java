package main.java.com.kyleswebspace.dragonspires.client;

import java.awt.Checkbox;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class BackgroundMusicThread extends Thread {
	
	private static Checkbox backgroundMusicCheckbox;
	private boolean isPlaying = false;
	
	public BackgroundMusicThread(boolean backgroundMusicLoaded,
			Checkbox backgroundMusicCheckbox) {
		
		BackgroundMusicThread.backgroundMusicCheckbox = backgroundMusicCheckbox;
	}

	@Override
	public void run() {
		
		try {
			Clip clip = null;
			while (true) {
				if(backgroundMusicCheckbox.getState() && !isPlaying) {
					clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(
							this.getClass().getResourceAsStream("resources/chess.wav")));
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					
					clip.start();
					
					isPlaying = true;
				} else if(!backgroundMusicCheckbox.getState() && isPlaying) {
					clip.stop();
					isPlaying = false;
				}
				
				Thread.sleep(100);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
