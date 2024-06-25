package br.com.macenalucas.screensound.repository;

import br.com.macenalucas.screensound.model.Artist;
import br.com.macenalucas.screensound.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByNameContainingIgnoreCase(String name);

    @Query("SELECT m FROM Artist a JOIN a.musics m WHERE a.name ILIKE %:name")
    List<Music> findMusicsByArtist(String name);
}
