package br.com.tnd.api.service;

import br.com.tnd.api.domain.Empresa;
import br.com.tnd.api.domain.EmpresaDto;
import br.com.tnd.api.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<Empresa> alterarEmpresa(long id, EmpresaDto empresaDto) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        empresa.get().setCnpj(empresaDto.getCnpj());
        empresa.get().setRazaoSocial(empresaDto.getRazaoSocial());

        Empresa empresaBD = empresaRepository.save(empresa.get());
        return ResponseEntity.ok(empresaBD);
    }

    public List<Empresa> listarTodasEmpresas() {
        return empresaRepository.findAll();
    }

    public void deletarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
