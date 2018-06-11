# TrabalhoOrgArq
Trabalho realizado na disciplina de Organização e Arquitetura de Computadores onde foi simulado uma cache com mapeamento direto e associativo de 16 e 32 linhas.
O grupo de desenvolvimento montado para este projeto foi o dos alunos: Douglas Paz, João Vitor Severo e Leonardo Marques; As tarefas foram divididas de acordo com
as atividades e facilidades individuais, dessa forma não forçando nenhum integrante a realizar uma tarefa que não deseja. 
A realização do relatório ficou por parte dos integrantes Douglas Paz e Leonardo Marques, enquanto o código foi desenvolvido pelo integrante João Vitor Severo.

Quaisquer dúvidas específicas sobre o código podem ser esclarecidas nos comentários em cima de cada metodo das classes.

A política de substituição utilizada no mapeamento associativo foi com contador.

O conceito geral por traz do programa:
	- Mapeamento Associativo :
		Para cada endereço passado para a cache, é armazenado a sua tag e a palavra correspondente;
		O programa procura pela cache de existe alguma tag correspondente e se existir, se existe uma palavra correspondente no mesmo local que foi encontrada a tag;
		Se existir, resulta em hit;
		
		Se nao existir ira inserir uma tag e um bloco de palavras correspondentes ate encher a cache;
		
		Quando encher, os primeiros enderecos começam a ser substituidos;
		
		
	- Mapeamento Direto :
		Para cada endereço passado para a cache, é armazenado a sua tag, a linha correspondente e um bloco de palavras;
		O programa procura pela cache de existe alguma linha correspondente e se existir, se existe uma tag correspondente no mesmo local que foi encontrada a linha;
		Se existir, resulta em hit;
		
		Se o programa encontrar a linha e não a tag, a nova tag irá substituí-la;
		
		Se não for encontrada a linha, uma nova linha é inserida na cache com a linha correspondete, a tag e um bloco de palavras;
		
		Quando encher, os primeiros enderecos começam a ser substituidos;

		
Código e elementos git desenvolvido pelo integrante do grupo João Vitor Severo.

Auxilio com parte do algoritimo de Mapeamento Direto do integrante Leonardo Marques.


