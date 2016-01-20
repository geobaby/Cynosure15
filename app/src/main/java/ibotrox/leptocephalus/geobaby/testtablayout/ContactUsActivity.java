package ibotrox.leptocephalus.geobaby.testtablayout;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class ContactUsActivity extends ActionBarActivity {

    private Toolbar toolbar;
    TextView info_text1p1, info_text2p1, info_text3p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        info_text1p1 = (TextView)findViewById(R.id.info_text1_1);
        info_text1p1.setMovementMethod(LinkMovementMethod.getInstance());

        info_text2p1 = (TextView)findViewById(R.id.info_text2_1);
        info_text2p1.setMovementMethod(LinkMovementMethod.getInstance());

        info_text3p1 = (TextView)findViewById(R.id.info_text3_1);
        info_text3p1.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_us, menu);
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
