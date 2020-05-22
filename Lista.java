private Celula head;
    private Celula tail;
    private int size;

    private class Celula {
        T item;
        Celula ant;
        Celula prox;

        public Celula(T item) {
            this.item = item;
        }
    }

    // Fazer lista vazia
    public Lista() {
        head = null;
        tail = head;
        size = 0;
    }

    public boolean isVazia() {
        return head == null;
    }

    // Inserção final
    public void add(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (isVazia()) {
            head = new Celula(item);
            tail = head;
        } else {
            tail.prox = new Celula(item);
            tail.prox.ant = tail;
            tail = tail.prox;
        }
        size++;
    }
    
    public int getSize(){
        return size;
    }
    
    public T getItem(int pos){
        if (pos < 0 || pos > size) {
            throw new NullPointerException();
        } else {
            Celula aux = head;
            int cont = 0;
            while(cont < pos && aux != null){
                aux = aux.prox;
                cont++;
            }
            return aux.item;
        }
        
    }

    //Pra excluir candidato se quiser
    public Object excluir(Object item) {
        if (item == null) {
            throw new NullPointerException();
        } else {
            Celula aux = head;
            while (aux != null && !aux.item.equals(item)) {
                aux = aux.prox;
            }
            if (aux == null) {
                throw new IllegalArgumentException("Elemento não encontrado");
            } else {
                if (aux == head) {
                    head = head.prox; // inicio
                } else {
                    aux.ant.prox = aux.prox; // meio
                }
                if (aux == tail) {
                    tail = tail.ant; // fim
                } else {
                    aux.prox.ant = aux.ant; // meio
                }
                size--;
                return aux.item;
            }
        }

    }

    @Override
    public String toString() {
        Celula aux = head;
        StringBuilder sb = new StringBuilder("[");
        while (aux != null) {
            sb.append(aux.item);
            sb.append(", ");
            aux = aux.prox;
        }
        if (sb.length() > 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }
