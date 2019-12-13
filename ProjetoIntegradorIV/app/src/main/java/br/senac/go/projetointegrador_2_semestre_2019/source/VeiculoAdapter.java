package br.senac.go.projetointegrador_2_semestre_2019.source;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.senac.go.projetointegrador_2_semestre_2019.R;
import br.senac.go.projetointegrador_2_semestre_2019.model.Veiculos;

public class VeiculoAdapter extends RecyclerView.Adapter<VeiculoAdapter.VeiculoViewHolder> {


    private List<Veiculos> dataList;

    public VeiculoAdapter(List<Veiculos> dataList) {

        this.dataList = dataList;
    }


    class VeiculoViewHolder extends RecyclerView.ViewHolder {

        public final View myView;

        TextView textVeiculo;
        ImageView img;

        VeiculoViewHolder(View veiculoItem) {
            super(veiculoItem);
            myView = itemView;

            textVeiculo = myView.findViewById(R.id.Tv_placa);

            img = myView.findViewById(R.id.imgView);


        }
    }
        @Override

        public VeiculoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_veiculo, parent, false);

            return new VeiculoViewHolder(view);


        }

        @Override

        public void onBindViewHolder(VeiculoViewHolder holder, int position) {


            String string = "moto";
            int id_imagem;

            if (dataList.get(position).getTipo() == "moto") {
                holder.img.setImageResource(R.drawable.bike);
}
            if(dataList.get(position).getTipo()!= "moto"){
                holder.img.setImageResource(R.drawable.car_);
        }

            holder.textVeiculo.setText(dataList.get(position).getPlaca());

}

        @Override
        public int getItemCount() {

        return dataList.size();
        }

    }
