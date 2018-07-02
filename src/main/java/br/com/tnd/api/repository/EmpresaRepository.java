package br.com.tnd.api.repository;

import br.com.tnd.api.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Empresa findByRazaoSocial(String razaoSocial);

}
