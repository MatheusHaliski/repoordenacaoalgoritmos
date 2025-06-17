public class RapidoOrd {

    // Quick Sort dividindo o vetor em partes menores
    // escolhe um "pivô" e coloca os menores à esquerda e maiores à direita
    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int p = partition(vetor, inicio, fim); // separa o vetor em duas partes

            // Ordena a parte da esquerda
            quickSort(vetor, inicio, p - 1);

            // Ordena a parte da direita
            quickSort(vetor, p + 1, fim);
        }
    }

    // Essa função coloca o pivô na posição correta e ajeita os números ao redor
    private static int partition(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim]; // escolhi o último número como pivô
        int i = inicio - 1; // essa variável vai controlar onde colocar os menores

        for (int j = inicio; j < fim; j++) {
            // Se o número atual é menor ou igual ao pivô, a gente avança a divisão
            if (vetor[j] <= pivo) {
                i++; // avançou
                // troca o número da posição i com o da posição j
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        // Depois de colocar todos menores à esquerda, troca o pivô para o lugar certo
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1; // devolve a posição do pivô
    }
}
