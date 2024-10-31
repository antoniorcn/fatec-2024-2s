string1 = "Ola mundo"
string2 = "Ola\tMundo \nBem vindo a NLP"

print(" String1: ", string1)
print(" String2: ", string2)

# print("Digite um texto: ")
# texto_digitado = input()

texto_digitado = input("Digite um texto: ")

print("Você digitou: ", texto_digitado)

tamanho = len(texto_digitado)
texto_maiusculo = texto_digitado.upper()
texto_minusculo = texto_digitado.lower()
primeiro_caracter = texto_digitado[0]
ultimo_caracter = texto_digitado[-1]
tres_primeiros = texto_digitado[0:3]
# texto_digitado[ <inicio> : <termino> : <passo> ]
tres_ultimos = texto_digitado\
[ len(texto_digitado) - 3: len(texto_digitado)]
print("Tamanho do texto digitado: ", tamanho)
print("Texto digitado em maiusculo: ", texto_maiusculo)
print("Texto digitado em minusculo: ", texto_minusculo)
print("Primeiro Caractere: ", primeiro_caracter)
print("Ultimo Caractere: ", ultimo_caracter)
print("Tres Primeiros Caracteres: ", tres_primeiros)
print("Tres Ultimos Caracteres: ", tres_ultimos)
print("-3: ", texto_digitado[-3])

print("Em que indice esta a letra (a): ", texto_digitado.find("a"))
print("Em que indice esta a letra (e): ", texto_digitado.find("e"))
print("Em que indice esta a letra (i): ", texto_digitado.find("i"))
print("Em que indice esta a letra (o): ", texto_digitado.find("o"))
print("Em que indice esta a letra (u): ", texto_digitado.find("u"))

