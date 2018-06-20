# Introdução
Esta é uma solução simples para formatação de um texto, no qual irá limitar a quantidade de caractéres inseridos por linha e justificar.

# Como Utilizar
Execute a classe Main passando de 0 a 3 argumentos, sendo os 3 argumentos listados abaixo respectivamente.

- Texto a ser formatado
- Quantidade limite de caracteres por linha
- Se o texto deve ou não ser justificado (true/false)

Caso não seja passado parâmetros serão definidos valores padrões para demonstração.

# Como Funciona
- Os parâmetros de limite e justificar são passados na construção do formatador.
- O texto é passado para o método.
- O método quebra o texto em parágrafos, palavras e depois formata conforme parâmetros.