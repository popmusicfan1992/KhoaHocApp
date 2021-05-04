package myteam.com.database;

import okhttp3.Response;

public interface ResponseAPI {
    void onSuccess(Response response);
    void onFailure();
}
