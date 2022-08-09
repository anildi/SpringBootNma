package ttl.larku.app;

import ttl.larku.domain.Student;
import ttl.larku.domain.Track;

import java.time.LocalDate;

/**
 * @author whynot
 */
public class CreationDemo {

    public static void main(String[] args) {

        Student student = new Student("Pankaj", "383 939 9393", LocalDate.of(2000, 10, 10), Student.Status.HIBERNATING);

//        Track track = new Track("John", "Pretty Things", "3:30", LocalDate.of(1962, 4, 4));
//
//        Track track1 = new Track("John", null, null, null);
//
        Track track2 = new Track();
        track2.setAlbum("John");

        Track track3 = new Track.Builder()
                .artist("John")
                .album("Pretty Things")
                .build();

        Track track4 = Track.artist("John")
                .album("Pretty Things")
                .build();
    }

}

