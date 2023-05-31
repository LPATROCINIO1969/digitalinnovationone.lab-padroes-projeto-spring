package one.digitalinnovation.gof.model;

import jakarta.persistence.*;


/**Esta classe faz parte da camada Model e é responsável por organizar os dados de cada cliente.
 * @author VENILTON FALVO JR.
 * @version  1.0
 *
 */

@Entity
@Table(name="Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    private Endereco endereco;

    /**Método que retorna o valor do ID (identificador único) do cliente
     *
     * @return Long Int - valor do ID
     */
    public Long getId() {
        return id;
    }

    /**Estabelece o valor do ID do cliente
     *
     * @param id Long Int
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**Método que retorna o nome do cliente
     *
     * @return String com 50 caracteres - nome
     */
    public String getNome() {
        return nome;
    }

    /**Instancia o nome do cliente
     *
     * @param nome String(50)
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**Método que retorna um objeto do tipo Endereço
     *
     * @return Endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**Instancia o endereço do Cliente
     *
     * @param endereco classe Endereço
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
