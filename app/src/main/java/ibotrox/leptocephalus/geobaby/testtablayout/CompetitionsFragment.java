package ibotrox.leptocephalus.geobaby.testtablayout;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CompetitionsFragment extends Fragment {

    private RecyclerView recyclerView;
    private View containerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout; //this takes care of all the drawer opening and closing and all.
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    public static final String FILE_NAME = "victor_data";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private CompetitionsRecyclerViewAdapter recyclerViewAdapter;

    public CompetitionsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_competitions, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewCompetitionsFragmentList);
        recyclerViewAdapter = new CompetitionsRecyclerViewAdapter(getActivity(),getData());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    public static List<CompetitionRecyclerViewContents> getData()
    {
        List<CompetitionRecyclerViewContents> data = new ArrayList<>();
//        int[] icons = {R.drawable.abc_btn_switch_to_on_mtrl_00001,
//                R.drawable.abc_btn_switch_to_on_mtrl_00001  };
        String[] titles = {"one","two"};

        for (int i=0; i<titles.length; i++)
        {
            CompetitionRecyclerViewContents current = new CompetitionRecyclerViewContents();
            current.title = titles[i];
            data.add(current);
        }

        return data;
    }


}
