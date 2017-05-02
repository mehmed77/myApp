package basiccalc.myapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import basiccalc.myapp.R;


public class HomeFragment extends Fragment {
    private FragmentTabHost mTabHost;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mTabHost = (FragmentTabHost)view.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(),R.id.realtabcontent);
        mTabHost.addTab(mTabHost.newTabSpec("post").setIndicator("Post"), FriendFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("search").setIndicator("Search"), ExploreFragment.class, null);

        return view;
    }

}
