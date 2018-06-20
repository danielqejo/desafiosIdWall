# Introdução
Solução para quando você estiver entediado, ela irá buscar os tópicos mais famosos da primeira página do reddit. Existe também um Bot do telegram, basta pedir pra ele e ele irá enviar no seu telegram.

# Como Utilizar

## Manual / Java
Execute a classe RedditCrawlerApplication passando 1 argumento, este argumento deve conter um texto dizendo quais subreddits devem ser buscados, cada um separado por ; (ex: cats;brazil;worldnews)

## Bot Telegram
- Adicione o bot DanielIdwallBot no seu telegram.
- Execute a classe TelegramBotApplication
- Envie uma mensagem ao bot utilizando o comando /NadaPraFazer seguido pelos subreddits (ex: /NadaPraFazer cats;brazil;worldnews)

# Como Funciona
- A aplicação passa em cada um dos subreddits informados e busca as postagens da primeira página.
- Separa as postagens com likes acima de 5000.
- Retorna a lista de postagens no telegram ou no console (Dependendo da classe executada).