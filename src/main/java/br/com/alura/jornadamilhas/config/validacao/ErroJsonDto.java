package br.com.alura.jornadamilhas.config.validacao;

public class ErroJsonDto {

    private Long codigo;
    private String campo;
    private String erro;

    public ErroJsonDto(Long codigo, String campo, String erro) {
        this.codigo = codigo;
        this.campo = campo;
        this.erro = erro;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
