/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DateFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peret
 * @param pString
 */
public class Formatador {

    public double ConverterVirgulaParaPonto(String pString) {
        String retorno = new String();
        int TamanhoString = pString.length();
        for (int i = 0; i < TamanhoString; i++) {
            if (pString.charAt(i) == ',') {
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return Double.parseDouble(retorno);
    }

    public String converterDoubleString(double precoDouble) {
        /*Transformando um double em 2 casas decimais*/
        DecimalFormat fmt = new DecimalFormat("0.00");   //limita o número de casas decimais    
        String string = fmt.format(precoDouble);
        String[] part = string.split("[,]");
        String preco = part[0] + "." + part[1];
        return preco;
    }

    public double converterDoubleDoisDecimais(double precoDouble) {
        DecimalFormat fmt = new DecimalFormat("0.00");
        String string = fmt.format(precoDouble);
        String[] part = string.split("[,]");
        String string2 = part[0] + "." + part[1];
        double preco = Double.parseDouble(string2);
        return preco;
    }

    public java.sql.Date formatarData(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    public static DateFormat DATE_SQL = new SimpleDateFormat("yyyy-MM-dd");
    public static DateFormat DATE_HOUR_SQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static DateFormat DATE_BR = new SimpleDateFormat("dd-MM-yyyy");
    public static DateFormat DATE_BR_YY = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    public static DateFormat DATE_BR_FULL = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static DateFormat TIME = new SimpleDateFormat("HH:mm:ss");
    public static DateFormat DATE_DAY = new SimpleDateFormat("dd");

    public static NumberFormat NF_DEC = new DecimalFormat("#,##0.00");
    public static NumberFormat NF_NDEC = new DecimalFormat("#,##0");

    public static NumberFormat NF_5DIG = new DecimalFormat("00000");
    public static NumberFormat NF_6DIG = new DecimalFormat("000000");

    public static NumberFormat NF_4DEC = new DecimalFormat("0.0000");

    public NumberFormat NF_2DEC2 = new DecimalFormat("#,###.##");

    public BigDecimal ConvertStringValueToBigDecimal(String numero, Integer qtdeCasasDecimais) {
        String casasDecimais = "";
        String num = numero;
        DecimalFormat df = null;
        try {
            if (qtdeCasasDecimais > 0) {
                for (int i = 0; i < qtdeCasasDecimais; i++) {
                    casasDecimais = casasDecimais.concat("0");
                }
                if (num.equals("")) {
                    num = "0.".concat(casasDecimais);
                }
                df = new DecimalFormat("#,##0.".concat(casasDecimais), new DecimalFormatSymbols(new Locale("pt", "BR")));
                df.setParseBigDecimal(true); // aqui o pulo do gato
                df.setRoundingMode(RoundingMode.DOWN);
                return (BigDecimal) df.parse(num); // deve voltar o BigDecimal "1234.56"
            } else {
                if (num.equals("")) {
                    num = "0";
                }
                df = new DecimalFormat("###########");
                df.setParseBigDecimal(true);
                df.setRoundingMode(RoundingMode.DOWN);
                return new BigDecimal(((BigDecimal) df.parse(num)).intValue());
            }
        } catch (ParseException ex) {
            //Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
            return new BigDecimal("0");
        }
    }

    public String criptografia(String original) {
        //String senha = null;
        String senha = null;
        MessageDigest algoritmo;
        byte messageDigest[];
        StringBuilder hexString;
        try {
            //algoritmo =MessageDigest.getInstance("SHA-256");// 64 letras
            algoritmo = MessageDigest.getInstance("MD5");  // 32 letras
            messageDigest = algoritmo.digest(original.getBytes("UTF-8"));
            hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            senha = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //System.out.println("Senha normal: " + original + " - Senha criptografada: " + senha);
        return senha;
    }

    public String removePontos(String documento) {
        String documentoSemPonto = documento.trim().replace(",", "").replace(".", "");
        return documentoSemPonto;
    }

}
