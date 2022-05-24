package br.com.hugoogle.util;

import br.com.hugoogle.model.ModoDePreparo;

import java.util.ArrayList;
import java.util.List;

public class PopularModoDePreparo {
    private static final List<ModoDePreparo> modoPreparos = new ArrayList<>();

    public static void criarModoDePreparo() {
        ModoDePreparo cafe = new ModoDePreparo("Cafe", """
                Adicionando filtro
                Fervendo agua
                Miturando agua fervida ao po de cafe
                Despejando cafe no copo
                """);

        ModoDePreparo cafeComLeite = new ModoDePreparo("CafeComLeite", """
                Adicionando filtro
                Fervendo agua
                Miturando agua fervida ao po de cafe
                Adicionando leite em po
                Misturando produtos
                Despejando cafe com leite no copo
                """);

        ModoDePreparo capuccino = new ModoDePreparo("Capuccino", """
                Adicionando filtro
                Fervendo agua
                Miturando agua fervida ao po de cafe
                Adicionando leite em po
                Adicionando chocolate me po
                Misturando produtos
                Despejando capuccino no copo
                """);

        ModoDePreparo chaDeLimao = new ModoDePreparo("ChaDeLimao", """
                Fervendo agua
                Miturando agua fervida ao cha
                Despejando cha de limao no copo
                """);

        ModoDePreparo aguaQuente = new ModoDePreparo("AguaQuente", """
                Fervendo agua
                Despejando agua no copo
                """);

        modoPreparos.add(cafe);
        modoPreparos.add(cafeComLeite);
        modoPreparos.add(capuccino);
        modoPreparos.add(chaDeLimao);
        modoPreparos.add(aguaQuente);

    }

    public static String getModoPreparo(String descricao) {
        return modoPreparos.stream()
                .filter(p -> p.getDescricao().equals(descricao) )
                .map(ModoDePreparo::getModo)
                .findAny().orElse("") ;
    }

}
