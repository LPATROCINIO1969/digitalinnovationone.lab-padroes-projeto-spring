package one.digitalinnovation.gof.repository;

import one.digitalinnovation.gof.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**Interface para mediação das ações entre o banco de dados e a aplicação. Responsável pela manutenção
 * dos dados do ENDEREÇO junto ao banco de dados.
 * Representa o padrão de projeto "Strategy" no qual o comportamento genérico aqui estabelecido é vinculado a
 * toda classe que implementar essa interface.
 * @author VENILTON FALVO JR.
 * @version 1.0
 */
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco,String> {
}
