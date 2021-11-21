package sv.edu.catolica.gabsshopapp.fragments;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

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
import sv.edu.catolica.gabsshopapp.activities.ShowAllActivity;
import sv.edu.catolica.gabsshopapp.adapters.CategoryAdapter;
import sv.edu.catolica.gabsshopapp.adapters.NewProductsAdapters;
import sv.edu.catolica.gabsshopapp.adapters.PopularProductsAdapter;
import sv.edu.catolica.gabsshopapp.models.CategoryModel;
import sv.edu.catolica.gabsshopapp.models.NewProductsModel;
import sv.edu.catolica.gabsshopapp.models.PopularProductsModel;


public class HomeFragment extends Fragment {

    TextView catShowAll,popularShowAll,newProductShowAll;

    RecyclerView catRecyclerview, newProductRecyclerview, popularReyclerview;

    //Category recyclerview
    CategoryAdapter categoryAdapter;
    List<CategoryModel> categoryModelList;

    //New Product reyclerview
    NewProductsAdapters newProductsAdapters;
    List<NewProductsModel> newProductsModelList;

    //popularProducts
    PopularProductsAdapter popularProductsAdapter;
    List<PopularProductsModel> popularProductsModelList;


    //firestore
    FirebaseFirestore db;

    private ImageCarousel carousel;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        db = FirebaseFirestore.getInstance();

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        catRecyclerview = root.findViewById(R.id.rec_category);
        newProductRecyclerview = root.findViewById(R.id.new_product_rec);
        popularReyclerview = root.findViewById(R.id.popular_rec);

        catShowAll=root.findViewById(R.id.category_see_all);
        popularShowAll=root.findViewById(R.id.popular_see_all);
        newProductShowAll=root.findViewById(R.id.newProducts_see_all);

        catShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ShowAllActivity.class);
                startActivity(intent);
            }
        });

        newProductShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ShowAllActivity.class);
                startActivity(intent);
            }
        });

        popularShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ShowAllActivity.class);
                startActivity(intent);
            }
        });

        //Image slider
        carousel = root.findViewById(R.id.image_slider);
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
                        "Blusa con amarilla off shoulder "

                )
        );
        carousel.setAutoPlay(true);
        carousel.setAutoPlayDelay(3000);
        carousel.setData(slideModels);

        //Category
        catRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        categoryModelList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getContext(), categoryModelList);
        catRecyclerview.setAdapter(categoryAdapter);

        db.collection("Category")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                CategoryModel categoryModel = document.toObject(CategoryModel.class);
                                categoryModelList.add(categoryModel);
                                categoryAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "" + task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        //New Products
        newProductRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        newProductsModelList = new ArrayList<>();
        newProductsAdapters = new NewProductsAdapters(getContext(), newProductsModelList);
        newProductRecyclerview.setAdapter(newProductsAdapters);
        db.collection("NewProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                NewProductsModel newProductsModel = document.toObject(NewProductsModel.class);
                                newProductsModelList.add(newProductsModel);
                                newProductsAdapters.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "" + task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        //New Products
        popularReyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        popularProductsModelList = new ArrayList<>();
        popularProductsAdapter = new PopularProductsAdapter(getContext(), popularProductsModelList);
        popularReyclerview.setAdapter(popularProductsAdapter);
        db.collection("AllProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                PopularProductsModel popularProductsModel = document.toObject(PopularProductsModel.class);
                                popularProductsModelList.add(popularProductsModel);
                                popularProductsAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "" + task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        return root;
    }
}