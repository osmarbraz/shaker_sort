/*
 * Página 40 Thomas H. Cormen 3 ed
 *
 * Algoritmo Shakersort (bidirectional bubblesort)
 * 
 * Shakersort é uma variante do Bubblesort. O algoritmo de classificação 
 * Bubblesort sempre percorre os elementos da esquerda e move o maior elemento 
 * para sua posição correta na primeira iteração e o segundo maior na segunda 
 * iteração, e assim por diante. Shakersort percorre o vetor em ambas as 
 * direções, alternativamente.
 *
 * Atenção:
 * Vetor em java inicia em 0, os algoritmos consideram início em 1.
 * A subtração de -1 ocorre somente no local de acesso ao vetor ou matriz 
 * para manter a compatibilidade entre os algoritmos.
 * 
 */

/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {

    /**
     * Realiza a troca de posição de dois elementos do vetor.
     *
     * @param A Vetor que contém os dados
     * @param i Primeira posição de troca
     * @param j Segunda posição de troca
     */
    public static void troca(int[] A, int i, int j) {
        int aux = A[i];
        A[i] = A[j];
        A[j] = aux;
    }

    /**
     * Realiza a ordenação utilizando o métod Shakersort.
     *
     * @param A Vetor que contém os dados
     * @param p Início do vetor
     * @param r Fim do vetor
     */
    public static void shakersort(int A[], int r, int p) {
        boolean troca = true;

        int inicio = r;
        int fim = p - 1;
        int ultima = 1;
        int primeira = p - 1;

        while (troca == true) {
            troca = false;
            for (int i = inicio; i < fim; i++) {
                if (A[i] > A[i + 1]) {
                    //troca
                    troca(A, i, i + 1);
                    ultima = i;  //posição da última troca
                    troca = true; //sinaliza ocorrência da troca
                }
            }
            fim = ultima; //vetor já ordenado de ultima+1 até n

            troca = false;
            for (int i = fim; i > inicio; i--) {
                if (A[i] < A[i - 1]) {
                    //troca
                    troca(A, i, i - 1);
                    primeira = i;  //posição da última troca
                    troca = true; //sinaliza ocorrência da troca
                }
            }
            inicio = primeira; //vetor já ordenado de primeira-1 até n
        }
    }

    public static void main(String args[]) {

        //Vetor dos dados        
        int A[] = {50, 70, 60, 90, 10, 30, 20, 40};

        //Fim do vetor
        int r = A.length;

        System.out.println(">>> Algoritmo ShakerSort/Ordenação pelo Método da Agitação <<<");
        System.out.println("Original: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i + 1) + " - " + A[i]);
        }

        shakersort(A, 0, r);

        System.out.println("Depois: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i + 1) + " - " + A[i]);
        }
    }
}
