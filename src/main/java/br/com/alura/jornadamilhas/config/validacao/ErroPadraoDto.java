package br.com.alura.jornadamilhas.config.validacao;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class ErroPadraoDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Instant dataHora;
    private Integer status;
    private String erro;
    private String mensagem;
    private String caminho;

    public ErroPadraoDto() {
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

}
