package sv.edu.catolica.gabsshopapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import sv.edu.catolica.gabsshopapp.R;
import sv.edu.catolica.gabsshopapp.adapters.SliderAdapter;

public class OnBoardingActivity extends AppCompatActivity {


    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    Button btn;
    TextView[]dots;
    LinearLayout dotsLayaout;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        //hide status bar
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //HIDE TOOLBAR
        getSupportActionBar().hide();

        viewPager=findViewById(R.id.slider);
        dotsLayaout=findViewById(R.id.dots);
        btn=findViewById(R.id.get_started_btn);
        addDots(0);


        //call Adapter
        sliderAdapter=new SliderAdapter(OnBoardingActivity.this);

        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(changeListener);
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 2000, 4000);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardingActivity.this,RegistrationActivity.class));
                finish();
            }
        });

    }

    private void addDots(int position){
        dots= new TextView[3];
        dotsLayaout.removeAllViews();
        for(int i = 0; i < dots.length; i++)
        {
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dotsLayaout.addView(dots[i]);
        }

        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.pink));
        }


    }

    private class MyTimerTask extends TimerTask {

        public void run() {

            OnBoardingActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem()==0){
                        //viewPager.setCurrentItem(1);
                        viewPager.setCurrentItem(1, true);
                    }else if(viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                        //viewPager.setCurrentItem(2, true);
                    }else if(viewPager.getCurrentItem()==2){
                        viewPager.setCurrentItem(0);
                        //viewPager.setCurrentItem(0, true);
                    }
                }
            });
        }
    }
    ViewPager.OnPageChangeListener changeListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            if (position==0){
                btn.setVisibility(View.VISIBLE);

            }else if (position==1){
                btn.setVisibility(View.VISIBLE);
            }else{
                //animation= AnimationUtils.loadAnimation(OnBoardingActivity.this,R.anim.slide_animation);
                //btn.setAnimation(animation);
                btn.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}