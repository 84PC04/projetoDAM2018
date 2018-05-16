/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaojdbc2018.nota;


import conexaojdbc2018.conexao.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */

/*
create table nota(
    codigo serial primary key,
    prova varchar(20) not null,
    nota numeric(4,2) not null check (nota >= 0 and nota <= 10),
    matricula_aluno int not null references aluno(matricula)
);

select codigo, prova, nota, matricula_aluno,
nome
from nota inner join aluno 
on (aluno.matricula = nota.matricula_aluno)
*/
public class DadosNota extends Dados {

    public void cadastrarNota(Nota n) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO nota(disciplina_nota, nota, aluno_nota) ";
        sql += " VALUES (?, ?, ?)";
        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        //preparedStatement.setInt(1, n.getId_Nota());
        preparedStatement.setString(1, n.getProva());
        preparedStatement.setFloat(2, n.getNota());
        preparedStatement.setInt(3, n.getAluno().getMatricula());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }
    
    public ArrayList<Nota> listar(NotaFiltro filtro) throws Exception {
        ArrayList<Nota> retorno = new ArrayList<>();

        int pos = 1;
        //instrução sql correspondente a inserção do aluno
        String sql = " select codigo, disciplina_nota, nota, aluno_nota, nome ";
        sql += " from nota inner join aluno  ";
        sql += " on (aluno.matricula = nota.aluno_nota)  ";
        sql += "  where codigo > 0 ";
        if (filtro.getAluno().getMatricula() > 0) {
            sql += " and matricula_aluno = ? ";
        }
        if (filtro.getNota() > 0) {
            sql += " and nota = ? ";
        }
        if (filtro.getNotaInicio() >= 0 && filtro.getNotaInicio() <= 10) {
            sql += " and ( nota >= ? and nota <= ? )";
        }
        /*if (filtro.getNome()!= null && filtro.getNome().trim().equals("") == false) {
            sql += " and a.nome like ? ";
        }*/
        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);

        if (filtro.getAluno().getMatricula() > 0) {
            preparedStatement.setInt(pos, filtro.getAluno().getMatricula());
            pos++;
        }
        if (filtro.getNota() > 0) {
            preparedStatement.setFloat(pos, filtro.getNota());
            pos++;
        }
        if (filtro.getNotaInicio() >= 0 && filtro.getNotaInicio() <= 10) {
            preparedStatement.setFloat(pos, filtro.getNotaInicio());
            pos++;
            preparedStatement.setFloat(pos, filtro.getNotaFim());
            pos++;
        }
        /*
        if (filtro.getNome()!= null && filtro.getNome().trim().equals("") == false) {
            preparedStatement.setString(pos,"%" +filtro.getNome() + "%");
            pos++;
        }*/
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Nota a = new Nota();
            //codigo, prova, nota, matricula_aluno,nome
            a.setCodigo(leitor.getInt("id_nota"));
            a.setProva(leitor.getString("disciplina_nota"));
            a.setNota(leitor.getFloat("nota"));
            a.getAluno().setMatricula(leitor.getInt("aluno_nota"));
            //a.getAluno().setNome(leitor.getString("nome"));
            retorno.add(a);
        }
        //fechando a conexão com o banco de dados
        desconectar();
        return retorno;
    }
/*
    public void removerAluno(Aluno a) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "DELETE FROM aluno WHERE matricula = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, a.getMatricula());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    public void atualizarAluno(Aluno a) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "UPDATE aluno SET nome = ? WHERE matricula = ? ";
        //preparando a instrução

        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, a.getNome());
        preparedStatement.setInt(2, a.getMatricula());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    
    */
}
