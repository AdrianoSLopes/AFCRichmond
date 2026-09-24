
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    private static List<SocioTorcedor> torcedores = new ArrayList<>();
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("===BEM VINDO AO SITE DO AFC RICHMOND===");
        int opcao;

        do {

            System.out.println("1. Cadastrar");
            System.out.println("2. Atualizar dados");
            System.out.println("3. Cancelar");
            System.out.println("4. Reativar");
            System.out.println("5. Sair");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarUsuario(entrada);
                    break;
                case 2:
                    atualizarUsuario(entrada);
                    break;
                case 3:
                    cancelarUsuario(entrada);
                    break;
                case 4:
                    reativarUsuario(entrada);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Digite uma opcao correta!");
                    break;
            }
        } while (opcao <= 1 || opcao > 5);
    }



    private static void cadastrarUsuario(Scanner  entrada) {
        SocioTorcedor torcedor = new SocioTorcedor();
        int p;

        do{
            System.out.println("Escolha seu plano de Socio Torcedor");
            System.out.println("1 - Prata - $20 mensal");
            System.out.println("2 - Ouro - $40 mensal");
            System.out.println("3 - Diamante - $60 mensal");
            p = entrada.nextInt();
            if(p == 1){
                torcedor.setPlano("Prata");
            }
            else if(p == 2){
                torcedor.setPlano("Ouro");
            }
            else if(p == 3){
                torcedor.setPlano("Diamante");
            }
            else{
                System.out.println("Digite o numero correto do plano");
            }
        }while(p < 1 || p > 3 );
        System.out.println("Digite seu nome: ");
        torcedor.setNome(entrada.next());

        System.out.println("Digite seu CPF: ");
        torcedor.setCpf(entrada.next());

        System.out.println("Digite seu email: ");
        torcedor.setEmail(entrada.next());

        System.out.println("Digite seu telefone: ");
        torcedor.setTelefone(entrada.next());

        System.out.println("Digite sua data de nascimento: ");
        torcedor.setDataNascimento(entrada.next());

        LocalDate dataCadastro = LocalDate.now();
        int numeroSocio = (int) (Math.random() * 100) + 1;

        System.out.println("Numero de socio: " + numeroSocio);
        System.out.println("Status: Cadastrado.");
        System.out.println("Data de cadastro: " + dataCadastro);
        torcedores.add(torcedor);
        System.out.println(torcedor);
    }

    private static void atualizarUsuario(Scanner entrada) {

        if (torcedores.isEmpty()) {
            System.out.println("Nenhum torcedor cadastrado");
            return;
        }

        System.out.println("Digite o CPF do torcedor que deseja atualizar: ");
        String cpf = entrada.next();

        SocioTorcedor torcedor = torcedores.stream()
                .filter(t -> t.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);

        if (torcedor == null) {
            System.out.println("Torcedor não encontrado.");
            return;
        }
        System.out.println("Qual item vc deseja alterar?");
        System.out.println("1. Nome");
        System.out.println("2. CPF");
        System.out.println("3. Email");
        System.out.println("4. Telefone");
        System.out.println("5. Data de nascimento");
        System.out.println("6. Sair");

        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo nome: ");
                torcedor.setNome(entrada.next());
                break;
            case 2:
                System.out.println("Digite o novo CPF: ");
                torcedor.setCpf(entrada.next());
                break;
            case 3:
                System.out.println("Digite o novo email: ");
                torcedor.setEmail(entrada.next());
                break;
            case 4:
                System.out.println("Digite o novo telefone: ");
                torcedor.setTelefone(entrada.next());
                break;
            case 5:
                System.out.println("Digite a nova data de nascimento: ");
                torcedor.setDataNascimento(entrada.next());
                break;
            case 6:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Digite um numero valido.");
                break;
        }
        System.out.println(torcedor);

    }

    private static void cancelarUsuario(Scanner entrada) {
        if (torcedores.isEmpty()) {
            System.out.println("Nenhum torcedor cadastrado");
            return;
        }

        System.out.println("Digite o CPF do torcedor que deseja cancelar: ");
        String cpf = entrada.next();

        SocioTorcedor torcedor = torcedores.stream()
                .filter(t -> t.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
        if (torcedor == null) {
            System.out.println("Torcedor nao encontrado.");
            return;
        }

        if (torcedor.getStatus().equals(StatusTorcedor.CANCELADO)) {
            System.out.println("Este usuario ja esta cancelado.");
            return;
        }

        torcedor.setStatus(StatusTorcedor.CANCELADO);
        System.out.println("Usuario cancelado com sucesso!");
    }

    private static void reativarUsuario(Scanner entrada) {
        if (torcedores.isEmpty()) {
            System.out.println("Nenhum torcedor cadastrado");
            return;
        }
        System.out.println("Digite o cpf do torcedor que deseja reativar: ");
        String cpf = entrada.next();

        SocioTorcedor torcedor = torcedores.stream()
                .filter(t -> t.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);

        if (torcedor == null) {
            System.out.println("Torcedor nao encontrado.");
            return;
        }

        if (torcedor.getStatus() ==  StatusTorcedor.ATIVO) {
            System.out.println("Torcedor ja esta ativo.");
            return;
        }

        torcedor.setStatus(StatusTorcedor.ATIVO);
        System.out.println("Usuario reativado com sucesso!");
    }
}
