package ibotrox.leptocephalus.geobaby.testtablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lucy on 30-07-2015.
 */
public class HomeScreenFragment extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static HomeScreenFragment getInstance(int position)
    {
        //return an instance (object) of MyFragment
        HomeScreenFragment myFragment = new HomeScreenFragment();
        Bundle args = new Bundle();
        args.putInt("position",position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.home_screen, container, false);

        try
        {
            Bundle bundle = getArguments(); //ithum try il veno!! kidakkatte.. god bless me..

            Fragment x = new TempFragment();
            FragmentManager fmanager1 = getFragmentManager();
            FragmentTransaction ftransaction1 = fmanager1.beginTransaction();
            ftransaction1.replace(R.id.fragmentContainerId1,x,"TAGx");
            ftransaction1.commit();

            Fragment y = new MenuFragmentMy();
            FragmentManager fmanager2 = getFragmentManager();
            FragmentTransaction ftransaction2 = fmanager2.beginTransaction();
            ftransaction2.replace(R.id.fragmentContainerId2,y,"TAGy");
            ftransaction2.commit();
        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(),"Pleas try again",Toast.LENGTH_SHORT).show();
        }
        return layout;
    }
}