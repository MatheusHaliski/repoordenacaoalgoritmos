public class InsercaoOrd {

    // O Insertion Sort funciona pegando um número por vez e "inserindo" no lugar certo à esquerda
    public static void insertionSort(int[] vetor) {
        int n = vetor.length;

        for (int i = 1; i < n; i++) {
            int chave = vetor[i]; // número q vai tentar colocar no lugar certo
            int j = i - 1;

            // Enquanto o número à esquerda for maior, vamos empurrando ele pra direita
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j]; // empurra para a direita
                j--; // anda para o próximo da esquerda
            }

            // Aqui é onde o número “chave” vai se encaixar certinho
            vetor[j + 1] = chave;
        }
    }
}
