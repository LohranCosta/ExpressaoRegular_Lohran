
import com.ifcoder.expressaoregular.ExpressaoRegular;

/**
 * @author lohran
 */
public class Aula {

	public static void main(String[] args) {
		ExpressaoRegular ER = new ExpressaoRegular();

		//Exercícios do trabalho
		ER.confere(ER.ASSINATURA_FUNCAO, "void funcao1(int a, float b) ;");
		ER.confere(ER.ASSINATURA_FUNCAO, "String funcao2();");

		ER.confere(ER.PARAMETROS_DE_FUNCAO, "(int a, float b)");
		ER.confere(ER.PARAMETROS_DE_FUNCAO, "(float media, String nome)");

		ER.confere(ER.CONDICIONAL, "if ( ano < 199 )");
		ER.confere(ER.CONDICIONAL, "if(3*a != 4+t)");

		ER.confere(ER.EXPRESSAO_MATEMATICA, "3 + media/3");
		ER.confere(ER.EXPRESSAO_MATEMATICA, "-4 + beta * media[1].x * soma(a,b)/4 * vetor[5].idade");

		//Exercícios da LFA13 - Expressão Regular
		ER.confere(ER.EXERC_02, "taerradoaentrada");
		ER.confere(ER.EXERC_02, "aentredatacerta");

		ER.confere(ER.EXERC_03, "teste@gmail.com");
		ER.confere(ER.EXERC_03, "testegmail.com");

	}
}
