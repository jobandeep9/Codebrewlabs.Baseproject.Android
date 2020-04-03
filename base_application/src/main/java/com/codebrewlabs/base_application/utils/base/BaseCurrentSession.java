package com.codebrewlabs.base_application.utils.base;

import com.codebrewlabs.base_application.utils.LocalData;
import com.codebrewlabs.base_application.utils.SharedPrefUtils;
import com.google.gson.Gson;
import timber.log.Timber;


/**
 * All the management of accessing, saving and clearing the data of shared preferences of the device is done in this class
 * **/

public class BaseCurrentSession<T extends LocalData> {

    protected static BaseCurrentSession i = null;
    private T localData;
    private Class<T> tClass;
    private final int LOCAL_DATA_READ_WRITE_KEY = 99;

    protected BaseCurrentSession(T localData, Class<T> tClass) {
        i = this;
        this.localData = localData;
        this.tClass = tClass;
        if (SharedPrefUtils.i() != null) {
            String data = SharedPrefUtils.i().readString(LOCAL_DATA_READ_WRITE_KEY);
            if (data != null && !data.isEmpty() && data.length() > 1) {
                try {
                    this.localData = (new Gson()).fromJson(data, tClass);
                } catch (Exception var5) {
                    this.localData = localData;
                }
            }
        }
    }

    public void saveDataLocally() {
        String data = (new Gson()).toJson(this.localData, this.tClass);
        Timber.tag("TAG").d("saveData: %s", data);
        if (SharedPrefUtils.i() != null) {
            SharedPrefUtils.i().writeString(LOCAL_DATA_READ_WRITE_KEY, data);
        }
    }

    public T getLocalData() {
        return this.localData;
    }
}
