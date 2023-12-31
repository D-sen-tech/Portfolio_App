package com.codewithdeba.portfolioapp.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codewithdeba.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragment extends Fragment implements PortfolioCallback{



    List<PortfolioItem> mdata;
    RecyclerView rv_portfolio;
    PortfolioAdapter portfolioAdapter;










    public PortfolioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_portfolio = view.findViewById(R.id.rv_portfolio);

        // create a lidt of portfolio items

        mdata = new ArrayList<>();
        mdata.add(new PortfolioItem(R.drawable.ongc));
        mdata.add(new PortfolioItem(R.drawable.netflix));
        mdata.add(new PortfolioItem(R.drawable.google));
        mdata.add(new PortfolioItem(R.drawable.baseline_home_24));
        mdata.add(new PortfolioItem(R.drawable.spotify));
        mdata.add(new PortfolioItem(R.drawable.telegram));
        mdata.add(new PortfolioItem(R.drawable.ongc));
        mdata.add(new PortfolioItem(R.drawable.google));
        mdata.add(new PortfolioItem(R.drawable.spotify));

        portfolioAdapter = new PortfolioAdapter(mdata,this);

        //setup grid recycleview

        rv_portfolio.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rv_portfolio.setAdapter(portfolioAdapter);

    }

    @Override
    public void onPortfolioItemClick(int pos) {

        // handle click listener event when portfolio item clicked

        // first we need to create a fragment bottom sheet instance

        PortfolioFragmentDetails portfolioFragmentDetails = new PortfolioFragmentDetails();


        // now we need to send portfolio item to portfolio dialog fragment
        // we will use bundle for that
        // also we need our portfolio item data class to implement serializable interface so we can send it

        Bundle bundle = new Bundle();
        bundle.putSerializable("object",mdata.get(pos));
        portfolioFragmentDetails.setArguments(bundle);


        // now let's open the portfolio bottom sheet fragment

        portfolioFragmentDetails.show(getActivity().getSupportFragmentManager(),"tagname");

        // now we done opening the bottom sheet let's test it out



    }
}