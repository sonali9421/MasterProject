package com.kiaora.masterproject.remote.apimodule;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 13-02-2018.
 */

public class ServerResult {
    @SerializedName("error")
    private Boolean error;

    @SerializedName("message")
    private String message;

    public ServerResult(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
