package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Classe da camada "control" responsável por integrar o sistema, ordenando as diversas ações, fornecendo uma interface unificada
 * para mapear os diversos serviços solicitados a aplicação, relativas a manutenção dos "clientes".
 * Esta classe encontra-se no padrão de projeto "Facade".
 * Realiza essa atividade utilizando um objeto da classe ClienteService por injeção de dependência (inversão de controle), convertido
 * em um padrão de projeto "Singleton" pela annotation @autowired.
 *
 * @author VENILTON FALVO JR.
 * @version 1.0
 */
@RestController
@RequestMapping("clientes")
public class ClientRestController {
    @Autowired
    private ClienteService clienteService;

    /**
     * Realiza o mapeamento da solicitação do cliente tipo GET e direciona a solicitação para listar todos os clientes presentes no banco de dados.
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarTodos());
//        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    /**
     * Realiza o mapeamento da solicitação do cliente tipo GET acompanhada pelo Id do cliente e direciona a solicitação para
     * retornar um cliente específico do banco de dados.
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorId(id));
//        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    /**
     * Realiza o mapeamento da solicitação do cliente tipo POST acompanhada pelo dados do cliente em forma JSON e
     * direciona a solicitação para o banco de dados.
     * @param cliente Cliente
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<String> inserir(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente " + cliente.getNome() + " salvo!");
//                .body("clienteService.buscarTodos()");
//        return ResponseEntity.ok(cliente);
    }

    /**
     * Realiza o mapeamento da solicitação do cliente tipo PUT acompanhada pelo Id do cliente e dados a serem atualizados
     * na forma JSON, e direciona a solicitação para o banco de dados.
     * @param id Long
     * @param cliente Cliente
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.atualizar(id, cliente);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente " + cliente.getNome() + " atualizado!");
//        return ResponseEntity.ok(cliente);
    }

    /**
     * Realiza o mapeamento da solicitação do cliente tipo DELETE acompanhada pelo Id do cliente
     * e direciona a solicitação para exclusão do cliente no banco de dados.
     * @param id Long
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente " + id + " excluído!");
//        return ResponseEntity.ok().build();
    }


}
