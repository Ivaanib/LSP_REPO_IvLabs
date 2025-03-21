package org.howard.edu.lsp.midterm.question5;

/**
 * Represents a music track with streaming capabilities.
 */


public class Music implements Streamable {
	/**
	 * Ivan Ibhawoh
	 * @param args
	 */
    private String title;

    public Music(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing music: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused music: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped music: " + title);
    }

    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}