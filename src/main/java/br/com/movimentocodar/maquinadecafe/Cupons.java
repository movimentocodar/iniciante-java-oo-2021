package br.com.movimentocodar.maquinadecafe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Cupons {
    private Map<String, Cupom> mapCupons = new HashMap<>();
    String codigo;
    Cupom cupom;

    public Cupons(){}

    public void addCupom(String codigo, Cupom cupom){
        this.mapCupons.put(codigo, cupom);
    }

    public Cupom encontrarCupom(String codigo){
        return (Cupom)this.mapCupons.get(codigo);
    }

    @Override
    public String toString(){
        return "Esse cupom é " + codigo + ", no valor de: " + Pagamento.moedaEmReais(cupom.getValor()) + ", válido até: " + cupom.getValidade() + "." ;
    }

    /*public void lerJSON() throws IOException {

       JsonElement root = new JsonParser().parse(new FileReader("target/cupom.json"));
       JsonObject object = root.getAsJsonObject();
       Gson gson = new Gson();
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            Cupom cupom = gson.fromJson(entry.getValue(), this);
            System.out.println(cupom);
        }

    }*/

    public void gravarJSON() throws IOException {
        //append:true para ir adicionando itens em sequencia sem resetar arquivo
        File file = new File("target/cupom.json");
        FileWriter fileWriter = new FileWriter(file, false);
        ObjectMapper mapper = new ObjectMapper();
        try {
            SequenceWriter seqWriter = mapper.writerWithDefaultPrettyPrinter().writeValuesAsArray(fileWriter);
            seqWriter.write(mapCupons);

            seqWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
