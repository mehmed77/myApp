package basiccalc.myapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;

import basiccalc.myapp.Tab.MyAdapter;
import basiccalc.myapp.Tab.SlidingTabLayout;
import basiccalc.myapp.fragment.FriendFragment;
import basiccalc.myapp.fragment.SettingFragment;
import basiccalc.myapp.helper.AlertDialogManager;
import basiccalc.myapp.helper.Session;
import basiccalc.myapp.helper.User;


public class MainActivity extends AppCompatActivity {
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private Drawer.Result navigationDrawerLeft;
    private AccountHeader.Result headerNavigationLeft;
    private Session session;
    private AlertDialogManager alertDialog;
    private TextView Name, Email;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);
        alertDialog = new AlertDialogManager();

//        Name = (TextView) findViewById(R.id.user_name);
//        Email = (TextView) findViewById(R.id.user_email);

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        session.checkLogin();

        User user = session.getUserDetails();


//        btnLogout.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                session.logoutUser();
//            }
//        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager)findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);

        //=================================================

        headerNavigationLeft = new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.drawable.icon)
                .addProfiles(
                        new ProfileDrawerItem().withName(user.getName()).withEmail("+998937501225").withIcon(getResources().getDrawable(R.drawable.icon))
                )
                .build();
        navigationDrawerLeft = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigationLeft)
                .withSelectedItem(0)
                .build();
        navigationDrawerLeft.addItem(new ProfileDrawerItem().withName("Home").withIcon(getResources().getDrawable(R.drawable.ic_home_white_24dp)));
        navigationDrawerLeft.addItem(new ProfileDrawerItem().withName("Explore").withIcon(getResources().getDrawable(R.drawable.ic_explore_white_24dp)));
        navigationDrawerLeft.addItem(new ProfileDrawerItem().withName("Chat").withIcon(getResources().getDrawable(R.drawable.ic_chat_white_24dp)));
        navigationDrawerLeft.addItem(new ProfileDrawerItem().withName("Friend").withIcon(getResources().getDrawable(R.drawable.ic_person_pin_white_24dp)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_search:
                return true;
            case R.id.action_logout:
                session.logoutUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}