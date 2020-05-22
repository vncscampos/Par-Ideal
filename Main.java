public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        Sistema s = Sistema.getInstance();
        s.gerarArquivo(); //gera os candidatos automaticamente
        s.inicializarCandidatos(); //inicializa os candidatos automaticamente
        s.criarMatch(); //faz os matches
        
        int acao;

        do {
            System.out.println("______________________________________________");
            System.out.println("Escolha uma tarefa:");
            System.out.println("1. Imprimir o número e a lista de potenciais companheiros;");
            System.out.println("2. Imprimir o número e o nome dos candidatos com maior número de potenciais companheiros");
            System.out.println("3. Imprimir o número e o nome dos candidatos sem companheiros;");
            System.out.println("4. Imprimir o número e o nome dos candidatos com interesse em uma área;");
            System.out.println("5. Imprimir o número e o nome dos candidatos que residem em determinado estado;");
            System.out.println("6. Adicionar um novo candidato;");
            System.out.println("7. Excluir um candidato;");
            System.out.println("8. Imprimir informações de um candidato;");
            System.out.println("0. SAIR.");
            System.out.println("______________________________________________");
            acao = leia.nextInt();

            switch (acao) {
                case 1:
                    s.imprimirLista();
                    break;
                case 2:
                    System.out.println("Candidatos com maior número de potenciais companheiros");
                    s.maisMatches();
                    break;
                case 3:
                    System.out.println("Candidatos sem companheiros: ");
                    s.semMatches();
                    break;
                case 4:
                    System.out.println("Insira a área de interesse: ");
                    int area = leia.nextInt();
                    s.candidatosArea(area);
                    break;
                case 5:
                    System.out.println("Insira o estado:");
                    String sigla = leia.next();
                    s.candidatosEstado(sigla);
                    
                    break;
                case 6:
                    System.out.println("Insira o nome do candidato:");
                    String nome = leia.next();
                    System.out.println("Insira o estado:");
                    String estado = leia.next();
                    System.out.println("Insira o sexo:");
                    String sexo = leia.next();
                    System.out.println("Insira o sexo do companheiro:");
                    String sexoC = leia.next();
                    System.out.println("1: ESPORTES\n"
                            + "2: ARTES\n"
                            + "3: MÚSICA\n"
                            + "4: CINEMA\n"
                            + "5: INFORMÁTICA\n"
                            + "6: ANIMAIS\n"
                            + "7: GASTRONOMIA\n"
                            + "8: CIÊNCIAS\n");
                    Scanner leia2 = new Scanner(System.in); //pra n dar erro por causa de buffer do teclado
                    String opcoes = leia2.next();
                    
                    String[] entradas = opcoes.split("\n"); //separa os numeros lidos em um vetor de string
                    int interesses[] = new int[entradas.length];
                    int i=0;
                    while(i < entradas.length){
                        interesses[i] = Integer.parseInt(entradas[i]); //passa os numeros lidos para o vetor de interesses
                        i++;
                    }
                    s.criarNovoCandidato(nome, estado, sexo, sexoC, interesses);
                    break;
                case 7:
                    System.out.print("Digite o ID do candidato que deseja excluir: ");
                    int id = leia.nextInt();
                    s.excluirCandidato(id);
                    break;
                case 8:
                    System.out.print("Digite o ID do candidato que deseja obter informções: ");
                    id = leia.nextInt();
                    s.imprimirCandidato(id);
                    break;
            }

        } while (acao != 0);

    }
