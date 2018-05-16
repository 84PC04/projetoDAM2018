/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaojdbc2018.aluno;

import conexaojdbc2018.nota.Nota;
import java.util.ArrayList;

/**
 *
 * @author professor
 */
public class Aluno {

    private int matricula;
    private String nome;
    private ArrayList<Nota> listaNotas;

    public Aluno() {
        this.listaNotas = new ArrayList<>();
    }

    public String toString() {
        return "Matricula: " + this.matricula + " Nome: " + this.nome;
    }

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the listaNotas
     */
    public ArrayList<Nota> getListaNotas() {
        return listaNotas;
    }

    /**
     * @param listaNotas the listaNotas to set
     */
    public void setListaNotas(ArrayList<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }
}
