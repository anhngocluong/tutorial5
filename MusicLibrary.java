package Tutorial4;

import java.util.ArrayList;

public class MusicLibrary {

    private String libraryName;
    private String owner;
    private ArrayList<String> tracks;
    private ArrayList<Playlist> playlists;

    public MusicLibrary(String rockCollection, String johnSmith) {
    }

    public void MusicLibrary(String libraryName, String owner) {
        this.libraryName = libraryName;
        this.owner = owner;
        this.tracks = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(String track) {
        if (tracks.remove(track)) {
            for (Playlist playlist : playlists) {
                playlist.removeTrack(track);
            }
        }
    }

    public void displayTracks() {
        System.out.println("All tracks in library:");
        for (String track : tracks) {
            System.out.println(track);
        }
    }

    public void searchTracks(String phrase) {
        System.out.println("Search results for " + phrase);
        for (String track : tracks) {
            if (track.toLowerCase().contains(phrase.toLowerCase())) {
                System.out.println(track);
            }
        }
    }

    public void createPlaylist(String name) {
        if (findPlaylist(name) == null) {
            playlists.add(new Playlist(name));
        } else {
            System.out.println("Playlist " + name + " already exists.");
        }
    }

    public Playlist findPlaylist(String name) {
        for (Playlist p : playlists) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public void addTrackToPlaylist(String track, String playlistName) {
        Playlist playlist = findPlaylist(playlistName);
        if (playlist != null && tracks.contains(track)) {
            playlist.addTrack(track);
        }
    }

    public void displayPlaylist(String name) {
        Playlist playlist = findPlaylist(name);
        if (playlist != null) {
            playlist.displayTracks();
        } else {
            System.out.println("Playlist " + name + " not found.");
        }
    }

    public void displayAllPlaylists() {
        System.out.println("All playlists:");
        for (Playlist playlist : playlists) {
            System.out.println("- " + playlist.getName());
        }
    }

    public int getTrackCount() {

        return tracks.size();
    }

    public int getPlaylistCount() {

        return playlists.size();
    }
}
