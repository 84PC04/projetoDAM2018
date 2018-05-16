/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaojdbc2018.aluno;

import conexaojdbc2018.conexao.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class DadosAluno extends Dados {

    public void cadastrarAluno(Aluno a) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO aluno (matricula, nome) ";
        sql += " VALUES (?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, a.getMatricula());
        preparedStatement.setString(2, a.getNome());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

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

    public ArrayList<Aluno> listar(Aluno filtro) throws Exception {
        ArrayList<Aluno> retorno = new ArrayList<>();

        int pos = 1;
        //instrução sql correspondente a inserção do aluno
        String sql = " select a.matricula, a.nome ";
        sql += " from aluno as a ";
        sql += " where a.matricula = a.matricula ";
        if (filtro.getMatricula() > 0) {
            sql += " and a.matricula = ? ";
        }
        if (filtro.getNome()!= null && filtro.getNome().trim().equals("") == false) {
            sql += " and a.nome like ? ";
        }
        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);

        if (filtro.getMatricula() > 0) {
            preparedStatement.setInt(pos, filtro.getMatricula());
            pos++;
        }
        if (filtro.getNome()!= null && filtro.getNome().trim().equals("") == false) {
            preparedStatement.setString(pos,"%" +filtro.getNome() + "%");
            pos++;
        }
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Aluno a = new Aluno();
            a.setMatricula(leitor.getInt("matricula"));
            a.setNome(leitor.getString("nome"));
            retorno.add(a);
        }
        //fechando a conexão com o banco de dados
        desconectar();
        return retorno;
    }
}
