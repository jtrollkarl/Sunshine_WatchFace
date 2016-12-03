package com.example.jay.sunshinewatchface;

import android.util.Log;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.WearableListenerService;

public class SunshineListenerService extends WearableListenerService {

    private static final String TAG = SunshineListenerService.class.getSimpleName();

    @Override
    public void onDataChanged(DataEventBuffer dataEventBuffer) {

        for (DataEvent dataEvent : dataEventBuffer){
            if(dataEvent.getType() == DataEvent.TYPE_CHANGED){
                DataMap dataMap = DataMapItem.fromDataItem(dataEvent.getDataItem()).getDataMap();
                String path = dataEvent.getDataItem().getUri().getPath();
                Log.d(TAG, path);
                if(path.equals("/weather-data")){
                    Log.d(TAG, "Data successfully received");
                    String high = dataMap.getString("temp-high");
                    String low = dataMap.getString("temp-low");
                    Asset weathericon = dataMap.getAsset("temp-icon");
                    Log.d(TAG, high + " "+ low);
                }
            }
        }

    }
}