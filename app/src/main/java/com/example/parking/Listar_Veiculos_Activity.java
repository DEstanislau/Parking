package com.example.parking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Listar_Veiculos_Activity extends AppCompatActivity {


    private ListView listView;
    private VeiculoDAO vdao;
    private List<Veiculo> veiculos;
    private List<Veiculo> veiculosSelecionados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_veiculos);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Lista de Veiculos");
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);


        listView = findViewById(R.id.lista_veiculos);
        vdao = new VeiculoDAO(this);
        veiculos = vdao.read();
        veiculosSelecionados.addAll(veiculos);
       // ArrayAdapter<Veiculo> adapter = new ArrayAdapter<Veiculo>(this, android.R.layout.simple_list_item_1, veiculosSelecionados);
        VeiculoAdapter adapter = new VeiculoAdapter(this,veiculosSelecionados);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listar, menu);

        SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                searchVeiculo(s);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_crud, menu);

    }

    public void searchVeiculo(String nome){
        veiculosSelecionados.clear();

        for(Veiculo veiculo : veiculos){
            if(veiculo.getNome().toLowerCase().contains(nome.toLowerCase())){
                veiculosSelecionados.add(veiculo);
            }
        }
        listView.invalidateViews();
    }

    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        final Veiculo veiculoExcluir = veiculosSelecionados.get(menuInfo.position);

        AlertDialog.Builder dialog = new AlertDialog.Builder(Listar_Veiculos_Activity.this);

        dialog.setTitle("Atenção !");
        dialog.setMessage("Realmente deseja Excluir ?");
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                veiculosSelecionados.remove(veiculoExcluir);
                veiculos.remove(veiculoExcluir);
                vdao.delete(veiculoExcluir);
                listView.invalidateViews();
                 toastt();
            }
        });

        dialog.setNegativeButton("Não",null);

        dialog.create();
        dialog.show();

    }



    public void atualizar(MenuItem item){

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        final Veiculo veiculoAtualizar = veiculosSelecionados.get(menuInfo.position);

        Intent intent = new Intent(getApplicationContext(), Cadastrar_Activity.class);
        intent.putExtra("veiculo", veiculoAtualizar);
        startActivity(intent);


    }



    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        switch(item.getItemId()){

            case R.id.novo :

                Intent intent = new Intent(getApplicationContext(), Cadastrar_Activity.class);
                startActivity(intent);
                break;

            case android.R.id.home:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        veiculos = vdao.read();
        veiculosSelecionados.clear();
        veiculosSelecionados.addAll(veiculos);
        listView.invalidateViews();
    }

   public void toastt(){

            Toast.makeText(getApplicationContext(), "Veiculo Excluido Com Sucesso!", Toast.LENGTH_SHORT).show();

   }


}
