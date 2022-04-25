package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Receita {

    private final List<Ingrediente> Ingredientes = new ArrayList<>();

    private static final List<Receita> listaReceita = new ArrayList<>();

    private final String modoPreparos;

    private final int codigo;
    private final String descricao;
    private final double preco;

    @Override
    public String toString() {
        return "Receita{" +
                "Ingredientes=" + Ingredientes +
                ", modoPreparos='" + modoPreparos + '\'' +
                ", codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

    public Receita(int codigo, String descricao, double preco, String modoPreparo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.modoPreparos = modoPreparo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getModoPreparos() {
        return modoPreparos;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        Ingredientes.add(ingrediente);
    }

    public List<Ingrediente> getIngredientes() {
        return Ingredientes;
    }

    public static Optional<Receita> getReceita(int codigo) {
        return listaReceita.stream().filter(i -> i.getCodigo() == codigo).findAny();
    }

    public static List<String> getListaDescricao() {

        return listaReceita.stream()
                .map(r -> "(" + r.getCodigo() + ") " + r.descricao)
                .collect(Collectors.toList());
    }

    public static int getCodigoMenuAgua(){
        int codigo = 0;
        for (Receita receita: listaReceita
        ) {
            if (receita.getDescricao().contains("Agua quente")) {
                codigo = receita.getCodigo();
            }
        }
        return  codigo;
    }

    public static void carregarReceita() {
        addReceita();

    }

    public static int getQuantidade() {
        return listaReceita.size();
    }

    static void addReceita() {
        ModoPreparo.addModoPreparo();

        Receita cafe = new Receita(1, "Cafe", 0.50, ModoPreparo.getModoPreparo(1));
        cafe.addIngrediente(new Ingrediente(1, 50));
        cafe.addIngrediente(new Ingrediente(2, 5));
        cafe.addIngrediente(new Ingrediente(3, 1));
        cafe.addIngrediente(new Ingrediente(7, 1));

        Receita cafeComLeite = new Receita(2, "Cafe com leite", 1.0, ModoPreparo.getModoPreparo(2));
        cafeComLeite.addIngrediente(new Ingrediente(1, 50));
        cafeComLeite.addIngrediente(new Ingrediente(2, 7));
        cafeComLeite.addIngrediente(new Ingrediente(3, 1));
        cafeComLeite.addIngrediente(new Ingrediente(4, 8));
        cafeComLeite.addIngrediente(new Ingrediente(7, 1));

        Receita capuccino = new Receita(3, "Capuccino", 1.50, ModoPreparo.getModoPreparo(3));
        capuccino.addIngrediente(new Ingrediente(1, 50));
        capuccino.addIngrediente(new Ingrediente(2, 5));
        capuccino.addIngrediente(new Ingrediente(3, 1));
        capuccino.addIngrediente(new Ingrediente(4, 5));
        capuccino.addIngrediente(new Ingrediente(7, 1));

        Receita cha = new Receita(4, "Cha de limao", 1.0, ModoPreparo.getModoPreparo(4));
        cha.addIngrediente(new Ingrediente(1, 50));
        cha.addIngrediente(new Ingrediente(3, 5));
        cha.addIngrediente(new Ingrediente(6, 1));
        cha.addIngrediente(new Ingrediente(7, 1));

        Receita aguaQuente = new Receita(5, "Agua quente", 0, ModoPreparo.getModoPreparo(5));
        aguaQuente.addIngrediente(new Ingrediente(1, 50));
        aguaQuente.addIngrediente(new Ingrediente(7, 1));

        Receita.listaReceita.add(cafe);
        Receita.listaReceita.add(cafeComLeite);
        Receita.listaReceita.add(capuccino);
        Receita.listaReceita.add(cha);
        Receita.listaReceita.add(aguaQuente);

    }


    record ModoPreparo(int codigo, String descricao) {

        public static List<ModoPreparo> modoPreparos = new ArrayList<>();

        @Override
        public String toString() {
            return "ModoPreparo{" +
                    "codigo=" + codigo +
                    ", descricao='" + descricao + '\'' +
                    '}';
        }

        static void addModoPreparo() {

            ModoPreparo cafe = new ModoPreparo(1, """
                    Adicionando filtro
                    Fervendo agua
                    Miturando agua fervida ao po de cafe
                    Despejando cafe no copo
                    """);

            ModoPreparo cafeComLeite = new ModoPreparo(2, """
                    Adicionando filtro
                    Fervendo agua
                    Miturando agua fervida ao po de cafe
                    Adicionando leite em po
                    Misturando produtos
                    Despejando cafe com leite no copo
                    """);

            ModoPreparo capuccino = new ModoPreparo(3, """
                    Adicionando filtro
                    Fervendo agua
                    Miturando agua fervida ao po de cafe
                    Adicionando leite em po
                    Adicionando chocolate me po
                    Misturando produtos
                    Despejando capuccino no copo
                    """);

            ModoPreparo chaDeLimao = new ModoPreparo(4, """
                    Fervendo agua
                    Miturando agua fervida ao cha
                    Despejando cha de limao no copo
                    """);

            ModoPreparo aguaQuente = new ModoPreparo(5, """
                    Fervendo agua
                    Despejando agua no copo
                    """);

            modoPreparos.add(cafe);
            modoPreparos.add(cafeComLeite);
            modoPreparos.add(capuccino);
            modoPreparos.add(chaDeLimao);
            modoPreparos.add(aguaQuente);

        }

        public static String getModoPreparo(int codigo) {

            return modoPreparos.stream()
                    .filter(p -> p.codigo() == codigo)
                    .map(ModoPreparo::descricao)
                    .findAny().orElse("");

        }
    }

}