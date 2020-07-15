package com.example.parking;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Cadastrar_Activity extends AppCompatActivity {

   private RadioButton radioCarro;
   private RadioButton radioMoto;
   private EditText nome;
   private EditText marca;
   private EditText cor;
   private EditText ano;
   private EditText dataE;
   private EditText dataS;
   private EditText horarioE;
   private EditText horarioS;

   private VeiculoDAO vdao;
   private Veiculo veiculo = null;

   String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Tela de Cadastro");
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);


        radioCarro = findViewById(R.id.radioCarro);
        radioMoto = findViewById(R.id.radioMoto);
        nome = findViewById(R.id.editNome);
        marca = findViewById(R.id.editMarca);
        cor = findViewById(R.id.editCor);
        ano = findViewById(R.id.editAno);
        dataE = findViewById(R.id.editDataE);
        dataS = findViewById(R.id.editDataS);
        horarioE = findViewById(R.id.editHorarioE);
        horarioS = findViewById(R.id.editHorarioS);


        vdao = new VeiculoDAO(this);

        Intent intent = getIntent();
        if(intent.hasExtra("veiculo")){
            veiculo = (Veiculo) intent.getSerializableExtra("veiculo");


            nome.setText(veiculo.getNome());
            marca.setText(veiculo.getMarca());
            cor.setText(veiculo.getCor());
            ano.setText(veiculo.getAno());
            dataE.setText(veiculo.getDataE());
            dataS.setText(veiculo.getDataS());
            horarioE.setText(veiculo.getHorarioE());
            horarioS.setText(veiculo.getHorarioS());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_cadastrar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.save:

                if(radioCarro.isChecked()){
                    tipo = "Carro";
                }else if(radioMoto.isChecked()){
                    tipo = "Moto";
                }else{
                    tipo = "";
                }


                if (veiculo == null) {

                    Veiculo veiculo = new Veiculo();

                    veiculo.setTipo(tipo);
                    veiculo.setNome(nome.getText().toString());
                    veiculo.setMarca(marca.getText().toString());
                    veiculo.setCor(cor.getText().toString());
                    veiculo.setAno(ano.getText().toString());
                    veiculo.setDataE(dataE.getText().toString());
                    veiculo.setDataS(dataS.getText().toString());
                    veiculo.setHorarioE(horarioE.getText().toString());
                    veiculo.setHorarioS(horarioS.getText().toString());
                    long id = vdao.save(veiculo);
                    Toast.makeText(this, "Veiculo Cadastrado ! ", Toast.LENGTH_LONG).show();
                    finish();

                } else {

                    veiculo.setTipo(tipo);
                    veiculo.setNome(nome.getText().toString());
                    veiculo.setMarca(marca.getText().toString());
                    veiculo.setCor(cor.getText().toString());
                    veiculo.setAno(ano.getText().toString());
                    veiculo.setDataE(dataE.getText().toString());
                    veiculo.setDataS(dataS.getText().toString());
                    veiculo.setHorarioE(horarioE.getText().toString());
                    veiculo.setHorarioS(horarioS.getText().toString());
                    vdao.update(veiculo);
                    finish();
                    Toast.makeText(this, "Veiculo Atualizado !", Toast.LENGTH_SHORT).show();
                }

             break;

            case R.id.close :
                finish();
                break;

            case android.R.id.home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
