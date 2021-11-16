package sv.edu.catolica.gabsshopapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.LinearLayout;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

import sv.edu.catolica.gabsshopapp.R;

public class OnBoardingCarousell extends AppCompatActivity {
    private ImageCarousel carousel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_carousell);

        carousel= findViewById(R.id.carousel);
        carousel.registerLifecycle(getLifecycle());
        List<CarouselItem> list = new ArrayList<>();
        list.add(
                new CarouselItem(
                        R.drawable.carousel1


                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.carousel2

                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.carousel3


                )
        );
        carousel.setAutoPlay(true);
        carousel.setAutoPlayDelay(3000);
        carousel.setData(list);

    }
}