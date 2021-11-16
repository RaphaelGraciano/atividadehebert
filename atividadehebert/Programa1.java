package atividadehebert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa1 {

    public static void main(String args[]) throws IOException {
        FileInputStream arquivo = new FileInputStream("C:\\Users\\rapha\\Desktop\\Inputs\\Inputs.txt");
        InputStreamReader lerinput = new InputStreamReader(arquivo);
        BufferedReader buff = new BufferedReader(lerinput);
        String line = buff.readLine();
        String[] input = new String[3];
        int i = -1;
        while (line != null) {
            i = i + 1;
            input[i] = line;
            line = buff.readLine();
        }
        String[] fatias = input[2].split(" ");
        int m = 0;
        int TamanhoMax = 0;
        for (int k = 0; k < fatias.length; k++) {
            m += Integer.parseInt(fatias[k]);
        }
        m = m / Integer.parseInt(input[0]);

        while (m > 0) {
            for (int k = 0; k < fatias.length; k++) {
                TamanhoMax += Integer.parseInt(fatias[k]) / m;
            }
            if (TamanhoMax == Integer.parseInt(input[0])) {
                System.out.println(m);
                break;
            } else {
                m = m - 1;
                TamanhoMax = 0;
            }
        }
    }
}