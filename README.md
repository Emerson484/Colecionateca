# Colecionateca
📚 Colecionateca - Gestão de Biblioteca Pessoal

A Colecionateca é uma solução digital para leitores e colecionadores que desejam organizar suas obras de forma padronizada. O projeto resolve o problema da fragmentação entre coleções físicas e digitais, permitindo o acompanhamento de progresso e a gestão completa em um único ambiente.

🛠️ Tecnologias e Conceitos Utilizados
Linguagem: Java.

Interface Gráfica: JavaFX (OpenJFX) e Scene Builder.

Persistência: Serialização de objetos em arquivos binários (.dat).

Arquitetura: MVC (Model-View-Controller).

🧩 Princípios de POO Aplicados
O projeto foi construído utilizando os pilares da Programação Orientada a Objetos:

Herança: As classes Ebook e LivroFisico herdam atributos comuns da classe base Livro.

Polimorfismo: Utilizado na interface ILivro e na sobrescrita do método toString() para exibir detalhes específicos de cada tipo de mídia.

Encapsulamento: Todos os atributos de modelo são privados com acesso via Getters e Setters.

Interfaces: Uso da interface ILivro para definir o contrato de operações CRUD do repositório.

🚀 Funcionalidades Principais
Cadastro Híbrido: Suporte para livros físicos (com número de páginas e localização) e e-books (com tamanho em MB e formato).

Acompanhamento de Leitura:

Cálculo automático de porcentagem lida para livros físicos.

Registro de progresso para e-books.

Busca e Filtros: Pesquisa em tempo real por título ou autor na tabela de livros.

Persistência de Dados: Os dados são salvos automaticamente no arquivo livros.dat, garantindo que as informações não sejam perdidas ao fechar o programa.

🖥️ Telas do Sistema
O sistema conta com três interfaces principais:

Dashboard Inicial: Acesso rápido ao gerenciamento.

Lista de Livros: Tabela interativa com opções de remoção, detalhes e atualização de progresso.

Cadastro Detalhado: Formulário dinâmico que alterna campos dependendo do tipo de livro selecionado.

🔧 Como Executar
Clone o repositório:
git clone https://github.com/Emerson484/colecionateca.git
Abra o projeto em uma IDE (NetBeans, IntelliJ ou VS Code).

Certifique-se de ter o SDK do JavaFX configurado.

Execute a classe ProjetoBiblioteca.java.

Desenvolvido por: Emerson

Disciplina: Programação Orientada a Objetos
