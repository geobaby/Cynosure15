package ibotrox.leptocephalus.geobaby.testtablayout;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Lucy on 30-07-2015.
 */
public class ThirdHomeScreenFragment extends Fragment {

    Context context;
    Button button;
    WebView webview;
    TextView progressTv;
//    String url = "http://cynosure15.site90.com/CynosureTest1.php";
    String url = "http://cynosure15.site90.com/ibotrox.php";

    public static ThirdHomeScreenFragment getInstance(int position) {
        //return an instance (object) of MyFragment
        ThirdHomeScreenFragment myFragment = new ThirdHomeScreenFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

//    public boolean isNetworkAvailable()
//    {
//        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.third_screen, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {

        }

        button = (Button)layout.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    webview.loadUrl(url);
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Cannot load URL", Toast.LENGTH_SHORT).show();
                }
            }
        });

        webview = (WebView) layout.findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);

//        boolean isInternetAvailable;
//        isInternetAvailable = isNetworkAvailable();

//        if (isInternetAvailable)
//        {
//
//        }
//        else
//        {
//            webview.loadUrl("file:///android_asset/errorpage/index.html");
//            Toast.makeText(getActivity(),"No Internet :(",Toast.LENGTH_SHORT).show();
//        }

        try
        {
            webview.setWebViewClient(new webClient());
            webview.loadUrl(url);
        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(), "Cannot load URL", Toast.LENGTH_SHORT).show();
        }


//        webview.setWebChromeClient(new WebChromeClient() {
//
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
////              super.onProgressChanged(view, newProgress);
//                if (newProgress < 100) {
//                    button.setText("Loading...");
//                }
//
//                if (newProgress == 100) {
//                    progressTv.setText("Uploaded by others");
//                    button.setText("Reload");
//                    Toast.makeText(getActivity(), "Webpage loaded", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        return layout;
    }

    private class webClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            try
            {
                view.loadUrl(url);
                view.setVisibility(View.VISIBLE);
            }
            catch (Exception e)
            {
                Toast.makeText(getActivity(),"Cannot load URL",Toast.LENGTH_SHORT).show();
            }
            return false;
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//            super.onReceivedError(view, errorCode, description, failingUrl);
            String customErrorPage = "<html>" +
                    "<body>" +
                    "Connect to the Internet, please :)" +
                    "</body>" +
                    "</html>";
            view.loadData(customErrorPage, "text/html", null);  //load this html page.

        }
    }


}