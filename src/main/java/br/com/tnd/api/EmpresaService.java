package br.com.tnd.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa getEmpresaPorRazaoSocial(String razaoSocial) {
        return empresaRepository.findByRazaoSocial(razaoSocial);
    }

    public ResponseEntity<Empresa> cadastrarEmpresa(EmpresaDto empresaDto) {
        Empresa empresa = new Empresa(empresaDto.getCnpj(), empresaDto.getRazaoSocial());
        Empresa empresaBD = empresaRepository.save(empresa);
        return ResponseEntity.ok(empresaBD);
    }

    public List<Empresa> listarTodasEmpresas() {
        return empresaRepository.findAll();
    }
}
