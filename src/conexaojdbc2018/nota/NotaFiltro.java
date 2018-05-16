/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaojdbc2018.nota;

/**
 *
 * @author aluno
 */
public class NotaFiltro extends Nota{
    private float notaInicio;
    private float notaFim;
    public NotaFiltro(){
        this.notaInicio = -1;
        this.notaFim = 11;
    }

    /**
     * @return the nota1
     */
    public float getNotaInicio() {
        return notaInicio;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setNotaInicio(float nota1) {
        this.notaInicio = nota1;
    }

    /**
     * @return the nota2
     */
    public float getNotaFim() {
        return notaFim;
    }

    /**
     * @param nota2 the nota2 to set
     */
    public void setNotaFim(float nota2) {
        this.notaFim = nota2;
    }
}
