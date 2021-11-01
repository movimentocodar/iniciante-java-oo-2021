package br.com.movimentocodar.maquinadecafe;

public class teste {

    /*     byte[] mapData = Files.readAllBytes(Paths.get("target/cupom.txt"));
                Map<String,String> cupomMap = new HashMap<String, String>();

                ObjectMapper objectMapper = new ObjectMapper();
                cupomMap = objectMapper.readValue(mapData, Cupom.class);

                Cupom cupomSelecionado = cupomMap.keySet(codigo);



                //read json file data to String
                byte[] jsonData = Files.readAllBytes(Paths.get("employee.txt"));

//create ObjectMapper instance
                ObjectMapper objectMapper = new ObjectMapper();

//read JSON like DOM Parser
                JsonNode rootNode = objectMapper.readTree(jsonData);
                JsonNode idNode = rootNode.path("id");
                System.out.println("id = "+idNode.asInt());

                JsonNode phoneNosNode = rootNode.path("phoneNumbers");
                Iterator<JsonNode> elements = phoneNosNode.elements();
                while(elements.hasNext()){
                    JsonNode phone = elements.next();
                    System.out.println("Phone No = "+phone.asLong());
                }  */

    //return true;


                        /*File file = new File("target/cupom.txt");
                        FileWriter fileWriter = new FileWriter(file, true);
                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            SequenceWriter seqWriter = mapper.writer().writeValuesAsArray(fileWriter);

                            seqWriter.write(novoCupom);

                            seqWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/

                        /*JsonGenerator jsonGenerator = new JsonFactory()
                                .createGenerator(new FileOutputStream("target/cupom.txt"));
                        //for pretty printing
                        jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());

                        jsonGenerator.writeStartObject(); // start root object
                        jsonGenerator.writeStringField("codigo", codigo);
                        jsonGenerator.writeStringField("validade", validade);
                        jsonGenerator.writeBooleanField("ativo", true);
                        jsonGenerator.writeNumberField("valor", troco);
                        jsonGenerator.writeEndObject(); //closing root object

                        jsonGenerator.flush();
                        jsonGenerator.close();*/



/*
    private void RegistraCupom(){
    }


    // Java usando a biblioteca Jackson

    Fatura fatura = // Criação do objeto fatura.

            ObjectMapper mapper = new ObjectMapper();

    String jsonString = mapper.writeValueAsString(fatura); // Objeto Java para JSON string.

    Fatura novamenteFatura = mapper.readValue(jsonString, Fatura.class); //JSON string para objeto Java.


String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
Map<String, Object> map
  = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});

    /
 */




   /* package br.com.movimentocodar.maquinadecafe;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

    public class cupomSerializer extends JsonSerializer<Cupom> {

        private ObjectMapper mapper = new ObjectMapper();

        @Override
        public void serialize(Cupom cupom, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            mapper.writeValue(jsonGenerator, cupom);
            jsonGenerator.writeObject(cupom);
       *//* jsonGenerator.writeFieldName("codigo",cupom.getCodigo());
        jsonGenerator.writeFieldName("valor",cupom.getValor());
        jsonGenerator.writeFieldName("data",);
        jsonGenerator.writeFieldName("ativo",);*//*
        }
    }
*/


    /*
                byte[] mapData = Files.readAllBytes(Paths.get("target/cupom.json"));

                final ObjectMapper objectMapper = new ObjectMapper();
                Cupons[] cuponsJson = objectMapper.readValue(mapData, Cupons[].class);

                System.out.println(cuponsJson.toString());




                Map<String,String> cupomMap = new HashMap<String, String>();

                ObjectMapper objectMapper = new ObjectMapper();
                cupomMap = objectMapper.readValue(mapData, Cupom.class);
                */


                /*
                final ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Cupom> langList = objectMapper.readValue(
                        new File("target/cupom.json"),
                        new TypeReference<Cupom<String, Cupom>>(){});

                langList.forEach(x -> System.out.println(x.toString()));

        */


               /* JsonElement root = new JsonParser().parse(new FileReader("target/cupom.json"));
                JsonObject object = root.getAsJsonObject();
                Gson gson = new Gson();
                for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
                    Cupom cupom = gson.fromJson(entry.getValue(), this);
                    System.out.println(cupom);
                }



               // cupons.lerJSON();*/

/*

    ler json


    final ObjectMapper objectMapper = new ObjectMapper();
    Map<Language> langList = objectMapper.readValue(
            new File("langs.json"),
            new TypeReference<List<Language>>(){});

        langList.forEach(x -> System.out.println(x.toString()));*/


}
