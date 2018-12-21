/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package assets;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class NumberFormat {
    
    public float commaToPoint(String number){
          
        String valor_com_virgula = number; // "1.000.000,00"
        
        String valor_sem_ponto = valor_com_virgula.replaceAll("\\.", ""); // "1000000,00"
        
        String valor_com_ponto = valor_sem_ponto.replace(",", "."); // "1000000.00"
        System.out.println(valor_com_ponto);
        float valor_numerico = Float.parseFloat(valor_com_ponto); // 100000
        
        return valor_numerico;
    }
    
    public String pointToComma(Float number){
        String valor_string = number.toString();
        valor_string = valor_string.replaceAll("\\.",",");
        String[] valor_string_split = valor_string.split(",");

        String number_exibir;
       
        valor_string_split[0] = valor_string_split[0].replace("/(\\d)(?=(\\d\\d\\d)+(?!\\d))/g", "$1.");
        
        number_exibir = valor_string_split[0]+','+valor_string_split[1];
        
        System.out.println(number_exibir);

        return number_exibir;
    }  
}

