package test.notfs.troja.notificationstest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;




public class MainActivity extends FragmentActivity {

    static int PAGE_COUNT = 1;
    static int fromNotcount;

    ViewPager pager;
    PagerAdapter pagerAdapter;
    ImageButton plusBtn, minusBtn;
    TextView count;
    Button btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        plusBtn = findViewById(R.id.button_plus);
        minusBtn = findViewById(R.id.button_minus);
        minusBtn.setVisibility(View.INVISIBLE);
        count = findViewById(R.id.count);
        btnNotification = findViewById(R.id.button_Create_notification);

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PAGE_COUNT +=1;
                pagerAdapter.notifyDataSetChanged();
                if (PAGE_COUNT > 1)
                    minusBtn.setVisibility(View.VISIBLE);
                pager.setCurrentItem(PAGE_COUNT);

            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PAGE_COUNT -=1;
                pagerAdapter.notifyDataSetChanged();
                if (PAGE_COUNT <= 1)
                minusBtn.setVisibility(View.INVISIBLE);
                pager.setCurrentItem(PAGE_COUNT);

            }
        });
        pager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                count.setText(String.valueOf(position));
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

        });
        fromNotcount = getIntent().getIntExtra("currentPage",0);
        if (fromNotcount > 0) {
            pager.setCurrentItem(fromNotcount);

        }
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
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

    }

}