package br.com.movimentocodar.maquinadecafe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cupons{
    private List<Cupom> cupons;

    public Cupons() throws IOException {
        if(this.cupons == null){ lerJSON();} //quando executar app
    }

    public void addNovoCupom(Cupom cupom) throws IOException {
        this.cupons.add(cupom);
        this.gravarJSON();
    }

    public Cupom encontrarCupom(String codigo){
        return this.cupons.stream().filter(c -> c.getCodigo().equals(codigo)).findAny().get();
    }

    public void lerJSON() throws IOException {
        byte[] mapData = Files.readAllBytes(Paths.get("target/cupom.json"));
        ObjectMapper mapper = new ObjectMapper();
        if (mapData.length > 0){
            this.cupons = new ArrayList<Cupom>(Arrays.asList(mapper.readValue(mapData, Cupom[].class)));
        } else {
            this.cupons = new ArrayList<Cupom>();
        }
    }

    public void gravarJSON() throws IOException {
        File file = new File("target/cupom.json");
        FileWriter fileWriter = new FileWriter(file, false);
        ObjectMapper mapper = new ObjectMapper();
        try {
            SequenceWriter seqWriter = mapper.writerWithDefaultPrettyPrinter().writeValues(fileWriter);
            seqWriter.write(this.cupons);

            seqWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}