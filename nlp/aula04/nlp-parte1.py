corpus = """rato roeu a roupa do rei de Roma,
O rato roeu a roupa do rei da Rússia,
O rato roeu a roupa do RodovaIho...
O rato a roer roía
E a rosa Rita Ramalho do rato a roer se ria.
O rato roeu a roupa do rei de roma
a rainha com raiva roeu o resto."""

corpus_lower = corpus.lower()
# print(corpus_lower)

# remover_pontuacao = corpus_lower.replace(",", " ").replace(".", " ")
# print(remover_pontuacao)

trans_table = str.maketrans('.,\n', '   ')
corpus_limpo = corpus_lower.translate(trans_table)
print(corpus_limpo)


tokens = corpus_limpo.split(" ")
print("Lista de tokens: ", tokens)

novos_tokens = []
for token in tokens:
    if token != '':
        novos_tokens.append(token)

print("Novos Tokens: ", novos_tokens)

vocabulario = list(set(novos_tokens))
print("Vocabulario: ", vocabulario)
print("Primeira palavra: ", vocabulario[0])

palavras_vocabulario = len(vocabulario)
palavras_texto = len(novos_tokens)
print("Tamanho Vocabulario : ", palavras_vocabulario)
print("Tamanho Texto : ", palavras_texto)
riqueza_lexical = palavras_vocabulario / palavras_texto
print("Riqueza Lexical : ", riqueza_lexical)
