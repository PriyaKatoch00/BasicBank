package com.priya.basicbank.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.priya.basicbank.Model.Model;
import com.priya.basicbank.R;

import java.util.ArrayList;
import java.util.List;

public class SendMoney extends RecyclerView.Adapter<ViewHolderAdapter> {

    com.priya.basicbank.Activities.SendMoney SendtoUser;
    List<Model> modelList;

    public SendMoney(com.priya.basicbank.Activities.SendMoney sentoUser, List<Model> modelList) {
        this.SendtoUser = sentoUser;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.userlist, parent, false);

        ViewHolderAdapter viewHolder = new ViewHolderAdapter(itemView);
        viewHolder.setOnClickListener((view, position) -> SendtoUser.selectuser(position));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapter holder, int position) {
        holder.mName.setText(modelList.get(position).getName());
        holder.mPhonenumber.setText(modelList.get(position).getPhoneno());
        holder.mBalance.setText(modelList.get(position).getBalance());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void setFilter(ArrayList<Model> newList){
        modelList = new ArrayList<>();
        modelList.addAll(newList);
        notifyDataSetChanged();
    }
}
