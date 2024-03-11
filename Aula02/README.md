# Ex01:

## Vector:

### Características:

Implementa uma matriz dinâmica que cresce automaticamente.
Sincronizado, o que significa que é seguro para operações em ambientes concorrentes.
Pode ser menos eficiente em comparação com as implementações não sincronizadas.

### Exemplo:

Imagine um sistema de reservas em um teatro, onde o Vector poderia ser usado para armazenar os assentos disponíveis, permitindo a reserva de assentos de maneira segura em ambientes concorrentes.

## ArrayList:

### Características:

Implementação de lista dinâmica baseada em arrays.
Não é sincronizado, o que pode resultar em melhor desempenho em operações não concorrentes.
Suporta acesso rápido e eficiente, mas pode ser menos eficiente em operações de inserção e remoção.

### Exemplo:

Em um sistema de gerenciamento de alunos, um ArrayList pode ser utilizado para armazenar a lista de alunos em uma turma, proporcionando fácil acesso e manipulação dos dados.
## LinkedList:

### Características:

Implementação de lista duplamente encadeada.
Oferece operações rápidas de inserção e remoção, mas acesso menos eficiente em comparação com o ArrayList.
Não é sincronizado.

### Exemplo:

Considere um sistema de reprodução de música, onde uma LinkedList pode ser usada para representar a lista de reprodução, facilitando a adição e remoção de músicas.

## HashMap:

### Características:

Implementação de tabela de hash que mapeia chaves para valores.
Permite acesso rápido aos elementos através de chaves.
Não é sincronizado, mas oferece melhor desempenho na maioria das situações em comparação com Hashtable.

### Exemplo:

Em um aplicativo de agenda, um HashMap poderia ser usado para associar os nomes dos contatos aos seus números de telefone, proporcionando uma busca eficiente por contatos.
