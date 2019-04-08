package com.sun.youtube_background_03.data.source.remote;

import android.os.AsyncTask;
import com.sun.youtube_background_03.data.model.Video;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import static com.sun.youtube_background_03.data.model.Video.JsonEntity.ITEM;
import static com.sun.youtube_background_03.data.model.Video.JsonEntity.SOURCE;
import static com.sun.youtube_background_03.utils.Constant.SNIPPET;

public class GetVideosAsyncTask extends AsyncTask<String, Void, List<Video>> {

    private static final String GET = "GET";
    private VideoRemoteDataCallBack mRemoteDataCallBack;
    private List<Video> mVideos = new ArrayList<>();

    public GetVideosAsyncTask(VideoRemoteDataCallBack videoRemoteDataCallBack) {
        mRemoteDataCallBack = videoRemoteDataCallBack;
    }

    @Override
    protected List<Video> doInBackground(String... strings) {
        try {
            String data = getDataFromUrl(strings[0]);
            mVideos = pareJsonToObject(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mVideos;
    }

    private String getDataFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(GET);
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        line = bufferedReader.readLine();
        httpURLConnection.disconnect();
        return line;
    }

    private List<Video> pareJsonToObject(String data) throws Exception {
        List<Video> videos = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(data);
        JSONArray jsonArray = jsonObject.getJSONArray(ITEM);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i).getJSONObject(SNIPPET);
            Video video = new Video.Builder().setID(
                    object.getJSONObject(SOURCE).getString(Video.JsonEntity.ID))
                    .setTitle(object.getString(Video.JsonEntity.TITLE))
                    .setDescription(object.getString(Video.JsonEntity.DESCRIPTION))
                    .setThumbnail(object.getString(Video.JsonEntity.THUMBNAIL))
                    .build();
            videos.add(video);
        }
        return videos;
    }

    @Override
    protected void onPostExecute(List<Video> videos) {
        super.onPostExecute(videos);
        mRemoteDataCallBack.getDataRemoteSuccess(videos);
    }
}
