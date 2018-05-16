/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaojdbc2018.aluno;

import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class NegocioAluno {
    public void cadastrarAluno(Aluno a) throws SQLException, Exception {
        //aplicar validações
        if (a == null) {
            throw new Exception("Favor instanciar o Aluno");
        }
        if (a.getMatricula() <= 0) {
            throw new Exception("A matricula do aluno deverá ser superior a ZERO");
        }
        if (a.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do aluno");
        }
        DadosAluno dados = new DadosAluno();
        dados.cadastrarAluno(a);
        
    }
}
