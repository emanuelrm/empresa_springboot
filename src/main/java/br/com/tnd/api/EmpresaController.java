package br.com.tnd.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping(value = "/listarTodas")
    public List<Empresa> listarTodasEmpresas() {
        return empresaService.listarTodasEmpresas();
    }

    @GetMapping(value="/listar")
    public Empresa exemplo(@PathVariable("razaoSocial") String razaoSocial) {
        return empresaService.getEmpresaPorRazaoSocial(razaoSocial);
    }

    @PostMapping
    public ResponseEntity<Empresa> cadastrar(@RequestBody EmpresaDto empresaDto) {
        return empresaService.cadastrarEmpresa(empresaDto);
    }
}
