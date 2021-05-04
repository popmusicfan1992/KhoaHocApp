package myteam.com.database;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

public class APIClient {
    private static OkHttpClient instance;

    public static OkHttpClient getInstance(Context applicationContext) {
        if (instance == null) {

            try {
                File httpCacheDirectory = new File(applicationContext.getCacheDir(), "http-cache");
                int cacheSize = 5 * 1024 * 1024; // 5MB
                Cache cache = new Cache(httpCacheDirectory, cacheSize);
                instance = new OkHttpClient.Builder()
                        .addNetworkInterceptor(new CacheInterceptor())
                        .cache(cache)
                        .build();
            } catch (Exception ex) {
                Timber.d("Get OKhttpClient fail");
            }
        }
        return instance;
    }

    public static void getAPICourse(OkHttpClient client, String url, ResponseAPI responseAPI) {
        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                call.cancel();
                responseAPI.onFailure();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                responseAPI.onSuccess(response);
            }
        });

    }
}