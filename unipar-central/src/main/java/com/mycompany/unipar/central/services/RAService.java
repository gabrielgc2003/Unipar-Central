package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.ValorInformadoRAException;
import com.mycompany.unipar.central.models.AbstractAcademico;
import com.mycompany.unipar.central.utils.db.ValidadorCampoNumerico;

public class RAService extends AbstractAcademico {

    public void validarRA(String ra) throws CampoLimiteTamanhoException, ValorInformadoRAException {
        if (ra == null || ra.isEmpty()) {
            throw new ValorInformadoRAException(ra, "RA");
        }

        if (ra.length() > 8) {
            throw new CampoLimiteTamanhoException("RA", "8");
        }

        if (!ValidadorCampoNumerico.isCampoNumericoValido(ra)) {
            throw new ValorInformadoRAException(ra, "RA");
        }
    }
}
