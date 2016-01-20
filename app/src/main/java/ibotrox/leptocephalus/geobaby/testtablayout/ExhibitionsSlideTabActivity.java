package ibotrox.leptocephalus.geobaby.testtablayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;


public class ExhibitionsSlideTabActivity extends ActionBarActivity implements MaterialTabListener {

    private Toolbar toolbar;
    public MaterialTabHost tabHost;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibitions_slide_tab);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0f);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabHost = (MaterialTabHost)findViewById(R.id.materialTabHost);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){

            @Override
            public void onPageSelected(int position) {
                tabHost.setSelectedNavigationItem(position);    //change the tab when a particular page is selected
            }
        });

        for (int i=0; i<adapter.getCount(); i++)
        {
            tabHost.addTab(tabHost.newTab().setText(adapter.getPageTitle(i)).setTabListener(this));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exhibitions_slide_tab, menu);
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
            return true;
        }

        if (id == android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(MaterialTab materialTab) {
        viewPager.setCurrentItem(materialTab.getPosition());    //change the viewpager correspondingly (page (fragment)) when a tab is selected
    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }

    //VIEW PAGER ADAPTER

    private class ViewPagerAdapter extends FragmentStatePagerAdapter
    {
//        int icons[] = {R.drawable.abc_ic_menu_paste_mtrl_am_alpha,
//                R.drawable.abc_btn_check_material,
//                R.drawable.abc_btn_switch_to_on_mtrl_00001};
        String[] exhibitions_tabs;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            exhibitions_tabs = getResources().getStringArray(R.array.exhibitions_tabs);
        }

        @Override
        public Fragment getItem(int position) {
            MyFragmentForExhibitionSlidingActivity myFragment = MyFragmentForExhibitionSlidingActivity.getInstance(position);
            return myFragment;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return exhibitions_tabs[position];
        }

//        private Drawable getIcon(int position)
//        {
//            return getResources().getDrawable(icons[position]);
//        }
    }

    // MY FRAGMENT TO DISPLAY IN TABHOST

    public static class MyFragmentForExhibitionSlidingActivity extends Fragment
    {
        private TextView textView;
        private TextView exhibitionname;
        private TextView details;
        private ImageView imageView;

        public static MyFragmentForExhibitionSlidingActivity getInstance(int position)
        {
            //return an instance (object) of MyFragmentForExhibitionSlidingActivity
            MyFragmentForExhibitionSlidingActivity myFragment = new MyFragmentForExhibitionSlidingActivity();
            Bundle args = new Bundle();
            args.putInt("position",position);
            myFragment.setArguments(args);
            return myFragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_my,container,false);
            textView = (TextView)layout.findViewById(R.id.position);
            exhibitionname = (TextView)layout.findViewById(R.id.exhibitionname);
            details = (TextView)layout.findViewById(R.id.details);
            imageView = (ImageView)layout.findViewById(R.id.image);
            Bundle bundle = getArguments();
            int position = bundle.getInt("position");

            switch (position)
            {
                case 0:
                    textView.setText("Applied Electronics");
                    exhibitionname.setText("Yaanthrika");
                    details.setText("Solving problems is one thing. Now develop and integrate an entire electronic instrument to adapt to this problem. Applied Electronics and Instrumentation welcomes you to Yaantrika.");
                    imageView.setImageResource(R.drawable.aei);
                    break;

                case 1:
                    textView.setText("Civil");
                    exhibitionname.setText("Nirmaan");
                    details.setText("The first settlements were raised from mud and stone. From the great pyramids of Giza to the towering skyscrapers of the metropolitans, Civil Engineering holds it all. Nirmaan, witness the evolution of what was once a mud hut to what has now become a structure of vast expanse.");
                    imageView.setImageResource(R.drawable.civil);
                    break;

                case 2:
                    textView.setText("Computer Science");
                    exhibitionname.setText("Pinnacle");
                    details.setText("The day Charles Babbage invented the Difference Engine, little did he know that his machine would revolutionize the world. Computers as we know of today are the descendants of these primitive machines and those who tame them are Computer Science Engineers. Surf through the codes of programming and discover yourself at Pinnacle.");
                    imageView.setImageResource(R.drawable.cse);
                    break;

                case 3:
                    textView.setText("Electrical");
                    exhibitionname.setText("Electra");
                    details.setText("From super high voltage electric lines to windmills to simple table fans, if electricity makes you feel at home, then you have got to become an Electrical and Electronics Engineer.  Electra, gives you a dazzling exhibition of deadly Electrical Machines.");
                    imageView.setImageResource(R.drawable.eee);
                    break;

                case 4:
                    textView.setText("Electronics");
                    exhibitionname.setText("Electronica");
                    details.setText("The simple pacemaker that keeps a man breathing, top secret military encoders and those beautiful Christmas lights you see, welcome to Electronics and Communication Engineering. Electronica, displays the prowess of Electronic Circuitry and Communication techniques.");
                    imageView.setImageResource(R.drawable.ec);
                    break;

                case 5:
                    textView.setText("Mechanical");
                    exhibitionname.setText("Mechaurora");
                    details.setText("Crank that engine and grease the gears. Those beast like monstrous machines stand still in front of a Mechanical Engineer. Mechaura, where man and machine unite, become enthralled by machines which live.");
                    imageView.setImageResource(R.drawable.me);
                    imageView.setBackgroundColor(Color.BLACK);
                    break;

                default:
                    textView.setText("Please try again");
                    exhibitionname.setText("Cynosure15 exhibitions");
                    details.setText("");
                    break;
            }

//            if (bundle != null)
//            {
//                textView.setText("Hi there " +  bundle.getInt("position"));
//            }
            return layout;
        }
    }
}
