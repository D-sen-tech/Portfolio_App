package com.codewithdeba.portfolioapp.team;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
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
public class TeamFragment extends Fragment {


    RecyclerView RvTeam;
    TeamAdapter adapter;
    List<TeamItem> mdata;

    public TeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RvTeam = view.findViewById(R.id.rv_team) ;

        // creat list of team items

        TeamItem item = new TeamItem("John Doe",getString(R.string.lorem_text2),R.drawable.user);
        TeamItem item2 = new TeamItem("Tuhin Paul",getString(R.string.lorem_text2),R.drawable.google);
        TeamItem item3 = new TeamItem("Subra sinha",getString(R.string.lorem_text2),R.drawable.netflix);

        mdata = new ArrayList<>();
        mdata.add(item);
        mdata.add(item2);
        mdata.add(item3);

        // setup adapter and recycleview

        RvTeam.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TeamAdapter(mdata);
        RvTeam.setAdapter(adapter);


    }
}