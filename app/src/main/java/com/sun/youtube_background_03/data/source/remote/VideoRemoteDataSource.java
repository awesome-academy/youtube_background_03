package com.sun.youtube_background_03.data.source.remote;

import com.sun.youtube_background_03.data.source.VideoDataSource;
import com.sun.youtube_background_03.utils.Constant;

public class VideoRemoteDataSource implements VideoDataSource.Remote {
    private static VideoRemoteDataSource sInstance;

    private VideoRemoteDataSource() {
    }

    public static VideoRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new VideoRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getListVideoWithGenres(String genre, VideoRemoteDataCallBack listener) {
        GetVideosAsyncTask fetchData = new GetVideosAsyncTask(listener);
        fetchData.execute(Constant.URL);
    }
}
