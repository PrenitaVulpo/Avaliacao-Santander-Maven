package utils;

import com.opencsv.CSVReader;
import entities.RawOperation;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class CSVUtil {
    final String file = "src/operacoes.csv";
    List<Map<String,String>> lines = null;
    final ArrangeUtils arrangeUtils = new ArrangeUtils();

    public CSVUtil(){
        try{
            CSVReader csvReader = new CSVReader(new FileReader(new File(file)));
            List<Map<String,String>> lines = new ArrayList<Map<String,String>>();

            String[] headers = csvReader.readNext();
            String[] columns = null;

            while((columns = csvReader.readNext()) != null){
                Map<String,String> entry = new HashMap<String, String>();

                for(int i = 0; i < columns.length; i++){
                    entry.put(headers[i], columns[i]);
                }
                lines.add(entry);
            }
            this.lines = arrangeUtils.filterMapList(lines);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<RawOperation> getRawList() {
        ArrayList<RawOperation> result = new ArrayList<>();
        lines.forEach(line -> result.add(new RawOperation(
                line.get("OPERADOR"),
                line.get("DATAHORAOPERACAO"),
                line.get("TIPO"),
                line.get("VALOR"),
                line.get("ID_DA_CONTA"),
                line.get("NOME_DO_BANCO"),
                line.get("NUMERO_DA_AGENCIA"),
                line.get("NUMERO_DA_CONTA")
        )));

        return result;
    }

    public void printMap(){
        this.lines.forEach(line -> {
            System.out.println(line.get("ID_DA_CONTA"));
        });
    }
}
