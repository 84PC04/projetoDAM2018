/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaojdbc2018.nota;

import conexaojdbc2018.aluno.*;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class NegocioNota {
    public void cadastrarNota(Nota n) throws SQLException, Exception {
        //aplicar validações
        if (n == null) {
            throw new Exception("Favor instanciar a Nota");
        }
        if (n.getNota() < 0 || n.getNota() > 10) {
            throw new Exception("A nota do aluno deverá ser igual ou superior a ZERO");
        }
        if (n.getAluno().equals("") == true) {
            throw new Exception("Informe o nome do aluno");
        }
        DadosNota dados = new DadosNota();
        dados.cadastrarNota(n);
        
    }
}
