package ibotrox.leptocephalus.geobaby.testtablayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment  {

    Context context;
    private View containerView;
    private ActionBarDrawerToggle mDrawerToggle;
    public static DrawerLayout mDrawerLayout; //this takes care of all the drawer opening and closing and all.
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    public static final String FILE_NAME = "victor_data";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    static Drawable d1;

//    ImageView cynosure_picture;
//    ImageView fb_icon, instagram_icon, twitter_icon;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    public void ImageViewClickHandler()
    {
//        cynosure_picture = (ImageView)getActivity().findViewById(R.id.cynosure_picture);
//        fb_icon = (ImageView)getActivity().findViewById(R.id.fb_icon);
//        instagram_icon = (ImageView)getActivity().findViewById(R.id.instagram_icon);
//        twitter_icon = (ImageView)getActivity().findViewById(R.id.twitter_icon);
//
//        fb_icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"our facebook page",Toast.LENGTH_SHORT).show();
//            }
//        });
//        instagram_icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"our instagram account",Toast.LENGTH_SHORT).show();
//            }
//        });
//        twitter_icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"our twitter tweets",Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUserLearnedDrawer = Boolean.valueOf(readFromSharedPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,"false"));
        if (savedInstanceState != null)
        {
            mFromSavedInstanceState = true; //first time use. make it true so that the next time, we will know that it is from savedInstanceState.
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

//        d1 = context.getResources().getDrawable(R.drawable.abc_btn_switch_to_on_mtrl_00001);
//        d1.setColorFilter(new PorterDuffColorFilter(0xffff00, PorterDuff.Mode.MULTIPLY));

//        cynosure_picture = (ImageView)layout.findViewById(R.id.cynosure_picture);
//        fb_icon = (ImageView)layout.findViewById(R.id.fb_icon);
//        instagram_icon = (ImageView)layout.findViewById(R.id.instagram_icon);
//        twitter_icon = (ImageView)layout.findViewById(R.id.twitter_icon);
//
//        fb_icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"our facebook page",Toast.LENGTH_SHORT).show();
//            }
//        });
//        instagram_icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"our instagram account",Toast.LENGTH_SHORT).show();
//            }
//        });
//        twitter_icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"our twitter tweets",Toast.LENGTH_SHORT).show();
//            }
//        });


        recyclerView = (RecyclerView)layout.findViewById(R.id.drawerList);
        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(),getData());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    public static List<RecyclerViewContent> getData()
    {
        List<RecyclerViewContent> data = new ArrayList<>();
        int[] icons = {R.drawable.abc_btn_radio_material,
                R.drawable.abc_btn_radio_material,
                R.drawable.abc_btn_radio_material,
                R.drawable.abc_btn_radio_material,
                R.drawable.abc_btn_radio_material};

        //two images deleted.
        String[] titles = {"Home","What is Cynosure?","Rules and Regulations","Contact","About Us"};
        //"Reach Us"
        //"Questions"

        for (int i=0; i<icons.length && i<titles.length; i++)
        {
            RecyclerViewContent current = new RecyclerViewContent();
            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);
        }

        return data;
    }

    public void setUp(int fragmentId, DrawerLayout myDrawerLayout, final Toolbar myToolbar) {
        //main activity il ninnu ulla components ne ingott map cheyyuka
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = myDrawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),myDrawerLayout,myToolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                if (!mUserLearnedDrawer)    //if the user has never opened the drawer before
                {
                    mUserLearnedDrawer = true;
                    saveToSharedPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,mUserLearnedDrawer+"");
                }
                getActivity().supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                //myToolbar.setAlpha(1-slideOffset);    //works only from api level 11

//                //works in api level 1 onwards
//                if (slideOffset<0.8)
//                {
//                    final AlphaAnimation animation = new AlphaAnimation(slideOffset, 1-slideOffset);
//                    animation.setDuration(0);
//                    animation.setFillAfter(true);
//                    myToolbar.startAnimation(animation);
//                }


            }
        };

        //showing the user the drawer the first time user starts the app
        if (!mUserLearnedDrawer && !mFromSavedInstanceState)
        {
            mDrawerLayout.openDrawer(containerView);
        }
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    public static void saveToSharedPreferences(Context context, String preferenceName, String preferenceValue)
    {
        try
        {
            //make this method static because it doesnt depend on any object!
            SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(preferenceName,preferenceValue);
            editor.apply(); //apply does things faster than commit, but apply is asynchronous, it wont notify of any error. commit has a waiting time and does things synchronously.
        }
        catch (Exception e)
        {
            Toast.makeText(context,"Please try again",Toast.LENGTH_SHORT).show();
        }
    }

    public static String readFromSharedPreferences(Context context, String preferenceName, String defaultValue)
    {
        SharedPreferences sharedPreferences = null;
        try
        {
            sharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        }
        catch (Exception e)
        {
            Toast.makeText(context,"Please try again",Toast.LENGTH_SHORT).show();
        }
        return sharedPreferences.getString(preferenceName,defaultValue);
    }
}











