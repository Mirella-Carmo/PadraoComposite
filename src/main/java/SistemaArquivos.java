public class SistemaArquivos {

    private Pasta raiz;

    public SistemaArquivos(Pasta raiz) {
        this.raiz = raiz;
    }

    public String getEstrutura() {
        return raiz.getEstrutura();
    }
}