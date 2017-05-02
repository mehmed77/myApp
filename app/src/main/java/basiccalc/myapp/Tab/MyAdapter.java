package basiccalc.myapp.Tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import basiccalc.myapp.R;
import basiccalc.myapp.fragment.ChatFragment;
import basiccalc.myapp.fragment.ExploreFragment;
import basiccalc.myapp.fragment.FriendFragment;
import basiccalc.myapp.fragment.HomeFragment;

/**
 * Created by Muxammad on 25.04.2017.
 */

public class MyAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String[] titles = {"A", "B", "C", "D"};
    int[] icon = new int[]{R.drawable.ic_home_white_24dp, R.drawable.ic_explore_white_24dp, R.drawable.ic_chat_white_24dp, R.drawable.ic_person_pin_white_24dp};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c) {
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon = (int) (24 * scale + 0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 1:
                fragment = new ExploreFragment();
                break;
            case 2:
                fragment = new ChatFragment();
                break;
            case 3:
                fragment = new FriendFragment();
                break;
            default:
                fragment = new HomeFragment();
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position){
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,heightIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }
}
