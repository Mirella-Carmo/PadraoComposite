import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaArquivosTest {

    @Test
    public void deveRetornarEstruturaDoArquivo() {

        Arquivo arquivo = new Arquivo("Relatorio", "pdf");

        assertEquals("Arquivo Relatorio.pdf", arquivo.getEstrutura());
    }

    @Test
    public void deveRetornarEstruturaDaPastaVazia() {

        Pasta pasta = new Pasta("Documentos");

        assertEquals("Pasta: Documentos", pasta.getEstrutura());
    }

    @Test
    public void deveAdicionarArquivoNaPasta() {

        Pasta pasta = new Pasta("Documentos");

        Arquivo arquivo = new Arquivo("Relatorio", "pdf");

        pasta.adicionar(arquivo);

        String estrutura = "Pasta: Documentos"
                + "\n  Arquivo Relatorio.pdf";

        assertEquals(estrutura, pasta.getEstrutura());
    }

    @Test
    public void deveAdicionarVariosArquivosNaPasta() {

        Pasta pasta = new Pasta("Documentos");

        Arquivo relatorio = new Arquivo("Relatorio", "pdf");
        Arquivo planilha = new Arquivo("Planilha", "xlsx");

        pasta.adicionar(relatorio);
        pasta.adicionar(planilha);

        String estrutura = "Pasta: Documentos"
                + "\n  Arquivo Relatorio.pdf"
                + "\n  Arquivo Planilha.xlsx";

        assertEquals(estrutura, pasta.getEstrutura());
    }

    @Test
    public void deveAdicionarUmaPastaDentroDeOutra() {

        Pasta documentos = new Pasta("Documentos");
        Pasta faculdade = new Pasta("Faculdade");

        Arquivo trabalho = new Arquivo("Trabalho", "docx");

        faculdade.adicionar(trabalho);
        documentos.adicionar(faculdade);

        String estrutura = "Pasta: Documentos"
                + "\n  Pasta: Faculdade"
                + "\n  Arquivo Trabalho.docx";

        assertEquals(estrutura, documentos.getEstrutura());
    }

    @Test
    public void deveRetornarEstruturaCompletaDoSistema() {

        Pasta documentos = new Pasta("Documentos");

        Arquivo relatorio = new Arquivo("Relatorio", "pdf");
        Arquivo planilha = new Arquivo("Planilha", "xlsx");

        Pasta faculdade = new Pasta("Faculdade");

        Arquivo trabalho = new Arquivo("Trabalho", "docx");

        Pasta projetos = new Pasta("Projetos");

        Arquivo codigo = new Arquivo("Composite", "java");

        projetos.adicionar(codigo);
        faculdade.adicionar(trabalho);
        faculdade.adicionar(projetos);

        documentos.adicionar(relatorio);
        documentos.adicionar(planilha);
        documentos.adicionar(faculdade);

        SistemaArquivos sistema = new SistemaArquivos(documentos);

        String estrutura = "Pasta: Documentos"
                + "\n  Arquivo Relatorio.pdf"
                + "\n  Arquivo Planilha.xlsx"
                + "\n  Pasta: Faculdade"
                + "\n  Arquivo Trabalho.docx"
                + "\n  Pasta: Projetos"
                + "\n  Arquivo Composite.java";

        assertEquals(estrutura, sistema.getEstrutura());
    }
}