package ibotrox.leptocephalus.geobaby.testtablayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;


public class MainActivity extends ActionBarActivity implements MaterialTabListener  {

    private Toolbar toolbar;
    public MaterialTabHost tabHost;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0f);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment navigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_nav_drawer_id);
        navigationDrawerFragment.setUp(R.id.fragment_nav_drawer_id,(DrawerLayout)findViewById(R.id.drawer_layout_id),toolbar);   //this method is defined to pass our drawer layout and toolbar to the navigation drawer.

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
            tabHost.addTab(tabHost.newTab().setIcon(adapter.getIcon(i)).setTabListener(this));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
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

    private class ViewPagerAdapter extends FragmentStatePagerAdapter
    {
        int icons[] = {R.drawable.abc_ic_menu_paste_mtrl_am_alpha,R.drawable.abc_btn_radio_material,
                R.drawable.abc_btn_check_material};
        //R.drawable.abc_btn_switch_to_on_mtrl_00001
        String[] tabs;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs);
        }

        @Override
        public Fragment getItem(int position) {
//            MyFragment myFragment = null;
            Fragment myFragment = null;
            switch (position)
            {
                case 0: myFragment = HomeScreenFragment.getInstance(position);
                        break;
                case 1: myFragment = SecondHomeScreenFragment.getInstance(position);
                        break;
                case 2: myFragment = ThirdHomeScreenFragment.getInstance(position);
                        break;
            }
            return myFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
        //return 3

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        private Drawable getIcon(int position)
        {
            return getResources().getDrawable(icons[position]);
        }
    }

//    public static class MyFragment extends Fragment
//    {
//        private TextView textView;
//
//        public static MyFragment getInstance(int position)
//        {
//            //return an instance (object) of MyFragment
//            MyFragment myFragment = new MyFragment();
//            Bundle args = new Bundle();
//            args.putInt("position",position);
//            myFragment.setArguments(args);
//            return myFragment;
//        }
//
//        @Nullable
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//            View layout = inflater.inflate(R.layout.fragment_my,container,false);
//            textView = (TextView)layout.findViewById(R.id.position);
//            Bundle bundle = getArguments();
//            if (bundle != null)
//            {
//                textView.setText("Hi there " +  bundle.getInt("position"));
//            }
//            return layout;
//        }
//    }
}
