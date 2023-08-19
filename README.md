

Sistema de Atendimento Virtual Baseado em Filas em Java ☕ 

Esse código representa a implementação de uma simulação um sistema de atendimento virtual baseado em filas. As pessoas, ao chegarem, entram em uma das duas filas de acordo com a sua idade:
 Fila 1 - Idosos
 Fila 2 - Não Idosos
A simulação comeca a rodar no minuto 0, e o arquivo de entrada, que é um arquivo txt que apresenta o tempo de chegadas das pessoas, além da fila onde ela será atendida e o tempo total de atendimento de da pessoa. O programa faz a leitura do arquivo e gera as filas para o processamento do atendimento. Cada objeto da fila armazena o numero do cliente, o tempo de chegada (o minuto q ele chegou na fiila) do cliente e o tempo de duração do atendimento. Após a criação das filas, deverá ser feito os atendimentos, de acordo com a ordem da fila de prioridade e da ordem de chegada e deve ser calculado o tempo total de atendimento que leva em conta o tempo de espera na fila mais o tempo de atendimento efetivo. A saída do seu programa é um arquivo de saida em texto com o nidentificador de cada cliente e seu tempo total de atendimento.
Para realizar a manipulação da Fila, é utilizado uma implementação do código de Lista Encadeada, Fila Encadeada, FilaArray e por fim o código da Fila Encadeada

**Estruturas de Dados Utilizadas**

O projeto utiliza estruturas de dados customizadas sendo elas Lista Encadeada, Fila Encadeada, Fila em Array e por fim a estrutura e dados Fila. A estrutura de dados Fila é implementada dessas estruturas de dados, aproveitando os conceitos e métodos definidos anteriormente. Assim, As estruturas de dados personalizadas trabalham em conjunto para criar um sistema eficiente de gerenciamento de atendimentos.
