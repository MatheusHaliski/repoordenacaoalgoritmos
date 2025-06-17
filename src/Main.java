import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // coloca o caminho do arquivo teste CSV
        String arquivo = "aleatorio_100.csv";

        // ler os números do arquivo e guardar num vetor
        int[] dados = lerArquivo(arquivo);

        if (dados == null) {
            System.out.println("Erro ao ler o arquivo.");
            return;
        }

        // Criar cópias dos dados para não misturar na hora de ordenar
        int[] dadosBolha = dados.clone();
        int[] dadosInsercao = dados.clone();
        int[] dadosRapido = dados.clone();

        //  medir o tempo do Bubble Sort
        long inicio = System.nanoTime();
        BolhaOrd.bubbleSort(dadosBolha);
        long fim = System.nanoTime();
        long tempoBolha = fim - inicio;
        System.out.println("Bubble Sort levou: " + tempoBolha + " nanosegundos");

        // Medir tempo do Insertion Sort
        inicio = System.nanoTime();
        InsercaoOrd.insertionSort(dadosInsercao);
        fim = System.nanoTime();
        long tempoInsercao = fim - inicio;
        System.out.println("Insertion Sort levou: " + tempoInsercao + " nanosegundos");

        // Medir tempo do Quick Sort
        inicio = System.nanoTime();
        RapidoOrd.quickSort(dadosRapido, 0, dadosRapido.length - 1);
        fim = System.nanoTime();
        long tempoRapido = fim - inicio;
        System.out.println("Quick Sort levou: " + tempoRapido + " nanosegundos");
    }

    // Função lê o arquivo CSV e transforma em um vetor de inteiros
    private static int[] lerArquivo(String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            // linha por linha e guardar os números num array
            // Primeiro, ler tudo para uma lista temporária pra saber o tamanho
            java.util.List<Integer> lista = new java.util.ArrayList<>();

            String linha;
            while ((linha = br.readLine()) != null) {
                // Supondo que cada linha tem só um número
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    int numero = Integer.parseInt(linha);
                    lista.add(numero);
                }
            }

            // transformar lista em array
            int[] resultado = new int[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                resultado[i] = lista.get(i);
            }

            return resultado;

        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Arquivo contém dado inválido: " + e.getMessage());
            return null;
        }
    }
}
