public class Candidato{
   private String nome;
   private String estado;
   private String sexo;
   private String sexo_comp;
   private int []interesses;
   private int grau;
   private long id;
   private Lista<Candidato> match;//Lista com identificadores de matches
   private Lista<long> lista_id;

   //Com o constructor cria mais rapidamente o candidato
   //Não necessita de sets,pois não vai haver alteração de dados
   //talvez para os matches
   public Candidato(String nome,String estado,String sexo,String sexo_comp){
       this.nome = nome;
       this.estado = estado;
       this.sexo = sexo;
       this.sexo_comp = sexo_comp;
       this.match = new Lista<Candidato>();
       this.lista_id = new Lista<long>();
   }

   public String getNome(){
       return this.nome;
   }

   public String getEstado(){
       return this.estado;
   }

   public String getSexo(){
       return this.sexo;
   }

   public String getSexoComp(){
       return this.sexo_comp;
   }

   public long getId(){
       return this.id;
   }

   //Calcula o grau de interesse do candidato
   public int getGrau(){
       for(int i = 0;i < interesse.length;i++){
           if(interesse[i] == 1 || interesse[i] == 3 || interesse[i] == 4){
               grau += 1;
           }else if(interesse[i] == 2 || interesse[i] == 6 || interesse[i] == 7 ){
               grau += 2;
           }else if(interesse[i] == 5 || interesse[i] == 8){
               grau += 3;
           }
       }

       return grau;
   }

   //Adiciona o id do candidato na lista de interesses
   public void add(long id){
      lista_id.insere(id);
   }

   //VerificaPotencialCompanheiro
   public static boolean VerificaCompanheiro(Candidato pessoa, Candidato pessoa2){
       if(pessoa.getEstado().equals(pessoa2.getEstado()) && pessoa.getSexoComp().equals(pessoa2.getSexo())
               && pessoa.getGrau() == pessoa2.getGrau()){
           return true;
       }else{
           return false;
       }
   }

   //InserePotencialCompanheiro
   public static boolean InsereCompanheiro(Candidato pessoa, Candidato pessoa2){
       if(pessoa.getId() == pessoa2.getId()){
          pessoa.add(pessoa2.getGrau());
          return true;
       }else{
           return false;
       }
   }

   public static int ImprimeNumeroCompanheiros(){
   }

   public static int ImprimeListaCompanheiros(){
   }

   public static boolean TemInteresse(){
   }

   //return true se no estado fornecido
   public static boolean Reside(){
   }

}
