package ibotrox.leptocephalus.geobaby.testtablayout;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class RulesandRegulationsActivity extends ActionBarActivity  {
    //implements FragmentManager.OnBackStackChangedListener

    TextView mTextView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rulesand_regulations);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        mTextView = (TextView)findViewById(R.id.mTextView);
//        mTextView.setMovementMethod(new ScrollingMovementMethod());

//        String[] rules_content = getResources().getStringArray(R.array.rules_content);
//        mTextView.setText(Arrays.toString(rules_content).replaceAll("\\[|\\]", ""));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rulesand_regulations, menu);
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
            //Toast.makeText(getApplicationContext(), "Sept 17,18,19 @SJCET, Choondacherry (Palai)", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Sept 17,18,19 @\n" +
                    "SJCET, Choondacherry P.O,\n" +
                    "Palai-686 579, \n" +
                    "Kottayam DISTRICT\n" +
                    "Kerala,India", Toast.LENGTH_LONG).show();
//            return true;
        }

        if (id == android.R.id.home)
        {
            //NavigationDrawerFragment.mDrawerLayout.openDrawer(Gravity.LEFT);
            NavUtils.navigateUpFromSameTask(this);

//            FragmentManager fm = getSupportFragmentManager();
//            if (fm.getBackStackEntryCount() > 0) {
//                fm.popBackStack();
//            }
//            else
//                return super.onOptionsItemSelected(item);;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onBackStackChanged() {
//        //Enable Up button only  if there are entries in the back stack
//        boolean canback = getSupportFragmentManager().getBackStackEntryCount()>0;
//        getSupportActionBar().setDisplayHomeAsUpEnabled(canback);
//    }
}
