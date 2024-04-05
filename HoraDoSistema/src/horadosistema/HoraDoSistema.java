package horadosistema;

import java.util.Date;

public class HoraDoSistema {

    public static void main(String[] args) {
        String idioma= System.getProperty("user.language");
        int largura=  Integer.parseInt(System.getProperty("screen.width"));
        int altura=  Integer.parseInt(System.getProperty("screen.height"));
        System.out.println("O idioma do sistema é: "+idioma);
        System.out.println("A resolução da maquina é: "+largura+"x"+altura);
    }
    
}
