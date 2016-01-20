package ibotrox.leptocephalus.geobaby.testtablayout;

import android.graphics.Typeface;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class AboutUsActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Slabo27px-Regular.TTF");
////ROBOTO-MEDIUM_0.TTF
//
//        TextView tv1 = (TextView) findViewById(R.id.info_text1);
//        TextView tv2 = (TextView) findViewById(R.id.info_text1_1);
//
//        tv1.setTypeface(font);
//        tv2.setTypeface(font);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about_us, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Sept 17,18,19 @\n" +
                    "SJCET, Choondacherry P.O,\n" +
                    "Palai-686 579, \n" +
                    "Kottayam DISTRICT\n" +
                    "Kerala,India", Toast.LENGTH_LONG).show();
        }

        if (id == android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
