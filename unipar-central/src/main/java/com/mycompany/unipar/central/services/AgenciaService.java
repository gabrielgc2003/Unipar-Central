package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.*;
import com.mycompany.unipar.central.models.Agencia;
import com.mycompany.unipar.central.repositories.AgenciaDAO;
import com.mycompany.unipar.central.repositories.BancoDAO;
import com.mycompany.unipar.central.utils.db.ValidadorCampoNumerico;

import java.sql.SQLException;
import java.util.List;

public class AgenciaService {

    private RAService raService;

    public void RAService(){
        this.raService = new RAService();
    }

    public void validar (Agencia agencia) throws CampoNaoInformadoException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, CampoNumericoInvalidoException, SQLException, NaoExisteDatabaseException, ValorInformadoException, ValorInformadoRAException {

        raService.validarRA(agencia.getRa());

        if (agencia == null){
            throw new EntidadeNaoInformadaException("agencia");
        }
        if (agencia.getId() <= 0){
            throw new ValorInformadoException(agencia.getId(), "Agencia");
        }
        if(!ValidadorCampoNumerico.isCampoNumericoValido(agencia.getCodigo())){
            throw new CampoNumericoInvalidoException("agencia(codigo)");
        }
        if(agencia.getCodigo() == null ||
                agencia.getCodigo().isEmpty() ||
                agencia.getCodigo().isBlank()){
            throw new CampoNaoInformadoException("agencia(Codigo)");
        }
        if (agencia.getCodigo().length() > 10){
            throw new CampoLimiteTamanhoException("agencia(Codigo)", "10");
        }
        if(!ValidadorCampoNumerico.isCampoNumericoValido(agencia.getDigito())){
            throw new CampoNumericoInvalidoException("agencia(digito))");
        }
        if(agencia.getDigito() == null ||
                agencia.getCodigo().isEmpty() ||
                agencia.getCodigo().isBlank()){
            throw new CampoNaoInformadoException(("agencia(Digito)"));
        }
        if (agencia.getDigito().length() > 2){
            throw new CampoLimiteTamanhoException("agencia(Digito)", "2");
        }
        if(!ValidadorCampoNumerico.isCampoNumericoValido(agencia.getRazaoSocial())){
            throw new CampoNumericoInvalidoException("agencia(RazaoSocial)");
        }
        if(agencia.getRazaoSocial() == null ||
                agencia.getRazaoSocial().isEmpty() ||
                agencia.getRazaoSocial().isBlank()){
            throw new CampoNaoInformadoException(("agencia(RazaoSocial)"));
        }
        if (agencia.getRazaoSocial().length() > 120){
            throw new CampoLimiteTamanhoException("agencia(RazaoSocial)", "120");
        }
        if(!ValidadorCampoNumerico.isCampoNumericoValido(agencia.getCnpj())){
            throw new CampoNumericoInvalidoException("agencia(CPNJ)");
        }
        if(agencia.getCnpj() == null ||
                agencia.getCnpj().isEmpty() ||
                agencia.getCnpj().isBlank()){
            throw new CampoNaoInformadoException(("agencia(CPNJ)"));
        }
        if (agencia.getCnpj().length() > 20){
            throw new CampoLimiteTamanhoException("agencia(CPNJ)", "20");
        }
        if(agencia.getCnpj() == null ||
                agencia.getCnpj().isEmpty() ||
                agencia.getCnpj().isBlank()){
            throw new CampoNaoInformadoException(("agencia(RA)"));
        }
        if (agencia.getCnpj().length() > 8){
            throw new CampoLimiteTamanhoException("agencia(RA)", "8");
        }

    }

    public void insert(Agencia agencia, int idBanco) throws Exception{
        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.insert(agencia, idBanco);
    }

    public void update(Agencia agencia, int idBanco) throws Exception{
        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        Agencia agenciaExistente = agenciaDAO.FIND_BY_ID(agencia.getId());
        if (agenciaExistente == null) {
            throw new NaoExisteDatabaseException("ID", "Banco");
        }
        agenciaDAO.update(agencia, idBanco);
    }

    public void delete(int id) throws Exception{
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        Agencia agenciaExistente = agenciaDAO.FIND_BY_ID(id);
        if (agenciaExistente == null) {
            throw new NaoExisteDatabaseException("ID", "Agencia");
        }
        agenciaDAO.delete(id);
    }

    public List<Agencia> findAll() throws SQLException, FindRetornadoException {
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        List<Agencia> listaAgencia = agenciaDAO.FIND_ALL();
        if (listaAgencia.isEmpty()){
            throw new FindRetornadoException("Agencia");
        }
        return listaAgencia;
    }

    public Agencia findById(int id) throws Exception{
        if(id <= 0)
            throw  new CampoLimiteTamanhoException("id","1");
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        Agencia retorno = agenciaDAO.FIND_BY_ID(id);

        if (retorno == null){
            throw new FindRetornadoException("Agencia");
        }
        return retorno;
    }

    public int findExiste (int id) throws Exception {
        if(id <= 0)
            throw  new CampoLimiteTamanhoException("id","1");
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        int count = agenciaDAO.findExiste(id);
        return count;
    }

}
