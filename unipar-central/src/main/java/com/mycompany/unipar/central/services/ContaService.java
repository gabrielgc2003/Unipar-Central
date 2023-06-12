package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.Conta;
import com.mycompany.unipar.central.repositories.ContaDAO;

import java.sql.SQLException;
import java.util.List;

public class ContaService {

    public void validar(Conta conta) throws EntidadeNaoInformadaException, CampoNaoInformadoException,
            CampoLimiteTamanhoException {
        if (conta == null) {
            throw new EntidadeNaoInformadaException("Conta");
        }
        if (conta.getNumero() == null || conta.getNumero().isEmpty() || conta.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("Conta(Numero)");
        }
        if (conta.getNumero().length() > 120) {
            throw new CampoLimiteTamanhoException("Conta(Numero)", "120");
        }
    }

    public List<Conta> listarContas() throws SQLException {
        try {
            ContaDAO contaDAO = new ContaDAO();
            return contaDAO.findAll();
        } catch (SQLException e) {
            throw new SQLException("Erro ao listar contas: " + e.getMessage());
        }
    }

    public Conta buscarContaPorId(int id) throws SQLException {
        try {
             ContaDAO contaDAO = new ContaDAO();
            Conta conta = contaDAO.findById(id);
            if (conta == null) {
                throw new IllegalArgumentException("Conta não encontrada");
            }
            return conta;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar conta por ID: " + e.getMessage());
        }
    }

    public void criarConta(Conta conta) throws SQLException {
        try {
             ContaDAO contaDAO = new ContaDAO();
            contaDAO.insert(conta);
        } catch (SQLException e) {
            throw new SQLException("Erro ao criar conta: " + e.getMessage());
        }
    }

    public void atualizarConta(Conta conta) throws SQLException {
        try {
            ContaDAO contaDAO = new ContaDAO();
            Conta contaExistente = contaDAO.findById(conta.getId());
            if (contaExistente == null) {
                throw new IllegalArgumentException("Conta não encontrada");
            }
            contaDAO.update(conta);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar conta: " + e.getMessage());
        }
    }

    public void excluirConta(int id) throws SQLException {
        try {
             ContaDAO contaDAO = new ContaDAO();
            Conta contaExistente = contaDAO.findById(id);
            if (contaExistente == null) {
                throw new IllegalArgumentException("Conta não encontrada");
            }
            contaDAO.delete(id);
        } catch (SQLException e) {
            throw new SQLException("Erro ao excluir conta: " + e.getMessage());
        }
    }
}
