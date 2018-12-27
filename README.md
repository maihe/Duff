# :beer: Desafio Ciclic - Backend Developer

Aplicação Web REST / Restful para selecionar a cerveja perfeita dada a temperatura e sugerir uma lista de reprodução do Spotify como acompanhamento:
Para completar esse desafio, decidi usar o Spring Boot, o H2 e o Heroku.Estas são três tecnologias sobre as quais tenho aprendido, mas que ainda não tiveram chance de se inscrever em um projeto. 
- Spring Boot
Para construir a minha estrutura de projeto de forma simplificada e organizada, agilizando o desenvolvimento e aplicando um bom padrão ao projeto
- H2
Banco de dados de memória, simples, pequeno, fácil de usar e serve perfeitamente para o caso apresentado
- Heroku
Independente de plataforma, não exige configuração local da aplicação, está conectado diretamente com o repositório possibilitando transparencia na execução

### [Home da aplicação](https://duff-ciclic.herokuapp.com)

**Lista inicial de cervejas:**

|Estilo da cerveja|Temperatura ideal |
|:---:|:---:|
|Weissbier|-1° a 3°|
|Pilsens |-2° a 4°|
|Weizenbier |-4° a 6°|
|Red ale|-5° a 5°|
|India pale ale|-6° a 7°|
|IPA|-7° a 10°|
|Dunkel|-8° a 2°|
|Imperial Stouts|-10° a 13°|
|Brown ale|0° a 14°|


## Tarefas

### 1. Crie um microserviço para os estilos de cerveja
O repositório de Cervejas está exposto pela API Rest que pode ser acessada em [beers](https://duff-ciclic.herokuapp.com/beers)
### 2. Criar um endpoint
O endpoint solicitado foi desenvolvido em [Duff](https://duff-ciclic.herokuapp.com/duff/)
```
https://duff-ciclic.herokuapp.com/duff/{temperatura}
```

**Regras de negócio** 

* Todo estilo de cerveja tem uma temperatura mínima e uma temperatura máxima.
* O cálculo para selecionar o estilo de cerveja adequado: é qual estilo contém a média das suas temperaturas mais próxima do input dado pela api.(Se o input foi -2 e temos as cervejas Dunkel e Weissbier o estilo selecionado é o Dunkel).
* Caso o resultado seja mais de um estilo de cerveja, devolver o estilo por ordem alfabética(entre Pilsens e IPA voltára IPA) e caso de empate na primeira letra, ordernar pela segunda e assim por diante.
* Caso não tenha uma playlist que contenha o nome do estilo, retornar um HTTP Status que achar mais adequado.
* A lista dada foi um exemplo, a api tem que estar pronta para receber mais estilos e mais temperaturas.

### 3. O que esperamos:

* Seu projeto deve ser **multi-plataforma**.
* Crie uma documentação e explique como como rodar localmente e também como realizar o deploy.
* Quanto mais simples for para realizar o deploy, melhor!
* Sinta-se a vontade para usar qualquer framework e ferramentas que se sentir a vontade a única restrição é a linguagem de programação que deve ser **Java**
