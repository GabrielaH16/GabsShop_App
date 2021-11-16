package sv.edu.catolica.gabsshopapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

import sv.edu.catolica.gabsshopapp.R;


public class HomeFragment extends Fragment {

    private ImageCarousel carousel;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_home, container, false);

        carousel=root.findViewById(R.id.image_slider);
        carousel.registerLifecycle(getLifecycle());
        List<CarouselItem> slideModels = new ArrayList<>();
        slideModels.add(
                new CarouselItem(
                        R.drawable.banner1,
                        "Photo by Kimiya Oveisi on Unsplash"

                )
        );
        slideModels.add(
                new CarouselItem(
                        R.drawable.banner2,
                        "Photo by Kimiya Oveisi on Unsplash"
                )
        );
        slideModels.add(
                new CarouselItem(
                        R.drawable.banner3,
                        "Photo by Kimiya Oveisi on Unsplash"

                )
        );
        carousel.setAutoPlay(true);
        carousel.setAutoPlayDelay(3000);
        carousel.setData(slideModels);


        return root;
    }
}