public abstract class ItemSistema {
    private String nome;

    public ItemSistema(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public abstract String getEstrutura();
}
