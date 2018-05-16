/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaojdbc2018;

import conexaojdbc2018.aluno.Aluno;
import conexaojdbc2018.aluno.DadosAluno;
import conexaojdbc2018.nota.DadosNota;
import conexaojdbc2018.nota.Nota;
import conexaojdbc2018.nota.NotaFiltro;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class ConexaoJDBC2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            DadosNota dados = new DadosNota();
            NotaFiltro n = new NotaFiltro();
            //n.setNota(9);
            n.setNotaInicio(9);
            n.setNotaFim(10);
            n.setProva("Primeira Avalicação");
            Aluno a = new Aluno();
            //a.setMatricula(3);
            //a.setNome("Camila");
            n.setAluno(a);
            ArrayList<Nota> lista = dados.listar(n);
            for (Nota n1 : lista) {
                JOptionPane.showMessageDialog(null, n1.toString());
            }
            
            //dados.cadastrarNota(n);
            JOptionPane.showMessageDialog(null, "Nota cadastrada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        /*try {
            DadosAluno d = new DadosAluno();
            Aluno a = new Aluno();
            a.setMatricula(3);
            a.setNome("melo professor");
            d.cadastrarAluno(a);
            JOptionPane.showMessageDialog(null, "Cadastrou");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }*/
    }

}
