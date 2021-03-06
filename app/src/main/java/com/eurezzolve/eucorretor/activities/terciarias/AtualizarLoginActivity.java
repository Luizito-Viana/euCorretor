/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:57
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.terciarias;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.DadosUsuario;

public class AtualizarLoginActivity extends AppCompatActivity {

    private Button buttonAtualizar;
    private DadosUsuario dadosUsuario;
    private TextInputEditText campoTelefone, campoEmpresa, campoCreci;
    private String telefone, creci, empresa;

    //OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Atualizar Perfil");

        /*Recupera os dados passados na Activity anterior*/
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            telefone = extras.getString("telefone");
            empresa = extras.getString("empresa");
            creci = extras.getString("creci");
        }

        campoCreci = (TextInputEditText) findViewById(R.id.editTextCreci);
        campoEmpresa = (TextInputEditText) findViewById(R.id.editTextEmpresa);
        campoTelefone = (TextInputEditText) findViewById(R.id.editTextTelefone);

    }

    //Volta para a anterior fehcando a atual
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    //Atualiza o perfil do usuario
    public void atualizarPerfilUsuario(View view) {
        dadosUsuario = new DadosUsuario();
        if(!campoTelefone.getText().toString().equals("")){
            dadosUsuario.setTelefone(campoTelefone.getText().toString());
        } else {
            dadosUsuario.setTelefone(telefone);
        }

        if(!campoEmpresa.getText().toString().equals("")){
            dadosUsuario.setEmpresa(campoEmpresa.getText().toString());
        } else {
            dadosUsuario.setEmpresa(empresa);
        }

        if(!campoCreci.getText().toString().equals("")){
            dadosUsuario.setCreci(campoCreci.getText().toString());
        } else {
            dadosUsuario.setCreci(creci);
        }

        dadosUsuario.salvar();
        finish();
    }
}
