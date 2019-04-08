package com.sun.youtube_background_03.data.source.remote;

import com.sun.youtube_background_03.data.model.Video;
import java.util.List;

public interface VideoRemoteDataCallBack {
    void getDataRemoteSuccess(List<Video> videos);

    void getDataRemoteFailed(Exception e);
}
