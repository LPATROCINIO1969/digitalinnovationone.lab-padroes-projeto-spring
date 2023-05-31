package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Interface que define que vincula a pesquisa do CEP a uma determinada URL responsável por
 * validar o CEP e retornar o endereço.
 * @author VENILTON FALVO JR.
 * @version 1.0
 */
@FeignClient(name="viacep",url="viacep.com.br/ws")
public interface ViaCepService {
    @RequestMapping(method = RequestMethod.GET,value="/{cep}/json")
    Endereco consultar(@PathVariable("cep") String cep);
}
