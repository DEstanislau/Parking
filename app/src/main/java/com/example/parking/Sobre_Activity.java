package com.example.parking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

public class Sobre_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_sobre_);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Sobre");

        String descricao = "O Grupo de desenvolvedores deste projeto tem como missão apoiar as organizações que desejam alcançar o sucesso através da excelência em gestão e da busca pela Qualidade.\n\n" +
                "Nosso trabalho é dar suporte às empresas que desejam se certificar em padrões de qualidade ou investir no desenvolvimento e evolução de sua gestão, por meio da otimização dos processos e da disseminação dos Fundamentos e Critérios de Excelência.";
        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription( descricao )
                .addGroup("Fale conosco")
                .addEmail("diegoperrone2018@gmail.com", "Envie um e-mail")
                .addWebsite("http://google.com.br/", "Acesse nosso site")
                .addGroup("Acesse nossas redes sociais")
                .addFacebook("https://www.facebook.com/diego.estanislau.99", "Facebook" )
                .addTwitter("https://twitter.com/EstanislauCrvg", "Twitter")
                .addYoutube("https://www.youtube.com/user/vasco", "Youtube")
                .addPlayStore("com.google.android.apps.plus", "Play Store")
                .addGitHub("google", "Github")
                .addInstagram("https://www.instagram.com/vascodagama/?hl=pt-br", "Instagram")
                .create();

        setContentView( sobre );



    }
}
