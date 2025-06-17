public class BolhaOrd {

    //  método que faz a ordenação usando o Bubble Sort
    // a cada passo, o maior número "borbulha" lá pra direita
    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;

        // passar por todos os elementos várias vezes
        for (int i = 0; i < n - 1; i++) {
            // Comparar pares de números lado a lado
            for (int j = 0; j < n - 1 - i; j++) {
                // Se o número da esquerda for maior, troca eles de lugar
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
            // Depois de cada rodada, o maior número do pedaço vai ficando no final
        }
    }
}

