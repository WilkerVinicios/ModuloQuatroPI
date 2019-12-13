package br.senac.go.projetointegrador_2_semestre_2019.source;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.senac.go.projetointegrador_2_semestre_2019.R;
import br.senac.go.projetointegrador_2_semestre_2019.model.Abastecimento;

public class AbastecimentoAdapter extends RecyclerView.Adapter<AbastecimentoAdapter.AbastecimentoViewHolder> {

    private List<Abastecimento> dataList;

    public AbastecimentoAdapter(List<Abastecimento> dataList) {

        this.dataList = dataList;
    }


    class AbastecimentoViewHolder extends RecyclerView.ViewHolder {

        public final View myView;

        TextView textVodo;
        TextView textLitros;
        TextView textVtotalPg;
        TextView textVnomePosto;
        TextView textVCombustivel;
        TextView textVplaca;
        TextView textVdata;


        AbastecimentoViewHolder(View abastecimentoItem) {
            super(abastecimentoItem);
            myView = itemView;

             textVodo = myView.findViewById(R.id.tx_odo);
             textLitros = myView.findViewById(R.id.tx_litros);
             textVtotalPg = myView.findViewById(R.id.tx_preco);
             textVnomePosto = myView.findViewById(R.id.tx_posto);
             textVplaca = myView.findViewById(R.id.tx_placa);
             textVdata = myView.findViewById(R.id.tx_data);




        }
    }
    @Override

    public AbastecimentoAdapter.AbastecimentoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_abastecimentos, parent, false);

        return new AbastecimentoAdapter.AbastecimentoViewHolder(view);


    }

    @Override

    public void onBindViewHolder(AbastecimentoAdapter.AbastecimentoViewHolder holder, int position) {

        holder.textVodo.setText("ODO: " +String.valueOf(dataList.get(position).getOdo())+" KM");
        holder.textLitros.setText(String.valueOf( dataList.get(position).getLitros())+ " L");
        holder.textVtotalPg.setText("R$ "+String.valueOf(dataList.get(position).getTotalPago()));
        holder.textVnomePosto.setText("POSTO: "+dataList.get(position).getNomePosto());
        holder.textVplaca.setText(dataList.get(position).getPlacaVeiculo());
        holder.textVdata.setText(String.valueOf(dataList.get(position).getData()));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}

