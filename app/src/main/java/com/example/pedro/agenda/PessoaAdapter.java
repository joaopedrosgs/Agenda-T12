package com.example.pedro.agenda;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PessoaAdapter extends RecyclerView.Adapter<PessoaAdapter.ViewHolder> {

    private List<String> moviesList;

    public PessoaAdapter(List<String> _moviesList) {
        this.moviesList = _moviesList;
    }

    @Override
    public PessoaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pessoa_item_list, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PessoaAdapter.ViewHolder holder, int position) {
        holder.textPessoaView.setText(moviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_pessoa_name)
        TextView textPessoaView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
