package com.example.newsapptutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFragment extends Fragment{

    String api ="b2b0d0f9800d46008499c2b171df986";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerViewofscience;
    private String category="science";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.sciencefragment,null);

        recyclerViewofscience=v.findViewById(R.id.recyclerviewofscience);
        modelClassArrayList=new ArrayList<>();
        recyclerViewofscience.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelClassArrayList);
        recyclerViewofscience.setAdapter(adapter);


        findnews();
        return v;
    }

    private void findnews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<importantnews>() {
            @Override
            public void onResponse(Call<importantnews> call, Response<importantnews> response) {
                if(response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<importantnews> call, Throwable t) {

            }
        });

    }
}
