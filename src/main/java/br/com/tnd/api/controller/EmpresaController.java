package br.com.tnd.api.controller;

import br.com.tnd.api.domain.Empresa;
import br.com.tnd.api.domain.EmpresaDto;
import br.com.tnd.api.domain.Fornecedor;
import br.com.tnd.api.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping(value = "/listartodas")
    public List<Empresa> listarTodasEmpresas() {
        return empresaService.listarTodasEmpresas();
    }

    @GetMapping(value="/listar/{razaoSocial}")
    public Empresa exemplo(@PathVariable("razaoSocial") String razaoSocial) {
        return empresaService.getEmpresaPorRazaoSocial(razaoSocial);
    }

    @PostMapping
    public ResponseEntity<Empresa> cadastrar(@RequestBody EmpresaDto empresaDto) {
        return empresaService.cadastrarEmpresa(empresaDto);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Empresa> alterar(@PathVariable("id") long id, @RequestBody EmpresaDto empresaDto) {
        return empresaService.alterarEmpresa(id, empresaDto);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        empresaService.deletarEmpresa(id);
    }

    @GetMapping(value="/listarFornecedores/{razaoSocial}")
    public ResponseEntity<List<Fornecedor>> listarFornecedores(@PathVariable("razaoSocial") String razaoSocial) {
        return empresaService.getFornecedoresEmpresa(razaoSocial);
    }

    @GetMapping(value="/listarFornecedores")
    public ResponseEntity<List<Fornecedor>> listarFornecedores() {
        return empresaService.getFornecedores();
    }
}
