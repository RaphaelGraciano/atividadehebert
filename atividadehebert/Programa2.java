package atividadehebert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa2 {

    public static void main(String args[]) throws IOException {
        FileInputStream arquivo = new FileInputStream("C:\\Users\\rapha\\Desktop\\Inputs\\Inputs.txt");
        InputStreamReader lerinput = new InputStreamReader(arquivo);
        BufferedReader buff = new BufferedReader(lerinput);
        String line = buff.readLine();

        // Recebendo os Inputs do arquivo
        String input1 = line;
        line = buff.readLine();
        String[] input1Separado = input1.split(" ");
        String[] input = new String[Integer.parseInt(input1Separado[1])];
        int i = -1;
        while (line != null) {
            i = i + 1;
            input[i] = line;
            line = buff.readLine();
        }

        // Funcionamento do programa
        int[] vendedores = new int[Integer.parseInt(input1Separado[0])];
        int[] desempenho = new int[Integer.parseInt(input1Separado[0])];
        int fim = 1;
        // Colocando os primeiros valores de tempo para os vendedores
        for (int j = 0; j < vendedores.length; j++) {
            try {
                vendedores[j] = Integer.parseInt(input[j]);
                input[j] = "0";
            } catch (Exception v) {
                System.out.println("Estão faltando ligações para suprir o número de vendedores");
            }
        }
        // Começando o looping para fazer com que os vendedores façam as "ligações"
        while (fim == 1) {
            fim = 0;
            // Realizando as ligações de cada um retirando 1 minuto por vez, caso chege em 0
            // ele recebe 1 ligação completa!
            for (int j = 0; j < vendedores.length; j++) {
                vendedores[j] = vendedores[j] - 1;
                if (vendedores[j] == 0) {
                    desempenho[j] = desempenho[j] + 1;
                }
            }
            // Olhando para ver quais são os atendentes que podem atender outra ligação
            for (int j = 0; j < vendedores.length; j++) {
                for (int k = 0; k < input.length; k++) {
                    if (vendedores[j] == 0 && Integer.parseInt(input[k]) != 0) {
                        try {
                            vendedores[j] = Integer.parseInt(input[k]);
                            input[k] = "0";
                        } catch (Exception v) {
                            System.out.println("Estão faltando ligações para suprir o número de vendedores");
                        }
                    }
                }
            }
            // Testando para ver se todas as ligações foram completas (Para ver se posso
            // fechar o looping)
            for (int j = 0; j < vendedores.length; j++) {
                if (vendedores[j] > 0) {
                    fim = 1;
                }
            }
        }
        // Exibindo os resultados
        for (int j = 0; j < vendedores.length; j++) {
            System.out.println(j + 1 + " " + desempenho[j]);
        }
    }
}