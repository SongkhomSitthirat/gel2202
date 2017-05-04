package com.sitthirat.gel2202.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.gesture.GestureLibraries;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sitthirat.gel2202.R;
import com.sitthirat.gel2202.tool.Contextor;


/**
 * Created by Prew.
 */
@SuppressWarnings("unused")
public class SecondFragment extends Fragment implements View.OnClickListener , WebFragment.WebFragmentListener {

    ImageView ivSecond1, ivSecond2, ivSecond3, ivSecond4, ivSecond5;

    WebFragment dialogFragment;

    @Override
    public void onButtonClickListener(String url) {
        Glide.with(Contextor.getInstance().getContext()).load(url).into(ivSecond1);
        Toast.makeText(Contextor.getInstance().getContext(),url,Toast.LENGTH_SHORT).show();
    }

    public SecondFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        dialogFragment = new WebFragment();
        ivSecond1 = (ImageView) rootView.findViewById(R.id.iv_second_1);
        ivSecond1.setOnClickListener(this);


        ((ImageView) rootView.findViewById(R.id.iv_second_2)).setOnClickListener(this);
        ((ImageView) rootView.findViewById(R.id.iv_second_3)).setOnClickListener(this);
        ((ImageView) rootView.findViewById(R.id.iv_second_4)).setOnClickListener(this);
        ((ImageView) rootView.findViewById(R.id.iv_second_5)).setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
//        Toast.makeText(getActivity(),"onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {

            case R.id.iv_second_1:
                dialogFragment.setTargetFragment(SecondFragment.newInstance(),1);
                dialogFragment.show(getActivity().getSupportFragmentManager(),"DialogFragment");
                break;

            case R.id.iv_second_2:
                dialogFragment.show(getActivity().getSupportFragmentManager(),"DialogFragment");
                break;

            case R.id.iv_second_3:
                break;

            case R.id.iv_second_4:
                break;

            case R.id.iv_second_5:
                break;
        }
    }
}
