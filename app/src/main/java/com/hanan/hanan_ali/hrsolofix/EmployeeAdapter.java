package com.hanan.hanan_ali.hrsolofix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>
{
    Context context;
    List<EmployeesList> employeeslist;

    public EmployeeAdapter(Context context, List<EmployeesList> employeeslist)
    {
        this.context = context;
        this.employeeslist = employeeslist;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position)
    {
        EmployeesList employeesList=employeeslist.get(position);
        holder.name.setText(employeesList.getName());
        holder.Governorat.setText(employeesList.getGovernorat());
        holder.section.setText(employeesList.getSection());
        holder.regest_reas.setText(employeesList.getRegest_reas());
        holder.date.setText(employeesList.getDate());
        holder.number.setText(employeesList.getNumber());



    }

    @Override
    public int getItemCount()
    {
        return employeeslist.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,Governorat,section,regest_reas,number,date;


        public EmployeeViewHolder(View itemView)
        {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            number=itemView.findViewById(R.id.number);
            Governorat=itemView.findViewById(R.id.gov);
            date=itemView.findViewById(R.id.date);
            section=itemView.findViewById(R.id.sec);
            regest_reas=itemView.findViewById(R.id.reason);
        }
    }

}
