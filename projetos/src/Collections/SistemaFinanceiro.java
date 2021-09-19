package Collections;

import java.util.*;
import java.util.stream.Stream;

public class SistemaFinanceiro {

    public static void main(String[] args) {
//        caixaEletronico.efetuarSaque(20);
//        caixaEletronico.efetuarTransferencia(contaDestino, 40);
//        caixaEletronico.encerrarUtilizacao();
//
//
//        // Da para usar herança para adicionar elementos que não sejam do tipo Cliente diretamente
//
//        for (Cliente titulares : contaConjunta.getOutrosTitulares()) {
//            System.out.println("Nome: " + titulares.getNome() + ", sobrenome: " + titulares.getSobrenome());
//        }
//
//        for (int i = 0; i < outrosTitulares.size(); i++) {
//            Cliente titulares = outrosTitulares.get(i);
//            System.out.println("Nome: " + titulares.getNome() + ", sobrenome: " + titulares.getSobrenome());
//        }

        // Classes wrappers encapsulam os comportamentos dos tipos primitivo

        // Os identificadores não precisariam seguir uma ordem sequencial

        Cliente titular = new Cliente("Fabio", "Silva");
        titular.setIdentificador(1);

        Cliente outroTitular = new Cliente("Fulano", "De tal");
        outroTitular.setIdentificador(2);

        Cliente maisUmTitular = new Cliente("Beltrano", "De tal");
        maisUmTitular.setIdentificador(3);

        Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

        clientes.put(titular.getIdentificador(), titular);
        clientes.put(titular.getIdentificador(), titular); // não será inserido repetidamente, atualiza o dado anterior
        clientes.put(outroTitular.getIdentificador(), outroTitular);
        clientes.put(maisUmTitular.getIdentificador(), maisUmTitular);

        // Para cada chave, ele pega as chaves com keySet
        for (Integer chave: clientes.keySet()) {
            System.out.println("Cliente de chave: " + chave + ": " + clientes.get(chave));
        }

        ContaConjunta contaConjunta = new ContaConjunta(titular);

        List<Cliente> outrosTitulares = new Vector<Cliente>();
        outrosTitulares.add(outroTitular);
        outrosTitulares.add(outroTitular);
        outrosTitulares.add(maisUmTitular);
        contaConjunta.setOutrosTitulares(outrosTitulares);

        Stream<Cliente> stream = outrosTitulares.stream();

        // tradicional
        for (Cliente cliente: outrosTitulares) {
            System.out.println(cliente);
        }

        // iterando em Streams utilizando expressões lambda, para cada elemento, guarde em um cliente e printe cada cliente
        stream.forEach(cliente -> System.out.println(cliente));

        // forma reduzida, dentro do meu Consumer, que o forEach aceita, que passa a ser o out, execute um método que retorne void, não precisa passar explicitamente printl(cliente) pois a Stream é do tipo Cliente
        stream.forEach(System.out::println);


    }
}
