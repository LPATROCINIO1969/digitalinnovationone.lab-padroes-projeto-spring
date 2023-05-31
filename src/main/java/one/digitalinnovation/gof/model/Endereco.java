package one.digitalinnovation.gof.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**Esta classe faz parte da camada Model (manipulação de dados) e é responsável por organizar as informações/dados que descrevem um endereço (cep, rua, bairro, cidade, etc.).
 *
 * @author VENILTON FALVO JR.
 * @version 1.0
 *
 */

@Entity
@Table(name="Endereco")
public class Endereco {
    @Id
    private String cep;

    @Column(nullable = false)
    private String logradouro;


    private String complemento;

    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String localidade;
    @Column(nullable = false)
    private String uf;
    private String ibge;
    private String gia;
    @Column(nullable = false)
    private String ddd;
    private String siafi;


    /**Método para retorno do CEP
     * @return String - valor do CEP
     */
    public String getCep() {
        return cep;
    }

    /**Instancia o valor do CEP no endereço atual
     * @param cep - String com 11 caracteres
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**Método para retorno do LOGRADOURO
     * @return String - valor do LOGRADOURO
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**Instancia o valor do LOGRADOURO no endereço atual
     * @param logradouro - String com 50 caracteres
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**Método para retorno do COMPLEMENTO do endereco
     * @return String - valor do COMPLEMENTO
     */
    public String getComplemento() {
        return complemento;
    }

    /**Instancia o COMPLEMENTO do endereço atual
     * @param complemento - String com 30 caracteres
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**Método para retorno do BAIRRO
     * @return String - valor do BAIRRO
     */
    public String getBairro() {
        return bairro;
    }

    /**Instancia o nome do BAIRRO do endereço atual
     * @param bairro - String com 30 caracteres
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**Método para retorno do LOCALIDADE = CIDADE
     * @return String - valor do LOCALIDADE
     */
    public String getLocalidade() {
        return localidade;
    }


    /**Instacia o nome da LOCALIDADE no endereço atual
     * @param localidade - String com 30 caracteres
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**Método para retorno do UF = unidade da federação
     * @return String - valor do UF
     */
    public String getUf() {
        return uf;
    }

    /**Instancia a sigla da unidade da federação (UF)
     * @param uf - String com 2 caracteres
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**Método para retorno do IBGE = registro no IBGE
     * @return String - valor do IBGE
     */
    public String getIbge() {
        return ibge;
    }

    /**Instancia o código do endereço no IBGE
     * @param ibge - String
     */
    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    /**Método para retorno do GIA = guia nacional de informação e apuração do ICMS
     * @return String - valor do GIA
     */
    public String getGia() {
        return gia;
    }

    /**Instancia o código GIA do endereço
     * @param gia - String
     */
    public void setGia(String gia) {
        this.gia = gia;
    }

    /**Método para retorno do DDD (telefonia)
     * @return String - valor do DDD
     */
    public String getDdd() {
        return ddd;
    }

    /**Instancia o código DDD da área do endereço atual
     * @param ddd - String com 2 caracteres
     */
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    /**Método para retorno do SIAFI = registro no tesouro nacional
     * @return String - valor do SIAFI
     */
    public String getSiafi() {
        return siafi;
    }

    /**Instancia o código SIAFI para o endereço atual
     *
     * @param siafi - String
     */
    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }
}
