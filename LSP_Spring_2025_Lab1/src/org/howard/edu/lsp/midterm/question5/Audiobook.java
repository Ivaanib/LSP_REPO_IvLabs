package org.howard.edu.lsp.midterm.question5;

/**
 * Represents an audiobook with streaming capabilities.
 */
public class Audiobook implements Streamable {
	/**
	 * Ivan Ibhawoh
	 * @param args
	 */
    private String title;

    public Audiobook(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }

    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " " + speed + "x");
    }
}