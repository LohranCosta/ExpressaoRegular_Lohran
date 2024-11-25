/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcoder.expressaoregular.ExpressaoRegular;


/**
 * @author lohran
 */
public class ExpressaoRegular {

	public String BRANCO, BRANCOS, BRANCOS_MIN1;
	public String DIGITO, DIGITOS;
	public String LETRA, LETRAS;
	public String IDENT;
	public String EXPONENCIAL;
	public String REAL;
	public String INTEIRO;
	public String NUMEROS;
	public String ATRIBUICAO;
	public String OPERADOR;
	public String CONDICIONAL;
	public String TIPOS;
	public String PARAMETRO;
	public String PARAMETROS_DE_FUNCAO;
	public String DECLARACAO;
	public String ASSINATURA_FUNCAO;
	public String OPERADOR_MATEMATICO;
	public String EXPRESSAO;
	public String EXPRESSAO_MATEMATICA;
	public String ATRIBUTO;
	public String INDEXACAO;
	public String CHAMADA_METODO;

	public String EXERC_02;
	public String EXERC_03;

	/**
	 * *****************************************
	 * Trabalho 02
	 * <p>
	 * Faças as Expressoes Regulares para reconhecer:
	 * 1. Assinatura de funções
	 * ex: void funcao1(int a, float b) ex: String funcao2()
	 * <p>
	 * 2. Parametros de funções ex: int a, float b ex: float media, String nome
	 * <p>
	 * 3. Condicional ex: if(ano < 1990) ex: if(3*a != 4+t)
	 * <p>
	 * 4. Expressão matemática ex: 3+media/3 ex: -4+beta*media[1].x ex: soma(a,
	 * b)/4*vetor[5].idade
	 * <p>
	 * OBS_1: Muitos erros ocorrem por falta de parenteses em torno da
	 * expressão, logo use e abuse dos parenteses, eles nunca serão demais.
	 * <p>
	 * OBS_2: A cada nova Expressao Regualar feita, teste-a.
	 * ******************************************
	 */

	public ExpressaoRegular() {
		BRANCO = "(\\s)";
		BRANCOS = BRANCO + "*";
		BRANCOS_MIN1 = BRANCO + "+";

		DIGITO = "([0-9])";
		DIGITOS = DIGITO + "+";
		LETRA = "([A-Za-z])";
		LETRAS = LETRA + "+";

		IDENT = "(" + LETRA + "(" + LETRA + "|" + DIGITO + ")*)";
		EXPONENCIAL = "(E(\\+|-)" + DIGITOS + ")?";
		REAL = "(\\-?" + DIGITOS + "\\.?" + DIGITOS + EXPONENCIAL + ")";
		INTEIRO = "(\\-?" + DIGITOS + ")";
		NUMEROS = "(" + INTEIRO + "|" + REAL + ")";
		PARAMETRO = "(" + IDENT + "|" + NUMEROS + ")";

		OPERADOR = "(<|>|<=|>=|==|!=)";
		OPERADOR_MATEMATICO = "(\\+|\\-|\\*|/)";
		TIPOS = "(void|int|float|double|char|boolean|long|short|byte|String)";

		EXERC_02 = BRANCOS + "^a[a-zA-Z]*a$";
		EXERC_03 = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


		DECLARACAO = TIPOS + BRANCOS_MIN1 + IDENT;

		PARAMETROS_DE_FUNCAO =
						BRANCOS + "\\("+ BRANCOS + DECLARACAO + BRANCOS +"(," + BRANCOS
						+ DECLARACAO + BRANCOS + ")*" +"\\)" + BRANCOS;

		ASSINATURA_FUNCAO = BRANCOS + DECLARACAO + BRANCOS + PARAMETROS_DE_FUNCAO + BRANCOS + ";";

		EXPRESSAO = PARAMETRO +
						"(" + BRANCOS + OPERADOR_MATEMATICO + BRANCOS + PARAMETRO + ")*";

		CONDICIONAL = BRANCOS + "if" + BRANCOS + "\\(" + BRANCOS + EXPRESSAO + BRANCOS
						+ OPERADOR + BRANCOS + EXPRESSAO + BRANCOS + "\\)" + BRANCOS;

		ATRIBUICAO = IDENT + BRANCOS + "=" + BRANCOS + REAL;

		ATRIBUTO = "(" + IDENT + "(\\." + IDENT + ")*)";

		INDEXACAO = IDENT + "\\[" + BRANCOS + DIGITOS + BRANCOS + "\\]";

		CHAMADA_METODO = IDENT + "\\(" + BRANCOS + "(" + PARAMETRO +	"(" + BRANCOS + "," + BRANCOS
						+ PARAMETRO + ")*)?" + BRANCOS + "\\)";

		EXPRESSAO_MATEMATICA = "(" + "(-?" + DIGITOS + "|" + IDENT + "|" + INDEXACAO + "|"
						+ CHAMADA_METODO + "|" + ATRIBUTO + ")" + "(" + BRANCOS + OPERADOR_MATEMATICO + BRANCOS +
						"(-?" + DIGITOS + "|" + IDENT + "|" + INDEXACAO + "|" + CHAMADA_METODO + "|" + ATRIBUTO + "))*" +")";
	}

	public void confere(String exp, String sentenca) {
		if ((sentenca != null) && !sentenca.isEmpty()) {
			if (sentenca.matches(exp)) {
				System.out.println("W:'" + sentenca + "'........ ACEITA!");
			} else {
				System.err.println("W:'" + sentenca + "'........ rejeitada.");
			}
		} else {
			System.err.println("Sentença vazia.");
		}
	}

}
