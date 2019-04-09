package com.sun.youtube_background_03.utils;

import com.sun.youtube_background_03.BuildConfig;

public class Constant {
    public static final String SNIPPET = "snippet";
    public static final String API =
            "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=";
    public static final String KEY = BuildConfig.API_KEY;
    public static final String PLAYLIST = BuildConfig.PLAYLIST;
    public static final String MAX_RESULT = "&maxResults=20";
    public static final String URL = API + PLAYLIST + "&key=" + KEY + MAX_RESULT;
}
