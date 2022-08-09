package ttl.larku.domain;

import java.time.LocalDate;

/**
 * @author whynot
 */
public class Track {

    private int id;
    private String artist;
    private String album;
    private String duration;
    private LocalDate date;

    private Track(String artist, String album, String duration, LocalDate date) {
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.date = date;
    }


    public Track() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static Builder artist(String artist) {
        return new Builder().artist(artist);
    }

    public static Builder album(String album) {
        return new Builder().album(album);
    }

    public static Builder duration(String duration) {
        return new Builder().duration(duration);
    }

    public static Builder date(LocalDate date) {
        return new Builder().date(date);
    }

    public static class Builder {
        private int id;
        private String artist;
        private String album;
        private String duration;
        private LocalDate date;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder artist(String artist) {
            this.artist = artist;
            return this;
        }

        public Builder album(String album) {
            this.album = album;
            return this;
        }

        public Builder duration(String duration) {
            this.duration = duration;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Track build() {
            if(artist == null) {
                throw new RuntimeException("Must have an artist");
            }
            Track t =  new Track(artist, album, duration, date);
            return t;
        }
    }
}
