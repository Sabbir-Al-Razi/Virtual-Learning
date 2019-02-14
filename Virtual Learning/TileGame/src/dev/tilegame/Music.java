package dev.tilegame;

import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

	
	/**
	 *
	 * @author USER-PC
	 */
	public class Music implements AudioClip {
		public static Clip clip;
		private final String song;

		Music(String name){
			song = "Music/sound.wav";
		}

		@Override
		public void loop() {
			// TODO Auto-generated method stub
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}

		@Override
		public void play() {
			  try {
			   File file = new File(song);
			   clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(file));
			   clip.start();
			  } 
	                  catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
			   System.err.println(e.getMessage());
			  }
	  
		}
		
		@Override
		public void stop() {
		}
		public static void stp(){
			clip.stop();
		}
	}

	
