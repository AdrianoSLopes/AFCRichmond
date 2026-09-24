public class SocioTorcedor {

    private String id;
    private String nome;
    private String Cpf;
    private String email;
    private String telefone;
    private String dataNascimento;
    private String dataCadastro;
    private String plano;
    private StatusTorcedor status;

    public SocioTorcedor() {
        this.status = StatusTorcedor.ATIVO;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public StatusTorcedor getStatus() {
        return status;
    }

    public void setStatus(StatusTorcedor status) {
        this.status = status;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    @Override
    public String toString(){
        return "Nome: " + getNome() +
                "\nCpf: " + getCpf() +
                "\nEmail: " + getEmail() +
                "\nTelefone: " + getTelefone() +
                "\nData de nascimento: " + getDataNascimento()+
                "\nPlano de socio: " + getPlano();
    }

}
