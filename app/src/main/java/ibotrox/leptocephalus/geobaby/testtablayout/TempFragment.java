package ibotrox.leptocephalus.geobaby.testtablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucy on 02-08-2015.
 */
public class TempFragment extends Fragment {

    private RecyclerView recyclerView;
    private View containerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout; //this takes care of all the drawer opening and closing and all.
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    public static final String FILE_NAME = "victor_data";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private MenuRecyclerViewAdapter recyclerViewAdapter;

    public TempFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.temp_fragment, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewCompetitionsFragmentListTop);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        recyclerViewAdapter = new MenuRecyclerViewAdapter(getActivity(),getData());
        recyclerView.setAdapter(recyclerViewAdapter);
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        return view;
    }
    public static List<MenuContents> getData()
    {
        List<MenuContents> data = new ArrayList<>();

        //TODO: its better to give these in strings.xml... do that next time
        String[] titles = {"Project Competition", "Best Idea"};
                //, "More"};
        //clicking on proct comprtn wil go to a slliding tab wiht schol level adn clcge level two tabs

        for (int i=0; i<titles.length; i++)
        {
            MenuContents current = new MenuContents();
            current.title = titles[i];
            data.add(current);
        }

        return data;
    }
}