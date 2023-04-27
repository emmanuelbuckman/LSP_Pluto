package org.howard.edu.lsp.finals.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
    /* Key is the genre, HashSet contains associated songs */
    private Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
    
    /* Add a song title to a genre */
    public void addSong(String genre, String songTitle) {
        if (map.containsKey(genre)) {
            HashSet<String> songSet = map.get(genre);
            songSet.add(songTitle);
        } else {
            HashSet<String> songSet = new HashSet<String>();
            songSet.add(songTitle);
            map.put(genre, songSet);
        }
    }
    
    /* Return the Set that contains all songs for a genre */
    public Set<String> getSongs(String genre) {
        if (map.containsKey(genre)) {
            return map.get(genre);
        } else {
            return null;
        }
    }
    
    /* Return genre, i.e., jazz, given a song title */
    public String getGenreOfSong(String songTitle) {
        for (String genre : map.keySet()) {
            HashSet<String> songSet = map.get(genre);
            if (songSet.contains(songTitle)) {
                return genre;
            }
        }
        return null;
    }
}

