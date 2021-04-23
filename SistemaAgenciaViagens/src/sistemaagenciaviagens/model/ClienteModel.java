package sistemaagenciaviagens.model;

import java.util.ArrayList;
import java.util.Calendar;

import java.io.Serializable;

public class ClienteModel extends PessoaModel implements Serializable{
    
    //Atributos
    
    private String rg;
    private String cpf;
    private Calendar dataNascimento;
    
    private PlanoModel plano;
    
    //Construtor
    
    public ClienteModel(){
        super();
        this.rg = "";
        this.cpf = "";
        this.dataNascimento = Calendar.getInstance();
    }
    
    //Getters
    
    public String getRg(){
        return rg;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public Calendar getDataNascimento(){
        return dataNascimento;
    }
    
    public PlanoModel getPlano(){
        return this.plano;
    }
    
    // Setters
    
    public void setRg(String rg) throws Exception{
        if(rg.equals("")){
            throw new Exception("\nO RG não foi informado");
        }
        else if(this.validaRG(rg) == false){  // Chama a função de validacao
            throw new Exception("\nO RG digitado não é válido. Cadastre novamente"
                    + " o cliente com um RG válido");
        }
        
        this.rg = rg;
    }
    
    public void setCpf(String cpf) throws Exception{
        if(cpf.equals("")){
            throw new Exception("\nO CPF não foi informado");
        }
        else if(this.validaCPF(cpf) == false){  // Chama a função de validacao
            throw new Exception("\nO CPF digitado não é válido. Cadastre novamente"
                    + " o cliente com um CPF válido");
        }
        
        this.cpf = cpf;
    }
    
    public void setDataNascimento(Calendar dataNascimento) throws Exception{
        // Se a data de nascimento digitada vier antes da data atual
        if(dataNascimento.after(Calendar.getInstance())){
            throw new Exception("\nNão pode ser a data de nascimento pois se "
                    + "trata de uma data futura");
        }
        
        if(dataNascimento == null){
            throw new Exception("\nA data não foi informada.");
        }
        
        this.dataNascimento = dataNascimento;
    }
    
    public void setPlano(PlanoModel plano) throws Exception{
        if(plano == null){
            throw new Exception("Plano não informado!");
        }
        
        this.plano = plano;
    }
    
    // Metodos
    
    /**
     * validaCPF irá validar o CPF seguinto uma serie de regras e criterios
     *
     */
    public boolean validaCPF(String cpf){
        int i, j;  // Indices que serao usados no for
        int n = 10;  /* Variavel que multiplicara cada numero do CPF, diminuindo
                        a cada operacao */
        int soma = 0;  /* Guarda a soma total apos ser feita a multiplicacao de 
                          cada numero do CPF com n */
        int resto = 0;  // Guarda o resto da divisao de soma por 11
        int digitoV1 = 0, digitoV2 = 0;  /* Dígitos verificadores que serao 
                                            calculados */
        int[] cpfVetor = new int[11];  /* Array auxiliar que contera cada digito
                                          do CPF como inteiro */
        
        for(i=0; i<11; i++){
            /* cpfVetor ira guardar cada numero do CPF em uma posicao do vetor 
               para facilitar nas operacoes aritmeticas. Apos ser feito o cast, 
               subtrai-se 48 por conta de ser o valor de 0 na tabela ASCII*/
            cpfVetor[i] = ((int) cpf.charAt(i)) - 48;
        }
        
        /* O for externo sera utilizado para encontrar e comprar o primeiro e o 
           segundo digito verificador, que estarao nas posicoes 9 e 10
           respectivamente */
        for(i=9; i<=10; i++){
            soma = 0;  // Soma recebe 0 a cada verificacao
            
            for(j=0; j<i; j++){
                soma += cpfVetor[j] * n;

                n--;
            }
            
            resto = soma % 11;
            
            // Se o resto for menor que dois, o digito verificador recebe 0
            if(resto < 2){
                if(i == 9){
                    digitoV1 = 0;
                }
                else{
                    digitoV2 = 0;
                }
            }
            /* Se o resto for maior ou igual a dois, o digito verificador recebe
               11 - resto */
            else{
                if(i == 9){
                    digitoV1 = 11 - resto;
                }
                else{
                    digitoV2 = 11 - resto;
                }
            }

            /* Se o primeiro digito verificador estiver invalido, o programa já
               retorna falso para nao precisa testar o segundo */
            if(cpfVetor[9] != digitoV1){
                return false;
            }
            
            n = 11;
        }
        
        // Se o segundo digito tambem estiver valido, o CPF e valido
        if(cpfVetor[10] == digitoV2){
            return true;
        }
        
        // Se o segundo digito nao for valido, o CPF nao e valido
        return false;
    }
    
    /**
     * validaRG irá validar o RG seguinto uma serie de regras e criterios
     *
     */
    public boolean validaRG(String rg){
        int i;
        int soma = 0;
        int resto = 0;
        int digitoV = 0;
        int[] rgVetor = new int[9];
        
        // Cria um vetor de inteiros para passar os valores
        for(i=0; i<9; i++){
            rgVetor[i] = ((int) rg.charAt(i)) - 48;
        }
        
        // Faz a soma total seguindo os criterios de validacao
        for(i=2; i<=9; i++){
            soma += rgVetor[i-2] * i;
        }
        
        resto = soma % 11;
        
        digitoV = 11 - resto;
        
        /* Regra 1: caso o digito verificador seja igual a 10, por regra ele passa
           a ser X */
        if(digitoV == 10){
            digitoV = 88;
        }
        /* Regra 2: caso o digito verificador seja igual a 11, ele passa 
           a ser 0 */
        else if(digitoV == 11){
            digitoV = 0;
        }
        
        /* Aqui é feita a comparacao caso o RG digitado termine com X */
        if((digitoV == 88) && (rg.charAt(8) == (char) digitoV)){
            return true;
        }
        else if(digitoV == rgVetor[8]){
            return true;
        }
        
        return false;
    }

    public Object getrg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getcpf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}