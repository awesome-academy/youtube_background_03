package com.sun.youtube_background_03.data.source;

import com.sun.youtube_background_03.data.source.remote.VideoRemoteDataCallBack;

public interface VideoDataSource {
    interface Remote {
        void getListVideoWithGenres(String genre, VideoRemoteDataCallBack listener);
    }
}
