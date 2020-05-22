import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Sistema {

    private static Sistema instance = null;
    private Lista<Candidato> candidatos;

    //MÉTODO FÁBRICA
    public static Sistema getInstance() {
        if (instance == null) {
            return new Sistema();
        } else {
            return null;
        }
    }

    private Sistema() {
        candidatos = new Lista();
    }

    //////////////GERA OS CANDIDATOS/////////////////
    public void gerarArquivo() {
        Scanner leia = new Scanner(System.in);
        Random r = new Random();
        int qtdM, qtdF, qtdI, qtdInteresse, aux, aux1;
        String nome, uf, sexo, sexoD, qtd;

        System.out.print("Informe a quantidade de Pessoas - M: ");
        qtdM = leia.nextInt();
        while (qtdM < 0) {

            System.out.print("Informe a quantidade de Pessoas - M: ");
            qtdM = leia.nextInt();
        }

        System.out.print("Informe a quantidade de Pessoas - F: ");
        qtdF = leia.nextInt();
        while (qtdF < 0) {

            System.out.print("Informe a quantidade de Pessoas - F: ");
            qtdF = leia.nextInt();
        }

        System.out.print("Informe a quantidade de Pessoas - I: ");
        qtdI = leia.nextInt();
        while (qtdI < 0) {

            System.out.print("Informe a quantidade de Pessoas - I: ");
            qtdI = leia.nextInt();
        }
        String textoQueSeraEscrito = (qtdI + qtdM + qtdF) + "";

        ArrayList<String> nomesM = nomesM();
        ArrayList<String> nomesF = nomesF();
        ArrayList<String> nomes = nomes();
        ArrayList<String> estados = uf();
        ArrayList<Integer> interesses;
        ArrayList<String> sexos = new ArrayList<String>();
        sexos.add("M");
        sexos.add("F");
        sexos.add("I");

        for (int i = 0; i < qtdM; i++) {
            nome = nomesM.get(r.nextInt(100));
            uf = estados.get(r.nextInt(26));
            sexo = "M";
            sexoD = sexos.get(r.nextInt(3));
            aux1 = r.nextInt((7 - 1) + 1) + 1;
            qtd = String.valueOf(aux1);
            textoQueSeraEscrito = textoQueSeraEscrito + "\n" + nome + "\n" + uf + "\n" + sexo + "\n" + sexoD + "\n" + qtd;

            interesses = new ArrayList<Integer>();
            for (int j = 0; j < aux1; j++) {
                aux = r.nextInt((7 - 1) + 1) + 1;

                while (interesses.contains(aux) == true) {
                    aux = r.nextInt((7 - 1) + 1) + 1;
                }
                interesses.add(aux);
                textoQueSeraEscrito = textoQueSeraEscrito + "\n" + aux;
            }
        }

        for (int i = 0; i < qtdM; i++) {
            nome = nomesF.get(r.nextInt(100));
            uf = estados.get(r.nextInt(26));
            sexo = "F";
            sexoD = sexos.get(r.nextInt(3));
            aux1 = r.nextInt((7 - 1) + 1) + 1;
            qtd = String.valueOf(aux1);
            textoQueSeraEscrito = textoQueSeraEscrito + "\n" + nome + "\n" + uf + "\n" + sexo + "\n" + sexoD + "\n" + qtd;

            interesses = new ArrayList<Integer>();
            for (int j = 0; j < aux1; j++) {
                aux = r.nextInt((7 - 1) + 1) + 1;

                while (interesses.contains(aux) == true) {
                    aux = r.nextInt((7 - 1) + 1) + 1;
                }
                interesses.add(aux);
                textoQueSeraEscrito = textoQueSeraEscrito + "\n" + aux;
            }
        }

        for (int i = 0; i < qtdM; i++) {
            nome = nomes.get(r.nextInt(100));
            uf = estados.get(r.nextInt(26));
            sexo = "I";
            sexoD = sexos.get(r.nextInt(3));
            aux1 = r.nextInt((7 - 1) + 1) + 1;
            qtd = String.valueOf(aux1);
            textoQueSeraEscrito = textoQueSeraEscrito + "\n" + nome + "\n" + uf + "\n" + sexo + "\n" + sexoD + "\n" + qtd;

            interesses = new ArrayList<Integer>();
            for (int j = 0; j < aux1; j++) {
                aux = r.nextInt((7 - 1) + 1) + 1;

                while (interesses.contains(aux) == true) {
                    aux = r.nextInt((7 - 1) + 1) + 1;
                }
                interesses.add(aux);
                textoQueSeraEscrito = textoQueSeraEscrito + "\n" + aux;
            }
        }

        FileWriter arquivo;

        try {
            arquivo = new FileWriter(new File("arquivo.txt"));
            arquivo.write(textoQueSeraEscrito);
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> nomesM() {
        ArrayList<String> nomes = new ArrayList<String>();

        try {
            File arquivo = new File("nomesM.txt");

            FileReader ler = new FileReader(arquivo);

            BufferedReader br = new BufferedReader(ler);
            while (br.ready()) {
                String nomeAtual = br.readLine();
                nomes.add(nomeAtual);
            }
        } catch (Exception ex) {

        }

        return nomes;
    }

    public static ArrayList<String> nomesF() {
        ArrayList<String> nomes = new ArrayList<String>();

        try {
            File arquivo = new File("nomesF.txt");

            FileReader ler = new FileReader(arquivo);

            BufferedReader br = new BufferedReader(ler);
            while (br.ready()) {
                String nomeAtual = br.readLine();
                nomes.add(nomeAtual);
            }
        } catch (Exception ex) {

        }

        return nomes;
    }

    public static ArrayList<String> nomes() {
        ArrayList<String> nomes = new ArrayList<String>();

        try {
            File arquivo = new File("nomes.txt");

            FileReader ler = new FileReader(arquivo);

            BufferedReader br = new BufferedReader(ler);
            while (br.ready()) {
                String nomeAtual = br.readLine();
                nomes.add(nomeAtual);
            }
        } catch (Exception ex) {

        }

        return nomes;
    }

    public static ArrayList<String> uf() {
        ArrayList<String> estados = new ArrayList<String>();

        try {
            File arquivo = new File("estados.txt");

            FileReader ler = new FileReader(arquivo);

            BufferedReader br = new BufferedReader(ler);
            while (br.ready()) {
                String estado = br.readLine();
                estados.add(estado);
            }
        } catch (Exception ex) {

        }

        return estados;
    }

    //////////INICIALIZA OS CANDIDATOS//////////////
    public void inicializarCandidatos() {
        try {
            File arquivo = new File("arquivo.txt");
            FileReader ler = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(ler);
            br.readLine();
            while (br.ready()) { //Enquanto tiver linha para ler, continua o loop
                String nome = br.readLine();
                String estado = br.readLine();
                String sexo = br.readLine();
                String sexo_comp = br.readLine();
                int size = Integer.parseInt(br.readLine());
                int interesses[] = new int[size];
                for (int i = 0; i < size; i++) {
                    int interesse = Integer.parseInt(br.readLine());
                    interesses[i] = interesse;
                }
                Candidato c = Candidato.newInstance(nome, estado, sexo, sexo_comp, interesses); //Instancia o candidato
                candidatos.add(c); //Armazena o candidato
            }
        } catch (Exception e) {
        }
    }

    public void criarNovoCandidato(String nome, String estado, String sexo, String sexoC, int[] interesses) {
        Candidato c = Candidato.newInstance(nome, estado, sexo, sexoC, interesses); //Cria o candidato
        for (int i = 0; i < candidatos.getSize(); i++) {
            Candidato c2 = candidatos.getItem(i);
            if (c2 != null) {
                Candidato.InsereCompanheiro(c, c2);
            }
        }
        candidatos.add(c); //Armazena o candidato
    }

    //////////FUNÇÕES DO SISTEMA////////////
    public void criarMatch() {
        for (int i = 0; i < candidatos.getSize(); i++) {
            Candidato c = candidatos.getItem(i);
            if (c != null) {
                for (int j = i + 1; j < candidatos.getSize(); j++) {
                    Candidato c2 = candidatos.getItem(j);
                    if (c2 != null) {
                        Candidato.InsereCompanheiro(c, c2);
                    }
                }
            }
        }
    }

    //Imprime todos os candidatos de um estado
    public void candidatosEstado(String estado) {
        for (int i = 0; i < candidatos.getSize(); i++) {
            Candidato c = candidatos.getItem(i);
            if (c != null) {
                if (Candidato.Reside(c, estado) == true) {
                    System.out.println(c.getId() + " " + c.getNome());
                }
            }
        }
    }

    //Imprime todos os candidatos de uma área
    public void candidatosArea(int cod) {
        for (int i = 0; i < candidatos.getSize(); i++) {
            Candidato c = candidatos.getItem(i);
            if (c != null) {
                if (Candidato.TemInteresse(c, cod) == true) {
                    System.out.println(c.getId() + " " + c.getNome());
                }
            }
        }
    }

    //Imprime os candidatos sem match
    public void semMatches() {
        for (int i = 0; i < candidatos.getSize(); i++) {
            Candidato c = candidatos.getItem(i);
            if (c != null) {
                if (c.getSizeMatch() == 0) {
                    System.out.println(c.getId() + " " + c.getNome());
                }
            }
        }
    }

    //Imprime os candidatos com mais matches
    public void maisMatches() {
        Candidato c = candidatos.getItem(0);
        int maior;

        //Verifica qual é maior match
        if (c != null) {
            maior = c.getSizeMatch();
            for (int i = 1; i < candidatos.getSize(); i++) {
                Candidato c2 = candidatos.getItem(i);
                if (c2 != null) {
                    if (maior < c2.getSizeMatch()) {
                        maior = c2.getSizeMatch();
                    }
                }
            }
            //Imprime os candidatos com maior match
            System.out.println("Número de matches: " + maior);
            for (int i = 0; i < candidatos.getSize(); i++) {
                Candidato c3 = candidatos.getItem(i);
                if (c3 != null) {
                    if (maior == c3.getSizeMatch()) {
                        System.out.println(c3.getId() + " " + c3.getNome());
                    }
                }
            }
        }

    }

    //Imprime a lista de companheiros de cada candidato
    public void imprimirLista() {
        for (int i = 0; i < candidatos.getSize(); i++) {
            Candidato c = candidatos.getItem(i);
            if (c != null) {
                System.out.println("Parceiros do(a): " + c.getNome());
                for (int j = 0; j < candidatos.getSize(); j++) {
                    Candidato c2 = candidatos.getItem(j);
                    c.ImprimeListaCompanheiros(c2);
                }
            }
            System.out.println("_____________________________");
        }
    }

    //Exclui candidato com o ID
    public boolean excluirCandidato(int ID) { //n testei nem sei se funfa acho q n
        for (int i = 0; i < candidatos.getSize(); i++) {
            Candidato c = candidatos.getItem(i);
            if (c.getId() == ID) {
                candidatos.excluir(ID);
                return true;
            }
        }
        return false;
    }

    //Imprimir informações de um candidato
    public void imprimirCandidato(int ID) {
        for (int i = 0; i < candidatos.getSize(); i++) {
            Candidato c = candidatos.getItem(i);
            if (c.getId() == ID) {
                System.out.println("Nome: " + c.getNome());
                System.out.println("Estado: " + c.getEstado());
                System.out.println("Sexo: " + c.getSexo());
                System.out.println("Sexo do companheiro(a): " + c.getSexoComp());
                int interesses[] = c.getInteresses();
                System.out.println("Interesses: ");
                for (int j = 0; j < interesses.length; j++) {
                    System.out.print(interesses[j] + " ");
                }
            }
        }
    }
}
