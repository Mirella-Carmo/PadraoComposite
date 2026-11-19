import java.util.ArrayList;
import java.util.List;

public class Pasta extends ItemSistema{
    private List<ItemSistema> itens;

    public Pasta(String nome){
        super(nome);
        this.itens = new ArrayList<>();
    }

    public void adicionar(ItemSistema item){
        itens.add(item);
    }

    @Override
    public String getEstrutura(){
        String estrutura = "Pasta: " + getNome();

        for (ItemSistema item : itens) {
            estrutura += "\n  " + item.getEstrutura();
        }

        return estrutura;
    }
}
