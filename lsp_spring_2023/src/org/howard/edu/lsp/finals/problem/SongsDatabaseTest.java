package org.howard.edu.lsp.finals.problem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SongsDatabaseTest {
    private SongsDatabase db;
    
    @Before
    public void setUp() {
        db = new SongsDatabase();
        db.addSong("Afrobeats", "Kwaku the Traveller");
        db.addSong("Afrobeats", "Soja");
        db.addSong("Asakaa", "Kumerica Yaba");
    }
    
    @Test
    public void testAddSong() {
        db.addSong("Afrobeats", "Goldigga");
        Set<String> AfrobeatsSongs = db.getSongs("Afrobeats");
        assertTrue(AfrobeatsSongs.contains("Goldigga"));
    }
    
    @Test
    public void testGetSongs() {
        Set<String> AfrobeatsSongs = db.getSongs("Afrobeats");
        Set<String> expectedAfrobeatsSongs = new HashSet<String>();
        expectedAfrobeatsSongs.add("Kwaku the Traveller");
        expectedAfrobeatsSongs.add("Soja");
        assertEquals(expectedAfrobeatsSongs, AfrobeatsSongs);
    }
    
    @Test
    public void testGetSongsInvalidGenre() {
        assertNull(db.getSongs("Hip Hop"));
    }
    
    @Test
    public void testGetGenreOfSong() {
        assertEquals("Afrobeats", db.getGenreOfSong("Kwaku the Traveller"));
    }
    
    @Test
    public void testGetGenreOfSongInvalidSong() {
        assertNull(db.getGenreOfSong("Freestyle"));
    }
}

