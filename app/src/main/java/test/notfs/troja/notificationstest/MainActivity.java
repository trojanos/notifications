package test.notfs.troja.notificationstest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {

    static final String TAG = "myLogs";
    FragmentManager fm;
//    FragmentTransaction ft;
    TextView count;

    ViewPager pager;
    PagerAdapter pagerAdapter;


    ImageButton plusButton,minusButton;

    static final int PAGE_COUNT = 10;
    FragmentOne fr1 = new FragmentOne();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plusButton = findViewById(R.id.button_plus);
        minusButton = findViewById(R.id.button_minus);
        count = findViewById(R.id.count);

        pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected, position = " + position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.fragments, fr1);
//                ft.addToBackStack("FragmentOne");
//                ft.commit();
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


    }
    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {


        public MyFragmentPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
        public CharSequence getPageTitle(int position) {
            System.out.println(position);
            return "Title " + position;

        }

    }

}
