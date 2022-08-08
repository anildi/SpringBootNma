/*
Copyright 2019-2022 Anil Pal
All rights reserved by The Third Lane, LLC.
*/

package ttl.larku.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttl.larku.domain.Track;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    public List<Track> findByTitleIgnoreCase(String title);
    public List<Track> findByTitleIgnoreCaseContaining(String title);
}
