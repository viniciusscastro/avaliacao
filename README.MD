Avaliação Spring boot

###Antes de clonar o projeto, realizar o fork do projeto para seu repositório!###
Descrição:
O projeto AvaliacaoSpringBoot contém funcionalidades para atender um sistema de controle de cursos, porém algumas funcionalidades ainda não estão concluídas e outras incompletas:

Exercícios:

1. A api “/aluno” implementada na classe AlunoController grava um aluno no banco de dados a partir de um 
objeto informado no banco. Porém é necessário implementar uma validação para que seja exibido uma mensagem de 
erro caso já exista o CPF informado cadastrado na tabela TB_ALUNO.

2. Implementar no projeto uma nova api para cadastro de um novo curso (TB_CURSO)

3. A api “turmas” da classe TurmaController retorna uma lista de turmas cadastradas com os instrutores e 
alunos cadastrados a ela, porém é necessário implementar o método listar() da classe TurmaService para realizar a 
conversão da lista de entidades do banco para lista de objetos do tipo TurmaDTO.

4. Implementar na classe de CursoRepository um método de busca por nome do curso que retorne uma lista de cursos. Não é necessário implementar as camadas de Service e Controller

5. Criar uma nova entidade com o nome ModuloEntity (referente a tabela TB_MODULO) e seus atributos.
Relacionar dentro da entidade ModuloEntity a entidade InstrutorEntity onde para cada módulo poderá existir um instrutor. 