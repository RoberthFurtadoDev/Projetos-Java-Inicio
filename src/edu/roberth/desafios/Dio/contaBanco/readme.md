# 📝 Descrição do Projeto
Este projeto implementa uma aplicação Java simples que simula a criação de uma conta bancária, coletando dados do usuário via terminal e exibindo uma mensagem de confirmação com os detalhes da conta.

# 🛠️ Funcionalidades
Coleta de dados do usuário via terminal

Validação básica de tipos de entrada

Formatação de saída para dados bancários

Exibição de mensagem personalizada com os dados da conta

# 📋 Pré-requisitos
Java JDK 11 ou superior

Maven (opcional, para gerenciamento de dependências)

IDE de sua preferência (IntelliJ, Eclipse, VS Code, etc.)

# 🚀 Como Executar o Projeto
Método 1: Executando via IDE
Clone o repositório ou importe o projeto para sua IDE

Localize a classe ContaTerminal.java

Execute o método main()

Método 2: Executando via linha de comando
bash
# Compilar o projeto
javac ContaTerminal.java

# Executar o programa
java ContaTerminal  
# 🖥️ Fluxo do Programa
O programa seguirá este fluxo de interação:

Solicitará o número da conta (inteiro)

Solicitará o número da agência (texto)

Solicitará o nome do cliente (texto)

Solicitará o saldo inicial (decimal)

Exibirá a mensagem de confirmação com todos os dados

Exemplo de execução:

Por favor, digite o número da Conta !  
1021  
Por favor, digite o número da Agência !  
067-8  
Por favor, digite o nome do Cliente !  
Roberth Furtado  
Por favor, digite o saldo inicial !  
237.48  
Olá Roberth Furtado, obrigado por criar uma conta em nosso banco, sua agência é 067-8, conta 1021 e seu saldo 237.48 já está disponível para saque  
# 🧩 Estrutura do Código
O projeto contém uma única classe principal:

ContaTerminal.java: Classe principal que contém a lógica de interação com o usuário

# 🛑 Possíveis Erros e Soluções
InputMismatchException: Ocorre quando o tipo de dado inserido não corresponde ao esperado.

Solução: Inserir valores no formato correto (números inteiros para conta, texto para agência, etc.).

Quebra de linha não consumida: Pode pular a entrada do nome do cliente.

Solução: O código já inclui um scanner.nextLine() adicional para consumir a quebra de linha.

# 📚 Aprendizados Aplicados
Este projeto demonstra:

Uso da classe Scanner para entrada de dados

Manipulação de diferentes tipos de variáveis (int, String, double)

Formatação de saída para valores monetários

Concatenação de strings para mensagens personalizadas

Boas práticas de manipulação de recursos (fechamento do Scanner)

# 📅 Roadmap de Melhorias
Implementar validação robusta de entradas

Adicionar tratamento de exceções personalizado

Converter para sistema com múltiplas contas

Implementar persistência em arquivo ou banco de dados

Criar interface gráfica (GUI)

# 🤝 Como Contribuir
Contribuições são bem-vindas! Siga estes passos:

Faça um fork do projeto

Crie uma branch para sua feature (git checkout -b feature/incrivel)

Commit suas mudanças (git commit -m 'Adicionando feature incrível')

Push para a branch (git push origin feature/incrivel)

Abra um Pull Request

# 📜 Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para detalhes.

