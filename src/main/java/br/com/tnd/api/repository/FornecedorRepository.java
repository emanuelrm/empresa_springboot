package br.com.tnd.api.repository;

import br.com.tnd.api.domain.Empresa;
import br.com.tnd.api.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    Fornecedor findByNome(String nome);

    List<Fornecedor> findFornecedoresByEmpresa(Empresa empresa);
}
