/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converterxmlparajson;

import org.json.JSONObject;
import org.json.XML;
import java.io.*;

/**
 *
 * @author Eleni Oliveira
 */
public class ConverterXMLparaJSON {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        String fileName = "src\\catalog.json";
        try {
            File file = new File("src\\catalog.xml");
            InputStream inputStream = new FileInputStream(file);
            StringBuilder builder = new StringBuilder();
            int ptr = 0;
            while ((ptr = inputStream.read()) != -1) {
                builder.append((char) ptr);
                //  System.out.println(ptr);
            }

            String xml = builder.toString();
            JSONObject jsonObj = XML.toJSONObject(xml);
           
            FileWriter fileWriter
                    = new FileWriter(fileName);

           
            BufferedWriter bufferedWriter
                    = new BufferedWriter(fileWriter);

            
            for (int i = 0; i < jsonObj.toString().split(",").length; i++) {
                System.out.println(jsonObj.toString().split(",")[i]);
                bufferedWriter.write(jsonObj.toString().split(",")[i]);
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(
                    "Erro ao gravar no arquivo '"
                    + fileName + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
