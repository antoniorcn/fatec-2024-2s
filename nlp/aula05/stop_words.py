from matplotlib import pyplot as plt
corpus = """rato roeu a roupa do rei de Roma,
O rato roeu a roupa do rei da Rússia,
O rato roeu a roupa do RodovaIho...
O rato a roer roía
E a rosa Rita Ramalho do rato a roer se ria.
O rato roeu a roupa do rei de roma
a rainha com raiva roeu o resto."""

corpus_lower = corpus.lower()

trans_table = str.maketrans('.,\n', '   ')
corpus_limpo = corpus_lower.translate(trans_table)
print(corpus_limpo)

tokens = corpus_limpo.split(" ")

stop_words = ['a', 'o', 'da', 'do', 'e', 'que', 'com', 'se', 'de']

tokens_limpos = []
for token in tokens:
    if token != '' and token not in stop_words:
        tokens_limpos.append( token )
print("Tokens: ", tokens_limpos)

vocabulario = list(set(tokens_limpos))
print("Vocabulario: ", vocabulario)

bag_of_words = {}
for token in tokens_limpos:
    if token in bag_of_words:
        bag_of_words[token] = bag_of_words[token] + 1
    else:
        bag_of_words[token] = 1

print("Bag of Words (com contagem): ", bag_of_words)


lista_palavras = []
lista_ocorrencias = []
for item in bag_of_words.items():
    lista_palavras.append( item[0] )
    lista_ocorrencias.append( item[1] )

plt.barh(lista_palavras, lista_ocorrencias)
plt.title('Palavras X Ocorrencias no Corpus')
# Label the x-axis
plt.xlabel('Palavras')
# Label the y-axis
plt.ylabel('Ocorrencias')
plt.savefig('palavras_ocorrencias.png')
