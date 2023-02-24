package com.example.uf1_nf1_pr2_nilyjordi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private MutableLiveData<String> data = new MutableLiveData<>();

    public void setData(String newData) {
        data.setValue(newData);
    }

    public LiveData<String> getData() {
        return data;
    }
}
