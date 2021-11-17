package sv.edu.catolica.gabsshopapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

import sv.edu.catolica.gabsshopapp.R;
import sv.edu.catolica.gabsshopapp.adapters.CategoryAdapter;
import sv.edu.catolica.gabsshopapp.models.CategoryModel;


public class HomeFragment extends Fragment {

    RecyclerView catRecyclerview;
    //Category recyclerview
    CategoryAdapter categoryAdapter;
    List<CategoryModel>categoryModelList;
    //firestore
    FirebaseFirestore db;

    private ImageCarousel carousel;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_home, container, false);
        catRecyclerview=root.findViewById(R.id.rec_category);
        db=FirebaseFirestore.getInstance();

        //Image slider
        carousel=root.findViewById(R.id.image_slider);
        carousel.registerLifecycle(getLifecycle());
        List<CarouselItem> slideModels = new ArrayList<>();
        slideModels.add(
                new CarouselItem(
                        R.drawable.ban1,
                        "Vestido negro floreado"

                )
        );
        slideModels.add(
                new CarouselItem(
                        R.drawable.ban2,
                        "Blusa con rayas desmangada"
                )
        );
        slideModels.add(
                new CarouselItem(
                        R.drawable.ban3,
                        "Blusa con isotipos "

                )
        );
        carousel.setAutoPlay(true);
        carousel.setAutoPlayDelay(3000);
        carousel.setData(slideModels);

        //Category
        catRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoryModelList= new ArrayList<>();
        categoryAdapter=new CategoryAdapter(getContext(),categoryModelList);
        catRecyclerview.setAdapter(categoryAdapter);

        db.collection("Category")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                CategoryModel categoryModel=document.toObject(CategoryModel.class);
                                categoryModelList.add(categoryModel);
                                categoryAdapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });
        return root;
    }
}