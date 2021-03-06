/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 22:01
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.model;

import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.helper.Base64Custom;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;


public class Indicacoes {
    private String nomeProprietario;
    private String telefoneProprietario;
    private int flagContato;

    public Indicacoes(){

    }

    public Indicacoes(String nomeProprietario, String telefoneProprietario, int flagContato) {
        this.nomeProprietario = nomeProprietario;
        this.telefoneProprietario = telefoneProprietario;
        this.flagContato = flagContato;
    }

    public void salvarIndicacoes(){
        FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        String idUsuario = Base64Custom.codificarBase64(autenticacao.getCurrentUser().getEmail());
        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("indicacoes")
                .child(idUsuario)
                .push()
                .setValue(this);
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getTelefoneProprietario() {
        return telefoneProprietario;
    }

    public void setTelefoneProprietario(String telefoneProprietario) {
        this.telefoneProprietario = telefoneProprietario;
    }

    public int getFlagContato() {
        return flagContato;
    }

    public void setFlagContato(int flagContato) {
        this.flagContato = flagContato;
    }
}
