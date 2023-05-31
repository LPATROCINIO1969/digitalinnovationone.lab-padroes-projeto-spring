package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.repository.ClienteRepository;
import one.digitalinnovation.gof.repository.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Classe responsável por implementar a interface Cliente no domínio "Service". Estabelece as regras de negócio
 * relativas a inserção, exclusão, alteração e consulta aos dados do cliente.
 * Realiza essas atividades através da injeção de dependência de objetos da classe ClienteRepository e EndereoRepository
 * definidos como classes no padrão Singleton pela annotation @Autowired.
 *
 * @author VENILTON FALVO JR.
 * @version 1.0
 *
 */

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    /**
     * Ordena uma consulta ao banco de dados, retornando a listagem completa de clientes (sem restrição).
     * @return Iterable - Lista de clientes
     */
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    /**
     * Ordena uma consulta ao banco de dados, retornando o cliente pelo seu ID.
     * @param id Long
     * @return Cliente
     */
    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    /**
     * Ordena a inserção de um novo cliente no banco de dados.
     * @param cliente Cliente
     *
     */
    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    /**
     * Ordena uma gravação de um cliente no banco de dados para nova inclusão ou atualização.
     * @param cliente Cliente
     *
     */
    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep)
                .orElseGet(
                        () -> {
                            Endereco novoEndereco = viaCepService.consultar(cep);
                            enderecoRepository.save(novoEndereco);
                            return novoEndereco;
                        }
                );
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    /**
     * Ordena uma atualização dos dados de um cliente antigo no banco de dados.
     * @param id Long
     * @param cliente Cliente
     *
     */
    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            cliente.setId(clienteBd.get().getId());
            salvarClienteComCep(cliente);
        }
    }

    /**
     * Ordena a exclusão de um cliente do banco de dados.
     * @param id Long
     *
     */
    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
