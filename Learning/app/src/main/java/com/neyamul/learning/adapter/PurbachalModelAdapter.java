package com.neyamul.learning.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.neyamul.learning.R;
import com.neyamul.learning.model.NotificationModel;
import com.neyamul.learning.model.PurbachalModel;

import java.util.List;

public class PurbachalModelAdapter extends RecyclerView.Adapter<PurbachalModelAdapter.ViewHolder>{

    private List<PurbachalModel> purbachalModelList;

    private Context context;

    public PurbachalModelAdapter(List<PurbachalModel> purbachalModelList, Context context) {
        this.purbachalModelList = purbachalModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.member_details, parent, false);
        return new PurbachalModelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PurbachalModel purbachalModel = purbachalModelList.get(position);
        holder.name.setText(purbachalModel.getName());
        holder.clubPosition.setText(purbachalModel.getClubPosition());
    }

    @Override
    public int getItemCount() {
        return purbachalModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView clubPosition;

        TextView address1;

        TextView address2;
        TextView cell;
        TextView email;
        TextView membershipNo;
        TextView bloodGroup;

        ImageView memberImage;
        ImageView btnCall;
        ImageView btnEmail;
        ImageView btnSms;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            clubPosition=itemView.findViewById(R.id.clubPosition);
            address1=itemView.findViewById(R.id.address1);
            address2=itemView.findViewById(R.id.address2);
            cell=itemView.findViewById(R.id.cell);
            email=itemView.findViewById(R.id.email);
            membershipNo=itemView.findViewById(R.id.membershipNo);
            bloodGroup=itemView.findViewById(R.id.bloodGroup);
            memberImage=itemView.findViewById(R.id.memberImage);
            btnCall=itemView.findViewById(R.id.btnCall);
            btnEmail=itemView.findViewById(R.id.btnEmail);
            btnSms=itemView.findViewById(R.id.btnSms);

        }


    }
}
