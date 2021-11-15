package com.example.daggerexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    Context context;
    String titleName="";
    List<ResultsModel> listDummy = new ArrayList<ResultsModel>();
    public ListAdapter(Context context, List<ResultsModel> listDummy) {
        this.context = context;
        this.listDummy =listDummy;

    }

    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.MyViewHolder holder, int position) {

        holder.Name.setText(listDummy.get(position).getName());
        holder.real_name.setText(listDummy.get(position).getRealname());
        holder.team.setText(listDummy.get(position).getTeam());
        holder.first.setText(listDummy.get(position).getFirstappearance());
    }

    @Override
    public int getItemCount() {
        return listDummy.size();
    }

    public void onResult(List<ResultsModel> capture) {
        Toast.makeText(context,"success",Toast.LENGTH_SHORT).show();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name, real_name, team, first;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.name);
            real_name = (TextView) itemView.findViewById(R.id.realname);
            team = (TextView) itemView.findViewById(R.id.team);
            first = (TextView) itemView.findViewById(R.id.first);
        }
    }
}