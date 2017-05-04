package com.sitthirat.gel2202.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sitthirat.gel2202.MainActivity;
import com.sitthirat.gel2202.R;
import com.sitthirat.gel2202.tool.Contextor;


/**
 * Created by Prew.
 */
@SuppressWarnings("unused")
public class WebFragment extends DialogFragment implements View.OnClickListener {

    WebFragmentListener listener;

    public interface WebFragmentListener {
        void onButtonClickListener(String url);
    }

    WebView webView;

    public WebFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static WebFragment newInstance() {
        WebFragment fragment = new WebFragment();
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
        final View rootview = inflater.inflate(R.layout.second_dialog, container, false);
        initInstances(rootview, savedInstanceState);

        webView = (WebView) rootview.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.co.th/imghp?hl=th&tab=wi&ei=s5MJWab-C8bL0ATV1oeYDw&ved=0EKouCBIoAQ");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        return rootview;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        ((Button)rootView.findViewById(R.id.btn_dialog_cancel)).setOnClickListener(this);
        ((Button)rootView.findViewById(R.id.btn_dialog_ok)).setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ActionBar.LayoutParams.MATCH_PARENT;
        params.height = ActionBar.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
        super.onResume();
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
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_dialog_cancel:
                getDialog().dismiss();
                break;

            case R.id.btn_dialog_ok:
                getDialog().dismiss();
                SecondFragment secondFragment = SecondFragment.newInstance();
                listener = (WebFragmentListener) getTargetFragment();
                listener.onButtonClickListener(webView.getUrl());
                break;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
