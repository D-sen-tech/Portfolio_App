package com.codewithdeba.portfolioapp.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codewithdeba.portfolioapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class PortfolioFragmentDetails extends BottomSheetDialogFragment {


    private ImageView imgPortfolio;
    private TextView title,description;


    public PortfolioFragmentDetails() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgPortfolio = view.findViewById(R.id.portfolio_details_img);
        title = view.findViewById(R.id.portfolio_details_title);
        description = view.findViewById(R.id.portfolio_details_desc);



        Bundle bundle = getArguments();
        PortfolioItem item = (PortfolioItem) bundle.getSerializable("object");

        loadPortfolioData(item);

    }


    void loadPortfolioData(PortfolioItem item) {

        Glide.with(getContext()).load(item.getImg()).into(imgPortfolio);

        // bind title and description ....

    }


}