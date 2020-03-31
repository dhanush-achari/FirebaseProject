package com.example.firebaseproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Member> member;
    public UserAdapter(Context c,ArrayList<Member> member){
        this.context=c;
        this.member=member;
    }
    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Member member=this.member.get(position);
        holder.name.setText(member.getName());
        holder.email.setText(member.getEmail());
        holder.project.setText(member.getProject());
        holder.dept.setText(member.getDept());
        holder.eid.setText(member.getEid());
        holder.address.setText(member.getAddress());
        holder.number.setText(member.getNumber());
    }

    @Override
    public int getItemCount() {
        return member.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,address,eid,project,dept,number,email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.namee);
            address=itemView.findViewById(R.id.addresse);
            eid=itemView.findViewById(R.id.eide);
            number=itemView.findViewById(R.id.numbere);
           project=itemView.findViewById(R.id.projecte);
           email=itemView.findViewById(R.id.emaile);
            dept=itemView.findViewById(R.id.Depte);

        }
    }
}
