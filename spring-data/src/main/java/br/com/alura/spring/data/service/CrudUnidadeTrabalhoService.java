package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {

    private Boolean system = true;
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }
    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação de unidade deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Vizualizar");
            System.out.println("4 - Deletar");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }



    private void salvar(Scanner scanner) {
        System.out.println("Nome da Unidade");
        String nome = scanner.next();

        System.out.println("Endereço da Unidade");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(nome);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Salvo!");
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();

        System.out.println("Novo nome da unidade");
        String nome = scanner.next();

        System.out.println("Novo endereço da Unidade");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setId(id);
        unidadeTrabalho.setDescricao(nome);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Salvo!");
    }

    private void visualizar() {
        Iterable<UnidadeTrabalho> unidades = unidadeTrabalhoRepository.findAll();
        unidades.forEach(unidade -> System.out.println(unidade));
    }

    private void deletar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        unidadeTrabalhoRepository.deleteById(id);
        System.out.println("Deletado!");
    }
}
