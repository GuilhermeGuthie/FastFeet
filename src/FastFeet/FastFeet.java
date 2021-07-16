package FastFeet;

import Models.Endereco;
import Models.Pedido;
import Models.Pessoa;
import View.TelaPrincipal;
import java.util.ArrayList;

public class FastFeet {

    public static ArrayList<Pessoa> ListaPessoa = null;
    public static ArrayList<Pedido> ListaPedido = null;
    public static ArrayList<Endereco> listaEndereco = null;

    
    public static void main(String[] args) {

        new TelaPrincipal().setVisible(true);
    }

}
