package com.example.ga.bakingapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VideoFragment extends Fragment {
    private Steps steps;
    private int i;

    public VideoFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.video_fragment, container, false);

        Bundle bundle = this.getArguments();
        i =bundle.getInt("stepnumber");
        steps = bundle.getParcelable("Steps");
        String s = steps.getVideoURL();
        String d = steps.getThumbnailURL();
        TextView tv = rootView.findViewById(R.id.video);
        TextView tv2 = rootView.findViewById(R.id.des);
        tv.setText(s);
        tv2.setText(d);





        return rootView;

    }
}
