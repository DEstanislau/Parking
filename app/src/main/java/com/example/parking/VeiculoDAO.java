package com.example.parking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    private SQLiteDatabase read;
    private SQLiteDatabase write;


    public VeiculoDAO(Context context){
        DbHelper db = new DbHelper(context);
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }


    public long save(Veiculo veiculo) {


        ContentValues values = new ContentValues();
        values.put("tipo", veiculo.getTipo());
        values.put("nome", veiculo.getNome());
        values.put("marca", veiculo.getMarca());
        values.put("cor", veiculo.getCor());
        values.put("ano", veiculo.getAno());
        values.put("dataE", veiculo.getDataE());
        values.put("dataS", veiculo.getDataS());
        values.put("horarioE", veiculo.getHorarioE());
        values.put("horarioS", veiculo.getHorarioS());

      return  write.insert(DbHelper.TABLE_VEICULOS, null, values);
    }


    public boolean update(Veiculo veiculo) {

        ContentValues values = new ContentValues();
        values.put("tipo", veiculo.getTipo());
        values.put("nome", veiculo.getNome());
        values.put("marca", veiculo.getMarca());
        values.put("cor", veiculo.getCor());
        values.put("ano", veiculo.getAno());
        values.put("dataE", veiculo.getDataE());
        values.put("dataS", veiculo.getDataS());
        values.put("horarioE", veiculo.getHorarioE());
        values.put("horarioS", veiculo.getHorarioS());

        String[] args = {veiculo.getId().toString()};
        write.update(DbHelper.TABLE_VEICULOS, values, "id=?", args);

        return false;
    }


    public void delete(Veiculo veiculo) {
        String[] args = {veiculo.getId().toString()};
        write.delete(DbHelper.TABLE_VEICULOS, "id=?", args);


    }


    public List<Veiculo> read() {
        List<Veiculo> listVeiculos = new ArrayList<>();
        String sql = "SELECT * FROM " + DbHelper.TABLE_VEICULOS + ";";

        Cursor c = read.rawQuery(sql, null);

        while(c.moveToNext()){

            Veiculo veiculo = new Veiculo();

            veiculo.setId(c.getInt(c.getColumnIndex("id")));
            veiculo.setTipo(c.getString(c.getColumnIndex("tipo")));
            veiculo.setNome(c.getString(c.getColumnIndex("nome")));
            veiculo.setMarca(c.getString(c.getColumnIndex("marca")));
            veiculo.setCor(c.getString(c.getColumnIndex("cor")));
            veiculo.setAno(c.getString(c.getColumnIndex("ano")));
            veiculo.setDataE(c.getString(c.getColumnIndex("dataE")));
            veiculo.setDataS(c.getString(c.getColumnIndex("dataS")));
            veiculo.setHorarioE(c.getString(c.getColumnIndex("horarioE")));
            veiculo.setHorarioS(c.getString(c.getColumnIndex("horarioS")));
            listVeiculos.add(veiculo);
        }

        return listVeiculos;

    }

}
