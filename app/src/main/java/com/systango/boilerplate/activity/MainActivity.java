package com.systango.boilerplate.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.systango.boilerplate.R;
import com.systango.boilerplatesdk.listener.OnFeature1ResponseListener;
import com.systango.boilerplatesdk.main.SystangoRestClient;
import com.systango.boilerplatesdk.network.response.SampleResponse;

public class MainActivity extends AppCompatActivity implements OnFeature1ResponseListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        SystangoRestClient systangoRestClient = new SystangoRestClient("{{API_KEY}}");
        systangoRestClient.feature1Method("value1", this);
    }

    @Override
    public void onFeature1Response(SampleResponse sampleResponse) {
        if (sampleResponse.getError() != null) {
            //Use sampleResponse here
        } else {
            //Handle error case here
        }
    }
}
