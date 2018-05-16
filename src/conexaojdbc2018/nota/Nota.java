/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaojdbc2018.nota;

import conexaojdbc2018.aluno.Aluno;

/**
 *
 * @author aluno
 */

/*


serial
*/
public class Nota {
    private int id_nota;
    private String disciplina_nota;
    private float nota;
    private Aluno aluno_nota;
    
    
    public Nota(){
        this.aluno_nota = new Aluno();
    }
    
    public String toString() {
        String retorno = "Código: " + this.id_nota;
        retorno += " Prova: " + this.disciplina_nota;
        retorno +=" Nota: " + this.nota;
        retorno +="\nMatricula: " + this.aluno_nota.getMatricula();
        retorno += " Nome: " + this.aluno_nota.getNome(); 
        return  retorno; 
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return id_nota;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.id_nota = codigo;
    }

        /**
     * @return the id_nota
     */
    public int getId_Nota() {
        return id_nota;
    }

    /**
     * @param id_nota the prova to set
     */
    public void setId_Nota(int id_nota) {
        this.id_nota = id_nota;
    }
    
    /**
     * @return the prova
     */
    public String getProva() {
        return disciplina_nota;
    }

    /**
     * @param prova the prova to set
     */
    public void setProva(String prova) {
        this.disciplina_nota = prova;
    }

    /**
     * @return the nota
     */
    public float getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(float nota) {
        this.nota = nota;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno_nota;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno_nota = aluno;
    }
}
