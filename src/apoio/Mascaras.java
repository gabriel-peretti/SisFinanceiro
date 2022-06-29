/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;
import javax.swing.text.MaskFormatter;

public class Mascaras {
    
    private MaskFormatter telefone, cep, cpf;
    
    private static final Mascaras mascara = new Mascaras();
    
    public enum MascaraTipo{
        CEP, TELEFONE, CPF;
    }
    
    private Mascaras(){
        
        try{
            telefone = new MaskFormatter("(##) ####-####");
            telefone.setPlaceholderCharacter('_');
            
            cep = new MaskFormatter("#####-###");
            cep.setPlaceholderCharacter('_');
            
            cpf = new MaskFormatter("###.###.###-##");
            cpf.setPlaceholderCharacter('_');
        }catch(Exception e){
            
        }    
    }
    
    public static Mascaras getInstance (){
        return mascara;
    }
    
    public MaskFormatter getMascara(MascaraTipo mask){
        
        switch(mask){
            case CEP:
                return cep;
            case CPF:
                return cpf;
            case TELEFONE:
                return telefone;
            default:
                return null;
        }
    }
    
}