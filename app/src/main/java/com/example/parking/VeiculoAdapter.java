package com.example.parking;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class VeiculoAdapter extends BaseAdapter {

    TextView tipo, nome, marca, cor, ano, dataE, dataS, horarioE, horarioS;


    private List<Veiculo> veiculos;
    private Activity activity;

    public VeiculoAdapter(Activity activity, List<Veiculo> veiculos){
        this.activity = activity;
        this.veiculos = veiculos;
    }

    @Override
    public int getCount() {
        return veiculos.size();
    }

    @Override
    public Object getItem(int i) {
        return veiculos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return veiculos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = activity.getLayoutInflater().inflate(R.layout.item_list, viewGroup, false);

         tipo = v.findViewById(R.id.textTipoList);
         nome = v.findViewById(R.id.textNomeList);
         marca = v.findViewById(R.id.textMarcaList);
         cor = v.findViewById(R.id.textCorList);
         ano = v.findViewById(R.id.textAnoList);
         dataE = v.findViewById(R.id.textDataEList);
         dataS = v.findViewById(R.id.textDataSList);
         horarioE = v.findViewById(R.id.textHorarioEList);
         horarioS = v.findViewById(R.id.textHorarioSList);

         Veiculo veiculo = veiculos.get(i);

         tipo.setText(veiculo.getTipo());
         nome.setText(veiculo.getNome());
         marca.setText(veiculo.getMarca());
         cor.setText(veiculo.getCor());
         ano.setText(veiculo.getAno());
         dataE.setText(veiculo.getDataE());
         dataS.setText(veiculo.getDataS());
         horarioE.setText(veiculo.getHorarioE());
         horarioS.setText(veiculo.getHorarioS());

        return v;
    }
}
