package ibotrox.leptocephalus.geobaby.testtablayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lucy on 30-07-2015.
 */
public class SecondHomeScreenFragment extends Fragment {
    //    private TextView textView;

    ImageView imageView;
    public static final String URL = "http://cynosure15.site90.com/reg.php";
    Button button;
    int TAKE_PHOTO_CODE = 0;
    String imageString = "test string";
    String asyncTastReturn = null;
    String currentDateandTime;
    JSONParser jsonParser = new JSONParser();
    EditText number;
    boolean isNumberGot = false;
    String yourNumber = "";
    String directory = "";
    boolean isImageString = false;

    public static SecondHomeScreenFragment getInstance(int position) {
        //return an instance (object) of MyFragment
        SecondHomeScreenFragment myFragment = new SecondHomeScreenFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.second_home, container, false);
//        textView = (TextView)layout.findViewById(R.id.position);
//        Bundle bundle = getArguments();
//        if (bundle != null)
//        {
//            textView.setText("Hi there " +  bundle.getInt("position"));
//        }

        try
        {
            directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Cynosure/";
            File cynosurefile = new File(directory);
            cynosurefile.mkdirs();
        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(),"Cannot create file, make sure SD card is properly inserted",Toast.LENGTH_SHORT).show();
        }

        imageView = (ImageView)layout.findViewById(R.id.imageView);
        number = (EditText)layout.findViewById(R.id.numberEditText);

        button = (Button) layout.findViewById(R.id.id_take_photo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start intent to capture image

                yourNumber = number.getText().toString();
                if (!(yourNumber.matches(""))) {
                    isNumberGot = true;
                } else {
                    Toast.makeText(getActivity(), "Please give your contact number", Toast.LENGTH_SHORT).show();
                }

                if (isNumberGot) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                    currentDateandTime = sdf.format(new Date());

                    String file = directory + "cynosurepicture.png";
                    //tempImageName = currentDateandTime.toString();
                    File newFile = new File(file);

                    try {
                        newFile.createNewFile();
                    } catch (IOException e) {
                        Log.d("ERROR ERRO0R ERROR0","EXCEPTION HERE0");
                        e.printStackTrace();
                        Toast.makeText(getActivity(), "Make sure SD card is properly inserted:\n\n"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    try {
                        Uri outfileUri = Uri.fromFile(newFile);
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outfileUri);
                        startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Cannot start camera, sorry", Toast.LENGTH_SHORT).show();
                    }


                    //Toast.makeText(getActivity(), "Loading.. this wont take long..", Toast.LENGTH_LONG).show();
                }
            }
        });

        return layout;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TAKE_PHOTO_CODE && resultCode == Activity.RESULT_OK)
        {
            //Toast.makeText(getActivity(),"Congratulations",Toast.LENGTH_SHORT).show();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 10;
//            options.inJustDecodeBounds = true;

            try
            {
//                final Bitmap imageBitmap = BitmapFactory.decodeFile("/sdcard/Pictures/Cynosure/cynosurepicture.png",options);

                String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Cynosure/";
                String fileDir = dir + "cynosurepicture.png";
                final Bitmap imageBitmap = BitmapFactory.decodeFile(fileDir,options);

                if (imageBitmap != null)
                {
                    imageView.setImageBitmap(imageBitmap);
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    imageBitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
                    byte[] bytes = outputStream.toByteArray();
                    imageString = Base64.encodeToString(bytes, Base64.DEFAULT);
                }
                else
                {
                    Log.d("ERROR","IMAGE BITMAP IS NULL");
                    Toast.makeText(getActivity(),"Try Again, please",Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e)
            {
                Log.d("ERROR1 ERROR1 ERROR1","EXCEPTION HERE1");
                e.printStackTrace();
                Toast.makeText(getActivity(),"Cannot access SD card, try again:\n\n"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }

//            // will results in a much smaller image than the original
//            int reqHeight = 120;
//            int reqWidth = 120;
//            final int height = options.outHeight;
//            final int width = options.outWidth;
//            int inSampleSize = 1;
//            if (height > reqHeight || width > reqWidth) {
//                // Calculate ratios of height and width to requested height and width
//                final int heightRatio = Math.round((float)height / (float)reqHeight);
//                final int widthRatio = Math.round((float)width / (float)reqWidth);
//
//                // Choose the smallest ratio as inSampleSize value, this will guarantee
//                // a final image with both dimensions larger than or equal to the
//                // requested height and width.
//                inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
//            }
//            options.inSampleSize = inSampleSize;

//          final Bitmap imageBitmap = BitmapFactory.decodeFile("/sdcard/Pictures/Cynosure/20150809_013719.jpg",options);

            //here was the code cut to the try block above


            //Toast.makeText(getActivity(),"Bitmap converted to string:\n"+imageString,Toast.LENGTH_SHORT).show();

            String length = imageString.length() + "";
            final String tempyourNumber = number.getText().toString();
            number.setText("");
            number.setHint("Please wait while your request is processing..");
            button.setText("[Your photo will be verified soon]");

            //Toast.makeText(getActivity(),tempyourNumber + "    " + length,Toast.LENGTH_LONG).show();

            if (imageString != "test string")
            {
                isImageString = true;
            }

            if((isNetworkAvailable(getActivity())) && (isImageString))
            {
                new sendStringtoDb().execute(imageString,tempyourNumber);
            }
            else
            {
                number.setHint("");
                button.setText("Take Photo and Send");
                Toast.makeText(getActivity(),"No Internet Connectivity!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isNetworkAvailable(Context ctx)
    {
        ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting() && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //ASYNCTASK
    public class sendStringtoDb extends AsyncTask<String,String,String>
    {
        @Override
        protected String doInBackground(String... args) {

            String myString = args[0];
            String phoneNumber = args[1];
            List<NameValuePair> nvPair = new ArrayList<>();
            nvPair.add(new BasicNameValuePair("ImageString",myString));
            nvPair.add(new BasicNameValuePair("Number",phoneNumber));
            JSONObject jsonObject = jsonParser.makeHttpRequest(URL,nvPair); //initially, this was outside the try block
            try
            {
                asyncTastReturn = jsonObject.getString("Status");
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
            catch (NullPointerException NPE)
            {
            }
            catch (Exception e)
            {
                e.printStackTrace();
                Log.d("LOG", "\n\ncaught this exception\n\n");
            }

            return asyncTastReturn;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            number.setHint("");
            button.setText("Take Photo and Send");

            switch (s)
            {
                case "Okay":
                    Toast.makeText(getActivity(), "Successfully uploaded your picture, Thanks ;)", Toast.LENGTH_SHORT).show();
                    break;

                default:
                    Toast.makeText(getActivity(), "Things didnt go as expected :( Please try again..:\n\n", Toast.LENGTH_SHORT).show();
                    break;
            }

//            if (s == "Okay")
//            {
//                Toast.makeText(getActivity(), "Successfully uploaded your picture, Thanks ;)", Toast.LENGTH_SHORT).show();
//            }
//            else if (s != "Okay")
//            {
//                Toast.makeText(getActivity(), "Things didnt go as expected, :( Please try again..:\n\n"+s, Toast.LENGTH_SHORT).show();
//            }
        }
    }
}


















