import com.letscode.controleRebeldes.InteligenciaCentral;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) {

        InteligenciaCentral ic = new InteligenciaCentral();

        ic.CadastrarRebelde();

        try{
            ic.imprimirListaRebeldes();
        }catch (FileNotFoundException | UnsupportedEncodingException e){
            e.printStackTrace();
        }


    }
}
