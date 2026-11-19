public class Arquivo extends ItemSistema{
    private String extensao;

    public Arquivo(String nome, String extensao){
        super(nome);
        this.extensao = extensao;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    @Override
    public String getEstrutura(){
        return "Arquivo " + getNome() + "." + extensao;
    }
}
